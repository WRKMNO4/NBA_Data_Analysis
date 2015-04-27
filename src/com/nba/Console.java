package com.nba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import com.kmno4.common.Config;

import BusinessLogic.BLService.BLService;
import BusinessLogic.BLService.BLServiceController;
import Enum.PlayerData;
import PO.PlayerDataPO;
import PO.PlayerPO;
import PO.SeasonInfoForPlayer;
import PO.TeamListPO;
import PO.TeamPO;
import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;

public class Console {
	public void execute(PrintStream out,String[] args){
		BLService bl = new BLServiceController("Data");
		bl.init();
		ArrayList<PlayerPO> allPlayers=bl.getAllPlayers();
		
		System.setOut(out);
		
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
			System.out.print(playerHighInfo) ;
		}
	}
//	public static void main(String[] args){
//		Console c = new Console() ;
//		File file = new File("aaaa") ;
//		PrintStream str;
//		try {
//			str = new PrintStream(file);
//			c.execute(str, null);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
