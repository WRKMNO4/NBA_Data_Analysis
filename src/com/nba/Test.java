package com.nba;

//此类为防止Github同步错误而新建的类
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

public class Test {
	BLService bl ;
	PrintStream out ;
	ArrayList<PlayerPO> allPlayers ;
	ArrayList<TeamPO> allTeams ;
	public Test(){
		bl = new BLServiceController("Data");
		bl.init();
	}
	public static void main(String[] args){
		Console c = new Console() ;
		c.execute(null, null);
		}
	public void execute(PrintStream out,String[] args){
		this.out =out ;
		
		TestConfig config = new TestConfig();
		Player player = new Player();
		CmdlineParser cp = new CmdlineParser(new Object[] { config, player });
		String comd = "-team" ;
		String[] comds = comd.split("\\s") ;
		try {
			cp.parse(comds);
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if (player.isHot) {
			getPlayerHotInfo(player.hotField,player.num) ;
		}
		if(player.isHigh) {
			getPlayerHighInfo(player.num) ;
		}
//		if()
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
	
	private ArrayList<PlayerHotInfo> getPlayerHotInfo(String field,int number){
		return null ;
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
		private boolean isHigh = false ;
		private boolean isAll = true ;
		private boolean isHot = false ;
		private String hotField ;
		private boolean isKing = false ;
		private String kingField ;
		private boolean isSeason ;
		private boolean isDaily ;
		
		@CmdOption(names = {"-high"},description = "show high info")
		public void isHigh(){
			this.isHigh = true ;
		}
				
		
		@CmdOption(names = { "-avg" }, description = "show avg",maxCount = 1, minCount = 0,conflictsWith={"-total"} )
		public void isAvg(){
			
		}
		
		@CmdOption(names ={"-hot"},args = {"field"},description = "show hot",maxCount = 1, minCount = 0,conflictsWith = {"-all","-king","-total","-avg","-filter","-sort"})
		public void setIsHot(String field){
			isHot = true ;
			isAll = false ;
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
			System.out.println("test king-------------");
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
			System.out.println("test daily____________");
		}
		
		@CmdOption(names = {"-all"},description = "show all information",maxCount = 1, minCount = 0,conflictsWith = {"-hot","-king"})
		public void setIsAll(){
			this.isHot = false ;
			this.isAll = true ;
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
		
		@CmdOption(names = {"-filter"},args = {"field.value"},description = "show filter info",conflictsWith = {"-sort","-king","-hot"})
		public void isFilter(String field){
			//调用bl方法
		}

		@CmdOption(names = {"-sort"},args = {"filed.sortOrder"},description = "show sort info",conflictsWith = {"-filter","-king","-hot"})
		public void isSort(String field){
			//调用bl方法
		}
				
	}
	
	@CmdCommand(names = { "-team","-t" },description = "Show Team information")
	class Team {
		private boolean isTotal;
		private boolean isAll=true;
		private boolean isHot;
		private String hotField;
		private boolean isHigh;
		private int num = 30 ;
		private boolean isSort;
		private String sortField;
		private boolean ifAscSort;
		
		@CmdOption(names={"-avg"},maxCount=1,minCount=0,conflictsWith={"-total","-hot"})
		private void setAvg(){
			isTotal=false;
		}
		
		@CmdOption(names={"-total"},maxCount=1,minCount=0,conflictsWith={"-avg","-hot"})
		private void setTotal(){
			isTotal=true;
		}
		
		@CmdOption(names = { "-n" }, args = { "number" }, maxCount = 1, minCount = 0)
		public void setNum(String number) {
			num = Integer.parseInt(number);
		}
		
		@CmdOption(names={"-all"},maxCount=1,minCount=0,conflictsWith={"-hot"})
		private void setAll(){
			isAll=true;
		}
		
		@CmdOption(names={"-hot"},args={"field"},maxCount=1,minCount=0,conflictsWith={"-all","-avg","-total","-sort"})
		private void setHot(String field){
			isHot=true;
			hotField=field;
			isAll=false;
		}
		
		@CmdOption(names={"-sort"},args={"field"},maxCount=1,minCount=0)
		private void setSort(String field){
			isSort=true;
			String[] tmpStr=field.split("\\.");
			sortField=tmpStr[0];
			if(tmpStr[1].equals("asc"))
				ifAscSort=true;
		}
	}
	

}


