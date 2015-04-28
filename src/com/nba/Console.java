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
import PO.SeasonInfoForTeam;
import PO.TeamDataPO;
import PO.TeamListPO;
import PO.TeamPO;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamNormalInfo;

public class Console {
	public void execute(PrintStream out,String[] args){
		BLService bl = new BLServiceController("Data");
		bl.init();
		ArrayList<PlayerPO> allPlayers=bl.getAllPlayers();
		ArrayList<TeamPO> allTeams = bl.getAllTeams();
		
		System.setOut(out);
//-----------------------------------------------------------------------------		
//		PlayerHotInfo playerHot = new PlayerHotInfo() ;
//		switch(field){
//		
//		}
//		playerHot.setField();
//		playerHot.setName(name);
//-----------------------------------------------------------------------------		
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
			out.print(playerHighInfo);
		}
//--------------------------------------------------------------------------------
		for(PlayerPO onePlayer : allPlayers){
			PlayerNormalInfo playerNormalInfo = new PlayerNormalInfo() ;
			SeasonInfoForPlayer infoOfSeason = onePlayer.getSeasonInfo(Config.LASTEST_SEASON) ;
			PlayerDataPO totalInfo = infoOfSeason.getTotalPlayerData() ;
			PlayerDataPO avgInfo = infoOfSeason.getAveragePlayerData() ;
			playerNormalInfo.setAge(Integer.parseInt(onePlayer.getAge()));
			playerNormalInfo.setAssist(totalInfo.getNumberOfAssist());
			playerNormalInfo.setBlockShot(totalInfo.getNumberOfBlock()) ;
			playerNormalInfo.setDefend(totalInfo.getNumberOfDefense());
			playerNormalInfo.setEfficiency(avgInfo.getEfficiencyOfTotal());
			playerNormalInfo.setFault(totalInfo.getNumberOfFault());
			playerNormalInfo.setFoul(totalInfo.getNumberOfFoul());
			playerNormalInfo.setMinute(PlayerDataPO.transportTime(totalInfo.getPresentTime())/60.0);
			playerNormalInfo.setName(onePlayer.getName() );
			playerNormalInfo.setNumOfGame(totalInfo.getNumberOfMatch());
			playerNormalInfo.setOffend(totalInfo.getNumberOfAttack());
			playerNormalInfo.setPenalty(avgInfo.getPercentageOffreeThrow());
			playerNormalInfo.setPoint(totalInfo.getScore());
			playerNormalInfo.setRebound(totalInfo.getNumberOfRebound());
			playerNormalInfo.setShot(avgInfo.getPercentageOfShooting());
			playerNormalInfo.setStart(totalInfo.getNumberOfStarting());
			playerNormalInfo.setSteal(totalInfo.getNumberOfSteal());
			playerNormalInfo.setTeamName(infoOfSeason.getTeam());
			playerNormalInfo.setThree(avgInfo.getPercentageOf3_Point());
		}
		
//--------------------------------------------------------------------------------
		for(TeamPO oneTeam: allTeams){
			TeamNormalInfo teamNormalInfo = new TeamNormalInfo();
			SeasonInfoForTeam seasonInfo = oneTeam.getSeasonInfo(Config.LASTEST_SEASON);
			TeamDataPO totalInfo=seasonInfo.getTotalTeamData();
			TeamDataPO avgInfo=seasonInfo.getAverageTeamData();
			teamNormalInfo.setAssist(totalInfo.getNumberOfAssist());
			teamNormalInfo.setBlockShot(totalInfo.getNumberOfBlock());
			teamNormalInfo.setDefendRebound(totalInfo.getNumberOfDefenseRebound());
			teamNormalInfo.setFault(totalInfo.getNumberOfFault());
			teamNormalInfo.setFoul(totalInfo.getNumberOfFoul());
			teamNormalInfo.setNumOfGame(seasonInfo.getNumberOfMatches());
			teamNormalInfo.setOffendRebound(totalInfo.getNumberOfAttackRebound());
			teamNormalInfo.setPenalty(avgInfo.getPercentageOfFreeThrow());
			
		}
	}
}
