package com.nba;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import com.kmno4.common.Config;

import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;
import de.tototec.cmdoption.CmdlineParserException;
import BusinessLogic.BLService.BLService;
import BusinessLogic.BLService.BLServiceController;
import BusinessLogic.SortHelper.PlayerSortHelper;
import BusinessLogic.SortHelper.TransferSortHelper;
import Enum.PlayerData;
import Enum.TeamData;
import Enum.Zone;
import PO.PlayerDataPO;
import PO.PlayerPO;
import PO.SeasonInfoForPlayer;
import PO.SeasonInfoForTeam;
import PO.StandingDataPO;
import PO.TeamDataPO;
import PO.TeamListPO;
import PO.TeamPO;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;

public class Console {
	public static BLService bl ;
	PrintStream out ;
	ArrayList<PlayerPO> allPlayers ;
	ArrayList<TeamPO> allTeams ;
	
	
	void getMostImprovedPlayer(String hotField,int topNumber){
		PlayerData dataType = TransferSortHelper.ConsoleStringToDataTypeForPlayer(hotField+"ImprovedRate") ;
		ArrayList<PlayerPO> players = bl.getMostImprovePlayer(Config.LASTEST_SEASON, dataType, topNumber) ;
		int i = 0 ;
		for(PlayerPO onePlayer:players){
			i++ ;
			PlayerHotInfo thePlayer = new PlayerHotInfo() ;
			SeasonInfoForPlayer thePlayerSeasonInfo = onePlayer.getSeasonInfo(Config.LASTEST_SEASON) ;
			thePlayer.setField(hotField);
			thePlayer.setName(onePlayer.getName());
			thePlayer.setPosition(onePlayer.getPosition());
			thePlayer.setTeamName(thePlayerSeasonInfo.getTeam());
			switch(dataType){
			case improveRateOfScore:
				thePlayer.setUpgradeRate(thePlayerSeasonInfo.getImprovedRateOfScore());
				thePlayer.setValue(thePlayerSeasonInfo.getAveragePlayerData().getScore());
				break;
			case improveRateOfAssist:
				thePlayer.setUpgradeRate(thePlayerSeasonInfo.getImprovedRateOfAssist());
				thePlayer.setValue(thePlayerSeasonInfo.getAveragePlayerData().getNumberOfAssist());
				break ;
			case improveRateOfRebound:
				thePlayer.setUpgradeRate(thePlayerSeasonInfo.getImprovedRateOfRebound());
				thePlayer.setValue(thePlayerSeasonInfo.getAveragePlayerData().getNumberOfRebound());
				break ;
			}
			out.print(i);
			out.print(thePlayer);
		}
		
	}
	void getDailyStandingPlayer(String kingField, int topNumber){
		PlayerData dataType = TransferSortHelper.ConsoleStringToDataTypeForPlayer(kingField) ;
		ArrayList<StandingDataPO> players = bl.getDatasOfDailyStandingPlayer(dataType, topNumber) ;
		int i = 0 ;
		for(StandingDataPO onePlayer : players){
			i++ ;
			PlayerKingInfo thePlayer = new PlayerKingInfo() ;
			thePlayer.setField(kingField); 
			thePlayer.setName(onePlayer.getPlayerName());
			thePlayer.setPosition(onePlayer.getPosition());
			thePlayer.setTeamName(onePlayer.getTeam());
			thePlayer.setValue(onePlayer.getData());
			out.print(i);
			out.print(thePlayer);
		}
	}
	void getSeasonStandingPlayer(String kingField, int topNumber){
		PlayerData dataType = TransferSortHelper.ConsoleStringToDataTypeForPlayer(kingField) ;
		ArrayList<PlayerPO> players = bl.getSeasonStandingPlayer(Config.LASTEST_SEASON, dataType, topNumber) ;
		int i=0;
		for(PlayerPO onePlayer:players){
			i++ ;
			PlayerKingInfo thePlayer = new PlayerKingInfo() ;
			SeasonInfoForPlayer thePlayerSeasonInfo = onePlayer.getSeasonInfo(Config.LASTEST_SEASON) ;
			thePlayer.setField(kingField);
			thePlayer.setName(onePlayer.getName());
			thePlayer.setPosition(onePlayer.getPosition());
			thePlayer.setTeamName(thePlayerSeasonInfo.getTeam());
			switch(dataType){
			case score:
				thePlayer.setValue(thePlayerSeasonInfo.getAveragePlayerData().getScore());
				break ;
			case numberOfRebound:
			    thePlayer.setValue(thePlayerSeasonInfo.getAveragePlayerData().getNumberOfRebound());
			    break ;
			case numberOfAssist:
				thePlayer.setValue(thePlayerSeasonInfo.getAveragePlayerData().getNumberOfAssist()) ;
				break ;
			}
			out.print(i);
			out.print(thePlayer);
		}
	}
	ArrayList<PlayerPO> getfilterPlayersByField(String field) {
		String position = "All" ;
		String league = "All" ;
		String age = "All" ;
		String[] strs = field.split(",") ;
		for(int i = 0;i<strs.length;i++){
			String[] cmds = strs[i].split("\\.") ;
			switch(cmds[0]){
			case "position":
				position = cmds[1] ;
				break ;
			case "league":
				league = cmds[1] ;
				break ;
			case "age":
				age = cmds[1] ;
				break ;
			}
		}
		int lowAge = 0 ;
		int highAge = 100 ;
		if(!age.equals("All")){
			String low2 = age.substring(0,2) ;
			String high2 = age.substring(age.length()-2,age.length()) ;
			
			highAge = Integer.parseInt(high2) ;
				
			try{
				lowAge = Integer.parseInt(low2) ;
			}catch(Exception e){
				
				if(age.charAt(0)=='<'){
					lowAge = 0 ;
				}
				if(age.charAt(0)=='>'){
					lowAge = highAge ;
					highAge = 100 ;
				}
			}
		}
		ArrayList<PlayerPO> players = bl.pickUpPlayerByCondition(position, league,lowAge,highAge,Config.LASTEST_SEASON) ;
		
		return players ;
	}
    
