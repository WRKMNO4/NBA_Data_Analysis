package com.kmno4.presentation;

import java.text.DecimalFormat;
import java.util.List;

import PO.PlayerDataPO;
import PO.PlayerPO;

public class TableContentTransfer {

	public static String[][] transferPlayerBasicInfo(int cloums,List<PlayerPO> players){
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
	public static String[][] transferPlayerAvgInfo(int cloums,List<PlayerPO> players){
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
	public static String[][] transferPlayerTotalInfo(int cloums,List<PlayerPO> players){
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
			body[i][11] = cutTailOfAvgData(totalData.getScore()) ;
		}
		return body ;
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
