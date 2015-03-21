package com.kmno4.presentation;

import java.util.List;

import PO.PlayerDataPO;
import PO.PlayerPO;

public class TableContentTransfer {

	public static String[][] transferPlayerBasicInfo(int cloums,List<PlayerPO> players){
		String[][] body=new String[players.size()][cloums];
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
			body[i][0] = avgData.getNumberOfRebound() ;
			body[i][1] = 
		
		}
		return body ;
	}
}
