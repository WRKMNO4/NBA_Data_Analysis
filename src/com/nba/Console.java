package com.nba;


import java.io.PrintStream;
import java.util.ArrayList;

import com.kmno4.common.Config;

import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;
import de.tototec.cmdoption.CmdlineParserException;
import BusinessLogic.BLService.BLService;
import BusinessLogic.BLService.BLServiceController;
import PO.PlayerDataPO;
import PO.PlayerPO;
import PO.SeasonInfoForPlayer;
import PO.SeasonInfoForTeam;
import PO.TeamDataPO;
import PO.TeamListPO;
import PO.TeamPO;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamNormalInfo;

public class Console {
	BLService bl ;
	PrintStream out ;
	ArrayList<PlayerPO> allPlayers ;
	ArrayList<TeamPO> allTeams ;
	
	
	void getMostImprovedPlayer(String hotField,int topNumber){
		//  
	}
	void getDailyStandingPlayer(String kingField){
	}
	void getSeasonStandingPlayer(String kingField){
	}
	ArrayList<PlayerPO> getfilterPlayersByField(String field, boolean isAll2,
			boolean isAsc2, int num2, boolean showTotal2) {
		return null ;
	}
    void getSortPlayerByField(boolean showTotal2, boolean isHigh2,
			int num2, String field) {
    	
	}
    void getSortAndFilter(boolean showTotal, boolean isHigh, int num,
			String sortField) {
	}
	
    
    
    
    