	void getSortPlayerByField(boolean showTotal2, boolean isHigh2,
			int num2, String field) {
    	String standard = showTotal2? "total":"avg" ;
    	if(isHigh2&&field.equals(""))
    		field = "realShot.desc" ;
    	if(!isHigh2&&field.equals(""))
    		field = "score.desc" ;
    	String[] strs = field.split(",") ;
    	String[] cmds = strs[0].split("\\.") ;
    	PlayerData dataType = TransferSortHelper.ConsoleStringToDataTypeForPlayer(cmds[0]) ;
    	ArrayList<PlayerPO> players = bl.sortPlayersByComprehension(standard, dataType, Config.LASTEST_SEASON) ;
    	if(players.size()>num2)
    		players = new ArrayList<>(players.subList(0,num2)) ;
    	
    	int i = 0 ;
    	
    	if(cmds[1].equals("asc"))
    		Collections.reverse(players);
    	
    		if(showTotal2){
    			for(PlayerPO onePlayer:players){
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
       	     		i++ ;
       	     		out.print(i);
       	         	out.print(playerNormalInfo) ;
    			}
    		}else{
    			for(PlayerPO onePlayer:players){
        			PlayerNormalInfo playerNormalInfo = new PlayerNormalInfo() ;
        			SeasonInfoForPlayer infoOfSeason = onePlayer.getSeasonInfo(Config.LASTEST_SEASON) ;
        			PlayerDataPO avgInfo = infoOfSeason.getAveragePlayerData() ;
        			PlayerDataPO totalInfo = infoOfSeason.getTotalPlayerData() ;
        			
            		playerNormalInfo.setAge(Integer.parseInt(onePlayer.getAge()));
            		playerNormalInfo.setAssist(avgInfo.getNumberOfAssist());
            		playerNormalInfo.setBlockShot(avgInfo.getNumberOfBlock()) ;
            		playerNormalInfo.setDefend(avgInfo.getNumberOfDefense());
            		playerNormalInfo.setEfficiency(avgInfo.getEfficiency());
            		playerNormalInfo.setFault(avgInfo.getNumberOfFault());
            		playerNormalInfo.setFoul(avgInfo.getNumberOfFoul());
            		playerNormalInfo.setMinute(PlayerDataPO.transportTime(avgInfo.getPresentTime())/60.0);
            		playerNormalInfo.setName(onePlayer.getName() );
            		playerNormalInfo.setNumOfGame(totalInfo.getNumberOfMatch());
            		playerNormalInfo.setOffend(avgInfo.getNumberOfAttack());
            		playerNormalInfo.setPenalty(avgInfo.getPercentageOffreeThrow());
            		playerNormalInfo.setPoint(avgInfo.getScore());
            		playerNormalInfo.setRebound(avgInfo.getNumberOfRebound());
            		playerNormalInfo.setShot(avgInfo.getPercentageOfShooting());
            		playerNormalInfo.setStart(totalInfo.getNumberOfStarting());
            		playerNormalInfo.setSteal(avgInfo.getNumberOfSteal());
            		if(!infoOfSeason.getTeam().equals("Unknown"))
            			playerNormalInfo.setTeamName(infoOfSeason.getTeam());
            		playerNormalInfo.setThree(avgInfo.getPercentageOf3_Point());
            	
            		i++ ;
            		out.print(i);
        			out.print(playerNormalInfo) ;
        		}
    		}
	}
    void getSortAndFilterForPlayer(boolean showTotal, int num,boolean isHigh,
			String sortField,String filterField) {
    	ArrayList<PlayerPO> players = getfilterPlayersByField(filterField) ;

    	if(isHigh&&sortField.equals(""))
    		sortField = "realShot.desc" ;
    	if(!isHigh&&sortField.equals(""))
    		sortField = "score.desc" ;
    	String standard = showTotal? "total":"avg" ;
    	String[] strs = sortField.split(",") ;
    	String[] cmds = strs[0].split("\\.") ;
    	PlayerData dataType = TransferSortHelper.ConsoleStringToDataTypeForPlayer(cmds[0]) ;
    	if(dataType==PlayerData.percentageOf3_Point||dataType==PlayerData.percentageOfShooting||dataType==PlayerData.percentageOfFreeThrow)
    		standard="avg";
    	Collections.sort(players, new PlayerSortHelper(standard, dataType, Config.LASTEST_SEASON));
    	if(players.size()>num)
    		players = new ArrayList<>(players.subList(0,num)) ;
    	
    	if(cmds[1].equals("asc"))
    		Collections.reverse(players);
    	
    	int i = 0 ;
    	if(isHigh){
    		for(PlayerPO onePlayer:players){
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
    				playerHighInfo.setLeague(team.getZone()==Zone.W?"West":"East");
    			playerHighInfo.setName(onePlayer.getName());
    			playerHighInfo.setOffendReboundEfficient(avgInfo.getPercentageOfAttackingRebound());
    			playerHighInfo.setPosition(onePlayer.getPosition());
    			playerHighInfo.setRealShot(avgInfo.getPercentageOfTrueShooting());
    			playerHighInfo.setReboundEfficient(avgInfo.getPercentageOfRebound());
    			playerHighInfo.setShotEfficient(avgInfo.getEfficiencyOfShooting());
    			playerHighInfo.setStealEfficient(avgInfo.getPercentageOfSteal());
    			if(team!=null)
    			playerHighInfo.setTeamName(team.getShortName());
    			i++ ;
    			out.print(i);
    			out.print(playerHighInfo);
        	}
    	}else{
    		if(showTotal){
    			for(PlayerPO onePlayer:players){
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
       	     		i++ ;
       	     		out.print(i);
       	         	out.print(playerNormalInfo) ;
    			}
    		}else{
    			for(PlayerPO onePlayer:players){
        			PlayerNormalInfo playerNormalInfo = new PlayerNormalInfo() ;
        			SeasonInfoForPlayer infoOfSeason = onePlayer.getSeasonInfo(Config.LASTEST_SEASON) ;
        			PlayerDataPO totalInfo = infoOfSeason.getTotalPlayerData() ;
        			PlayerDataPO avgInfo = infoOfSeason.getAveragePlayerData() ;
       
            		playerNormalInfo.setAge(Integer.parseInt(onePlayer.getAge()));
            		playerNormalInfo.setAssist(avgInfo.getNumberOfAssist());
            		playerNormalInfo.setBlockShot(avgInfo.getNumberOfBlock()) ;
            		playerNormalInfo.setDefend(avgInfo.getNumberOfDefense());
            		playerNormalInfo.setEfficiency(avgInfo.getEfficiency());
            		playerNormalInfo.setFault(avgInfo.getNumberOfFault());
            		playerNormalInfo.setFoul(avgInfo.getNumberOfFoul());
            		playerNormalInfo.setMinute(PlayerDataPO.transportTime(avgInfo.getPresentTime())/60.0);
            		playerNormalInfo.setName(onePlayer.getName() );
            		playerNormalInfo.setNumOfGame(totalInfo.getNumberOfMatch());
            		playerNormalInfo.setOffend(avgInfo.getNumberOfAttack());
            		playerNormalInfo.setPenalty(avgInfo.getPercentageOffreeThrow());
            		playerNormalInfo.setPoint(avgInfo.getScore());
            		playerNormalInfo.setRebound(avgInfo.getNumberOfRebound());
            		playerNormalInfo.setShot(avgInfo.getPercentageOfShooting());
            		playerNormalInfo.setStart(totalInfo.getNumberOfStarting());
            		playerNormalInfo.setSteal(avgInfo.getNumberOfSteal());
            		if(!infoOfSeason.getTeam().equals("Unknown"))
            			playerNormalInfo.setTeamName(infoOfSeason.getTeam());
            		playerNormalInfo.setThree(avgInfo.getPercentageOf3_Point());
            	
            		i++ ;
            		out.print(i);
        			out.print(playerNormalInfo) ;
        		}
    		}
    		
    	}
	
    	
	}
    //----------------------------Team-----------------------------
    void getHotTeam(String hotField, int num) {
    	TeamData dataType=TransferSortHelper.ConsoleStringToDataTypeForTeam(hotField);
    	ArrayList<TeamPO> teams = bl.getSeasonStandingTeam(Config.LASTEST_SEASON, dataType);
    	if(num<=50)
    		teams = new ArrayList<>(teams.subList(0, num));
    	outputTeamHotInfo(teams,hotField);
    	
	}
    
