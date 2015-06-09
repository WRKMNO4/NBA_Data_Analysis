package BusinessLogic.BLService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import BusinessLogic.MatchBusinessLogic.MatchBusinessLogic;
import BusinessLogic.PlayerBusinessLogic.PlayerBusinessLogic;
import BusinessLogic.Statistics.StatisticsBusinessLogic;
import BusinessLogic.Statistics.StatisticsController;
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
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerDataPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.SeasonInfoForPlayer;
import PO.SeasonListPO;
import PO.SeasonPO;
import PO.StandingDataPO;
import PO.TeamPO;

import com.kmno4.common.Config;
import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class BLServiceController implements  BLService{
	SeasonListPO seasonList ;
	TeamBusinessLogic teamController ;
	PlayerBusinessLogic playerController ;
	MatchBusinessLogic matchController ;
	StatisticsBusinessLogic statisticsController ;
	String fileAddress;
	
	public BLServiceController(String fileAddress) {
		this.seasonList = new SeasonListPO() ;
		this.teamController = new BusinessLogic.TeamBusinessLogic.TeamController() ;
		this.playerController = new BusinessLogic.PlayerBusinessLogic.PlayerController() ;
		this.matchController = new BusinessLogic.MatchBusinessLogic.MatchController() ;
		this.statisticsController = new StatisticsController(fileAddress) ;
		this.fileAddress=fileAddress;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		teamController.init(fileAddress);
		playerController.init(fileAddress);
		matchController.init(fileAddress);
		teamController.calculateFinalData();
		playerController.calculateFinalData();
		Runnable refresh = new Refresh() ;
		Thread t = new Thread(refresh) ;
		t.start();
	}

	void refresh(){
		matchController.init(fileAddress);
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
	public ArrayList<PlayerPO> pickUpPlayerByCondition(String position,
			String league, int lowAge, int highAge,Season season) {
		if(position.equals("All"))
			position="";
		if(league.equals("All"))
			league="";
		return playerController.pickUpPlayersByCondition(position,league,lowAge,highAge,season);
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
	public StandingDataPO getDatasOfDailyStandingPlayers(PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.getDatasOfDailyStandingPlayers(Config.LASTEST_SEASON,
				Config.LASTEST_DATE , dataType);
	}
	
	@Override
	public ArrayList<StandingDataPO> getDatasOfDailyStandingPlayer(
			PlayerData dataType, int number) {
		return playerController.getDatasOfDailyStandingPlayers(Config.LASTEST_SEASON,
				Config.LASTEST_DATE , dataType, number);
	}

	@Override
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season,
			PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.getSeasonStandingPlayer(season,dataType);
	}


	@Override
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season,
			PlayerData dataType, int number) {
		
		return playerController.getSeasonStandingPlayer(season,dataType,number);
	}
	
	@Override
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,
			TeamData dataType) {
		// TODO Auto-generated method stub
		return teamController.getSeasonStandingTeam(season,dataType) ;
	}

	@Override
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,
			TeamData dataType, int number) {
		return teamController.getSeasonStandingTeam(season,dataType,number) ;
	}
	
	@Override
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season,
			PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.getMostImprovePlayer(season,dataType);
	}

	@Override
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season,
			PlayerData dataType, int number) {
		return playerController.getMostImprovePlayer(season,dataType,number);
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
		    	try {
					Thread.sleep(10 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} 
		    	}
			}
		}

	@Override
	public ArrayList<MatchPO> getLatestTeam() {
		// TODO Auto-generated method stub
		return getAllMatches(Config.LASTEST_SEASON);
	}

	@Override
	public ArrayList<MatchPO> getLatest5MatchesForPlayer(PlayerPO player) {
		// TODO Auto-generated method stub
		return playerController.getLatest5Matches(player);
	}

	@Override
	public ArrayList<MatchPO> getLatest5MatchesForTeam(TeamPO team) {
		// TODO Auto-generated method stub
		return teamController.getLatest5Matches(team);
		}

	@Override
	public ArrayList<TeamPO> getTeamRankings(Season season, Zone zone) {
		return teamController.getTeamRankings(season, zone);
	}

	@Override
	public ArrayList<Double> getSeasonAvgData(Season season) {
		SeasonPO theSeason = SeasonListPO.getSeasonPO(season) ;
		return theSeason.getAvgDataOfAllPlayer();
	}

	@Override
	public ArrayList<Double> getAllSeasonsDataOfOnePlayer(PlayerData dataType,
			PlayerPO player) {
		// TODO Auto-generated method stub
		ArrayList<Double> results = new ArrayList<>() ;
		ArrayList<SeasonInfoForPlayer> infos = player.getSeasonInfos() ;
		for(SeasonInfoForPlayer oneSeason : infos){
			PlayerDataPO avgData = oneSeason.getAveragePlayerData() ;
			switch(dataType){
			case percentageOfShooting:
				results.add(avgData.getPercentageOfShooting()) ;
				break ;
			case efficiency:
				results.add(avgData.getEfficiency()) ;
				break ;
			case percentageOfUse:
				results.add(avgData.getPercentageOfUse()) ;
				break ;
			case percentageOfFault:
				results.add(avgData.getPercentageOfFault()) ;
				break ;
			}
		}
		return results;
	}

	@Override
	public ArrayList<Double> getAllMatchesDataOfOnePlayerOfOneSeason(
			PlayerData dataType, PlayerPO player, Season season) {
		// TODO Auto-generated method stub
		ArrayList<Double> results = new ArrayList<>() ;
		SeasonInfoForPlayer seasonInfo = player.getSeasonInfo(season) ;
		ArrayList<MatchPO> matches = seasonInfo.getMatches() ;
		for(MatchPO oneMatch:matches){
			PlayerDataOfOneMatchPO theMatchData = oneMatch.getPlayerDataOfOneMatchByName(player.getName()) ;
			switch(dataType){
			case percentageOfShooting:
				results.add(theMatchData.getPercentageOfShooting()) ;
				break ;
			case efficiency:
				results.add(theMatchData.getEfficiency()) ;
				break ;
			case percentageOfUse:
				results.add(theMatchData.getPercentageOfUse()) ;
				break ;
			case percentageOfFault:
				results.add(theMatchData.getPercentageOfFault()) ;
				break ;
			}
		}
		return results;
	}

	@Override
	public ArrayList<ArrayList<String>> getPlayerHighInfo() {
		return playerController.getPlayerHighInfo(fileAddress);
	}

	@Override
	public ArrayList<Integer> getRankingOfOneTeamIn3Years(String teamShortName) {
//		return teamController.getRankingOfOneTeamIn3Years(teamShortName);
		return new ArrayList<Integer>();
	}

	@Override
	public boolean ifStableThanSelf(PlayerPO player, PlayerData dataType,
			Season season) {
		
		return statisticsController.ifStableThanSelf(player, dataType, season);
	}

	@Override
	public boolean ifBetterThanSelf(PlayerPO player, PlayerData dataType,
			Season season) {
		
		return statisticsController.ifBetterThanSelf(player, dataType, season);
	}

	@Override
	public boolean ifStableThanAnother(PlayerPO player, PlayerPO anotherPlayer,
			PlayerData dataType, Season season) {
		
		return statisticsController.ifStableThanAnother(player, anotherPlayer, dataType, season);
	}

	@Override
	public boolean ifBetterThanAnother(PlayerPO player, PlayerPO anotherPlayer,
			PlayerData dataType, Season season) {
		
		return statisticsController.ifBetterThanAnother(player, anotherPlayer, dataType, season);
	}

	

	}