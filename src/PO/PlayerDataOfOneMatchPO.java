package PO;

import java.util.ArrayList;

public class PlayerDataOfOneMatchPO {
	String name ;
	String position ;
	String presentTimeOfOneMatch ;
	double numberOfShooting ;
	double numberOfShotAttempt ;
	double numberOf3_point ;
	double numberOf3_pointAttempt ;
	double numberOfFreeThrow ;
	double numberOfFreeThrowAttempt ;
	double numberOfAttackRebound ;
	double numberOfDefenseRebound ;
	double numberOfReboundOfOneMatch ;
	double numberOfAssistOfOneMatch ;
	double numberOfSteal;  
	double numberOfBlockOfOneMatch ;
	double numberOfFaultOfOneMatch ;
	
	double numberOfFoulOfOneMatch ;
	double scoreOfOneMatch ;
	
	
	
	double percentageOfShooting ;
	double percentageOf3_Point ;
	double percentageOffreeThrow ;
	
	double numberOfAttack ;
	double numberOfDefense ;
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
	
	boolean double_double;
	
	
	public PlayerDataOfOneMatchPO(){
		
	}
	public PlayerDataOfOneMatchPO(String[] splitString){
	   	this.setName(splitString[0]);
    	this.setPosition(splitString[1]);
		this.setPresentTimeOfOneMatch(splitString[2]);
		this.setNumberOfShooting(Integer.parseInt(splitString[3]));
		this.setNumberOfShotAttempt(Integer.parseInt(splitString[4]));
		this.setNumberOf3_point(Integer.parseInt(splitString[5]));
		this.setNumberOf3_pointAttempt(Integer.parseInt(splitString[6]));
		this.setNumberOfFreeThrow(Integer.parseInt(splitString[7])) ;
		this.setNumberOfFreeThrowAttempt(Integer.parseInt(splitString[8]));
		this.setNumberOfAttackRebound(Integer.parseInt(splitString[9]));
		this.setNumberOfDefenseRebound(Integer.parseInt(splitString[10]));
		this.setNumberOfReboundOfOneMatch(Integer.parseInt(splitString[11]));
		this.setNumberOfAssistOfOneMatch(Integer.parseInt(splitString[12]));
		this.setNumberOfSteal(Integer.parseInt(splitString[13]));
		this.setNumberOfBlockOfOneMatch(Integer.parseInt(splitString[14]));
		this.setNumberOfFaultOfOneMatch(Integer.parseInt(splitString[15]));
		this.setNumberOfFoulOfOneMatch(Integer.parseInt(splitString[16]));
		if(splitString[17].equals("null"))  // Invalid data
			this.setScoreOfOneMatch(this.getNumberOfFreeThrow() + 
					2 * (this.getNumberOfShooting() - this. getNumberOf3_point()) +
					3 * this.getNumberOf3_point()   );      //calculate by other data of him
		else
			this.setScoreOfOneMatch(Integer.parseInt(splitString[17]));
		this.setDouble_double(ifDoubleDouble());
		
	}
	
