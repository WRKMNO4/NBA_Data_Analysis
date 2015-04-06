package DataService.MatchDataService;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import DataService.FileHelper.FileHelper;
import Enum.Season;
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
		read("Data/matches") ;
	}
	void read(String fileName){
		File file = new File(fileName) ;
		if(file.isDirectory()){
			File[] allFiles = file.listFiles() ;
			Arrays.sort(allFiles,new CompareByTime());
			
			for(int i = 0; i<allFiles.length;i++){   //����matches�ļ����������ļ�
				ArrayList<String> tempString  = FileHelper.readByLine(allFiles[i]) ;
//				System.out.println(allFiles[i].getName());
				MatchPO newMatch = new MatchPO() ;
				newMatch.setName(allFiles[i].getName());
				
				//Set season for newMatch
				String theFileName=allFiles[i].getName();
				String seasonName = theFileName.substring(0,5) ;
				switch(seasonName){
				case "12-13":
					newMatch.setSeason(Season.season12_13);
					break;
				case "13-14":
					newMatch.setSeason(Season.season13_14);
					break;
				case "14-15":
					newMatch.setSeason(Season.season14_15);
					break;
				}
				
				boolean isFirstTeam = false ; 
				for(int j = 0;j<tempString.size() ;j++){ 
					String[] splitString=tempString.get(j).split(";");
					if(tempString.get(j).length() == 3){
						isFirstTeam =!isFirstTeam ;
						continue ;
					}
						
					switch(j){
					case 0: newMatch.setDate(splitString[0]);
					        if(splitString[1].split("-")[0].equals("NOH"))
					        	splitString[1].split("-")[0]="NOP";
					        else if(splitString[1].split("-")[1].equals("NOH"))
					        	splitString[1].split("-")[1]="NOP";
					        newMatch.setFirstTeam(splitString[1].split("-")[0]);
					        newMatch.setSecondTeam(splitString[1].split("-")[1]);
					        newMatch.setFinalScore(new ScoreOfMatchPO(splitString[2]));
					        break;
					case 1: ArrayList<ScoreOfMatchPO> allScore = new ArrayList<ScoreOfMatchPO>();
					        for(int scoreCount=0;scoreCount<splitString.length;scoreCount++)
					        	allScore.add(new ScoreOfMatchPO(splitString[scoreCount]));
					        newMatch.setAllScore(allScore);
					        break;
					 default:  //读取每个球员的具体信息 
						 PlayerDataOfOneMatchPO onePlayer = new PlayerDataOfOneMatchPO(splitString);
						 PlayerPO thePlayer = PlayerListPO.findPlayerByName(onePlayer.getName());
						 if(thePlayer == null){   //若原数组里没有此队员
							 PlayerPO newPlayer = new PlayerPO();
							 newPlayer.setName(onePlayer.getName());
							 newPlayer.setPortraitURL("images/nba_logo.png");
							 newPlayer.setActionURL("images/nba_logo.png");
							 PlayerListPO.addPlayer(newPlayer) ;
							 thePlayer = newPlayer ;
						 }
						 thePlayer.addDataOfOneMatchOfOnePlayer(onePlayer,newMatch.getSeason());
						 
						 if(isFirstTeam){
							 newMatch.addDataOfOnePlayerOfFirstTeam(onePlayer);
							 thePlayer.setTeam(newMatch.getFirstTeam(),newMatch.getSeason());
						 }else{
							 newMatch.addDataOfOnePlayerOfSecondTeam(onePlayer);
							 thePlayer.setTeam(newMatch.getSecondTeam(),newMatch.getSeason());
						 }
						 TeamPO theTeam = TeamListPO.findTeamByShortName(thePlayer.getTeam(newMatch.getSeason())) ;
						 theTeam.addPlayer(thePlayer,newMatch.getSeason());
					}	
				}
				
				newMatch.calculateTeamData();
				newMatch.calculateTotalTime();
				newMatch.calculatePlayersData();
				
				TeamPO firstTeam = TeamListPO.findTeamByShortName(newMatch.getFirstTeam());
				TeamPO secondTeam = TeamListPO.findTeamByShortName(newMatch.getSecondTeam());
				firstTeam.addMatch(newMatch,newMatch.getSeason());
				secondTeam.addMatch(newMatch,newMatch.getSeason());
				
				//更新球队的对手信息
				firstTeam.updateOtherTeamData(newMatch.getFinalScore().getSecondScore(),newMatch.getTotalTime(),newMatch.getSecondTeamData(),newMatch.getSeason());
				secondTeam.updateOtherTeamData(newMatch.getFinalScore().getFirstScore(),newMatch.getTotalTime(),newMatch.getFirstTeamData(),newMatch.getSeason());
				
				//更新球员的对手信息 
				newMatch.updateOtherTeamDataForPlayers();
				
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
	
	class CompareByTime implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			File f1=(File)o1;
			File f2=(File)o2;
			if(f1.lastModified()>f2.lastModified())
				return 1;
			else if(f1.lastModified()==f2.lastModified())
				return 0;
			else
				return -1;
		}
		
	}
}
