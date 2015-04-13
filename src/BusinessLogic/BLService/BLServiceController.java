package BusinessLogic.BLService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import BusinessLogic.MatchBusinessLogic.MatchBusinessLogic;
import BusinessLogic.PlayerBusinessLogic.PlayerBusinessLogic;
import BusinessLogic.TeamBusinessLogic.TeamBusinessLogic;
import DataService.MatchDataService.MatchController;
import DataService.MatchDataService.MatchDataService;
import DataService.PlayerDataService.PlayerController;
import DataService.PlayerDataService.PlayerDataService;
import DataService.TeamDataService.TeamController;
import DataService.TeamDataService.TeamDataService;
import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import Enum.Zone;
import PO.MatchPO;
import PO.PlayerPO;
import PO.SeasonListPO;
import PO.StandingDataPO;
import PO.TeamPO;

import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class BLServiceController implements  BLService{
	SeasonListPO seasonList ;
	TeamBusinessLogic teamController ;
	PlayerBusinessLogic playerController ;
	MatchBusinessLogic matchController ;
	
	public BLServiceController() {
		this.seasonList = new SeasonListPO() ;
		this.teamController = new BusinessLogic.TeamBusinessLogic.TeamController() ;
		this.playerController = new BusinessLogic.PlayerBusinessLogic.PlayerController() ;
		this.matchController = new BusinessLogic.MatchBusinessLogic.MatchController() ;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		teamController.init();
		playerController.init();
		matchController.init();
		teamController.calculateFinalData();
		playerController.calculateFinalData();
		Runnable refresh = new Refresh() ;
		Thread t = new Thread(refresh) ;
		t.start();
	}

	void refresh(){
		matchController.init();
		teamController.calculateFinalData();
		playerController.calculateFinalData();
	}
	@Override
	public ArrayList<PlayerPO> getAllPlayers() {
		// TODO Auto-generated method stub
		return playerController.getAllPlayers();
	}

	@Override
	public ArrayList<TeamPO> getAllTeams() {
		// TODO Auto-generated method stub
		return teamController.getAllTeams();
	}

	@Override
	public ArrayList<PlayerPO> sortPlayersByComprehension(String standard,
			PlayerData dataType,Season season) {
		// TODO Auto-generated method stub
		return playerController.sortPlayersByComprehension(standard, dataType,season);
	}

	@Override
	public ArrayList<TeamPO> sortTeamsByComprehension(String standard,
			TeamData dataType,Season season) {
		// TODO Auto-generated method stub
		return teamController.sortTeamsByComprehension(standard, dataType,season) ;
	}

	@Override
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard, PlayerData dataType,Season season) {
		// TODO Auto-generated method stub
		return playerController.pickUpPlayersByCondition(position, zone, district,standard, dataType,season);
	}

	@Override
	public MatchPO findMatch(Season season, String date, String nameOfTeams) {
		// TODO Auto-generated method stub
		return matchController.findMatch(season, date, nameOfTeams) ;
	}

	@Override
	public ArrayList<PlayerPO> findPlayerByName(String name) {
		// TODO Auto-generated method stub
		return playerController.findPlayerByName(name);
	}

//	@Override
//	public ArrayList<TeamPO> findTeamByName(String name) {
//		// TODO Auto-generated method stub
//		return teamController.findTeamByName(name);
//	}

	@Override
	public ArrayList<StandingDataPO> getDatasOfDailyStandingPlayers(Season season,
			String date, PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.getDatasOfDailyStandingPlayers(season,
				date, dataType);
	}

	@Override
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season,
			PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.getSeasonStandingPlayer(season,dataType);
	}

	@Override
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,
			TeamData dataType) {
		// TODO Auto-generated method stub
		return teamController.getSeasonStandingTeam(season,dataType) ;
	}

	@Override
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season,
			PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.getMostImprovePlayer(season,dataType);
	}
	
	public ArrayList<MatchPO> getAllMatches(Season season) {
		// TODO Auto-generated method stub
		return matchController.getAllMatches(season);
	}
	
	class Refresh implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				refresh();
		    	System.out.println("In 2012 There are "+getAllMatches(Season.season12_13).size()+"matches");
		    	System.out.println("In 2013 There are "+getAllMatches(Season.season13_14).size()+"matches");
		    	System.out.println("End one turn");
		    	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} 
		    	}
			}
		}
	}

	
