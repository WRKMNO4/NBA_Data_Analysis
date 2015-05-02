package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.kmno4.common.Config;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import BusinessLogic.SortHelper.PlayerSortHelper;
import DataService.PlayerDataService.PlayerDataService;
import DataService.TeamDataService.TeamController;
import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import Enum.Zone;
import PO.MatchPO;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.SeasonListPO;
import PO.StandingDataPO;
import PO.TeamListPO;
import PO.TeamPO;

public class PlayerController implements PlayerBusinessLogic{
	PlayerDataService playerController;
	@Override
	public void init(String fileAddress) {
		// TODO Auto-generated method stub
		playerController = new DataService.PlayerDataService.PlayerController(fileAddress) ;
	}
	public void calculateFinalData(){
		playerController.calculateFinalData() ;
	}
	
	@Override
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard,PlayerData dataType,Season season) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> results = new ArrayList<PlayerPO>();
		for(PlayerPO onePlayer: playerController.getAllPlayers()){
			TeamPO ofTeam = TeamListPO.findTeamByShortName(onePlayer.getTeam(season));
			if(ofTeam!=null && onePlayer.getPosition().contains(position) && (ofTeam.getZone().equals(zone) || 
					ofTeam.getDistrict().equals(district)))
				results.add(onePlayer);
		}
		Collections.sort(results, new PlayerSortHelper(standard, dataType,season));
		if(results.size()>50)
			results = new ArrayList<>(results.subList(0, 50)) ;
		return results;
	}
	
	/**
	 * 
	 * @param position
	 * @param league
	 * @param lowAge
	 * @param highAge
	 * @param season
	 * @return 为了测试接口而设计的方法。
	 */
	@Override
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			String league, int lowAge, int highAge,Season season) {
		ArrayList<PlayerPO> results = new ArrayList<PlayerPO>();
		for(PlayerPO onePlayer: playerController.getAllPlayers()){
			TeamPO ofTeam = TeamListPO.findTeamByShortName(onePlayer.getTeam(season));
			if(ofTeam!=null && onePlayer.getPosition().contains(position) 
					&& ofTeam.getZone().toString().contains(league) && Integer.parseInt(onePlayer.getAge()) > lowAge
					&& Integer.parseInt(onePlayer.getAge()) <= highAge)
					results.add(onePlayer);
		}
		return results;
	}

	@Override
	public ArrayList<PlayerPO> sortPlayersByComprehension(String standard,PlayerData dataType,Season season) {
		ArrayList<PlayerPO> results= (ArrayList<PlayerPO>) playerController.getAllPlayers().clone();
		Collections.sort(results,new PlayerSortHelper(standard, dataType,season));
		return results;
	}
	@Override
	public ArrayList<PlayerPO> getAllPlayers() {
		// TODO Auto-generated method stub
		return playerController.getAllPlayers();
	}
	@Override
	public ArrayList<PlayerPO> findPlayerByName(String name) {
		// TODO Auto-generated method stub
		return playerController.findPlayerByName(name);
	}
	@Override
	public StandingDataPO getDatasOfDailyStandingPlayers(Season season, String date, PlayerData dataType) {
		// TODO Auto-generated method stub
		//transfer the date format
		
		ArrayList<MatchPO> matches = SeasonListPO.getMatchesOfOneDay(season,date);
		if(matches.size()==0)
			return null;
		ArrayList<PlayerDataOfOneMatchPO> datas=new ArrayList<>();
		for(MatchPO oneMatch : matches){
			datas.addAll(oneMatch.getFirstTeam_PlayerData());
			datas.addAll(oneMatch.getSecondTeam_PlayerData());
		}
		Collections.sort(datas,new PlayerDataComparator(dataType));
		
		double standingData = 0 ;
		switch(dataType){
		case score:
				standingData=datas.get(0).getScoreOfOneMatch();
			break;
		case numberOfRebound:
				standingData=datas.get(0).getNumberOfReboundOfOneMatch();
			break;
		case numberOfAssist:
				standingData=datas.get(0).getNumberOfAssistOfOneMatch();
			break;
		case numberOfBlock:
				standingData=datas.get(0).getNumberOfBlockOfOneMatch();
			break;
		case numberOfSteal:
				standingData=datas.get(0).getNumberOfSteal();
		}
		PlayerDataOfOneMatchPO oneMatchData=datas.get(0);
		PlayerPO thePlayer=PlayerListPO.findPlayerAccurately(oneMatchData.getName());
		StandingDataPO standingDataPO = new StandingDataPO(thePlayer.getName(), thePlayer.getPosition(), 
					thePlayer.getTeam(season),standingData);
		
		return standingDataPO;
	}
	@Override
	public ArrayList<StandingDataPO> getDatasOfDailyStandingPlayers(
			Season season, String date, PlayerData dataType,
			int number) {
		ArrayList<MatchPO> matches = SeasonListPO.getMatchesOfOneDay(season,date);
		if(matches.size()==0)
			return null;
		ArrayList<PlayerDataOfOneMatchPO> datas=new ArrayList<>();
		for(MatchPO oneMatch : matches){
			datas.addAll(oneMatch.getFirstTeam_PlayerData());
			datas.addAll(oneMatch.getSecondTeam_PlayerData());
		}
		Collections.sort(datas,new PlayerDataComparator(dataType));
		
		ArrayList<StandingDataPO> results = new ArrayList<>();
		for(int i=0;i<number;i++){
		double standingData = 0 ;
		switch(dataType){
		case score:
			standingData=datas.get(i).getScoreOfOneMatch();
			break;
		case numberOfRebound:
			standingData=datas.get(i).getNumberOfReboundOfOneMatch();
			break;
		case numberOfAssist:
			standingData=datas.get(i).getNumberOfAssistOfOneMatch();
			break;
		case numberOfBlock:
			standingData=datas.get(i).getNumberOfBlockOfOneMatch();
			break;
		case numberOfSteal:
			standingData=datas.get(i).getNumberOfSteal();
			break;
		}
		PlayerDataOfOneMatchPO oneMatchData=datas.get(i);
		PlayerPO thePlayer=PlayerListPO.findPlayerAccurately(oneMatchData.getName());
		StandingDataPO standingDataPO = new StandingDataPO(thePlayer.getName(), thePlayer.getPosition(), 
				thePlayer.getTeam(season),standingData);
		results.add(standingDataPO);
		}
		return results;
	}
	
	@Override
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season,
			PlayerData dataType) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> allPlayers = playerController.getAllPlayers() ;
		Collections.sort(allPlayers,new PlayerSortHelper("avg", dataType, season));
		ArrayList<PlayerPO> result =new ArrayList<>(allPlayers.subList(0,5));
		return result ;
	}
	
	@Override
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season,
			PlayerData dataType, int number) {
		ArrayList<PlayerPO> allPlayers = playerController.getAllPlayers() ;
		Collections.sort(allPlayers,new PlayerSortHelper("avg", dataType, season));
		ArrayList<PlayerPO> result =new ArrayList<>(allPlayers.subList(0,number));
		return result ;
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
	@Override
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season,
			PlayerData dataType) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> allPlayers = playerController.getAllPlayers() ;
		Collections.sort(allPlayers,new PlayerSortHelper("avg", dataType, season));
		ArrayList<PlayerPO> result = new ArrayList<>(allPlayers.subList(0, 5));
		return result ;
	}
	
	@Override
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season,
			PlayerData dataType, int number) {
		ArrayList<PlayerPO> allPlayers = playerController.getAllPlayers() ;
		Collections.sort(allPlayers,new PlayerSortHelper("avg", dataType, season));
		ArrayList<PlayerPO> result = new ArrayList<>(allPlayers.subList(0, number));
		return result ;
	}
	
	@Override
	public ArrayList<MatchPO> getLatest5Matches(PlayerPO player) {
		// TODO Auto-generated method stub
		ArrayList<MatchPO> allMatches = player.getMatches(Config.LASTEST_SEASON) ;
		if(allMatches.size()<5){
	        return allMatches ;
		}
		ArrayList<MatchPO> latest5Matches = new ArrayList<>(allMatches.subList(allMatches.size()-5, allMatches.size())) ;
		return latest5Matches ;
	}
	

	
	

}
