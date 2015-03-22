package com.kmno4.presentation;

import java.text.DecimalFormat;
import java.util.List;

import PO.PlayerDataPO;
import PO.PlayerPO;
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
	public static String[][] transferPlayerAvgInfo(int colums,PlayerPO player,int seasons){
		String[][] body = new String[seasons][colums] ;
	
			
			PlayerDataPO avgData = player.getAveragePlayerData() ;
			body[seasons-1][0] = cutTailOfAvgData(avgData.getNumberOfRebound()) ;
			body[seasons-1][1] = cutTailOfAvgData(avgData.getNumberOfAssist()) ;
			body[seasons-1][2] = avgData.getPresentTime() ;
			body[seasons-1][3] = cutTailOfAvgData(avgData.getPercentageOfShooting()) ;
			body[seasons-1][4] = cutTailOfAvgData(avgData.getPercentageOf3_Point()) ;
			body[seasons-1][5] = cutTailOfAvgData(avgData.getPercentageOffreeThrow()) ;
			body[seasons-1][6] = cutTailOfAvgData(avgData.getNumberOfAttack()) ;
			body[seasons-1][7] = cutTailOfAvgData(avgData.getNumberOfDefense()) ;
			body[seasons-1][8] = cutTailOfAvgData(avgData.getNumberOfSteal()) ;
			body[seasons-1][9] = cutTailOfAvgData(avgData.getNumberOfBlock()) ;
			body[seasons-1][10] = cutTailOfAvgData(avgData.getNumberOfFault()) ;
			body[seasons-1][11] = cutTailOfAvgData(avgData.getNumberOfFoul()) ;
			body[seasons-1][12] = cutTailOfAvgData(avgData.getScore()) ;
			body[seasons-1][13] = cutTailOfAvgData(avgData.getEfficiency()) ;
			body[seasons-1][14] = cutTailOfAvgData(avgData.getEfficiencyOfGmSc()) ;
			body[seasons-1][15] = cutTailOfAvgData(avgData.getPercentageOfTrueShooting()) ;
			body[seasons-1][16] = cutTailOfAvgData(avgData.getEfficiencyOfShooting()) ;
			body[seasons-1][17] = cutTailOfAvgData(avgData.getPercentageOfRebound()) ;
			body[seasons-1][18] = cutTailOfAvgData(avgData.getPercentageOfAttackingRebound()) ;
			body[seasons-1][19] = cutTailOfAvgData(avgData.getPercentageOfDefenseRebound()) ;
			body[seasons-1][20] = cutTailOfAvgData(avgData.getPercentageOfAssist()) ;
			body[seasons-1][21] = cutTailOfAvgData(avgData.getPercentageOfSteal()) ;
			body[seasons-1][22] = cutTailOfAvgData(avgData.getPercentageOfBlock()) ;
			body[seasons-1][23] = cutTailOfAvgData(avgData.getPercentageOfFault()) ;
			body[seasons-1][24] = cutTailOfAvgData(avgData.getPercentageOfUse()) ;
		
		return body ;
	}
	public static String[][] transferPlayerTotalInfo(int colums,PlayerPO player,int seasons){
		String[][] body = new String[seasons][colums] ;
			
			PlayerDataPO totalData = player.getTotalPlayerData() ;
			body[seasons-1][0] = cutTailOfTotalData(totalData.getNumberOfMatch()) ;
			body[seasons-1][1] = cutTailOfTotalData(totalData.getNumberOfStarting()) ;
			body[seasons-1][2] = cutTailOfTotalData(totalData.getNumberOfRebound()) ;
			body[seasons-1][3] = cutTailOfTotalData(totalData.getNumberOfAssist()) ;
			body[seasons-1][4] = totalData.getPresentTime() ;
			body[seasons-1][5] = cutTailOfTotalData(totalData.getNumberOfAttack()) ;
			body[seasons-1][6] = cutTailOfTotalData(totalData.getNumberOfDefense()) ;
			body[seasons-1][7] = cutTailOfTotalData(totalData.getNumberOfSteal()) ;
			body[seasons-1][8] = cutTailOfTotalData(totalData.getNumberOfBlock()) ;
			body[seasons-1][9] = cutTailOfTotalData(totalData.getNumberOfFault()) ;
			body[seasons-1][10] = cutTailOfTotalData(totalData.getNumberOfFoul()) ;
			body[seasons-1][11] = cutTailOfTotalData(totalData.getScore()) ;
		
		return body ;
	}
	
	public static String[][] transferTeamBasicInfo(int colums,List<TeamPO> teams){
		String[][] body = new String[teams.size()][colums] ;
		for(int i = 0 ; i<teams.size();i++){
			TeamPO team = teams.get(i);
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
	
	public static String[][] transferTeamAvgInfo(int colums,TeamPO team, int seasons){
		String[][] body = new String[seasons][colums] ;
	
			TeamDataPO avgData=team.getAverageTeamData();
			body[seasons-1][0]= cutTailOfAvgData(avgData.getNumberOfShooting());
			body[seasons-1][1]= cutTailOfAvgData(avgData.getNumberOfShotAttempt());
			body[seasons-1][2]= cutTailOfAvgData(avgData.getNumberOf3_point());
			body[seasons-1][3]= cutTailOfAvgData(avgData.getNumberOf3_pointAttempt());
			body[seasons-1][4]= cutTailOfAvgData(avgData.getNumberOfFreeThrow());
			body[seasons-1][5]= cutTailOfAvgData(avgData.getNumberOfFreeThrowAttempt());
			body[seasons-1][6]= cutTailOfAvgData(avgData.getNumberOfAttackRebound());
			body[seasons-1][7]= cutTailOfAvgData(avgData.getNumberOfDefenseRebound());
			body[seasons-1][8]= cutTailOfAvgData(avgData.getNumberOfRebound());
			body[seasons-1][9]= cutTailOfAvgData(avgData.getNumberOfAssist());
			body[seasons-1][10]= cutTailOfAvgData(avgData.getNumberOfSteal());
			body[seasons-1][11]= cutTailOfAvgData(avgData.getNumberOfBlock());
			body[seasons-1][12]= cutTailOfAvgData(avgData.getNumberOfFault());
			body[seasons-1][13]= cutTailOfAvgData(avgData.getNumberOfFoul());
			body[seasons-1][14]= cutTailOfAvgData(avgData.getScore());
			
			body[seasons-1][15]= cutTailOfAvgData(avgData.getPercentageOfShooting());
			body[seasons-1][16]= cutTailOfAvgData(avgData.getPercentageOf3_point());
			body[seasons-1][17]= cutTailOfAvgData(avgData.getPercentageOfFreeThrow());
			
			body[seasons-1][18]= cutTailOfAvgData(team.getPercentageOfWinning());
			body[seasons-1][19]= cutTailOfAvgData(avgData.getRoundOfAttack());
			body[seasons-1][20]= cutTailOfAvgData(avgData.getEfficiencyOfAttack());
			body[seasons-1][21]= cutTailOfAvgData(avgData.getEfficiencyOfDefense());
			body[seasons-1][22]= cutTailOfAvgData(avgData.getEfficiencyOfRebound());
			body[seasons-1][23]= cutTailOfAvgData(avgData.getEfficiencyOfSteal());
			body[seasons-1][24]= cutTailOfAvgData(avgData.getEfficiencyOfAssist());
		
		return body;
		
	}

	public static String[][] transferTeamTotalInfo(int colums,TeamPO team, int seasons){
		String[][] body = new String[seasons][colums] ;
			
			TeamDataPO totalData=team.getTotalTeamData();
			body[seasons-1][0]=cutTailOfTotalData(team.getNumberOfMatches());
			body[seasons-1][1]= cutTailOfTotalData(totalData.getNumberOfShooting());
			body[seasons-1][2]= cutTailOfTotalData(totalData.getNumberOfShotAttempt());
			body[seasons-1][3]= cutTailOfTotalData(totalData.getNumberOf3_point());
			body[seasons-1][4]= cutTailOfTotalData(totalData.getNumberOf3_pointAttempt());
			body[seasons-1][5]= cutTailOfTotalData(totalData.getNumberOfFreeThrow());
			body[seasons-1][6]= cutTailOfTotalData(totalData.getNumberOfFreeThrowAttempt());
			body[seasons-1][7]= cutTailOfTotalData(totalData.getNumberOfAttackRebound());
			body[seasons-1][8]= cutTailOfTotalData(totalData.getNumberOfDefenseRebound());
			body[seasons-1][9]= cutTailOfTotalData(totalData.getNumberOfRebound());
			body[seasons-1][10]= cutTailOfTotalData(totalData.getNumberOfAssist());
			body[seasons-1][11]= cutTailOfTotalData(totalData.getNumberOfSteal());
			body[seasons-1][12]= cutTailOfTotalData(totalData.getNumberOfBlock());
			body[seasons-1][13]= cutTailOfTotalData(totalData.getNumberOfFault());
			body[seasons-1][14]= cutTailOfTotalData(totalData.getNumberOfFoul());
			body[seasons-1][15]= cutTailOfTotalData(totalData.getScore());
			body[seasons-1][16]= cutTailOfTotalData(totalData.getRoundOfAttack());
			
		return body;
	}
	
	static String cutTailOfAvgData(double num){
		DecimalFormat df = new DecimalFormat("#.0") ;
		return df.format(num) ;
	}
	static String cutTailOfTotalData(double num){
		int number = (int)num ;
		return String.valueOf(number) ;
	}
}
