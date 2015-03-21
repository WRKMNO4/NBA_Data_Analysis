package com.kmno4.presentation;

import java.text.DecimalFormat;
import java.util.List;

import PO.PlayerDataPO;
import PO.PlayerPO;
import PO.TeamDataPO;
import PO.TeamPO;

public class TableContentTransfer {

	public static String[][] transferPlayerBasicInfo(List<PlayerPO> players){
		String[][] body=new String[players.size()][];
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
	public static String[][] transferPlayerAvgInfo(List<PlayerPO> players){
		String[][] body = new String[players.size()][] ;
		for(int i = 0 ; i<players.size();i++){
			PlayerPO player = players.get(i) ;
			PlayerDataPO avgData = player.getAveragePlayerData() ;
			body[i][0] = cutTailOfAvgData(avgData.getNumberOfRebound()) ;
			body[i][1] = cutTailOfAvgData(avgData.getNumberOfAssist()) ;
			body[i][2] = avgData.getPresentTime() ;
			body[i][3] = cutTailOfAvgData(avgData.getPercentageOfShooting()) ;
			body[i][4] = cutTailOfAvgData(avgData.getPercentageOf3_Point()) ;
			body[i][5] = cutTailOfAvgData(avgData.getPercentageOffreeThrow()) ;
			body[i][6] = cutTailOfAvgData(avgData.getNumberOfAttack()) ;
			body[i][7] = cutTailOfAvgData(avgData.getNumberOfDefense()) ;
			body[i][8] = cutTailOfAvgData(avgData.getNumberOfSteal()) ;
			body[i][9] = cutTailOfAvgData(avgData.getNumberOfBlock()) ;
			body[i][10] = cutTailOfAvgData(avgData.getNumberOfFault()) ;
			body[i][11] = cutTailOfAvgData(avgData.getNumberOfFoul()) ;
			body[i][12] = cutTailOfAvgData(avgData.getScore()) ;
			body[i][13] = cutTailOfAvgData(avgData.getEfficiency()) ;
			body[i][14] = cutTailOfAvgData(avgData.getEfficiencyOfGmSc()) ;
			body[i][15] = cutTailOfAvgData(avgData.getPercentageOfTrueShooting()) ;
			body[i][16] = cutTailOfAvgData(avgData.getEfficiencyOfShooting()) ;
			body[i][17] = cutTailOfAvgData(avgData.getPercentageOfRebound()) ;
			body[i][18] = cutTailOfAvgData(avgData.getPercentageOfAttackingRebound()) ;
			body[i][19] = cutTailOfAvgData(avgData.getPercentageOfDefenseRebound()) ;
			body[i][20] = cutTailOfAvgData(avgData.getPercentageOfAssist()) ;
			body[i][21] = cutTailOfAvgData(avgData.getPercentageOfSteal()) ;
			body[i][22] = cutTailOfAvgData(avgData.getPercentageOfBlock()) ;
			body[i][23] = cutTailOfAvgData(avgData.getPercentageOfFault()) ;
			body[i][24] = cutTailOfAvgData(avgData.getPercentageOfUse()) ;
		}
		return body ;
	}
	public static String[][] transferPlayerTotalInfo(List<PlayerPO> players){
		String[][] body = new String[players.size()][] ;
		for(int i = 0;i<players.size();i++){
			PlayerPO player = players.get(i) ;
			PlayerDataPO totalData = player.getTotalPlayerData() ;
			body[i][0] = cutTailOfTotalData(totalData.getNumberOfMatch()) ;
			body[i][1] = cutTailOfTotalData(totalData.getNumberOfStarting()) ;
			body[i][2] = cutTailOfTotalData(totalData.getNumberOfRebound()) ;
			body[i][3] = cutTailOfTotalData(totalData.getNumberOfAssist()) ;
			body[i][4] = totalData.getPresentTime() ;
			body[i][5] = cutTailOfTotalData(totalData.getNumberOfAttack()) ;
			body[i][6] = cutTailOfTotalData(totalData.getNumberOfDefense()) ;
			body[i][7] = cutTailOfTotalData(totalData.getNumberOfSteal()) ;
			body[i][8] = cutTailOfTotalData(totalData.getNumberOfBlock()) ;
			body[i][9] = cutTailOfTotalData(totalData.getNumberOfFault()) ;
			body[i][10] = cutTailOfTotalData(totalData.getNumberOfFoul()) ;
			body[i][11] = cutTailOfTotalData(totalData.getScore()) ;
		}
		return body ;
	}
	
	public static String[][] transferTeamBasicInfo(List<TeamPO> teams){
		String[][] body = new String[teams.size()][] ;
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
	
	public static String[][] transferTeamAvgInfo(List<TeamPO> teams){
		String[][] body = new String[teams.size()][] ;
		for(int i = 0 ; i<teams.size();i++){
			TeamPO team= teams.get(i);
			TeamDataPO avgData=team.getAverageTeamData();
			body[i][0]= cutTailOfAvgData(avgData.getNumberOfShooting());
			body[i][1]= cutTailOfAvgData(avgData.getNumberOfShotAttempt());
			body[i][2]= cutTailOfAvgData(avgData.getNumberOf3_point());
			body[i][3]= cutTailOfAvgData(avgData.getNumberOf3_pointAttempt());
			body[i][4]= cutTailOfAvgData(avgData.getNumberOfFreeThrow());
			body[i][5]= cutTailOfAvgData(avgData.getNumberOfFreeThrowAttempt());
			body[i][6]= cutTailOfAvgData(avgData.getNumberOfAttackRebound());
			body[i][7]= cutTailOfAvgData(avgData.getNumberOfDefenseRebound());
			body[i][8]= cutTailOfAvgData(avgData.getNumberOfRebound());
			body[i][9]= cutTailOfAvgData(avgData.getNumberOfAssist());
			body[i][10]= cutTailOfAvgData(avgData.getNumberOfSteal());
			body[i][11]= cutTailOfAvgData(avgData.getNumberOfBlock());
			body[i][12]= cutTailOfAvgData(avgData.getNumberOfFault());
			body[i][13]= cutTailOfAvgData(avgData.getNumberOfFoul());
			body[i][14]= cutTailOfAvgData(avgData.getScore());
			
			body[i][15]= cutTailOfAvgData(avgData.getPercentageOfShooting());
			body[i][16]= cutTailOfAvgData(avgData.getPercentageOf3_point());
			body[i][17]= cutTailOfAvgData(avgData.getPercentageOfFreeThrow());
			
			body[i][18]= cutTailOfAvgData(team.getPercentageOfWinning());
			body[i][19]= cutTailOfAvgData(avgData.getRoundOfAttack());
			body[i][20]= cutTailOfAvgData(avgData.getEfficiencyOfAttack());
			body[i][21]= cutTailOfAvgData(avgData.getEfficiencyOfDefense());
			body[i][22]= cutTailOfAvgData(avgData.getEfficiencyOfRebound());
			body[i][23]= cutTailOfAvgData(avgData.getEfficiencyOfSteal());
			body[i][24]= cutTailOfAvgData(avgData.getEfficiencyOfAssist());
		}
		return body;
		
	}

	public static String[][] transferTeamTotalInfo(List<TeamPO> teams){
		String[][] body = new String[teams.size()][] ;
		for(int i = 0 ; i<teams.size();i++){
			TeamPO team= teams.get(i);
			TeamDataPO totalData=team.getTotalTeamData();
			body[i][0]=cutTailOfTotalData(team.getNumberOfMatches());
			body[i][1]= cutTailOfTotalData(totalData.getNumberOfShooting());
			body[i][2]= cutTailOfTotalData(totalData.getNumberOfShotAttempt());
			body[i][3]= cutTailOfTotalData(totalData.getNumberOf3_point());
			body[i][4]= cutTailOfTotalData(totalData.getNumberOf3_pointAttempt());
			body[i][5]= cutTailOfTotalData(totalData.getNumberOfFreeThrow());
			body[i][6]= cutTailOfTotalData(totalData.getNumberOfFreeThrowAttempt());
			body[i][7]= cutTailOfTotalData(totalData.getNumberOfAttackRebound());
			body[i][8]= cutTailOfTotalData(totalData.getNumberOfDefenseRebound());
			body[i][9]= cutTailOfTotalData(totalData.getNumberOfRebound());
			body[i][10]= cutTailOfTotalData(totalData.getNumberOfAssist());
			body[i][11]= cutTailOfTotalData(totalData.getNumberOfSteal());
			body[i][12]= cutTailOfTotalData(totalData.getNumberOfBlock());
			body[i][13]= cutTailOfTotalData(totalData.getNumberOfFault());
			body[i][14]= cutTailOfTotalData(totalData.getNumberOfFoul());
			body[i][15]= cutTailOfTotalData(totalData.getScore());
			body[i][16]= cutTailOfTotalData(totalData.getRoundOfAttack());
			
		}
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
