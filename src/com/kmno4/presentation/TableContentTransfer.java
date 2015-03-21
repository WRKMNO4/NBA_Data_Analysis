package com.kmno4.presentation;

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
			body[i][0] = ""+avgData.getNumberOfRebound() ;
			body[i][1] = ""+avgData.getNumberOfAssist() ;
			body[i][2] = ""+avgData.getPresentTime() ;
			body[i][3] = ""+avgData.getPercentageOfShooting() ;
			body[i][4] = ""+avgData.getPercentageOf3_Point() ;
			body[i][5] = ""+avgData.getPercentageOffreeThrow() ;
			body[i][6] = ""+avgData.getNumberOfAttack() ;
			body[i][7] = ""+avgData.getNumberOfDefense() ;
			body[i][8] = ""+avgData.getNumberOfSteal() ;
			body[i][9] = ""+avgData.getNumberOfBlock() ;
			body[i][10] = ""+avgData.getNumberOfFault() ;
			body[i][11] = ""+avgData.getNumberOfFoul() ;
			body[i][12] = ""+avgData.getScore() ;
			body[i][13] = ""+avgData.getEfficiency() ;
			body[i][14] = ""+avgData.getEfficiencyOfGmSc() ;
			body[i][15] = ""+avgData.getPercentageOfTrueShooting() ;
			body[i][16] = ""+avgData.getEfficiencyOfShooting() ;
			body[i][17] = ""+avgData.getPercentageOfRebound() ;
			body[i][18] = ""+avgData.getPercentageOfAttackingRebound() ;
			body[i][19] = ""+avgData.getPercentageOfDefenseRebound() ;
			body[i][20] = ""+avgData.getPercentageOfAssist() ;
			body[i][21] = ""+avgData.getPercentageOfSteal() ;
			body[i][22] = ""+avgData.getPercentageOfBlock() ;
			body[i][23] = ""+avgData.getPercentageOfFault() ;
			body[i][24] = ""+avgData.getPercentageOfUse() ;
		}
		return body ;
	}
	public static String[][] transferPlayerTotalInfo(int cloums,List<PlayerPO> players){
		String[][] body = new String[players.size()][] ;
		for(int i = 0;i<players.size();i++){
			PlayerPO player = players.get(i) ;
			PlayerDataPO totalData = player.getTotalPlayerData() ;
			body[i][0] = ""+totalData.getNumberOfMatch() ;
			body[i][1] = ""+totalData.getNumberOfStarting() ;
			body[i][2] = ""+totalData.getNumberOfRebound() ;
			body[i][3] = ""+totalData.getNumberOfAssist() ;
			body[i][4] = ""+totalData.getPresentTime() ;
			body[i][5] = ""+totalData.getNumberOfAttack() ;
			body[i][6] = ""+totalData.getNumberOfDefense() ;
			body[i][7] = ""+totalData.getNumberOfSteal() ;
			body[i][8] = ""+totalData.getNumberOfBlock() ;
			body[i][9] = ""+totalData.getNumberOfFault() ;
			body[i][10] = ""+totalData.getNumberOfFoul() ;
			body[i][11] = ""+totalData.getScore() ;
		}
		return body ;
	}
}