	public void calculatePlayerData(int totalTime,TeamDataPO teamData,TeamDataPO theOtherTeamData,ArrayList<PlayerDataOfOneMatchPO> playersData ){
		percentageOfShooting = (double)numberOfShooting/numberOfShotAttempt ;
		percentageOf3_Point = (double)numberOf3_point/numberOf3_pointAttempt ;
		percentageOffreeThrow = (double)numberOfFreeThrow/numberOfFreeThrowAttempt ;
		efficiency = (scoreOfOneMatch+numberOfReboundOfOneMatch+numberOfAssistOfOneMatch+numberOfSteal+numberOfBlockOfOneMatch)
				-(numberOfShotAttempt - numberOfShooting)-(numberOfFreeThrowAttempt-numberOfFreeThrow)-numberOfFaultOfOneMatch ;
		
		efficiencyOfGmSc = scoreOfOneMatch + 0.4*numberOfShooting-0.7*numberOfShotAttempt-0.4*(numberOfFreeThrowAttempt-numberOfFreeThrow)
				+0.7*numberOfAttackRebound+0.3*numberOfDefenseRebound+numberOfSteal+0.7*numberOfAssistOfOneMatch+0.7*numberOfBlockOfOneMatch-0.4*numberOfFoulOfOneMatch-numberOfFaultOfOneMatch;
		percentageOfTrueShooting = scoreOfOneMatch/(2*(numberOfShotAttempt+0.44*numberOfFreeThrowAttempt)) ;
		efficiencyOfShooting = (numberOfShooting+0.5*numberOf3_point)/numberOfShotAttempt ;
		percentageOfRebound = numberOfReboundOfOneMatch*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfRebound()+theOtherTeamData.getNumberOfRebound()) ;
		percentageOfAttackingRebound = numberOfAttackRebound*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfAttackRebound()+theOtherTeamData.getNumberOfAttackRebound());
		percentageOfDefenseRebound = numberOfDefenseRebound*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfDefenseRebound()+theOtherTeamData.getNumberOfDefenseRebound()) ;
		percentageOfAssist = numberOfAssistOfOneMatch/(transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(totalTime/5.0)*teamData.getNumberOfShooting()-numberOfShooting) ;
		percentageOfSteal = numberOfSteal*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/theOtherTeamData.getRoundOfAttack() ;
		percentageOfBlock = numberOfBlockOfOneMatch*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(theOtherTeamData.getNumberOfShotAttempt()-theOtherTeamData.getNumberOf3_pointAttempt()) ;
		percentageOfFault = numberOfFaultOfOneMatch/( (theOtherTeamData.getNumberOfShotAttempt()-theOtherTeamData.getNumberOf3_pointAttempt()) + 0.44*numberOfFreeThrowAttempt+numberOfFaultOfOneMatch) ;
		percentageOfUse = (numberOfShotAttempt+0.44*numberOfFreeThrowAttempt+numberOfFaultOfOneMatch)*(totalTime/5.0)/transfromTime(presentTimeOfOneMatch,playersData,totalTime)/(teamData.getNumberOfShotAttempt()+0.44*teamData.getNumberOfFreeThrowAttempt()+teamData.getNumberOfFault());
	}
	int transfromTime(String time,ArrayList<PlayerDataOfOneMatchPO> playersData,int totalTime){
		int result = 0 ;
		if(time.equals("null")||time.equals("None")){
			result = totalTime *5;
			for(PlayerDataOfOneMatchPO onePlayer:playersData){
				if(!onePlayer.getName().equals(name)){
				   result =result - transfromTime(onePlayer.getPresentTimeOfOneMatch(), playersData, totalTime) ;
				}
			}
			if(result<0){
				result = 0;
			}
			presentTimeOfOneMatch = ""+result/60+":"+result%60 ;
			return result ;
		}
		String[] strs = time.split(":");
		result = Integer.parseInt(strs[0])*60+Integer.parseInt(strs[1]) ;
		return result ;
	}
	
	public boolean ifDoubleDouble(){
		int count=0;
		if(scoreOfOneMatch>=10)
			count++;
		if(numberOfReboundOfOneMatch>=10)
			count++;
		if(numberOfAssistOfOneMatch>=10)
			count++;
		if(numberOfSteal>=10)
			count++;
		if(numberOfBlockOfOneMatch>=10)
			count++;
		if(count>=2)
			return true;
		else
			return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setPresentTimeOfOneMatch(String presentTimeOfOneMatch) {
		this.presentTimeOfOneMatch = presentTimeOfOneMatch;
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
	public void setNumberOfReboundOfOneMatch(double numberOfReboundOfOneMatch) {
		this.numberOfReboundOfOneMatch = numberOfReboundOfOneMatch;
	}
	public void setNumberOfAssistOfOneMatch(double numberOfAssistOfOneMatch) {
		this.numberOfAssistOfOneMatch = numberOfAssistOfOneMatch;
	}
	public void setNumberOfSteal(double numberOfSteal) {
		this.numberOfSteal = numberOfSteal;
	}
	public void setNumberOfBlockOfOneMatch(double numberOfBlockOfOneMatch) {
		this.numberOfBlockOfOneMatch = numberOfBlockOfOneMatch;
	}
	public void setNumberOfFaultOfOneMatch(double numberOfFaultOfOneMatch) {
		this.numberOfFaultOfOneMatch = numberOfFaultOfOneMatch;
	}
	public void setPercentageOfShooting(double percentageOfShooting) {
		this.percentageOfShooting = percentageOfShooting;
	}
	public void setPercentageOf3_Point(double percentageOf3_Point) {
		this.percentageOf3_Point = percentageOf3_Point;
	}
	public void setPercentageOffreeThrow(double percentageOffreeThrow) {
		this.percentageOffreeThrow = percentageOffreeThrow;
	}
	public void setNumberOfAttack(double numberOfAttack) {
		this.numberOfAttack = numberOfAttack;
	}
	public void setNumberOfDefense(double numberOfDefense) {
		this.numberOfDefense = numberOfDefense;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	public void setEfficiencyOfGmSc(double efficiencyOfGmSc) {
		this.efficiencyOfGmSc = efficiencyOfGmSc;
	}
	public void setPercentageOfTrueShooting(double percentageOfTrueShooting) {
		this.percentageOfTrueShooting = percentageOfTrueShooting;
	}
	public void setEfficiencyOfShooting(double efficiencyOfShooting) {
		this.efficiencyOfShooting = efficiencyOfShooting;
	}
	public void setPercentageOfRebound(double percentageOfRebound) {
		this.percentageOfRebound = percentageOfRebound;
	}
	public void setPercentageOfAttackingRebound(double percentageOfAttackingRebound) {
		this.percentageOfAttackingRebound = percentageOfAttackingRebound;
	}
	public void setPercentageOfDefenseRebound(double percentageOfDefenseRebound) {
		this.percentageOfDefenseRebound = percentageOfDefenseRebound;
	}
	public void setPercentageOfAssist(double percentageOfAssist) {
		this.percentageOfAssist = percentageOfAssist;
	}
	public void setPercentageOfSteal(double percentageOfSteal) {
		this.percentageOfSteal = percentageOfSteal;
	}
	public void setPercentageOfBlock(double percentageOfBlock) {
		this.percentageOfBlock = percentageOfBlock;
	}
	public void setPercentageOfFault(double percentageOfFault) {
		this.percentageOfFault = percentageOfFault;
	}
	public void setPercentageOfUse(double percentageOfUse) {
		this.percentageOfUse = percentageOfUse;
	}
	public void setNumberOfFoulOfOneMatch(double numberOfFoulOfOneMatch) {
		this.numberOfFoulOfOneMatch = numberOfFoulOfOneMatch;
	}
	public void setScoreOfOneMatch(double scoreOfOneMatch) {
		this.scoreOfOneMatch = scoreOfOneMatch;
	}
	public String getPosition() {
		return position;
	}
	public String getPresentTimeOfOneMatch() {
		return presentTimeOfOneMatch;
	}
	public double getNumberOfShooting() {
		return numberOfShooting;
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
	public double getNumberOfReboundOfOneMatch() {
		return numberOfReboundOfOneMatch;
	}
	public double getNumberOfAssistOfOneMatch() {
		return numberOfAssistOfOneMatch;
	}
	public double getNumberOfSteal() {
		return numberOfSteal;
	}
	public double getNumberOfBlockOfOneMatch() {
		return numberOfBlockOfOneMatch;
	}
	public double getNumberOfFaultOfOneMatch() {
		return numberOfFaultOfOneMatch;
	}
	public double getNumberOfFoulOfOneMatch() {
		return numberOfFoulOfOneMatch;
	}
	public double getScoreOfOneMatch() {
		return scoreOfOneMatch;
	}
	public boolean isDouble_double() {
		return double_double;
	}
	public void setDouble_double(boolean double_double) {
		this.double_double = double_double;
	}
	
	
}
