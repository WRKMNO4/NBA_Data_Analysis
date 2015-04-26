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
			PlayerHighInfo player = new PlayerHighInfo() ;
			
			player.setAssistEfficient(avgInfo.getPercentageOfAssist());
			player.setBlockShotEfficient(avgInfo.getPercentageOfBlock());
			player.setDefendReboundEfficient(avgInfo.getPercentageOfDefenseRebound());
			player.setFaultEfficient(avgInfo.getPercentageOfFault());
			player.setFrequency(avgInfo.getPercentageOfUse());
			player.setGmSc(avgInfo.getEfficiencyOfGmSc());
			player.setLeague(team.getZone().toString());
			player.setName(onePlayer.getName());
			player.setOffendReboundEfficient(avgInfo.getPercentageOfAttackingRebound());
			player.setPosition(onePlayer.getPosition());
			player.setRealShot(avgInfo.getPercentageOfTrueShooting());
			player.setReboundEfficient(avgInfo.getPercentageOfRebound());
			player.setShotEfficient(avgInfo.getEfficiencyOfShooting());
			player.setStealEfficient(avgInfo.getPercentageOfSteal());
			player.setTeamName(team.getFullName());
			
			System.out.print(player) ;
		}
	}
	public static void main(String[] args){
		Console c = new Console() ;
		File file = new File("aaaa") ;
		PrintStream str;
		try {
			str = new PrintStream(file);
			c.execute(str, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
