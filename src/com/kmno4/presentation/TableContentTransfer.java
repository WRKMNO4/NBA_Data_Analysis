package com.kmno4.presentation;

import java.util.List;

import PO.PlayerPO;

public class TableContentTransfer {

	public void transfer(String[] playerHead,List<PlayerPO> players){
		String[][] body=new String[players.size()][playerHead.length];
		for(int i=0;i<players.size();i++){
			for(int j=0;j<playerHead.length;j++){
				String[i][j]=players.get(i).getAttri(playerHead[j]);
			}
		}		
	}
}
