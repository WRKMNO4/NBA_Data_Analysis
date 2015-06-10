package MySqlTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kenai.jaffl.annotations.In;
import com.kmno4.common.Config;

import sun.reflect.generics.scope.ClassScope;
import Enum.Season;
import PO.MatchListPO;
import PO.MatchPO;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.ScoreOfMatchPO;
import PO.SeasonListPO;
import PO.TeamListPO;
import PO.TeamPO;

public class MatchDataToPO {
	MatchListPO matches ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?user=root&password=941104&useUnicode=true&characterEncoding=UTF8" ;
	java.sql.Connection con = null ;
	java.sql.PreparedStatement stmtMatch = null ;
	java.sql.PreparedStatement stmtScore = null ;
	java.sql.PreparedStatement stmtPlayerData = null ;
	String queryMatch = "select * from matches" ;
	ResultSet rsM = null ;
	String queryScore = "select * from scoresofonematch where matchID=?" ;
	ResultSet rsS = null ;
	String queryPlayerData = "select * from playerdataofonematch where matchID = ?";
	ResultSet rsP = null ;
	 
	public MatchDataToPO(){
		matches = new MatchListPO() ;
	}
	 
	public void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver" ) ;
			System.out.println("加载MySQL驱动");
			
			con = DriverManager.getConnection(url) ;
			System.out.println("链接数据库");
			
