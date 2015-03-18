package PO;

import java.util.ArrayList;

public class PlayerDataPO {

	//该球员赛季总数据
	int numberOfMatch ;//参赛场数
	int numberOfStarting ;//首发场数
	double numberOfRebound ;//篮板数
	double numberOfAssist ;//助攻数
	String presentTime ;//在场时间
	
	
	double percentageOfShooting ;//投篮命中率
	double percentageOf3_Point ;//三分命中率
	double percentageOffreeThrow ;//罚球命中率
	
	double numberOfAttack ;//进攻数
	double numberOfDefense ;//防守数
	double numberOfSteal ;//抢断数
	double numberOfBlock ;//盖帽数 
	double numberOfFault ;//失误数
	double numberOfFoul ;//犯规数，
	double score ;//得分，
	double efficiency ;//效率，
	
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
	
	public void calculatePlayerTotalDataInOneSeason(ArrayList<PlayerDataOfOneMatchPO> datas){
		numberOfMatch = datas.size() ;
		numberOfStarting = datas.size() ;
		
		int totalTime = 0 ;
		
		for(PlayerDataOfOneMatchPO oneMatch:datas){
			numberOfRebound += oneMatch.getNumberOfReboundOfOneMatch() ;
			numberOfAssist += oneMatch.getNumberOfAssistOfOneMatch() ;
			totalTime += transportTime(oneMatch.getPresentTimeOfOneMatch()) ;
			
			numberOfAttack += oneMatch.getNumberOfAttack() ;
			numberOfDefense += oneMatch.getNumberOfDefense() ;
			numberOfSteal += oneMatch.getNumberOfSteal() ;
			numberOfBlock += oneMatch.getNumberOfBlockOfOneMatch() ;
			numberOfFault += oneMatch.getNumberOfFaultOfOneMatch() ;
			numberOfFoul += oneMatch.getNumberOfFoulOfOneMatch() ;
			score = oneMatch.getScoreOfOneMatch() ;
			efficiency += oneMatch.getEfficiency() ;
			
		    efficiencyOfGmSc += oneMatch.getEfficiencyOfGmSc() ;
		    
		}
		presentTime ="" +totalTime/60+":"+totalTime%60 ;
	}
	
	public void calculatePlayerAverageDataInOneSeason(ArrayList<PlayerDataOfOneMatchPO> datas){
		
		calculatePlayerTotalDataInOneSeason(datas);
		
		double totalPOShooting = 0;
		double totalPO3 = 0 ;
		double totalPOFT = 0;
		
		double totalPOTS = 0 ;
		double totalEOS = 0;
		double totalPOR = 0;
		double totalPOAR = 0;
		double totalPODR = 0 ;
		double totalPOA = 0 ;
		double totalPOS = 0;
		double totalPOB = 0;
		double totalPOF = 0;
		double totalPOU = 0;
		
		for(PlayerDataOfOneMatchPO oneMatch:datas){
		    totalPOShooting += oneMatch.getPercentageOfShooting() ;
		    totalPO3 += oneMatch.getPercentageOf3_Point() ;
		    totalPOFT += oneMatch.getPercentageOffreeThrow() ;
		    totalPOTS += oneMatch.getPercentageOfTrueShooting() ;
	    	totalEOS += oneMatch.getEfficiencyOfShooting() ;
	  		totalPOR = oneMatch.getPercentageOfRebound() ;
			totalPOAR = oneMatch.getPercentageOfAttackingRebound() ;
			totalPODR = oneMatch.getPercentageOfDefenseRebound() ;
			totalPOA = oneMatch.getPercentageOfAssist() ;
			totalPOS = oneMatch.getPercentageOfSteal() ;
			totalPOB = oneMatch.getPercentageOfBlock() ;
			totalPOF = oneMatch.getPercentageOfFault() ;
			totalPOU = oneMatch.getPercentageOfUse() ;
		}
		
		numberOfRebound = numberOfRebound/numberOfMatch ;
		numberOfAssist = numberOfAssist/numberOfMatch ;
		double totalTime = transportTime(presentTime) ;
		double avgTime = totalTime/numberOfMatch ;
		presentTime = ""+avgTime/60+":"+avgTime%60 ;
		
		percentageOfShooting = totalPOShooting/numberOfMatch ;
		percentageOf3_Point = totalPO3/numberOfMatch ;
		percentageOffreeThrow = totalPOFT/numberOfMatch ;
		
		numberOfAttack = numberOfAttack/numberOfMatch ;
		numberOfDefense = numberOfDefense/numberOfMatch ;
		numberOfSteal = numberOfSteal/numberOfMatch ;
		numberOfBlock = numberOfBlock/numberOfMatch ;
		numberOfFault = numberOfFault/numberOfMatch ;
		numberOfFoul = numberOfFoul/numberOfMatch ;
		score = score/numberOfMatch ;
		efficiency = efficiency/numberOfMatch ;
		
		efficiencyOfGmSc = efficiencyOfGmSc/numberOfMatch ;
		percentageOfTrueShooting = totalPOTS/numberOfMatch ;
		efficiencyOfShooting = totalEOS/numberOfMatch ;
		percentageOfRebound = totalPOR/numberOfMatch ;
		percentageOfAttackingRebound = totalPOAR/numberOfMatch ;
		percentageOfDefenseRebound = totalPODR/numberOfMatch ;
		percentageOfAssist = totalPOA/numberOfMatch ;
		percentageOfSteal = totalPOS/numberOfMatch ;
		percentageOfBlock = totalPOB/numberOfMatch ;
		percentageOfFault = totalPOF/numberOfMatch ;
		percentageOfUse = totalPOU/numberOfMatch ;
	}
	int transportTime(String time){
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
	
	
}
