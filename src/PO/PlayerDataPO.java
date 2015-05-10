package PO;

import java.util.ArrayList;

public class PlayerDataPO {
	int numberOfMatch ;
	int numberOfStarting ;
	double numberOfRebound ;
	double numberOfAssist ;
	String presentTime ;
	
	
	
	double percentageOfShooting ;
	double percentageOf3_Point ;
	double percentageOffreeThrow ;
	
	double numberOfAttack ;
	double numberOfDefense ;
	double numberOfSteal ;
	double numberOfBlock ; 
	double numberOfFault ;
	double numberOfFoul ;
	double score ;
	double efficiency ;
	
	double efficiencyOfGmSc ;
	double percentageOfTrueShooting ;
	double efficiencyOfShooting ;
	double percentageOfRebound ; 
	double percentageOfAttackingRebound ;
	double percentageOfDefenseRebound ;
	double percentageOfAssist ;
	double percentageOfSteal ;
	double percentageOfBlock ;
	double percentageOfFault ;
	double percentageOfUse ;
	
	double double_double;  
	double comprehension;  
	
	double numberOfShotAttempt ;
	double numberOfShooting ;
	double numberOf3_point ;
	double numberOf3_pointAttempt ;
	double numberOfFreeThrow ;
	double numberOfFreeThrowAttempt ;
	double numberOfAttackRebound ;
	double numberOfDefenseRebound ;
	
	
	double efficiencyOfTotal;
	
	public void calculatePlayerTotalDataInOneSeason(ArrayList<PlayerDataOfOneMatchPO> datas){
		numberOfMatch = datas.size() ;
		
		int totalTime = 0 ;
		
		for(PlayerDataOfOneMatchPO oneMatch:datas){
			if(oneMatch.ifStarting==true)
				numberOfStarting += 1 ;
			numberOfRebound += oneMatch.getNumberOfReboundOfOneMatch() ;
			numberOfAssist += oneMatch.getNumberOfAssistOfOneMatch() ;
			totalTime += transportTime(oneMatch.getPresentTimeOfOneMatch()) ;
			
			numberOfAttack += oneMatch.getNumberOfAttack() ;
			numberOfDefense += oneMatch.getNumberOfDefense() ;
			numberOfSteal += oneMatch.getNumberOfSteal() ;
			numberOfBlock += oneMatch.getNumberOfBlockOfOneMatch() ;
			numberOfFault += oneMatch.getNumberOfFaultOfOneMatch() ;
			numberOfFoul += oneMatch.getNumberOfFoulOfOneMatch() ;
			score += oneMatch.getScoreOfOneMatch() ;
			
		    if(oneMatch.isDouble_double()==true)
		    	double_double += 1;
		    
		    numberOfShotAttempt += oneMatch.getNumberOfShotAttempt() ;
		    numberOfShooting += oneMatch.getNumberOfShooting() ;
		    numberOf3_point += oneMatch.getNumberOf3_point() ;
			numberOf3_pointAttempt += oneMatch.getNumberOf3_pointAttempt() ;
			numberOfFreeThrow += oneMatch.getNumberOfFreeThrow() ;
			numberOfFreeThrowAttempt += oneMatch.getNumberOfFreeThrowAttempt() ;
			numberOfAttackRebound += oneMatch.getNumberOfAttackRebound() ;
			numberOfDefenseRebound += oneMatch.getNumberOfDefenseRebound() ;
			if(oneMatch.isDouble_double())
		      double_double += 1 ;
		    
		}
		presentTime ="" +totalTime/60+":"+totalTime%60 ;
		comprehension = (score+numberOfRebound+numberOfAssist)/3;
	}
	