	void getSortTeamByField(boolean isTotal, boolean isHigh, int num, String sortField,boolean ifAscSort) {
    	TeamData dataType=TransferSortHelper.ConsoleStringToDataTypeForTeam(sortField);
    	String standard = isTotal? "total":"avg";
    	ArrayList<TeamPO> teams=bl.sortTeamsByComprehension(standard, dataType, Config.LASTEST_SEASON);
    	teams = new ArrayList<>(teams.subList(0, num));
    	if(ifAscSort)
    		Collections.reverse(teams);
    	if(isHigh)
    		outputTeamHighInfo(teams);
    	else{
    		if(isTotal)
    			outputTeamNormalTotalInfo(teams);
    		else
    			outputTeamNormalAvgInfo(teams);
    	}
	}
    
    
    
	public void execute(PrintStream out,String[] args){
		if(args[0].contains("datasource")){
			bl = new BLServiceController(args[1]) ;
			bl.init();
			return ;
		}
		this.out =out ;
		System.setOut(out);
		TestConfig config = new TestConfig();
		Player player = new Player();
		Team team = new Team();
		
//		String[] strs = args[0].split(" ") ;
		
		CmdlineParser cp = new CmdlineParser(new Object[] { config, player , team }) ;
		try {
			cp.parse(args);
//			for(int i = 1 ;i<strs.length;i++){
//				String[] strs1 = strs[i].split(" ") ;
//				strs1[0] = "-"+strs1[0] ;
//				cp.parse(new String[]{"-n","50"});
//				for(int j=0;j<strs1.length;j++)
//					System.out.println(strs1[j]);
//			}
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if(args[0].contains("-player")) {
		if(player.isHot)
			getMostImprovedPlayer(player.hotField,player.getTopnumber()) ;
		else if(player.isKing){
			    if(player.isDaily)
					getDailyStandingPlayer(player.kingField , player.topNumber) ;
				else
					getSeasonStandingPlayer(player.kingField, player.topNumber) ;
	     	}else{
	     		if(player.isFilter&&!player.isSort)
	     			getSortAndFilterForPlayer(player.showTotal, player.num,player.isHigh, player.sortField,player.filterField) ;
	     		else if(player.isSort&&!player.isFilter)
	     			getSortPlayerByField(player.showTotal, player.isHigh, player.num, player.sortField);
	     		else if(player.isFilter&&player.isSort)
	     			getSortAndFilterForPlayer(player.showTotal, player.num,player.isHigh, player.sortField,player.filterField) ;
	     		else if(!player.isFilter && !player.isSort){
	     			getSortPlayerByField(player.showTotal, player.isHigh, player.num, player.sortField);
	     		}
	     	 }
		}    
		
		else{
			if(team.isHot)
				getHotTeam(team.hotField , team.num);
			else{
				if(team.isSort)
					getSortTeamByField(team.isTotal,team.isHigh,team.num,team.sortField,team.ifAscSort);
				else if(!team.isSort){
					if(team.isHigh)
						getSortTeamByField(team.isTotal, true , team.num , "winRate",team.ifAscSort);
					else
						getSortTeamByField(team.isTotal,false,team.num,"score",team.ifAscSort);  //相当于"-team"
					}
				}
			}		
	}
	
	
	private void getPlayerHighInfo(int number){
		allPlayers = bl.getAllPlayers() ;
		int i = 0 ;
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
				playerHighInfo.setLeague(team.getZone()==Zone.W?"West":"East");
			playerHighInfo.setName(onePlayer.getName());
			playerHighInfo.setOffendReboundEfficient(avgInfo.getPercentageOfAttackingRebound());
			playerHighInfo.setPosition(onePlayer.getPosition());
			playerHighInfo.setRealShot(avgInfo.getPercentageOfTrueShooting());
			playerHighInfo.setReboundEfficient(avgInfo.getPercentageOfRebound());
			playerHighInfo.setShotEfficient(avgInfo.getEfficiencyOfShooting());
			playerHighInfo.setStealEfficient(avgInfo.getPercentageOfSteal());
			if(team!=null)
			playerHighInfo.setTeamName(team.getShortName());
			i++ ;
			out.print(i);
			out.print(playerHighInfo);
    	}
	}
	
	
	class TestConfig {
		@CmdOption(names = { "--help", "-h", "-?" },args={"isHelp"}, description = "show help",maxCount = 1, minCount = 0)
		public void ishelp(String isHelp){
			System.out.println(isHelp);
		}
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
		private String hotField = "";
		private boolean isKing = false ;
		private String kingField ="";
		private boolean isSeason ;
		private boolean isDaily ;
		private boolean isAsc = false ;
		private boolean isFilter = false  ;
		private String filterField ="";
		private boolean isSort = false  ;
		private String sortField ="";
		
