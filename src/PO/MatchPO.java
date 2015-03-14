package PO;

import java.util.ArrayList;

public class MatchPO {
	String name;    //比赛的文件名字
	
	String season;
	String date;
	String firstTeam;
	String secondTeam;
	ScoreOfMatchPO finalScore;
	/*ScorePO firstScore,secondScore,thirdScore,fourthScore;*/
	ArrayList<ScoreOfMatchPO> allScore ;
	
	ArrayList<PlayerDataOfOneMatchPO> firstTeamData;
	ArrayList<PlayerDataOfOneMatchPO> secondTeamData;
	public MatchPO(){
		firstTeamData = new ArrayList<>() ;
		secondTeamData = new ArrayList<>() ;
	}
	
	public void addDataOfOnePlayerOfFirstTeam(PlayerDataOfOneMatchPO onePlayer){  
		firstTeamData.add(onePlayer) ;
	}
	public void addDataOfOnePlayerOfSecondTeam(PlayerDataOfOneMatchPO onePlayer){  
		secondTeamData.add(onePlayer) ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFirstTeam() {
		return firstTeam;
	}
	public void setFirstTeam(String firstTeam) {
		this.firstTeam = firstTeam;
	}
	public String getSecondTeam() {
		return secondTeam;
	}
	public void setSecondTeam(String secondTeam) {
		this.secondTeam = secondTeam;
	}
	public ScoreOfMatchPO getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(ScoreOfMatchPO finalScore) {
		this.finalScore = finalScore;
	}
	public ArrayList<ScoreOfMatchPO> getAllScore() {
		return allScore;
	}
	public void setAllScore(ArrayList<ScoreOfMatchPO> allScore) {
		this.allScore = allScore;
	}
	public ArrayList<PlayerDataOfOneMatchPO> getFirstTeamData() {
		return firstTeamData;
	}
	public void setFirstTeamData(ArrayList<PlayerDataOfOneMatchPO> firstTeamData) {
		this.firstTeamData = firstTeamData;
	}
	public ArrayList<PlayerDataOfOneMatchPO> getSecondTeamData() {
		return secondTeamData;
	}
	public void setSecondTeamData(ArrayList<PlayerDataOfOneMatchPO> secondTeamData) {
		this.secondTeamData = secondTeamData;
	}
	
	
	
}
