package PO;

import java.util.ArrayList;

public class PlayerDataPO {

	//����Ա����������
	int numberOfMatch ;//��������
	int numberOfStarting ;//�׷�����
	double numberOfRebound ;//������
	double numberOfAssist ;//������
	String presentTime ;//�ڳ�ʱ��
	
	
	
	double percentageOfShooting ;//Ͷ��������
	double percentageOf3_Point ;//����������
	double percentageOffreeThrow ;//����������
	
	double numberOfAttack ;//������
	double numberOfDefense ;//������
	double numberOfSteal ;//������
	double numberOfBlock ;//��ñ�� 
	double numberOfFault ;//ʧ����
	double numberOfFoul ;//��������
	double score ;//�÷֣�
	double efficiency ;//Ч�ʣ�
	
	double efficiencyOfGmSc ;//GmScЧ��ֵ��
	double percentageOfTrueShooting ;//��ʵ�����ʣ�
	double efficiencyOfShooting ;//Ͷ��Ч�ʣ�
	double percentageOfRebound ; //�����ʣ�
	double percentageOfAttackingRebound ;//���������ʣ�
	double percentageOfDefenseRebound ;//���������ʣ�
	double percentageOfAssist ;// �����ʣ�
	double percentageOfSteal ;//�����ʣ�
	double percentageOfBlock ;//��ñ�ʣ�
	double percentageOfFault ;//ʧ���ʣ�
	double percentageOfUse ;//ʹ����
	
	int double_double;  //��˫
	double comprehension;  // �÷�/����/����
	
	public void calculatePlayerTotalDataInOneSeason(ArrayList<PlayerDataOfOneMatchPO> datas,TeamDataPO teamdatas,DataForFinalCalculationPO otherDatas){
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
		    
		    if(oneMatch.isDouble_double()==true)
		    	double_double += 1;
		    
		}
		presentTime ="" +totalTime/60+":"+totalTime%60 ;
		comprehension = (score+numberOfRebound+numberOfAssist)/3;
	}
	
	public void calculatePlayerAverageDataInOneSeason(ArrayList<PlayerDataOfOneMatchPO> datas){
		
//		calculatePlayerTotalDataInOneSeason(datas) ;
		
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
	public int getDouble_double() {
		return double_double;
	}
	public double getComprehension() {
		return comprehension;
	}


	
	
}