		@CmdOption(names = {"-high"},description = "show high info",conflictsWith = {"-avg","-total","-hot","-filter","-king"}) 
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
		
		@CmdOption(names = {"-filter"},args = {"field.value"},description = "show filter info",conflictsWith = {"-king","-hot","-high"})
		public void isFilter(String field){
			isFilter = true ;
			filterField = field ;
			isHigh = false ;
		}

		@CmdOption(names = {"-sort"},args = {"filed.sortOrder"},description = "show sort info",conflictsWith = {"-king","-hot"})
		public void isSort(String field){
			isSort = true ;
			sortField = field ;
		}
	}
	
	@CmdCommand(names = { "-team","-t" },description = "Show Team information")
	class Team {
		private boolean isTotal;
		private boolean isAll = true;
		private boolean isHot;
		private String hotField;
		private boolean isHigh;
		private int num = 30 ;
		private boolean isSort;
		private String sortField;
		private boolean ifAscSort;
		TeamData normalDataType=TeamData.score;
		TeamData highDataType=TeamData.percentageOfWinning;
		
		@CmdOption(names={"-avg"},maxCount=1,minCount=0,conflictsWith={"-total","-hot"})
		public void setAvg(){
			isTotal=false;
		}
		
		@CmdOption(names={"-total"},maxCount=1,minCount=0,conflictsWith={"-avg","-hot"})
		public void setTotal(){
			isTotal=true;
		}
		
