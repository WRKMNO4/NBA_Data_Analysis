package PO;

import java.util.ArrayList;

public class TeamDataPO {
	int numberOfShooting ;//投篮命中数
	int numberOfShotAttempt ;//，投篮出手数，
	int numberOf3_point ;//三分命中数，
	int numberOf3_pointAttempt ;//三分出手数，
	int numberOfFreeThrow ;//罚球命中数，
	int numberOfFreeThrowAttempt ;//罚球出手数，
	int numberOfAttackRebound ;//进攻篮板数，
	int numberOfDefenseRebound ;//防守篮板数，
	int numberOfRebound ;//篮板球，
	int numberOfAssist ;//助攻数，
	int numberOfSteal ;//抢断数，
	int numberOfBlock ;//盖帽数，
	int numberOfFault ;//失误数，
	int numberOfFoul ;//犯规数，
	int score ;//比赛得分
	
	double percentageOfShooting ;//投篮命中率，
	double percentageOf3_point ;//三分命中率，
	double percentageOfFreeThrow ;//罚球命中率，
	double percentageOfWinning ;//胜率，
	double roundOfAttack ;//进攻回合
	double efficiencyOfAttack ;//，进攻效率，
	double efficiencyOfDefense ;//防守效率，
	double efficiencyOfBlock ;//篮板效率，
	double efficiencyOfSteal ;//抢断效率
	double efficiencyOfAssist ;//助攻率。
	
	public void calculateTeamDataOfOneMatch(ArrayList<PlayerDataOfOneMatchPO> playerDatas){
		for(int i=0;i<playerDatas.size();i++){
			PlayerDataOfOneMatchPO tempData=playerDatas.get(i);
			
			numberOfShooting += tempData.getNumberOfShooting();
			numberOfShotAttempt += tempData.getNumberOfShotAttempt();
			numberOf3_point += tempData.getNumberOf3_point();
			numberOf3_pointAttempt += tempData.getNumberOf3_pointAttempt();
			numberOfFreeThrow += tempData.getNumberOfFreeThrow();
			numberOfFreeThrowAttempt += tempData.getNumberOfFreeThrowAttempt();
			numberOfAttackRebound += tempData.getNumberOfAttackRebound();
			numberOfDefenseRebound += tempData.getNumberOfDefenseRebound();
			numberOfRebound += tempData.getNumberOfReboundOfOneMatch();
			numberOfAssist += tempData.getNumberOfAssistOfOneMatch();
			numberOfSteal += tempData.getNumberOfSteal();
			numberOfBlock += tempData.getNumberOfBlockOfOneMatch();
			numberOfFault += tempData.getNumberOfFaultOfOneMatch();
			numberOfFoul += tempData.getNumberOfFoulOfOneMatch();
			score += tempData.getScoreOfOneMatch();
			
			
		}
	}
	
	
	public int getNumberOfShooting() {
		return numberOfShooting;
	}
	public int getNumberOfShotAttempt() {
		return numberOfShotAttempt;
	}
	public int getNumberOf3_point() {
		return numberOf3_point;
	}
	public int getNumberOf3_pointAttempt() {
		return numberOf3_pointAttempt;
	}
	public int getNumberOfFreeThrow() {
		return numberOfFreeThrow;
	}
	public int getNumberOfFreeThrowAttempt() {
		return numberOfFreeThrowAttempt;
	}
	public int getNumberOfAttackRebound() {
		return numberOfAttackRebound;
	}
	public int getNumberOfDefenseRebound() {
		return numberOfDefenseRebound;
	}
	public int getNumberOfRebound() {
		return numberOfRebound;
	}
	public int getNumberOfAssist() {
		return numberOfAssist;
	}
	public int getNumberOfSteal() {
		return numberOfSteal;
	}
	public int getNumberOfBlock() {
		return numberOfBlock;
	}
	public int getNumberOfFault() {
		return numberOfFault;
	}
	public int getNumberOfFoul() {
		return numberOfFoul;
	}
	public int getScore() {
		return score;
	}
	public double getPercentageOfShooting() {
		return percentageOfShooting;
	}
	public double getPercentageOf3_point() {
		return percentageOf3_point;
	}
	public double getPercentageOfFreeThrow() {
		return percentageOfFreeThrow;
	}
	public double getPercentageOfWinning() {
		return percentageOfWinning;
	}
	public double getRoundOfAttack() {
		return roundOfAttack;
	}
	public double getEfficiencyOfAttack() {
		return efficiencyOfAttack;
	}
	public double getEfficiencyOfDefense() {
		return efficiencyOfDefense;
	}
	public double getEfficiencyOfBlock() {
		return efficiencyOfBlock;
	}
	public double getEfficiencyOfSteal() {
		return efficiencyOfSteal;
	}
	public double getEfficiencyOfAssist() {
		return efficiencyOfAssist;
	}
	
	
	
}