			stmtMatch = con.prepareStatement(queryMatch) ;
			stmtScore = con.prepareStatement(queryScore) ;
			stmtPlayerData = con.prepareStatement(queryPlayerData) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("链接数据库失败");
			e.printStackTrace();
		}
		
	}
	
	public void read(){
		int id = 0 ;
		
		try {
//			stmtMatch.setInt(1, id);
			 rsM = stmtMatch.executeQuery() ;
			 Season season = null ;
			while(rsM.next()){
				season = getSeason(rsM.getString("time")) ;//比赛赛季
				
				
				MatchPO oneMatch = new MatchPO() ;
				oneMatch.setName(getName(rsM.getString("time"), rsM.getString("firstTeam"), rsM.getString("secondTeam")));
				oneMatch.setSeason(season);
				oneMatch.setDate(rsM.getString("time").substring(5));
				oneMatch.setFirstTeam(rsM.getString("firstTeam"));
				oneMatch.setSecondTeam(rsM.getString("secondTeam"));
				oneMatch.setFinalScore(new ScoreOfMatchPO(rsM.getInt("firstScore"), rsM.getInt("secondScore")));
				
				
				ArrayList<ScoreOfMatchPO> allScores = new ArrayList<>() ;
				stmtScore.setInt(1, id); 
				 rsS = stmtScore.executeQuery() ;
				while(rsS.next()){
					allScores.add(new ScoreOfMatchPO(rsS.getInt("firstScore"), rsS.getInt("secondScore"))) ;
				}
				oneMatch.setAllScore(allScores);
				
				
				stmtPlayerData.setInt(1, id);
				rsP = stmtPlayerData.executeQuery() ;
				while(rsP.next()){
					PlayerDataOfOneMatchPO onePlayer = new PlayerDataOfOneMatchPO() ;
					onePlayer.setName(rsP.getString("name"));
					onePlayer.setPosition(rsP.getString("position"));
					onePlayer.setIfStarting( rsP.getInt("ifStarting")>0 );
					onePlayer.setPresentTimeOfOneMatch(rsP.getString("persentTime"));
					onePlayer.setNumberOfShooting(rsP.getInt("numberOfShooting"));
					onePlayer.setNumberOfShotAttempt(rsP.getInt("numberOfShotAttempt"));
					onePlayer.setNumberOf3_point(rsP.getInt("numberOf3_point"));
					onePlayer.setNumberOf3_pointAttempt(rsP.getInt("numberOf3_pointAttempt"));
					onePlayer.setNumberOfFreeThrow(rsP.getInt("numberOfFreeThrow"));
					onePlayer.setNumberOfFreeThrowAttempt(rsP.getInt("numberOfFreeThrowAttempt"));
					onePlayer.setNumberOfAttackRebound(rsP.getInt("numberOfAttackRebound"));
					onePlayer.setNumberOfDefenseRebound(rsP.getInt("numberOfDefenseRebound"));
					onePlayer.setNumberOfReboundOfOneMatch(rsP.getInt("numberOfRebound"));
					onePlayer.setNumberOfAssistOfOneMatch(rsP.getInt("numberOfAssist"));
					onePlayer.setNumberOfSteal(rsP.getInt("numberOfSteal"));
					onePlayer.setNumberOfBlockOfOneMatch(rsP.getInt("numberOfBlock"));
					onePlayer.setNumberOfFaultOfOneMatch(rsP.getInt("numberOfFault"));
					onePlayer.setNumberOfFoulOfOneMatch(rsP.getInt("numberOfFoul"));
				    onePlayer.setScoreOfOneMatch(rsP.getInt("score"));
				    onePlayer.setDouble_double(onePlayer.ifDoubleDouble());
				    
				    PlayerPO thePlayer = PlayerListPO.findPlayerAccurately(onePlayer.getName()) ;
				    if(thePlayer == null){   //若原数组里没有此队员
						 PlayerPO newPlayer = new PlayerPO();
						 newPlayer.setName(onePlayer.getName());
						 newPlayer.setPortraitURL("images/nba_logo.png");
						 newPlayer.setActionURL("images/nba_logo.png");
						 PlayerListPO.addPlayer(newPlayer) ;
						 thePlayer = newPlayer ;
					 }
				     thePlayer.addDataOfOneMatchOfOnePlayer(onePlayer, season);
				     thePlayer.addMatch(season, oneMatch);
				     
				     if(rsP.getString("team").equals(oneMatch.getFirstTeam())){
				    	 oneMatch.addDataOfOnePlayerOfFirstTeam(onePlayer);
				     }else{
				    	 oneMatch.addDataOfOnePlayerOfSecondTeam(onePlayer);
				     }
				     thePlayer.setTeam(rsP.getString("team"), season);
				     
				     TeamPO theTeam = TeamListPO.findTeamByShortName(rsP.getString("team")) ;
				     if(theTeam==null){
						 System.out.println(rsP.getString("team"));
						 continue;
				     }
				     theTeam.addPlayer(thePlayer, season);
				}
				
				
				if(oneMatch.getSeason().compareTo(Config.LASTEST_SEASON)>0)
					Config.setLatestSeason(season);
				if(oneMatch.getSeason().equals(Config.LASTEST_SEASON))
					Config.LASTEST_DATE=new String(oneMatch.getDate());
				
				oneMatch.calculateTeamData();
				oneMatch.calculateTotalTime();
				oneMatch.calculatePlayersData();
				
				TeamPO firstTeam = TeamListPO.findTeamByShortName(oneMatch.getFirstTeam()) ;
				TeamPO secondTeam = TeamListPO.findTeamByShortName(oneMatch.getSecondTeam()) ;
				firstTeam.addMatch(oneMatch, season);
				try{
				secondTeam.addMatch(oneMatch, season);
				}catch(Exception e){
					System.out.println(oneMatch.getSecondTeam());
					return ;
				}
				
				firstTeam.updateOtherTeamData(oneMatch.getFinalScore().getSecondScore(),oneMatch.getTotalTime(),oneMatch.getSecondTeamData(),oneMatch.getSeason());
				secondTeam.updateOtherTeamData(oneMatch.getFinalScore().getFirstScore(),oneMatch.getTotalTime(),oneMatch.getFirstTeamData(),oneMatch.getSeason());
				
				//更新球员的对手信息 
				oneMatch.updateOtherTeamDataForPlayers();
				
				SeasonListPO.addMatch(season, oneMatch);
				
				id++ ;
//				stmtMatch.setInt(1, id);
//				rsM = stmtMatch.executeQuery();
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getName(String date,String firstTeam,String secondTeam){
		String name = getSeason(date).toString() ;
		name = name+"_"+date.substring(5)+"_"+firstTeam+"-"+secondTeam ;
		return name ;
		
	}
	
	private Season getSeason(String date){
		Season season = null;
		int year= Integer.parseInt(date.substring(0, 4)) ;
		int month = Integer.parseInt(date.substring(5,7)) ;
		switch(year){
		case 2012:
			if(month>9)
		    	season =  Season.season12_13 ;
			break ;
		case 2013:
			if(month>9)
		    	season = Season.season13_14 ;
			else
				season = Season.season12_13 ;
			break ;
		case 2014:
			if(month>9)
				season = Season.season14_15 ;
			else
				season = Season.season13_14 ;
			break ;
		case 2015:
			if(month>9) 
				;
			else
				season = Season.season14_15 ;
			break ;
		}
		return season ;
		
	}

	public static void main(String[] args){
		MatchDataToPO mtp = new MatchDataToPO() ;
		mtp.init(); 
		mtp.read();
	}
}
