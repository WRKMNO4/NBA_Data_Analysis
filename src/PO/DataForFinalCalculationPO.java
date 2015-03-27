package PO;

public class DataForFinalCalculationPO {
	double teamTotalTime ;
	double numberOfReboundOfOtherTeam ;
	double numberOfAttackReboundOfOtherTeam ;
	double numberOfDefenseReboundOfOtherTeam ;
	double numberOfRoundOfAttackOfOtherTeam ;
	double numberOf2_PointAttemptOfOtherTeam ;
	
	double scoreOfOtherTeam;
	
	public void update(int totalTime, TeamDataPO otherTeamData){
		this.teamTotalTime += totalTime ;
		numberOfReboundOfOtherTeam += otherTeamData.getNumberOfRebound() ;
		numberOfAttackReboundOfOtherTeam += otherTeamData.getNumberOfAttackRebound() ;
		numberOfDefenseReboundOfOtherTeam += otherTeamData.getNumberOfDefenseRebound() ;
		numberOfRoundOfAttackOfOtherTeam += otherTeamData.getRoundOfAttack() ;
		numberOf2_PointAttemptOfOtherTeam += (otherTeamData.getNumberOfShotAttempt() 
				- otherTeamData.getNumberOf3_pointAttempt()) ;
	}
	
	public void update(double score){
		this.scoreOfOtherTeam += score ;
	}
	public double getTeamTotalTime() {
		return teamTotalTime;
	}

	public double getNumberOfReboundOfOtherTeam() {
		return numberOfReboundOfOtherTeam;
	}

	public double getNumberOfAttackReboundOfOtherTeam() {
		return numberOfAttackReboundOfOtherTeam;
	}

	public double getNumberOfDefenseReboundOfOtherTeam() {
		return numberOfDefenseReboundOfOtherTeam;
	}

	public double getNumberOfRoundOfAttackOfOtherTeam() {
		return numberOfRoundOfAttackOfOtherTeam;
	}

	public double getNumberOf2_PointAttemptOfOtherTeam() {
		return numberOf2_PointAttemptOfOtherTeam;
	}

	public double getScoreOfOtherTeam() {
		return scoreOfOtherTeam;
	}
	
	
}
