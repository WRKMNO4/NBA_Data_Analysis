package PO;

public class PlayerDataPO {
	TeamPO team ;
	int numberOfMatch ;//参赛场数
	int numberOfStarting ;//首发场数
	int numberOfRebound ;//篮板数
	int numberOfAssist ;//助攻数
	
	double presentTime ;//在场时间
	double percentageOfShooting ;//投篮命中率
	double percentageOf3_Point ;//三分命中率
	double percentageOffreeThrow ;//罚球命中率
	
	int numberOfAttack ;//进攻数
	int numberOfDefense ;//防守数
	int numberOfSteal ;//抢断数
	int numberOfBlock ;//盖帽数 
	int numberOfFault ;//失误数
	int numberOfFoul ;//犯规数，
	int score ;//得分，
	int efficiency ;//效率，
	
	double efficiencyOfGmSc ;//GmSc效率值，
	double percentageOfTrueShooting ;//真实命中率，
	double efficiencyOfShooting ;//投篮效率，
	double percentageOfRebound ; //篮板率，
	double percentageOfAttackingRebound ;//进攻篮板率，
	double percentageOfDefenseRebound ;//防守篮板率，
	double percentageOfAssist ;// 助攻率，
	double percentageOfSteal ;//抢断率，
	double percentageOfBlock ;//盖帽率，
	double percentageOfFault ;//失误率，
	double percentageOfUse ;//使用率
	
	
	
	
	public TeamPO getTeam() {
		return team;
	}
	public int getNumberOfMatch() {
		return numberOfMatch;
	}
	public int getNumberOfStarting() {
		return numberOfStarting;
	}
	public int getNumberOfRebound() {
		return numberOfRebound;
	}
	public int getNumberOfAssist() {
		return numberOfAssist;
	}
	public double getPresentTime() {
		return presentTime;
	}
	public double getPercentageOfShooting() {
		return percentageOfShooting;
	}
	public double getPercentageOf3_Point() {
		return percentageOf3_Point;
	}
	public double getPercentageOffreeThrow() {
		return percentageOffreeThrow;
	}
	public int getNumberOfAttack() {
		return numberOfAttack;
	}
	public int getNumberOfDefense() {
		return numberOfDefense;
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
	public int getEfficiency() {
		return efficiency;
	}
	public double getEfficiencyOfGmSc() {
		return efficiencyOfGmSc;
	}
	public double getPercentageOfTrueShooting() {
		return percentageOfTrueShooting;
	}
	public double getEfficiencyOfShooting() {
		return efficiencyOfShooting;
	}
	public double getPercentageOfRebound() {
		return percentageOfRebound;
	}
	public double getPercentageOfAttackingRebound() {
		return percentageOfAttackingRebound;
	}
	public double getPercentageOfDefenseRebound() {
		return percentageOfDefenseRebound;
	}
	public double getPercentageOfAssist() {
		return percentageOfAssist;
	}
	public double getPercentageOfSteal() {
		return percentageOfSteal;
	}
	public double getPercentageOfBlock() {
		return percentageOfBlock;
	}
	public double getPercentageOfFault() {
		return percentageOfFault;
	}
	public double getPercentageOfUse() {
		return percentageOfUse;
	}
	
	
}