		@CmdOption(names = { "-n" }, args = { "number" }, maxCount = 1, minCount = 0)
		public void setNum(String number) {
			num = Integer.parseInt(number);
		}
		
		@CmdOption(names={"-all"},maxCount=1,minCount=0,conflictsWith={"-hot"})
		public void setIsAll(){
			isAll=true;
		}
		
		@CmdOption(names={"-hot"},args={"field"},maxCount=1,minCount=0,conflictsWith={"-all","-avg","-total","-sort"})
		public void setHot(String field){
			isHot=true;
			hotField=field;
			isAll=false;
		}
		
		@CmdOption(names={"-sort"},args={"field"},maxCount=1,minCount=0)
		public void setSort(String field){
			isSort=true;
			String[] tmpStr=field.split("\\.");
			sortField=tmpStr[0];
			if(tmpStr[1].equals("asc"))
				ifAscSort=true;
		}
		
		@CmdOption(names={"-high"},maxCount=1,minCount=0)
		public void setHigh(){
			isHigh = true;
		}
	}

	public void outputTeamNormalTotalInfo(ArrayList<TeamPO> teams){
		int i = 0 ;
		for(TeamPO oneTeam: teams){
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
			i++ ;
			out.print(i);
			out.print(teamNormalInfo);
			}
		}
	