	public void execute(PrintStream out,String[] args){
		this.out =out ;
		System.setOut(out);
		if(args[0].contains("datasource")){
			bl = new BLServiceController(args[1]) ;
			bl.init();
			return ;
		}
		
		TestConfig config = new TestConfig();
		Player player = new Player();
		
		CmdlineParser cp = new CmdlineParser(new Object[] { config, player }) ;
		try {
			cp.parse(args);
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if(player.isHot)
			getMostImprovedPlayer(player.hotField,player.getTopnumber()) ;
		else if(player.isKing){
			    if(player.isDaily)
					getDailyStandingPlayer(player.kingField) ;
				else
					getSeasonStandingPlayer(player.kingField) ;
	     	}else{
	     		if(player.isFilter&&!player.isSort)
	     			getSortAndFilter(player.showTotal, player.isHigh, player.num, player.sortField) ;
	     		else if(player.isSort&&!player.isFilter)
	     			getSortPlayerByField(player.showTotal, player.isHigh, player.num, player.sortField);
	     		else if(player.isFilter&&player.isSort)
	     			getSortAndFilter(player.showTotal, player.isHigh, player.num, player.sortField) ;
	     			
	     	 }
	     	
	     	
		  
/*	
//-----------------------------------------------------------------------------		
		
		}
//--------------------------------------------------------------------------------
		for(PlayerPO onePlayer : allPlayers){
			PlayerNormalInfo playerNormalInfo = new PlayerNormalInfo() ;
			SeasonInfoForPlayer infoOfSeason = onePlayer.getSeasonInfo(Config.LASTEST_SEASON) ;
			PlayerDataPO totalInfo = infoOfSeason.getTotalPlayerData() ;
			PlayerDataPO avgInfo = infoOfSeason.getAveragePlayerData() ;
			playerNormalInfo.setAge(Integer.parseInt(onePlayer.getAge()));
			playerNormalInfo.setAssist(totalInfo.getNumberOfAssist());
			playerNormalInfo.setBlockShot(totalInfo.getNumberOfBlock()) ;
			playerNormalInfo.setDefend(totalInfo.getNumberOfDefense());
			playerNormalInfo.setEfficiency(avgInfo.getEfficiencyOfTotal());
			playerNormalInfo.setFault(totalInfo.getNumberOfFault());
			playerNormalInfo.setFoul(totalInfo.getNumberOfFoul());
			playerNormalInfo.setMinute(PlayerDataPO.transportTime(totalInfo.getPresentTime())/60.0);
			playerNormalInfo.setName(onePlayer.getName() );
			playerNormalInfo.setNumOfGame(totalInfo.getNumberOfMatch());
			playerNormalInfo.setOffend(totalInfo.getNumberOfAttack());
			playerNormalInfo.setPenalty(avgInfo.getPercentageOffreeThrow());
			playerNormalInfo.setPoint(totalInfo.getScore());
			playerNormalInfo.setRebound(totalInfo.getNumberOfRebound());
			playerNormalInfo.setShot(avgInfo.getPercentageOfShooting());
			playerNormalInfo.setStart(totalInfo.getNumberOfStarting());
			playerNormalInfo.setSteal(totalInfo.getNumberOfSteal());
			if(!infoOfSeason.getTeam().equals("Unknown"))
				playerNormalInfo.setTeamName(infoOfSeason.getTeam());
			playerNormalInfo.setThree(avgInfo.getPercentageOf3_Point());
		}
		
//--------------------------------------------------------------------------------
		for(TeamPO oneTeam: allTeams){
			TeamNormalInfo teamNormalInfo = new TeamNormalInfo();
			SeasonInfoForTeam seasonInfo = oneTeam.getSeasonInfo(Config.LASTEST_SEASON);
			TeamDataPO totalInfo=seasonInfo.getTotalTeamData();
			TeamDataPO avgInfo=seasonInfo.getAverageTeamData();
			teamNormalInfo.setAssist(totalInfo.getNumberOfAssist());
			teamNormalInfo.setBlockShot(totalInfo.getNumberOfBlock());
			teamNormalInfo.setDefendRebound(totalInfo.getNumberOfDefenseRebound());
			teamNormalInfo.setFault(totalInfo.getNumberOfFault());
			teamNormalInfo.setFoul(totalInfo.getNumberOfFoul());
			teamNormalInfo.setNumOfGame(seasonInfo.getNumberOfMatches());
			teamNormalInfo.setOffendRebound(totalInfo.getNumberOfAttackRebound());
			teamNormalInfo.setPenalty(avgInfo.getPercentageOfFreeThrow());
			teamNormalInfo.setPoint(totalInfo.getScore());
			teamNormalInfo.setRebound(totalInfo.getNumberOfRebound());
			teamNormalInfo.setShot(avgInfo.getPercentageOfShooting());
			teamNormalInfo.setSteal(totalInfo.getNumberOfSteal());
			teamNormalInfo.setTeamName(oneTeam.getShortName());
			teamNormalInfo.setThree(avgInfo.getPercentageOf3_point());
			}
		
//--------------------------------------------------------------------------------
		for(TeamPO oneTeam: allTeams){
			TeamHighInfo teamHighInfo = new TeamHighInfo();
			SeasonInfoForTeam seasonInfo = oneTeam.getSeasonInfo(Config.LASTEST_SEASON);
			TeamDataPO totalInfo=seasonInfo.getTotalTeamData();
			TeamDataPO avgInfo=seasonInfo.getAverageTeamData();
			teamHighInfo.setAssistEfficient(avgInfo.getEfficiencyOfAssist());
			teamHighInfo.setDefendEfficient(avgInfo.getEfficiencyOfDefense());
			teamHighInfo.setDefendReboundEfficient(avgInfo.getEfficiencyOfDefenseRebound());
			teamHighInfo.setOffendEfficient(avgInfo.getEfficiencyOfAttack());
			teamHighInfo.setOffendReboundEfficient(avgInfo.getEfficiencyOfAttackRebound());
			teamHighInfo.setOffendRound(avgInfo.getRoundOfAttack());
			teamHighInfo.setStealEfficient(avgInfo.getEfficiencyOfSteal());
			teamHighInfo.setTeamName(oneTeam.getShortName());
			teamHighInfo.setWinRate(seasonInfo.getPercentageOfWinning());
			
		}
		*/
		
	}
	private void getPlayerHighInfo(int number){
		allPlayers = bl.getAllPlayers() ;
		for(PlayerPO onePlayer : allPlayers){
			TeamPO team = TeamListPO.findTeamByShortName(onePlayer.getTeam(Config.LASTEST_SEASON));
			SeasonInfoForPlayer info = onePlayer.getSeasonInfo(Config.LASTEST_SEASON);
			PlayerDataPO avgInfo=info.getAveragePlayerData();
			PlayerDataPO totalInfo = info.getTotalPlayerData() ;
			PlayerHighInfo playerHighInfo = new PlayerHighInfo() ;
			playerHighInfo.setAssistEfficient(avgInfo.getPercentageOfAssist());
			playerHighInfo.setBlockShotEfficient(avgInfo.getPercentageOfBlock());
			playerHighInfo.setDefendReboundEfficient(avgInfo.getPercentageOfDefenseRebound());
			playerHighInfo.setFaultEfficient(avgInfo.getPercentageOfFault());
			playerHighInfo.setFrequency(avgInfo.getPercentageOfUse());
			playerHighInfo.setGmSc(avgInfo.getEfficiencyOfGmSc());
			if(team!=null)
			playerHighInfo.setLeague(team.getZone().toString());
			playerHighInfo.setName(onePlayer.getName());
			playerHighInfo.setOffendReboundEfficient(avgInfo.getPercentageOfAttackingRebound());
			playerHighInfo.setPosition(onePlayer.getPosition());
			playerHighInfo.setRealShot(avgInfo.getPercentageOfTrueShooting());
			playerHighInfo.setReboundEfficient(avgInfo.getPercentageOfRebound());
			playerHighInfo.setShotEfficient(avgInfo.getEfficiencyOfShooting());
			playerHighInfo.setStealEfficient(avgInfo.getPercentageOfSteal());
			if(team!=null)
			playerHighInfo.setTeamName(team.getShortName());
			out.print(playerHighInfo);
    	}
	}
	
	
	class TestConfig {
		@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
		public boolean help;
	}

	@CmdCommand(names = { "-player","-p" },description = "Show Player information")
	class Player {
		private boolean showTotal = false;
		private int num = 50;
		private int topNumber = 5 ;
		private boolean isHigh = false ;
		private boolean isAll = true ;
		private boolean isHot = false ;
		private String hotField ;
		private boolean isKing = false ;
		private String kingField ;
		private boolean isSeason ;
		private boolean isDaily ;
		private boolean isAsc = false ;
		private boolean isFilter = false  ;
		private String filterField ;
		private boolean isSort = false  ;
		private String sortField ;
		
		@CmdOption(names = {"-high"},description = "show high info")
		public void isHigh(){
			this.isHigh = true ;
		}
				
		
		@CmdOption(names = { "-avg" }, description = "show avg",maxCount = 1, minCount = 0,conflictsWith={"-total"} )
		public void isAvg(){
			showTotal =false ;
		}
		
		@CmdOption(names ={"-hot"},args = {"field"},description = "show hot",maxCount = 1, minCount = 0,conflictsWith = {"-all","-king","-total","-avg","-filter","-sort"})
		public void setIsHot(String field){
			isHot = true ;
			isAll = false ;
			isKing = false ;
			this.hotField = field ;
		}
		public String getHotField(){
			return hotField ;
		}
		
		
		@CmdOption(names ={"-king"},args = {"field"},description = "show king",maxCount = 1 ,minCount = 0,conflictsWith = {"-avg","-total","-all","-hot","-filter","-sort"})
		public void setIsKing(String field){
			isKing = true ;
			isHot = false ;
			isAll = false ;
			kingField = field ;
		}
		
		@CmdOption(names ={"-season"},description = "show season info",conflictsWith = {"-daily"},requires = {"-king"})
		public void setIsSeason(){
			isSeason = true ;
			isDaily = false ;
		}

		@CmdOption(names ={"-daily"},description = "show daily info",conflictsWith = {"-season"},requires = {"-king"})
		public void setIsDaily(){
			isSeason = false ;
			isDaily = true ;
		}
		
		@CmdOption(names = {"-all"},description = "show all information",maxCount = 1, minCount = 0,conflictsWith = {"-hot","-king"})
		public void setIsAll(){
			this.isHot = false ;
			this.isAll = true ;
			this.isKing = false ;
		}

		@CmdOption(names = { "-total" }, description = "show total",maxCount = 1, minCount = 0,conflictsWith={"-avg"} )
		public void setShowTotal() {
			this.showTotal = true;
		}
		
		public boolean isShowTotal() {
			return showTotal;
		}

		@CmdOption(names = { "-n" }, args = { "number" }, maxCount = 1, minCount = 0)
		public void setNum(String number) {
			this.num = Integer.parseInt(number);
		}
		
		public int getNum() {
			return num;
		}
		public int getTopnumber(){
			return topNumber ;
		}
		
		@CmdOption(names = {"-filter"},args = {"field.value"},description = "show filter info",conflictsWith = {"-sort","-king","-hot"})
		public void isFilter(String field){
		}

		@CmdOption(names = {"-sort"},args = {"filed.sortOrder"},description = "show sort info",conflictsWith = {"-filter","-king","-hot"})
		public void isSort(String field){
			
		}
	}
	
	class Team {
		
	}
	
	

}

