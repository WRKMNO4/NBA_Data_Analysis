package PO;

import java.util.ArrayList;

public class PlayerDataOfOneMatchPO {
	//某场比赛中的数据
	String name ;//名字
	String position ;//位置
	String presentTimeOfOneMatch ;//在场时间
	int numberOfShooting ;//投篮命中数
	int numberOfShotAttempt ; // 投篮出手数，
	int numberOf3_point ;//三分命中数，
	int numberOf3_pointAttempt ;//三分出手数，
	int numberOfFreeThrow ;//罚球命中数，
	int numberOfFreeThrowAttempt ;//罚球出手数，
	int numberOfAttackRebound ;//进攻（前场）篮板球，
	int numberOfDefenseRebound ;//防守（后场）篮板球，
	int numberOfReboundOfOneMatch ;//总篮板球，
	int numberOfAssistOfOneMatch ;//助攻数，
	int numberOfSteal;  //抢断数
	int numberOfBlockOfOneMatch ;//盖帽数，
	int numberOfFaultOfOneMatch ;//失误数，
	
	int numberOfFoulOfOneMatch ;//犯规数，
	int scoreOfOneMatch ;//个人得分
	
	
	
	double percentageOfShooting ;//投篮命中率
	double percentageOf3_Point ;//三分命中率
	double percentageOffreeThrow ;//罚球命中率
	
	int numberOfAttack ;//进攻数
	int numberOfDefense ;//防守数
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
	
	
	public PlayerDataOfOneMatchPO(){
		
	}
	public PlayerDataOfOneMatchPO(String[] splitString){
	   	this.setName(splitString[0]);//名字
    	this.setPosition(splitString[1]);//位置
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
	}
	
	public void calculatePlayerData(int totalTime,TeamDataPO teamData,TeamDataPO theOtherTeamData,ArrayList<PlayerDataOfOneMatchPO> playersData ){//所有球员在长时间和对手总篮板
		percentageOfShooting = (double)numberOfShooting/numberOfShotAttempt ;//投篮命中率
		percentageOf3_Point = (double)numberOf3_point/numberOf3_pointAttempt ;//三分命中率
		percentageOffreeThrow = (double)numberOfFreeThrow/numberOfFreeThrowAttempt ;//罚球命中率
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
	int transfromTime(String time,ArrayList<PlayerDataOfOneMatchPO> playersData,int totalTime){//转化时间为整数，单位秒
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
			presentTimeOfOneMatch = ""+result/60+":"+result%60 ;//设置缺失的上场时间
//			System.out.println(result+"  "+presentTimeOfOneMatch);
			return result ;
		}
		String[] strs = time.split(":");
		result = Integer.parseInt(strs[0])*60+Integer.parseInt(strs[1]) ;
		return result ;
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
	public void setNumberOfShooting(int numberOfShooting) {
		this.numberOfShooting = numberOfShooting;
	}
	public void setNumberOfShotAttempt(int numberOfShotAttempt) {
		this.numberOfShotAttempt = numberOfShotAttempt;
	}
	public void setNumberOf3_point(int numberOf3_point) {
		this.numberOf3_point = numberOf3_point;
	}
	public void setNumberOf3_pointAttempt(int numberOf3_pointAttempt) {
		this.numberOf3_pointAttempt = numberOf3_pointAttempt;
	}
	public void setNumberOfFreeThrow(int numbreOfFreeThrow) {
		this.numberOfFreeThrow = numbreOfFreeThrow;
	}
	public void setNumberOfFreeThrowAttempt(int numberOfFreeThrowAttempt) {
		this.numberOfFreeThrowAttempt = numberOfFreeThrowAttempt;
	}
	public void setNumberOfAttackRebound(int numberOfAttackRebound) {
		this.numberOfAttackRebound = numberOfAttackRebound;
	}
	public void setNumberOfDefenseRebound(int numberOfDefenseRebound) {
		this.numberOfDefenseRebound = numberOfDefenseRebound;
	}
	public void setNumberOfReboundOfOneMatch(int numberOfReboundOfOneMatch) {
		this.numberOfReboundOfOneMatch = numberOfReboundOfOneMatch;
	}
	public void setNumberOfAssistOfOneMatch(int numberOfAssistOfOneMatch) {
		this.numberOfAssistOfOneMatch = numberOfAssistOfOneMatch;
	}
	public void setNumberOfSteal(int numberOfSteal) {
		this.numberOfSteal = numberOfSteal;
	}
	public void setNumberOfBlockOfOneMatch(int numberOfBlockOfOneMatch) {
		this.numberOfBlockOfOneMatch = numberOfBlockOfOneMatch;
	}
	public void setNumberOfFaultOfOneMatch(int numberOfFaultOfOneMatch) {
		this.numberOfFaultOfOneMatch = numberOfFaultOfOneMatch;
	}
	public void setNumberOfFoulOfOneMatch(int numberOfFoulOfOneMatch) {
		this.numberOfFoulOfOneMatch = numberOfFoulOfOneMatch;
	}
	public void setScoreOfOneMatch(int scoreOfOneMatch) {
		this.scoreOfOneMatch = scoreOfOneMatch;
	}
	public String getPosition() {
		return position;
	}
	public String getPresentTimeOfOneMatch() {
		return presentTimeOfOneMatch;
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
	public int getNumberOfReboundOfOneMatch() {
		return numberOfReboundOfOneMatch;
	}
	public int getNumberOfAssistOfOneMatch() {
		return numberOfAssistOfOneMatch;
	}
	public int getNumberOfSteal() {
		return numberOfSteal;
	}
	public int getNumberOfBlockOfOneMatch() {
		return numberOfBlockOfOneMatch;
	}
	public int getNumberOfFaultOfOneMatch() {
		return numberOfFaultOfOneMatch;
	}
	public int getNumberOfFoulOfOneMatch() {
		return numberOfFoulOfOneMatch;
	}
	public int getScoreOfOneMatch() {
		return scoreOfOneMatch;
	}
	
	
}
