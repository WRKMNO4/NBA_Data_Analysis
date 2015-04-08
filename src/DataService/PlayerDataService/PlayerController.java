package DataService.PlayerDataService;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import DataService.FileHelper.FileHelper;
import Enum.PlayerData;
import Enum.ResultMessage;
import Enum.Season;
import PO.MatchPO;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.SeasonListPO;
import PO.StandingDataPO;

public class PlayerController implements PlayerDataService{

	public PlayerListPO players ;
	
	public PlayerController(){
		players= new PlayerListPO();
		read("Data/players/info");
	}
	
	public void read(String fileName){
		File file=new File(fileName);
		if(file.isDirectory()){
			File[] allFiles=file.listFiles();
			for(int i=0;i<allFiles.length;i++){    //����info�ļ�����������ļ�
				ArrayList<String> tempString=FileHelper.readByLine(allFiles[i]);
				PlayerPO newPlayer=new PlayerPO();
				for(int j=0;j<tempString.size();j++){
					if(j%2==0)
						continue;
					String data=FileHelper.analysisOfOneLine(tempString.get(j)).get(1);
					switch(j){
					case 1: newPlayer.setName(data); break;
					case 3: newPlayer.setNumber(data); break;
					case 5: newPlayer.setPosition(data); break;
					case 7: newPlayer.setHeight(data); break;
					case 9: newPlayer.setWeight(data); break;
					case 11: newPlayer.setBirth(data); break;
					case 13: newPlayer.setAge(data);
					        break;
					case 15: 
						     newPlayer.setExp(data); break;
					case 17: newPlayer.setSchool(data); break;
					default: break;
					}
				}
				newPlayer.setPortraitURL("Data/players/portrait/"+newPlayer.getName()+".png");
				newPlayer.setActionURL("Data/players/action/"+newPlayer.getName()+".png");
				if(!new File(newPlayer.getPortraitURL()).exists())  //portrait image not exists
					newPlayer.setPortraitURL("images/nba_logo.png");
				if(!new File(newPlayer.getActionURL()).exists())   //action image not exists
					newPlayer.setActionURL("images/nba_logo.png");
			
				players.addPlayer(newPlayer) ;
			}
		}
	}
	
	
	@Override
	public ResultMessage addPlayer(PlayerPO onePlayer) {
		// TODO Auto-generated method stub
		return players.addPlayer(onePlayer) ;
	}

	@Override
	public ArrayList<PlayerPO> findPlayerByName(String name) {
		// TODO Auto-generated method stub
		return players.findPlayerFaintly(name);
	}

	public ArrayList<PlayerPO> getAllPlayers() {
		return players.getAllPlayers();
	}

	@Override
	public void calculateFinalData() {
		// TODO Auto-generated method stub
		for(PlayerPO onePlayer:players.getAllPlayers()){
			onePlayer.calculateFinalData();
		}
	}

	@Override
	public ArrayList<StandingDataPO> getDatasOfDailyStandingPlayers(Season season,
			String date, PlayerData dataType) {
		// TODO Auto-generated method stub
		ArrayList<MatchPO> matches = SeasonListPO.getMatchesOfOneDay(season,date);
		if(matches.size()==0)
			return null;
		ArrayList<PlayerDataOfOneMatchPO> datas=new ArrayList<>();
		for(MatchPO oneMatch : matches){
			datas.addAll(oneMatch.getFirstTeam_PlayerData());
			datas.addAll(oneMatch.getSecondTeam_PlayerData());
		}
		Collections.sort(datas,new PlayerDataComparator(dataType));
		
		double[] standingDataArray = new double[5];
		switch(dataType){
		case score:
			for(int i=0;i<5;i++)
				standingDataArray[i]=datas.get(i).getScoreOfOneMatch();
			break;
		case numberOfRebound:
			for(int i=0;i<5;i++)
				standingDataArray[i]=datas.get(i).getNumberOfReboundOfOneMatch();
			break;
		case numberOfAssist:
			for(int i=0;i<5;i++)
				standingDataArray[i]=datas.get(i).getNumberOfAssistOfOneMatch();
			break;
		case numberOfBlock:
			for(int i=0;i<5;i++)
				standingDataArray[i]=datas.get(i).getNumberOfBlockOfOneMatch();
			break;
		case numberOfSteal:
			for(int i=0;i<5;i++)
				standingDataArray[i]=datas.get(i).getNumberOfSteal();
		}
		//Find Players
		ArrayList<StandingDataPO> standingDatas=new ArrayList<StandingDataPO>();
		for(int i=0;i<5;i++){      //select top 5
			PlayerDataOfOneMatchPO oneMatchData=datas.get(i);
			PlayerPO thePlayer=PlayerListPO.findPlayerAccurately(oneMatchData.getName());
			standingDatas.add(new StandingDataPO(thePlayer.getName(), thePlayer.getPosition(), 
					thePlayer.getTeam(season),standingDataArray[i]));
		}
		return standingDatas;
	}
	
	class PlayerDataComparator implements Comparator {
		PlayerData dataType;
		public PlayerDataComparator(PlayerData dataType){
			this.dataType=dataType;
		}
		
		public int compare(Object o1, Object o2) {
			PlayerDataOfOneMatchPO f1=(PlayerDataOfOneMatchPO)o1;
			PlayerDataOfOneMatchPO f2=(PlayerDataOfOneMatchPO)o2;
			double number1 = 0;
			double number2 = 0;
			switch(dataType){
			case score:
				number1=f1.getScoreOfOneMatch();
				number2=f2.getScoreOfOneMatch();
				break;
			case numberOfRebound:
				number1=f1.getNumberOfReboundOfOneMatch();
				number2=f2.getNumberOfReboundOfOneMatch();
				break;
			case numberOfAssist:
				number1=f1.getNumberOfAssistOfOneMatch();
				number2=f2.getNumberOfAssistOfOneMatch();
				break;
			case numberOfBlock:
				number1=f1.getNumberOfBlockOfOneMatch();
				number2=f2.getNumberOfBlockOfOneMatch();
				break;
			case numberOfSteal:
				number1=f1.getNumberOfSteal();
				number2=f2.getNumberOfSteal();
				break;
			}
			
			if(number1>number2)
				return -1;
			else if(number1==number2)
				return 0;
			else
				return 1;
		}
	}

}
