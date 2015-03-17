package DataService.MatchDataService;

import java.io.File;
import java.util.ArrayList;

import DataService.FileHelper.FileHelper;
import PO.MatchListPO;
import PO.MatchPO;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerDataPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.ScoreOfMatchPO;
import PO.TeamDataPO;
import PO.TeamListPO;
import PO.TeamPO;

public class MatchController implements MatchDataService{
	MatchListPO matches ;
	
	public MatchController(){
		matches=new MatchListPO();
		read("迭代一数据/matches") ;
	}
	void read(String fileName){
		File file = new File(fileName) ;
		if(file.isDirectory()){
			File[] allFiles = file.listFiles() ;
			for(int i = 0; i<allFiles.length;i++){   //����matches�ļ����������ļ�
				ArrayList<String> tempString  = FileHelper.readByLine(allFiles[i]) ;
//				System.out.println(allFiles[i].getName());
				MatchPO newMatch = new MatchPO() ;
				
				boolean isFirstTeam = false ; //�ж���һֻ���
				for(int j = 0;j<tempString.size() ;j++){      //��ÿ�����¼�¼���ÿһ�н��з���
					String[] splitString=tempString.get(j).split(";");
					if(tempString.get(j).length() == 3){
						isFirstTeam =!isFirstTeam ;
						continue ;
					}
						
					switch(j){
					case 0: newMatch.setDate(splitString[0]);
					        newMatch.setFirstTeam(splitString[1].split("-")[0]);
					        newMatch.setSecondTeam(splitString[1].split("-")[1]);
					        newMatch.setFinalScore(new ScoreOfMatchPO(splitString[2]));
					        break;
					case 1: ArrayList<ScoreOfMatchPO> allScore = new ArrayList<ScoreOfMatchPO>();
					        for(int scoreCount=0;scoreCount<splitString.length;scoreCount++)
					        	allScore.add(new ScoreOfMatchPO(splitString[scoreCount]));
					        newMatch.setAllScore(allScore);
					        break;
					 default: 
						 PlayerDataOfOneMatchPO onePlayer = new PlayerDataOfOneMatchPO(splitString);
						 PlayerPO thePlayer = PlayerListPO.findPlayerByName(onePlayer.getName());
						 if(thePlayer == null){
							 PlayerPO newPlayer = new PlayerPO();
							 newPlayer.setName(onePlayer.getName());
							 PlayerListPO.addPlayer(newPlayer) ;
							 thePlayer = newPlayer ;
						 }
						 thePlayer.addDataOfOneMatchOfOnePlayer(onePlayer);
						 
						 if(isFirstTeam){
							 newMatch.addDataOfOnePlayerOfFirstTeam(onePlayer);
							 thePlayer.setTeam(newMatch.getFirstTeam());
						 }else{
							 newMatch.addDataOfOnePlayerOfSecondTeam(onePlayer);
							 thePlayer.setTeam(newMatch.getSecondTeam());
						 }
						 TeamPO theTeam = TeamListPO.findTeamByShortName(thePlayer.getTeam()) ;
						 theTeam.addPlayer(thePlayer);
					}	
				}
				
				newMatch.calculateTeamData();
				newMatch.calculateTotalTime();
				newMatch.calculatePlayersData();
				
				TeamPO firstTeam = TeamListPO.findTeamByShortName(newMatch.getFirstTeam());
				TeamPO secondTeam = TeamListPO.findTeamByShortName(newMatch.getSecondTeam());
				firstTeam.addMatch(newMatch);
				secondTeam.addMatch(newMatch);
				
				addMatch(newMatch);
			}
		}
	}
	
	
	@Override
	public void addMatch(MatchPO oneMatch) {
		// TODO Auto-generated method stub
		matches.addMatch(oneMatch);
	}

	@Override
	public MatchPO findMatchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
