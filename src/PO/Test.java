package PO;

import java.util.List;

import PO.PlayerDataPO;
import PO.PlayerPO;

public class Test {

//	public static String[][] transferPlayerBasicInfo(int cloums,List<PlayerPO> players){
//		String[][] body=new String[players.size()][cloums];
//		for(int i=0;i<players.size();i++){
//			PlayerPO player=players.get(i);
//			body[i][0]=player.getName();
//			body[i][1]=player.getPosition();
//			body[i][2]=player.getNumber();
//			body[i][3]=player.getHeight();
//			body[i][4]=player.getWeight();
//			body[i][5]=player.getBirth();
//			body[i][6]=player.getAge();
//			body[i][7]=player.getExp();
//			body[i][8]=player.getSchool();
//		}
//		return body;
//	}
//	public static String[][] transferPlayerAvgInfo(int cloums,List<PlayerPO> players){
//		String[][] body = new String[players.size()][] ;
//		for(int i = 0 ; i<players.size();i++){
//			PlayerPO player = players.get(i) ;
//			PlayerDataPO avgData = player.getAveragePlayerData() ;
//			body[i][0] = avgData.getNumberOfRebound() ;
//			body[i][1] =avgData.getNumberOf3_point();
//		
//		}
//		return body ;
//	}
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
			body[i][0]= ""+avgData.getNumberOfShooting();
			body[i][1]= ""+avgData.getNumberOfShotAttempt();
			body[i][2]= ""+avgData.getNumberOf3_point();
			body[i][3]= ""+avgData.getNumberOf3_pointAttempt();
			body[i][4]= ""+avgData.getNumberOfFreeThrow();
			body[i][5]= ""+avgData.getNumberOfFreeThrowAttempt();
			body[i][6]= ""+avgData.getNumberOfAttackRebound();
			body[i][7]= ""+avgData.getNumberOfDefenseRebound();
			body[i][8]= ""+avgData.getNumberOfRebound();
			body[i][9]= ""+avgData.getNumberOfAssist();
			body[i][10]= ""+avgData.getNumberOfSteal();
			body[i][11]= ""+avgData.getNumberOfBlock();
			body[i][12]= ""+avgData.getNumberOfFault();
			body[i][13]= ""+avgData.getNumberOfFoul();
			body[i][14]= ""+avgData.getScore();
			
			body[i][15]= ""+avgData.getPercentageOfShooting();
			body[i][16]= ""+avgData.getPercentageOf3_point();
			body[i][17]= ""+avgData.getPercentageOfFreeThrow();
			
			body[i][18]= ""+team.getPercentageOfWinning();
			body[i][19]= ""+avgData.getRoundOfAttack();
			body[i][20]= ""+avgData.getEfficiencyOfAttack();
			body[i][21]= ""+avgData.getEfficiencyOfDefense();
			body[i][22]= ""+avgData.getEfficiencyOfRebound();
			body[i][23]= ""+avgData.getEfficiencyOfSteal();
			body[i][24]= ""+avgData.getEfficiencyOfAssist();
		}
		return body;
		
	}

	public static String[][] transferTeamTotalInfo(List<TeamPO> teams){
		String[][] body = new String[teams.size()][] ;
		for(int i = 0 ; i<teams.size();i++){
			TeamPO team= teams.get(i);
			TeamDataPO totalData=team.getTotalTeamData();
			body[i][0]=""+team.getNumberOfMatches();
			body[i][1]= ""+totalData.getNumberOfShooting();
			body[i][2]= ""+totalData.getNumberOfShotAttempt();
			body[i][3]= ""+totalData.getNumberOf3_point();
			body[i][4]= ""+totalData.getNumberOf3_pointAttempt();
			body[i][5]= ""+totalData.getNumberOfFreeThrow();
			body[i][6]= ""+totalData.getNumberOfFreeThrowAttempt();
			body[i][7]= ""+totalData.getNumberOfAttackRebound();
			body[i][8]= ""+totalData.getNumberOfDefenseRebound();
			body[i][9]= ""+totalData.getNumberOfRebound();
			body[i][10]= ""+totalData.getNumberOfAssist();
			body[i][11]= ""+totalData.getNumberOfSteal();
			body[i][12]= ""+totalData.getNumberOfBlock();
			body[i][13]= ""+totalData.getNumberOfFault();
			body[i][14]= ""+totalData.getNumberOfFoul();
			body[i][15]= ""+totalData.getScore();
			body[i][16]= ""+totalData.getRoundOfAttack();
			
		}
		return body;
	}
}

