package PO;

import java.util.ArrayList;

public class TeamDataPO {
	double numberOfShooting ;//Ͷ��������
	double numberOfShotAttempt ;//��Ͷ����������
	double numberOf3_point ;//������������
	double  numberOf3_pointAttempt ;//���ֳ�������
	double numberOfFreeThrow ;//������������
	double numberOfFreeThrowAttempt ;//�����������
	double numberOfAttackRebound ;//������������
	double numberOfDefenseRebound ;//������������
	double numberOfRebound ;//������
	double numberOfAssist ;//��������
	double numberOfSteal ;//��������
	double numberOfBlock ;//��ñ����
	double numberOfFault ;//ʧ������
	double numberOfFoul ;//��������
	double score ;//�����÷�
	
	double percentageOfShooting ;//Ͷ�������ʣ�
	double percentageOf3_point ;//���������ʣ�
	double percentageOfFreeThrow ;//���������ʣ�
	//double percentageOfWinning ;
	double roundOfAttack ;//�����غ�
	double efficiencyOfAttack ;//������Ч�ʣ�
	double roundOfDefense ;//���ػغ�
	double efficiencyOfDefense ;//����Ч�ʣ�
	double efficiencyOfRebound ;//����Ч�ʣ�
	double efficiencyOfSteal ;//����Ч��
	double efficiencyOfAssist ;//�����ʡ�
	
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
		}   //end the loop
		
		percentageOfShooting = (double)numberOfShooting / (double)numberOfShotAttempt;
		percentageOf3_point = (double)numberOf3_point / (double) numberOf3_pointAttempt;
		percentageOfFreeThrow = (double) numberOfFreeThrow / (double) numberOfFreeThrowAttempt;
		
	}
	
	public void calculateTeamDataOfOneMatchUsingTheOther(TeamDataPO dataOfTheOther){
		roundOfAttack = numberOfShotAttempt + 0.4 * numberOfFreeThrowAttempt
				- 1.07 * (numberOfAttackRebound / (numberOfAttackRebound + 
						dataOfTheOther.numberOfDefenseRebound) * (numberOfShotAttempt -numberOfShooting))
						+ 1.07 * numberOfFault ;
		
		dataOfTheOther.setRoundOfDefense(roundOfAttack);//���ö��ֵķ��ػغ�
		
		efficiencyOfAttack = (double)score/roundOfAttack*100;
		
		dataOfTheOther.setEfficiencyOfDefense(efficiencyOfAttack);//���ö��ֵķ���Ч��
		
		efficiencyOfRebound = (double)(numberOfAttackRebound + numberOfDefenseRebound) / (double)
				(numberOfAttackRebound + numberOfDefenseRebound + dataOfTheOther.numberOfAttackRebound 
						+ dataOfTheOther.numberOfDefenseRebound) ;
		
		dataOfTheOther.setEfficiencyOfSteal(dataOfTheOther.getNumberOfSteal()/(double)roundOfAttack*100);//���öԷ�������Ч��
		
		efficiencyOfAssist = numberOfAssist/(double)roundOfAttack*100 ;
		
	}

	public void calculateTeamTotalDataInOneSeason(ArrayList<MatchPO> matches, String teamShortName){
		for(int i=0;i<matches.size();i++){
			TeamDataPO teamData = matches.get(i).getTeamDataByName(teamShortName);
			numberOfShooting += teamData.getNumberOfShooting();
			numberOfShotAttempt += teamData.getNumberOfShotAttempt();
			numberOf3_point += teamData.getNumberOf3_point();
			numberOf3_pointAttempt += teamData.getNumberOf3_pointAttempt();
			numberOfFreeThrow += teamData.getNumberOfFreeThrow();
			numberOfFreeThrowAttempt += teamData.getNumberOfFreeThrowAttempt();
			numberOfAttackRebound += teamData.getNumberOfAttackRebound();
			numberOfDefenseRebound += teamData.getNumberOfDefenseRebound();
			numberOfRebound += teamData.getNumberOfRebound();
			numberOfAssist += teamData.getNumberOfAssist();
			numberOfSteal += teamData.getNumberOfSteal();
			numberOfBlock += teamData.getNumberOfBlock();
			numberOfFault += teamData.getNumberOfFault();
			numberOfFoul += teamData.getNumberOfFoul();
			score += teamData.getScore();
			
			percentageOfShooting += teamData.getPercentageOfShooting();
			percentageOf3_point += teamData.getPercentageOf3_point();
			percentageOfFreeThrow += teamData.getPercentageOfFreeThrow();
			
			roundOfAttack += teamData.getRoundOfAttack();
			roundOfDefense+=teamData.getRoundOfDefense();
			
			efficiencyOfAttack += teamData.getEfficiencyOfAttack();
			efficiencyOfDefense += teamData.getEfficiencyOfDefense();
			efficiencyOfRebound += teamData.getEfficiencyOfRebound();
			efficiencyOfSteal += teamData.getEfficiencyOfSteal();
			efficiencyOfAssist += teamData.getEfficiencyOfAssist();
		}
	} 

	public void calculateTeamAverageDataInOneSeason(TeamDataPO totalTeamData, int matches, DataForFinalCalculationPO dataOfOtherTeams){
		numberOfShooting = totalTeamData.getNumberOfShooting() / matches ;
		numberOfShotAttempt = totalTeamData.getNumberOfShotAttempt() / matches;
		numberOf3_point = totalTeamData.getNumberOf3_point() / matches;
		numberOf3_pointAttempt = totalTeamData.getNumberOf3_pointAttempt() / matches;
		numberOfFreeThrow = totalTeamData.getNumberOfFreeThrow() / matches;
		numberOfFreeThrowAttempt = totalTeamData.getNumberOfFreeThrowAttempt() / matches;
		numberOfAttackRebound = totalTeamData.getNumberOfAttackRebound() / matches;
		numberOfDefenseRebound = totalTeamData.getNumberOfDefenseRebound() / matches;
		numberOfRebound = totalTeamData.getNumberOfRebound() / matches;
		numberOfAssist = totalTeamData.getNumberOfAssist() / matches;
		numberOfSteal = totalTeamData.getNumberOfSteal() / matches;
		numberOfBlock = totalTeamData.getNumberOfBlock() / matches;
		numberOfFault = totalTeamData.getNumberOfFault() / matches;
		numberOfFoul = totalTeamData.getNumberOfFoul() / matches;
		score = totalTeamData.getScore() / matches;
		
		percentageOfShooting = totalTeamData.getNumberOfShooting() / totalTeamData.getNumberOfShotAttempt();
		percentageOf3_point =  totalTeamData.getNumberOf3_point() / totalTeamData.getNumberOf3_pointAttempt();
		percentageOfFreeThrow =  totalTeamData.getNumberOfFreeThrow() / totalTeamData.getNumberOfFreeThrowAttempt();
		
		roundOfAttack =  totalTeamData.getRoundOfAttack() / matches;
		
		efficiencyOfAttack =  totalTeamData.getScore()/totalTeamData.getRoundOfAttack()*100 ;
		efficiencyOfDefense =  dataOfOtherTeams.getScoreOfOtherTeam()/totalTeamData.getRoundOfDefense()*100;
		efficiencyOfRebound = totalTeamData.getNumberOfRebound() / 
				(totalTeamData.getNumberOfRebound()+dataOfOtherTeams.getNumberOfReboundOfOtherTeam());
		efficiencyOfSteal = totalTeamData.getNumberOfSteal()/totalTeamData.getRoundOfDefense()*100;
		efficiencyOfAssist = totalTeamData.getNumberOfAssist() / totalTeamData.getRoundOfAttack()*100;
	}

	public double getNumberOfShooting() {
		return numberOfShooting;
	}

	public void setNumberOfShooting(double numberOfShooting) {
		this.numberOfShooting = numberOfShooting;
	}

	public void setNumberOfShotAttempt(double numberOfShotAttempt) {
		this.numberOfShotAttempt = numberOfShotAttempt;
	}

	public void setNumberOf3_point(double numberOf3_point) {
		this.numberOf3_point = numberOf3_point;
	}

	public void setNumberOf3_pointAttempt(double numberOf3_pointAttempt) {
		this.numberOf3_pointAttempt = numberOf3_pointAttempt;
	}

	public void setNumberOfFreeThrow(double numberOfFreeThrow) {
		this.numberOfFreeThrow = numberOfFreeThrow;
	}

	public void setNumberOfFreeThrowAttempt(double numberOfFreeThrowAttempt) {
		this.numberOfFreeThrowAttempt = numberOfFreeThrowAttempt;
	}

	public void setNumberOfAttackRebound(double numberOfAttackRebound) {
		this.numberOfAttackRebound = numberOfAttackRebound;
	}

	public void setNumberOfDefenseRebound(double numberOfDefenseRebound) {
		this.numberOfDefenseRebound = numberOfDefenseRebound;
	}

	public void setNumberOfRebound(double numberOfRebound) {
		this.numberOfRebound = numberOfRebound;
	}

	public void setNumberOfAssist(double numberOfAssist) {
		this.numberOfAssist = numberOfAssist;
	}

	public void setNumberOfSteal(double numberOfSteal) {
		this.numberOfSteal = numberOfSteal;
	}

	public void setNumberOfBlock(double numberOfBlock) {
		this.numberOfBlock = numberOfBlock;
	}

	public void setNumberOfFault(double numberOfFault) {
		this.numberOfFault = numberOfFault;
	}

	public void setNumberOfFoul(double numberOfFoul) {
		this.numberOfFoul = numberOfFoul;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void setPercentageOfShooting(double percentageOfShooting) {
		this.percentageOfShooting = percentageOfShooting;
	}

	public void setPercentageOf3_point(double percentageOf3_point) {
		this.percentageOf3_point = percentageOf3_point;
	}

	public void setPercentageOfFreeThrow(double percentageOfFreeThrow) {
		this.percentageOfFreeThrow = percentageOfFreeThrow;
	}

	public void setRoundOfAttack(double roundOfAttack) {
		this.roundOfAttack = roundOfAttack;
	}

	public void setEfficiencyOfAttack(double efficiencyOfAttack) {
		this.efficiencyOfAttack = efficiencyOfAttack;
	}

	public void setRoundOfDefense(double roundOfDefense) {
		this.roundOfDefense = roundOfDefense;
	}

	public void setEfficiencyOfDefense(double efficiencyOfDefense) {
		this.efficiencyOfDefense = efficiencyOfDefense;
	}

	public void setEfficiencyOfRebound(double efficiencyOfRebound) {
		this.efficiencyOfRebound = efficiencyOfRebound;
	}

	public void setEfficiencyOfSteal(double efficiencyOfSteal) {
		this.efficiencyOfSteal = efficiencyOfSteal;
	}

	public void setEfficiencyOfAssist(double efficiencyOfAssist) {
		this.efficiencyOfAssist = efficiencyOfAssist;
	}

	public double getNumberOfShotAttempt() {
		return numberOfShotAttempt;
	}

	public double getNumberOf3_point() {
		return numberOf3_point;
	}

	public double getNumberOf3_pointAttempt() {
		return numberOf3_pointAttempt;
	}

	public double getNumberOfFreeThrow() {
		return numberOfFreeThrow;
	}

	public double getNumberOfFreeThrowAttempt() {
		return numberOfFreeThrowAttempt;
	}

	public double getNumberOfAttackRebound() {
		return numberOfAttackRebound;
	}

	public double getNumberOfDefenseRebound() {
		return numberOfDefenseRebound;
	}

	public double getNumberOfRebound() {
		return numberOfRebound;
	}

	public double getNumberOfAssist() {
		return numberOfAssist;
	}

	public double getNumberOfSteal() {
		return numberOfSteal;
	}

	public double getNumberOfBlock() {
		return numberOfBlock;
	}

	public double getNumberOfFault() {
		return numberOfFault;
	}

	public double getNumberOfFoul() {
		return numberOfFoul;
	}

	public double getScore() {
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

	public double getRoundOfAttack() {
		return roundOfAttack;
	}

	public double getEfficiencyOfAttack() {
		return efficiencyOfAttack;
	}

	public double getRoundOfDefense() {
		return roundOfDefense;
	}

	public double getEfficiencyOfDefense() {
		return efficiencyOfDefense;
	}

	public double getEfficiencyOfRebound() {
		return efficiencyOfRebound;
	}

	public double getEfficiencyOfSteal() {
		return efficiencyOfSteal;
	}

	public double getEfficiencyOfAssist() {
		return efficiencyOfAssist;
	}
	
	
	
	
}