	public void outputTeamNormalAvgInfo(ArrayList<TeamPO> teams){
		int i = 0;
		for(TeamPO oneTeam: teams){
			TeamNormalInfo teamNormalInfo = new TeamNormalInfo();
			SeasonInfoForTeam seasonInfo = oneTeam.getSeasonInfo(Config.LASTEST_SEASON);
			TeamDataPO totalInfo=seasonInfo.getTotalTeamData();
			TeamDataPO avgInfo=seasonInfo.getAverageTeamData();
			teamNormalInfo.setAssist(avgInfo.getNumberOfAssist());
			teamNormalInfo.setBlockShot(avgInfo.getNumberOfBlock());
			teamNormalInfo.setDefendRebound(avgInfo.getNumberOfDefenseRebound());
			teamNormalInfo.setFault(avgInfo.getNumberOfFault());
			teamNormalInfo.setFoul(avgInfo.getNumberOfFoul());
			teamNormalInfo.setNumOfGame(seasonInfo.getNumberOfMatches());
			teamNormalInfo.setOffendRebound(avgInfo.getNumberOfAttackRebound());
			teamNormalInfo.setPenalty(avgInfo.getPercentageOfFreeThrow());
			teamNormalInfo.setPoint(avgInfo.getScore());
			teamNormalInfo.setRebound(avgInfo.getNumberOfRebound());
			teamNormalInfo.setShot(avgInfo.getPercentageOfShooting());
			teamNormalInfo.setSteal(avgInfo.getNumberOfSteal());
			teamNormalInfo.setTeamName(oneTeam.getShortName());
			teamNormalInfo.setThree(avgInfo.getPercentageOf3_point());
			
			i++ ;
			out.print(i);
			out.print(teamNormalInfo);
			}
		}
	
	public void outputTeamHighInfo(ArrayList<TeamPO> teams){
		int i = 0 ;
		for(TeamPO oneTeam: teams){
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
			
			i++ ;
			out.print(i);
			out.print(teamHighInfo);
		}
	}
	
	public void outputTeamHotInfo(ArrayList<TeamPO> teams,String field) {
		TeamData dataType = TransferSortHelper.ConsoleStringToDataTypeForTeam(field);
		int i = 0 ;
		for(TeamPO oneTeam: teams){
			TeamHotInfo teamHotInfo = new TeamHotInfo() ;
			teamHotInfo.setField(field);
			teamHotInfo.setLeague(oneTeam.getZone()==Zone.W?"West":"East");
			teamHotInfo.setTeamName(oneTeam.getShortName());
			teamHotInfo.setValue(TransferSortHelper.TeamDataTypeToAvgData(dataType, oneTeam, Config.LASTEST_SEASON));
			 
			i++ ;
			out.print(i);
			out.print(teamHotInfo);
		}
			
	}
	
}
	