	public void calculatePlayerAverageDataInOneSeason(PlayerDataPO totalDataOfPlayer,TeamDataPO totalDataOfTeam,DataForFinalCalculationPO otherTeamData){
		int num = totalDataOfPlayer.getNumberOfMatch() ;
		this.numberOfRebound = totalDataOfPlayer.getNumberOfRebound()/num ;
		this.numberOfAssist = totalDataOfPlayer.getNumberOfAssist()/num ;
		
		String[] strs = totalDataOfPlayer.getPresentTime().split(":") ;
		int seconds = Integer.parseInt(strs[0])*60+Integer.parseInt(strs[1]) ;
		int avgSecond = seconds/num ;
		this.presentTime = "" + avgSecond/60 +":"+avgSecond%60 ;
		
		this.percentageOfShooting = totalDataOfPlayer.getNumberOfShooting()/totalDataOfPlayer.getNumberOfShotAttempt() ;
		this.percentageOf3_Point = totalDataOfPlayer.getNumberOf3_point()/totalDataOfPlayer.getNumberOf3_pointAttempt();
		this.percentageOffreeThrow = totalDataOfPlayer.getNumberOfFreeThrow()/totalDataOfPlayer.getNumberOfFreeThrowAttempt() ;
		this.numberOfAttack = totalDataOfPlayer.getNumberOfAttack()/num ;
		this.numberOfDefense = totalDataOfPlayer.getNumberOfDefense()/num ;
		this.numberOfSteal = totalDataOfPlayer.getNumberOfSteal()/num ;
		this.numberOfBlock = totalDataOfPlayer.getNumberOfBlock()/num ;
		this.numberOfFault = totalDataOfPlayer.getNumberOfFault()/num ;
		this.numberOfFoul = totalDataOfPlayer.getNumberOfFoul()/num ;
		this.score = totalDataOfPlayer.getScore()/num ;
		this.efficiencyOfTotal = ((totalDataOfPlayer.getScore()+totalDataOfPlayer.getNumberOfRebound()+totalDataOfPlayer.getNumberOfAssist()+totalDataOfPlayer.getNumberOfSteal()+totalDataOfPlayer.getNumberOfBlock())
				          -(totalDataOfPlayer.getNumberOfShotAttempt()-totalDataOfPlayer.getNumberOfShooting())-(totalDataOfPlayer.getNumberOfFreeThrowAttempt()-totalDataOfPlayer.getNumberOfFreeThrow())
				          -totalDataOfPlayer.getNumberOfFault()) ;
		this.efficiency = this.efficiencyOfTotal/num ;
		this.efficiencyOfGmSc = totalDataOfPlayer.getScore()+0.4*totalDataOfPlayer.getNumberOfShooting()-0.7*totalDataOfPlayer.getNumberOfShotAttempt()-0.4*(totalDataOfPlayer.getNumberOfFreeThrowAttempt()-totalDataOfPlayer.getNumberOfFreeThrow())
				+0.7*totalDataOfPlayer.getNumberOfAttackRebound()+0.3*totalDataOfPlayer.getNumberOfDefenseRebound()
				+totalDataOfPlayer.getNumberOfSteal()+0.7*totalDataOfPlayer.getNumberOfAssist()+0.7*totalDataOfPlayer.getNumberOfBlock()
				-0.4*totalDataOfPlayer.getNumberOfFault()-totalDataOfPlayer.getNumberOfFoul() ;
		this.efficiencyOfGmSc = this.efficiencyOfGmSc/num ;
		
		this.percentageOfTrueShooting = totalDataOfPlayer.getScore()/(2*(totalDataOfPlayer.getNumberOfShotAttempt()+0.44*totalDataOfPlayer.getNumberOfFreeThrowAttempt())) ;
		this.efficiencyOfShooting = (totalDataOfPlayer.getNumberOfShooting()+0.5*totalDataOfPlayer.getNumberOf3_point())/totalDataOfPlayer.getNumberOfShotAttempt() ;
		this.percentageOfRebound = totalDataOfPlayer.getNumberOfRebound()*otherTeamData.getTeamTotalTime()/seconds/(totalDataOfTeam.getNumberOfRebound()+otherTeamData.getNumberOfReboundOfOtherTeam()) ;
		this.percentageOfAttackingRebound = totalDataOfPlayer.getNumberOfAttackRebound()*otherTeamData.getTeamTotalTime()/seconds/(totalDataOfTeam.getNumberOfAttackRebound()+otherTeamData.getNumberOfAttackReboundOfOtherTeam()) ;
		this.percentageOfDefenseRebound = totalDataOfPlayer.getNumberOfDefenseRebound()*otherTeamData.getTeamTotalTime()/seconds/(totalDataOfTeam.getNumberOfDefenseRebound()+otherTeamData.getNumberOfDefenseReboundOfOtherTeam()) ;
		this.percentageOfAssist = totalDataOfPlayer.getNumberOfAssist()/(seconds/otherTeamData.getTeamTotalTime()*totalDataOfTeam.getNumberOfShooting()-totalDataOfPlayer.getNumberOfShooting()) ;
		this.percentageOfSteal = totalDataOfPlayer.getNumberOfSteal()*otherTeamData.getTeamTotalTime()/seconds/otherTeamData.getNumberOfRoundOfAttackOfOtherTeam() ;
        this.percentageOfBlock = totalDataOfPlayer.getNumberOfBlock()*otherTeamData.getTeamTotalTime()/seconds/otherTeamData.getNumberOf2_PointAttemptOfOtherTeam() ;
        this.percentageOfFault = totalDataOfPlayer.getNumberOfFault()/(totalDataOfPlayer.getNumberOfShotAttempt()-totalDataOfPlayer.getNumberOf3_pointAttempt()+0.44*totalDataOfPlayer.getNumberOfFreeThrowAttempt()+totalDataOfPlayer.getNumberOfFault()) ;
        this.percentageOfUse = (totalDataOfPlayer.getNumberOfShotAttempt()+0.44*totalDataOfPlayer.getNumberOfFreeThrowAttempt()+totalDataOfPlayer.getNumberOfFault())
        		*otherTeamData.getTeamTotalTime()/seconds/(totalDataOfTeam.getNumberOfShotAttempt()+0.44*totalDataOfTeam.getNumberOfFreeThrowAttempt()+totalDataOfTeam.getNumberOfFault()) ;
        this.comprehension = totalDataOfPlayer.getComprehension()/num ;
        this.double_double = (double)totalDataOfPlayer.getDouble_double()/num ;
	}


	public double getEfficiencyOfTotal() {
		return efficiencyOfTotal;
	}

	public static int transportTime(String time){
		int result = 0;
		String[] strs = time.split(":") ;
		result = Integer.parseInt(strs[0])*60 + Integer.parseInt(strs[1]) ;
		return result ;
	}
	
	public int getNumberOfMatch() {
		return numberOfMatch;
	}
	public int getNumberOfStarting() {
		return numberOfStarting;
	}
	public double getNumberOfRebound() {
		return numberOfRebound;
	}
	public double getNumberOfAssist() {
		return numberOfAssist;
	}
	public String getPresentTime() {
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
	public double getNumberOfAttack() {
		return numberOfAttack;
	}
	public double getNumberOfDefense() {
		return numberOfDefense;
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
	public double getEfficiency() {
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
	public double getDouble_double() {
		return double_double;
	}
	public double getComprehension() {
		return comprehension;
	}

	public double getNumberOfShotAttempt() {
		return numberOfShotAttempt;
	}

	public double getNumberOfShooting() {
		return numberOfShooting;
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

	public void setNumberOfStarting(int numberOfStarting) {
		this.numberOfStarting = numberOfStarting;
	}
	

	
	
}
