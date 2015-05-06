package com.kmno4.presentation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.kmno4.common.Config;

import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import PO.MatchPO;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerDataPO;
import PO.PlayerPO;
import PO.ScoreOfMatchPO;
import PO.SeasonInfoForPlayer;
import PO.StandingDataPO;
import PO.TeamDataPO;
import PO.TeamPO;

public class TableContentTransfer {

	public static String[][] transferPlayerBasicInfo(int colums,List<PlayerPO> players){
		String[][] body=new String[players.size()][colums];
		for(int i=0;i<players.size();i++){
			PlayerPO player=players.get(i);
			body[i][0]=player.getName();
			body[i][1]=player.getPosition();
			body[i][2]=player.getNumber();
			body[i][3]=player.getHeight();
			body[i][4]=player.getWeight();
			body[i][5]=player.getBirth();
			body[i][6]=player.getAge();
			body[i][7]=player.getExp();
			body[i][8]=player.getSchool();
		}
		return body;
	}
	
	public static String[][] transferPlayerSortTotalInfo(ArrayList<PlayerPO> players){
		String[][] body = new String[players.size() + 1][Config.PLAYER_SORT_TOTAL.length] ;
		body[0] =  Config.PLAYER_SORT_TOTAL ;
		Season season = Config.LASTEST_SEASON;
		for(int i = 1;i<body.length;i++){
			PlayerPO onePlayer = players.get(i - 1) ;
			PlayerDataPO totalData = onePlayer.getSeasonInfo(season).getTotalPlayerData() ;
			body[i][0] = onePlayer.getName() ;
			body[i][1] = cutTailOfTotalData(totalData.getNumberOfMatch()) ;
			body[i][2] = cutTailOfTotalData(totalData.getNumberOfStarting()) ;
			body[i][3] = cutTailOfTotalData(totalData.getNumberOfRebound()) ;
			body[i][4] = cutTailOfTotalData(totalData.getNumberOfAssist()) ;
			body[i][5] = totalData.getPresentTime() ;
			body[i][6] = cutTailOfTotalData(totalData.getNumberOfAttack()) ;
			body[i][7] = cutTailOfTotalData(totalData.getNumberOfDefense()) ;
			body[i][8] = cutTailOfTotalData(totalData.getNumberOfSteal()) ;
			body[i][9] = cutTailOfTotalData(totalData.getNumberOfBlock()) ;
			body[i][10] = cutTailOfTotalData(totalData.getNumberOfFault()) ;
			body[i][11] = cutTailOfTotalData(totalData.getNumberOfFoul()) ;
			body[i][12] = cutTailOfTotalData(totalData.getScore()) ;
		}
        return body ;
}
	public static String[][] transferPlayerSortAvgInfo(ArrayList<PlayerPO> players){
		String[][] body = new String[players.size() + 1][Config.PLAYER_SORT_AVERAGE.length] ;
		body[0] = Config.PLAYER_SORT_AVERAGE ;
		Season season = Config.LASTEST_SEASON;
		for(int i= 1;i<body.length;i++){
			PlayerPO onePlayer = players.get(i - 1) ; 
			PlayerDataPO avgData = onePlayer.getSeasonInfo(season).getAveragePlayerData() ;
			body[i][0] = onePlayer.getName() ;
			body[i][1] = cutTailOfAvgData(avgData.getNumberOfRebound()) ;
			body[i][2] = cutTailOfAvgData(avgData.getNumberOfAssist()) ;
			body[i][3] = avgData.getPresentTime() ;
			body[i][4] = cutTailOfAvgData(avgData.getPercentageOfShooting()) ;
			body[i][5] = cutTailOfAvgData(avgData.getPercentageOf3_Point()) ;
			body[i][6] = cutTailOfAvgData(avgData.getPercentageOffreeThrow()) ;
			body[i][7] = cutTailOfAvgData(avgData.getNumberOfAttack()) ;
			body[i][8] = cutTailOfAvgData(avgData.getNumberOfDefense()) ;
			body[i][9] = cutTailOfAvgData(avgData.getNumberOfSteal()) ;
			body[i][10] = cutTailOfAvgData(avgData.getNumberOfBlock()) ;
			body[i][11] = cutTailOfAvgData(avgData.getNumberOfFault()) ;
			body[i][12] = cutTailOfAvgData(avgData.getNumberOfFoul()) ;
			body[i][13] = cutTailOfAvgData(avgData.getScore()) ;
			body[i][14] = cutTailOfAvgData(avgData.getEfficiency()) ;
			body[i][15] = cutTailOfAvgData(avgData.getEfficiencyOfGmSc()) ;
			body[i][16] = cutTailOfAvgData(avgData.getPercentageOfTrueShooting()) ;
			body[i][17] = cutTailOfAvgData(avgData.getEfficiencyOfShooting()) ;
			body[i][18] = cutTailOfAvgData(avgData.getPercentageOfRebound()) ;
			body[i][19] = cutTailOfAvgData(avgData.getPercentageOfAttackingRebound()) ;
			body[i][20] = cutTailOfAvgData(avgData.getPercentageOfDefenseRebound()) ;
			body[i][21] = cutTailOfAvgData(avgData.getPercentageOfAssist()) ;
			body[i][22] = cutTailOfAvgData(avgData.getPercentageOfSteal()) ;
			body[i][23] = cutTailOfAvgData(avgData.getPercentageOfBlock()) ;
			body[i][24] = cutTailOfAvgData(avgData.getPercentageOfFault()) ;
			body[i][25] = cutTailOfAvgData(avgData.getPercentageOfUse()) ;
		}
		return body ;
		
	}
	public static String[][] transferPlayerAvgInfo(PlayerPO player){
		String[][] body = new String[Config.Seasons.length + 1][Config.PLAYER_AVERAGE_INFO.length] ;
		body[0] = Config.PLAYER_AVERAGE_INFO;
		for (int i = 1; i < body.length; i ++) {
			SeasonInfoForPlayer seasonInfo = player.getSeasonInfo(getSeason(i - 1));
			
			PlayerDataPO avgData = seasonInfo.getAveragePlayerData() ;
			body[i][0] = Config.Seasons[i - 1];
			body[i][1] = cutTailOfAvgData(avgData.getNumberOfRebound()) ;
			body[i][2] = cutTailOfAvgData(avgData.getNumberOfAssist()) ;
			body[i][3] = avgData.getPresentTime() ;
			body[i][4] = cutTailOfAvgData(avgData.getPercentageOfShooting()) ;
			body[i][5] = cutTailOfAvgData(avgData.getPercentageOf3_Point()) ;
			body[i][6] = cutTailOfAvgData(avgData.getPercentageOffreeThrow()) ;
			body[i][7] = cutTailOfAvgData(avgData.getNumberOfAttack()) ;
			body[i][8] = cutTailOfAvgData(avgData.getNumberOfDefense()) ;
			body[i][9] = cutTailOfAvgData(avgData.getNumberOfSteal()) ;
			body[i][10] = cutTailOfAvgData(avgData.getNumberOfBlock()) ;
			body[i][11] = cutTailOfAvgData(avgData.getNumberOfFault()) ;
			body[i][12] = cutTailOfAvgData(avgData.getNumberOfFoul()) ;
			body[i][13] = cutTailOfAvgData(avgData.getScore()) ;
			body[i][14] = cutTailOfAvgData(avgData.getEfficiency()) ;
			body[i][15] = cutTailOfAvgData(avgData.getEfficiencyOfGmSc()) ;
			body[i][16] = cutTailOfAvgData(avgData.getPercentageOfTrueShooting()) ;
			body[i][17] = cutTailOfAvgData(avgData.getEfficiencyOfShooting()) ;
			body[i][18] = cutTailOfAvgData(avgData.getPercentageOfRebound()) ;
			body[i][19] = cutTailOfAvgData(avgData.getPercentageOfAttackingRebound()) ;
			body[i][20] = cutTailOfAvgData(avgData.getPercentageOfDefenseRebound()) ;
			body[i][21] = cutTailOfAvgData(avgData.getPercentageOfAssist()) ;
			body[i][22] = cutTailOfAvgData(avgData.getPercentageOfSteal()) ;
			body[i][23] = cutTailOfAvgData(avgData.getPercentageOfBlock()) ;
			body[i][24] = cutTailOfAvgData(avgData.getPercentageOfFault()) ;
			body[i][25] = cutTailOfAvgData(avgData.getPercentageOfUse()) ;
		}
		return body ;
	}
	public static String[][] transferPlayerTotalInfo(PlayerPO player){
		String[][] body = new String[Config.Seasons.length + 1][Config.PLAYER_TOTAL_INFO.length];
		body[0] = Config.PLAYER_TOTAL_INFO;
		for(int i = 1; i < body.length; i ++) {
			PlayerDataPO totalData = player.getSeasonInfo(getSeason(i - 1)).getTotalPlayerData() ;
			body[i][0] = Config.Seasons[i - 1];
			body[i][1] = cutTailOfTotalData(totalData.getNumberOfMatch()) ;
			body[i][2] = cutTailOfTotalData(totalData.getNumberOfStarting()) ;
			body[i][3] = cutTailOfTotalData(totalData.getNumberOfRebound()) ;
			body[i][4] = cutTailOfTotalData(totalData.getNumberOfAssist()) ;
			body[i][5] = totalData.getPresentTime() ;
			body[i][6] = cutTailOfTotalData(totalData.getNumberOfAttack()) ;
			body[i][7] = cutTailOfTotalData(totalData.getNumberOfDefense()) ;
			body[i][8] = cutTailOfTotalData(totalData.getNumberOfSteal()) ;
			body[i][9] = cutTailOfTotalData(totalData.getNumberOfBlock()) ;
			body[i][10] = cutTailOfTotalData(totalData.getNumberOfFault()) ;
			body[i][11] = cutTailOfTotalData(totalData.getNumberOfFoul()) ;
			body[i][12] = cutTailOfTotalData(totalData.getScore()) ;
		}
		
		return body ;
	}
	public static String[][] transferPlayerRecentGameInfo(PlayerPO player) {
		ArrayList<MatchPO> matches = MainFrame.mainFrame.bl.getLatest5MatchesForPlayer(player);
		String body[][] = new String[matches.size() + 1][Config.PLAYER_RECENT_INFO.length];
		body[0] = Config.PLAYER_RECENT_INFO;
		for(int i = 1; i < body.length; i ++) {
			MatchPO match = matches.get(i - 1);
			PlayerDataOfOneMatchPO playerData = match.getPlayerDataOfOneMatchByName(player.getName());
			body[body.length - i][0] = Config.Seasons[getSeasonNum(match.getSeason())];
			body[body.length - i][1] = match.getDate();
			body[body.length - i][2] = match.getFirstTeam() + "@" + match.getSecondTeam();
			body[body.length - i][3] = playerData.getPosition() ;
			body[body.length - i][4] = playerData.getPresentTimeOfOneMatch() ;
			body[body.length - i][5] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfShooting())) ;
			body[body.length - i][6] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfShotAttempt())) ;
			body[body.length - i][7] = String.valueOf(cutTailOfTotalData(playerData.getNumberOf3_point())) ;
			body[body.length - i][8] = String.valueOf(cutTailOfTotalData(playerData.getNumberOf3_pointAttempt())) ;
			body[body.length - i][9] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFreeThrow())) ;
			body[body.length - i][10] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFreeThrowAttempt())) ;
			body[body.length - i][11] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfAttackRebound())) ;
			body[body.length - i][12] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfDefenseRebound())) ;
			body[body.length - i][13] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfReboundOfOneMatch())) ;
			body[body.length - i][14] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfAssistOfOneMatch())) ;
			body[body.length - i][15] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfSteal())) ;
			body[body.length - i][16] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfBlockOfOneMatch() )) ;
			body[body.length - i][17] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFaultOfOneMatch())) ;
			body[body.length - i][18] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFoulOfOneMatch() )) ;
			body[body.length - i][19] = String.valueOf(cutTailOfTotalData(playerData.getScoreOfOneMatch())) ;
		}
		
		return body;
	}
	
	
	public static String[][] transferTeamBasicInfo(List<TeamPO> teams){
		String[][] body = new String[teams.size() + 1][Config.TEAM_BASIC_INFO.length] ;
		body[0] = Config.TEAM_BASIC_INFO;
		for(int i = 1 ; i<body.length;i++){
			TeamPO team = teams.get(i - 1);
			body[i][0]=team.getFullName();
			body[i][1]=team.getShortName();
			body[i][2]=team.getCity();
			body[i][3]=team.getZone().toString();
			body[i][4]=team.getDistrict();
			body[i][5]=team.getHomeCourt();
			body[i][6]=""+team.getTimeOfEstablishment();
		}
		return body;
	}
	
	public static String[][] transferTeamSortAvgInfo(int columns, ArrayList<TeamPO> teams,Season season){
		String[][] body = new String[teams.size()][columns];
		body[0]=Config.TEAM_SORT_AVERAGE;

		for(int i=1;i<teams.size();i++){
			TeamPO theTeam=teams.get(i);
			TeamDataPO avgData = theTeam.getSeasonInfo(season).getAverageTeamData();
			body[i][0]=theTeam.getFullName();
			body[i][1]= cutTailOfAvgData(avgData.getNumberOfShooting());
			body[i][2]= cutTailOfAvgData(avgData.getNumberOfShotAttempt());
			body[i][3]= cutTailOfAvgData(avgData.getNumberOf3_point());
			body[i][4]= cutTailOfAvgData(avgData.getNumberOf3_pointAttempt());
			body[i][5]= cutTailOfAvgData(avgData.getNumberOfFreeThrow());
			body[i][6]= cutTailOfAvgData(avgData.getNumberOfFreeThrowAttempt());
			body[i][7]= cutTailOfAvgData(avgData.getNumberOfAttackRebound());
			body[i][8]= cutTailOfAvgData(avgData.getNumberOfDefenseRebound());
			body[i][9]= cutTailOfAvgData(avgData.getNumberOfRebound());
			body[i][10]= cutTailOfAvgData(avgData.getNumberOfAssist());
			body[i][11]= cutTailOfAvgData(avgData.getNumberOfSteal());
			body[i][12]= cutTailOfAvgData(avgData.getNumberOfBlock());
			body[i][13]= cutTailOfAvgData(avgData.getNumberOfFault());
			body[i][14]= cutTailOfAvgData(avgData.getNumberOfFoul());
			body[i][15]= cutTailOfAvgData(avgData.getScore());
		
			body[i][16]= cutTailOfAvgData(avgData.getPercentageOfShooting());
			body[i][17]= cutTailOfAvgData(avgData.getPercentageOf3_point());
			body[i][18]= cutTailOfAvgData(avgData.getPercentageOfFreeThrow());
			
			body[i][19]= cutTailOfAvgData(theTeam.getSeasonInfo(season).getPercentageOfWinning());
			body[i][20]= cutTailOfAvgData(avgData.getRoundOfAttack());

			body[i][21]= cutTailOfAvgData(avgData.getEfficiencyOfAttack());
			body[i][22]= cutTailOfAvgData(avgData.getEfficiencyOfDefense());
			body[i][23]= cutTailOfAvgData(avgData.getEfficiencyOfRebound());
			body[i][24]= cutTailOfAvgData(avgData.getEfficiencyOfSteal());
			body[i][25]= cutTailOfAvgData(avgData.getEfficiencyOfAssist());
		}
		return body;
	}
	
	public static String[][] transferTeamSortTotalInfo(int columns,ArrayList<TeamPO> teams,Season season){
		String[][] body = new String[teams.size()][columns];
		body[0] = Config.TEAM_SORT_TOTAL;
		
		for(int i=1;i<teams.size();i++){
			TeamPO theTeam = teams.get(i);
			TeamDataPO totalData = theTeam.getTotalTeamData(season) ;
			body[i][0] = theTeam.getFullName();
			body[i][1]=cutTailOfTotalData(theTeam.getSeasonInfo(season).getNumberOfMatches());
			body[i][2]= cutTailOfTotalData(totalData.getNumberOfShooting());
			body[i][3]= cutTailOfTotalData(totalData.getNumberOfShotAttempt());
			body[i][4]= cutTailOfTotalData(totalData.getNumberOf3_point());
			body[i][5]= cutTailOfTotalData(totalData.getNumberOf3_pointAttempt());
			body[i][6]= cutTailOfTotalData(totalData.getNumberOfFreeThrow());
			body[i][7]= cutTailOfTotalData(totalData.getNumberOfFreeThrowAttempt());
			body[i][8]= cutTailOfTotalData(totalData.getNumberOfAttackRebound());
			body[i][9]= cutTailOfTotalData(totalData.getNumberOfDefenseRebound());
			body[i][10]= cutTailOfTotalData(totalData.getNumberOfRebound());
			body[i][11]= cutTailOfTotalData(totalData.getNumberOfAssist());
			body[i][12]= cutTailOfTotalData(totalData.getNumberOfSteal());
			body[i][13]= cutTailOfTotalData(totalData.getNumberOfBlock());
			body[i][14]= cutTailOfTotalData(totalData.getNumberOfFault());
			body[i][15]= cutTailOfTotalData(totalData.getNumberOfFoul());
			body[i][16]= cutTailOfTotalData(totalData.getScore());
			body[i][17]= cutTailOfTotalData(totalData.getRoundOfAttack());
		}
		return body;
	}
	
	public static String[][] transferTeamAvgInfo(TeamPO team){
		String[][] body = new String[Config.Seasons.length + 1][Config.TEAM_AVERAGE_INFO.length] ;	
		body[0] = Config.TEAM_AVERAGE_INFO;
		for(int i = 1; i < body.length; i ++) {
			Season season = getSeason(i - 1);
			TeamDataPO avgData=team.getSeasonInfo(season).getAverageTeamData();
			body[i][0] = Config.Seasons[i - 1];
			body[i][1]= cutTailOfAvgData(avgData.getNumberOfShooting());
			body[i][2]= cutTailOfAvgData(avgData.getNumberOfShotAttempt());
			body[i][3]= cutTailOfAvgData(avgData.getNumberOf3_point());
			body[i][4]= cutTailOfAvgData(avgData.getNumberOf3_pointAttempt());
			body[i][5]= cutTailOfAvgData(avgData.getNumberOfFreeThrow());
			body[i][6]= cutTailOfAvgData(avgData.getNumberOfFreeThrowAttempt());
			body[i][7]= cutTailOfAvgData(avgData.getNumberOfAttackRebound());
			body[i][8]= cutTailOfAvgData(avgData.getNumberOfDefenseRebound());
			body[i][9]= cutTailOfAvgData(avgData.getNumberOfRebound());
			body[i][10]= cutTailOfAvgData(avgData.getNumberOfAssist());
			body[i][11]= cutTailOfAvgData(avgData.getNumberOfSteal());
			body[i][12]= cutTailOfAvgData(avgData.getNumberOfBlock());
			body[i][13]= cutTailOfAvgData(avgData.getNumberOfFault());
			body[i][14]= cutTailOfAvgData(avgData.getNumberOfFoul());
			body[i][15]= cutTailOfAvgData(avgData.getScore());
			body[i][16]= cutTailOfAvgData(avgData.getPercentageOfShooting());
			body[i][17]= cutTailOfAvgData(avgData.getPercentageOf3_point());
			body[i][18]= cutTailOfAvgData(avgData.getPercentageOfFreeThrow());
			body[i][19]= cutTailOfAvgData(team.getSeasonInfo(season).getPercentageOfWinning());
			body[i][20]= cutTailOfAvgData(avgData.getRoundOfAttack());
			body[i][21]= cutTailOfAvgData(avgData.getEfficiencyOfAttack());
			body[i][22]= cutTailOfAvgData(avgData.getEfficiencyOfDefense());
			body[i][23]= cutTailOfAvgData(avgData.getEfficiencyOfRebound());
			body[i][24]= cutTailOfAvgData(avgData.getEfficiencyOfSteal());
			body[i][25]= cutTailOfAvgData(avgData.getEfficiencyOfAssist());
		}
	    	
		
		return body;
		
	}

	public static String[][] transferTeamTotalInfo(TeamPO team){
		String[][] body = new String[Config.Seasons.length + 1][Config.TEAM_TOTAL_INFO.length] ;	
		body[0] = Config.TEAM_TOTAL_INFO;
		for(int i = 1; i < body.length; i ++) {
			Season season = getSeason(i - 1);
			TeamDataPO totalData=team.getSeasonInfo(season).getTotalTeamData();
			body[i][0] = Config.Seasons[i - 1];
			body[i][1]=cutTailOfTotalData(team.getSeasonInfo(season).getNumberOfMatches());
			body[i][2]= cutTailOfTotalData(totalData.getNumberOfShooting());
			body[i][3]= cutTailOfTotalData(totalData.getNumberOfShotAttempt());
			body[i][4]= cutTailOfTotalData(totalData.getNumberOf3_point());
			body[i][5]= cutTailOfTotalData(totalData.getNumberOf3_pointAttempt());
			body[i][6]= cutTailOfTotalData(totalData.getNumberOfFreeThrow());
			body[i][7]= cutTailOfTotalData(totalData.getNumberOfFreeThrowAttempt());
			body[i][8]= cutTailOfTotalData(totalData.getNumberOfAttackRebound());
			body[i][9]= cutTailOfTotalData(totalData.getNumberOfDefenseRebound());
			body[i][10]= cutTailOfTotalData(totalData.getNumberOfRebound());
			body[i][11]= cutTailOfTotalData(totalData.getNumberOfAssist());
			body[i][12]= cutTailOfTotalData(totalData.getNumberOfSteal());
			body[i][13]= cutTailOfTotalData(totalData.getNumberOfBlock());
			body[i][14]= cutTailOfTotalData(totalData.getNumberOfFault());
			body[i][15]= cutTailOfTotalData(totalData.getNumberOfFoul());
			body[i][16]= cutTailOfTotalData(totalData.getScore());
			body[i][17]= cutTailOfTotalData(totalData.getRoundOfAttack());
		}
			
			
		return body;
	}
	
	public static String[][] transferTeamRecentMatch(TeamPO team) {
		ArrayList<MatchPO> matches = MainFrame.mainFrame.bl.getLatest5MatchesForTeam(team);
		String[][] body = new String[matches.size() + 1][Config.TEAM_RECENT_INFO.length];
		body[0] = Config.TEAM_RECENT_INFO;
		for(int i = 1; i < body.length; i ++) {
			MatchPO m = matches.get(i - 1);
			TeamDataPO teamData = team.getShortName().equals(m.getFirstTeam()) ? m.getFirstTeamData() : m.getSecondTeamData();
			body[i][0] = Config.Seasons[getSeasonNum(m.getSeason())];
			body[i][1] = m.getDate();
			body[i][2] = m.getFirstTeam() + "@" + m.getSecondTeam();
			body[i][3]= cutTailOfAvgData(teamData.getNumberOfShooting());
			body[i][4]= cutTailOfAvgData(teamData.getNumberOfShotAttempt());
			body[i][5]= cutTailOfAvgData(teamData.getNumberOf3_point());
			body[i][6]= cutTailOfAvgData(teamData.getNumberOf3_pointAttempt());
			body[i][7]= cutTailOfAvgData(teamData.getNumberOfFreeThrow());
			body[i][8]= cutTailOfAvgData(teamData.getNumberOfFreeThrowAttempt());
			body[i][9]= cutTailOfAvgData(teamData.getNumberOfAttackRebound());
			body[i][10]= cutTailOfAvgData(teamData.getNumberOfDefenseRebound());
			body[i][11]= cutTailOfAvgData(teamData.getNumberOfRebound());
			body[i][12]= cutTailOfAvgData(teamData.getNumberOfAssist());
			body[i][13]= cutTailOfAvgData(teamData.getNumberOfSteal());
			body[i][14]= cutTailOfAvgData(teamData.getNumberOfBlock());
			body[i][15]= cutTailOfAvgData(teamData.getNumberOfFault());
			body[i][16]= cutTailOfAvgData(teamData.getNumberOfFoul());
			body[i][17]= cutTailOfAvgData(teamData.getScore());
			body[i][18]= cutTailOfAvgData(teamData.getPercentageOfShooting());
			body[i][19]= cutTailOfAvgData(teamData.getPercentageOf3_point());
			body[i][20]= cutTailOfAvgData(teamData.getPercentageOfFreeThrow());
			body[i][21]= cutTailOfAvgData(teamData.getRoundOfAttack());
			body[i][22]= cutTailOfAvgData(teamData.getEfficiencyOfAttack());
			body[i][23]= cutTailOfAvgData(teamData.getEfficiencyOfDefense());
			body[i][24]= cutTailOfAvgData(teamData.getEfficiencyOfRebound());
			body[i][25]= cutTailOfAvgData(teamData.getEfficiencyOfSteal());
			body[i][26]= cutTailOfAvgData(teamData.getEfficiencyOfAssist());
			
			
		}
		
		
		return body;
	}
	
	public static String[][] transferStandingDailyPlayerInfo(ArrayList<StandingDataPO> datas){
		String[][] body = new String[datas.size() + 1][Config.STANDING_DAILYPLAYER_TABLEHEAD.length] ;
		body[0] = Config.STANDING_DAILYPLAYER_TABLEHEAD;
		for(int i = 1;i<body.length;i++){
			StandingDataPO thePlayer = datas.get(i - 1) ;
			body[i][0] = thePlayer.getPlayerName() ;
			body[i][1] = thePlayer.getTeam() ;
			body[i][2] = thePlayer.getPosition() ;
			body[i][3] = String.valueOf(cutTailOfTotalData(thePlayer.getData())) ;
		}
		return body ;
	}
	
	public static String[][] transferStandingSeasonPlayerInfo(ArrayList<PlayerPO> datas,Season season,PlayerData dataType){
		String [][] body = new String[datas.size() + 1][Config.STANDING_SEASONPLAYER_TABLEHEAD.length] ;
		body[0] = Config.STANDING_SEASONPLAYER_TABLEHEAD;
		for(int i=1;i<body.length;i++){
			PlayerPO thePlayer = datas.get(i - 1) ;
			PlayerDataPO playerData = thePlayer.getSeasonInfo(season).getAveragePlayerData() ;
			body[i][0] = thePlayer.getName() ;
			body[i][1] = thePlayer.getTeam(season) ;
			body[i][2] = thePlayer.getPosition() ;
			switch(dataType){
			case score: 
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getScore())) ;
				break ;
			case numberOfRebound:
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getNumberOfRebound())) ;
				break ;
			case numberOfAssist :
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getNumberOfAssist())) ;
				break ;
			case numberOfBlock :
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getNumberOfBlock())) ;
				break ;
			case numberOfSteal :
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getNumberOfSteal())) ;
				break ;
			case percentageOf3_Point :
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getPercentageOf3_Point()));
				break ;
			case percentageOfShooting :
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getPercentageOfShooting())) ;
				break ;
			case percentageOfFreeThrow :
				body[i][3] = String.valueOf(cutTailOfAvgData(playerData.getPercentageOffreeThrow())) ;
				break ;
			}
		}
		return body ;
	}

	public static String[][] transferStandingSeasonTeamInfo(ArrayList<TeamPO> datas,Season season,TeamData dataType){
		String[][] body = new String[datas.size() + 1][Config.STANDING_SEASONTEAM_TABLEHEAD.length] ;
		body[0] = Config.STANDING_SEASONTEAM_TABLEHEAD;
		for(int i = 1 ;i<body.length;i++){
			TeamPO theTeam = datas.get(i - 1) ;
			TeamDataPO teamData = theTeam.getAverageTeamData(season);
			body[i][0] = theTeam.getFullName() ;
			body[i][1] = theTeam.getZone().toString() ;
			body[i][2] = theTeam.getDistrict();
			switch(dataType){
			case score: 
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getScore())) ;
				break ;
			case numberOfRebound:
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getNumberOfRebound())) ;
				break ;
			case numberOfAssist :
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getNumberOfAssist())) ;
				break ;
			case numberOfBlock :
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getNumberOfBlock())) ;
				break ;
			case numberOfSteal :
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getNumberOfSteal())) ;
				break ;
			case percentageOf3_point :
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getPercentageOf3_point()));
				break ;
			case percentageOfShooting :
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getPercentageOfShooting())) ;
				break ;
			case percentageOfFreeThrow :
				body[i][3] = String.valueOf(cutTailOfAvgData(teamData.getPercentageOfFreeThrow())) ;
				break ;
			}
		}
		return body ;
	}

	
	public static String[][] transferStandingImprovedInfo(ArrayList<PlayerPO> datas, Season season ,PlayerData dataType){
		String[][] body = new String[datas.size() + 1][Config.STANDING_IMPROVE_TABLEHEAD.length] ;
		body[0] = Config.STANDING_IMPROVE_TABLEHEAD;
		for(int i = 1 ; i<body.length ;i++){
			PlayerPO thePlayer = datas.get(i - 1) ;
			SeasonInfoForPlayer playerData = thePlayer.getSeasonInfo(season) ;
			body[i][0] = thePlayer.getName() ;
			body[i][1] = thePlayer.getTeam(season) ;
			body[i][2] = thePlayer.getPosition();
			switch(dataType){
			case improveRateOfScore :
				body[i][3] = cutTailOfAvgData(playerData.getImprovedRateOfScore()) ;
				break ;
			case improveRateOfRebound :
				body[i][3] = cutTailOfAvgData(playerData.getImprovedRateOfRebound()) ;
				break ;
			case improveRateOfAssist :
				body[i][3] = cutTailOfAvgData(playerData.getImprovedRateOfAssist()) ;
				break ;
			}
		}
		return body ;
	}

	public static String[][] transferMatchBasicInfo(ArrayList<MatchPO> datas){
		String[][] body = new String[datas.size() + 1][Config.MATCH_BASIC_INFO.length] ;
		body[0] = Config.MATCH_BASIC_INFO;
		for(int i = 1 ;i<body.length;i++){
			MatchPO theMatch = datas.get(i - 1);
			
			body[body.length - i][0] = theMatch.getDate() ;
			body[body.length - i][1] = theMatch.getFirstTeam() ;
			body[body.length - i][2] = String.valueOf(theMatch.getFinalScore().getFirstScore()) ;
			body[body.length - i][3] = String.valueOf(theMatch.getFinalScore().getSecondScore()) ;
			body[body.length - i][4] = theMatch.getSecondTeam() ;
		}
		return body ;
	}
	
	public static String[][] transferMatchDetailInfo(ArrayList<PlayerDataOfOneMatchPO> datas){
		String[][] body = new String[datas.size() + 1][Config.MATCH_DETAIL_INFO.length] ;
		body[0] = Config.MATCH_DETAIL_INFO;
		for(int i= 1 ; i < body.length ; i++){
			PlayerDataOfOneMatchPO playerData = datas.get(i - 1) ;
			body[i][0] = playerData.getName() ;
			body[i][1] = playerData.getPosition() ;
			body[i][2] = playerData.getPresentTimeOfOneMatch() ;
			body[i][3] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfShooting())) ;
			body[i][4] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfShotAttempt())) ;
			body[i][5] = String.valueOf(cutTailOfTotalData(playerData.getNumberOf3_point())) ;
			body[i][6] = String.valueOf(cutTailOfTotalData(playerData.getNumberOf3_pointAttempt())) ;
			body[i][7] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFreeThrow())) ;
			body[i][8] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFreeThrowAttempt())) ;
			body[i][9] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfAttackRebound())) ;
			body[i][10] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfDefenseRebound())) ;
			body[i][11] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfReboundOfOneMatch())) ;
			body[i][12] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfAssistOfOneMatch())) ;
			body[i][13] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfSteal())) ;
			body[i][14] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfBlockOfOneMatch() )) ;
			body[i][15] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFaultOfOneMatch())) ;
			body[i][16] = String.valueOf(cutTailOfTotalData(playerData.getNumberOfFoulOfOneMatch() )) ;
			body[i][17] = String.valueOf(cutTailOfTotalData(playerData.getScoreOfOneMatch())) ;
		}
		return body ;
	}
	
	
	public static String[][] transferMatchScores(MatchPO match){
		ArrayList<ScoreOfMatchPO> scores = match.getAllScore();
		
		
		String[][] body = new String[3][scores.size() + 1] ;
		body[0][0] = "队伍";
		body[0][1] = "第1节";
		body[0][2] = "第2节";
		body[0][3] = "第3节";
		body[0][4] = "第4节";
		int k = 5;
		while(k < body[0].length) {
			body[0][k] = "加时" + (k - 4);
			k ++;
		}
		body[1][0] = match.getFirstTeam();
		body[2][0] = match.getSecondTeam();
		for(int i = 1; i < body[0].length; i ++) {
			ScoreOfMatchPO s = scores.get(i - 1);
			body[1][i] = s.getFirstScore() + "";
			body[2][i] = s.getSecondScore() + "";
		}
		
		return body ;
	}
	
	static String cutTailOfAvgData(double num){
		String result = String.format("%.2f", num) ;
		if(result.charAt(result.length() - 1) == '0' && result.charAt(result.length() - 2) == '0')
		    return result.substring(0, result.length() - 3);
		return result ;
	}
	static String cutTailOfTotalData(double num){
		int number = (int)num ;
		return String.valueOf(number) ;
	}
	public static Season getSeason(int i){
			Season season = null ;
			switch(i){
			case 0:
				season = Season.season12_13 ;
				break ;
			case 1:
				season = Season.season13_14 ;
				break ;
			case 2:
				season = Season.season14_15 ;
				break ;
			}
			return season ;
	}
	public static int getSeasonNum(Season s) {
		switch(s) {
		case season12_13 : return 0;
		case season13_14 : return 1;
		case season14_15 : return 2;
		default : return -1;
		}
		
	}
	public static Season getSeasonByString(String s) {
		switch(s) {
		case "2012-2013赛季" : return Season.season12_13;
		case "2013-2014赛季" : return Season.season13_14;
		case "2014-2015赛季" : return Season.season14_15;
		default : return Season.season13_14;
		}
	}
}
