package PO;

import java.util.ArrayList;

import Enum.Season;

public class SeasonInfoForPlayer {
	Season season;
	ArrayList<PlayerDataOfOneMatchPO> datas=new ArrayList<PlayerDataOfOneMatchPO>();
	PlayerDataPO totalPlayerData = new PlayerDataPO();
	PlayerDataPO averagePlayerData = new PlayerDataPO() ;
	ArrayList<MatchPO> allMatches = new ArrayList<MatchPO>() ;
	
	DataForFinalCalculationPO dataOfOtherTeam = new DataForFinalCalculationPO() ;
	
	double improvedRateOfScore;
	double improvedRateOfRebound;
	double improvedRateOfAssist;
	
	String team="Unknown" ; 
	public SeasonInfoForPlayer(Season season){
		this.season=season;
	}
	public void addMatch(MatchPO match){
		allMatches.add(match) ;
	}
	public void calculateImprovedRate(){
		if(datas.size()>5){
			double totalScore = 0 ;
			double totalRebound = 0;
			double totalAssist = 0 ;
			
			double scoreOf5 = 0;
			double reboundOf5 = 0 ;
			double assistOf5 = 0 ;
			
			for(int i = 0 ;i<datas.size()-5;i++){
				PlayerDataOfOneMatchPO oneMatch = datas.get(i) ;
				totalScore += oneMatch.getScoreOfOneMatch() ;
				totalRebound += oneMatch.getNumberOfReboundOfOneMatch() ;
				totalAssist += oneMatch.getNumberOfAssistOfOneMatch() ;
			}
			for(int i = datas.size()-5 ;i<datas.size();i++){
				PlayerDataOfOneMatchPO oneMatch = datas.get(i) ;
				scoreOf5 += oneMatch.getScoreOfOneMatch() ;
				reboundOf5 += oneMatch.getNumberOfReboundOfOneMatch() ;
				assistOf5 += oneMatch.getNumberOfAssistOfOneMatch() ;
			}
			if(totalScore == 0 )
		    	this.improvedRateOfScore = 0 ;
			else
				this.improvedRateOfScore = ((scoreOf5/5)-(totalScore / (datas.size()-5))) / (totalScore / (datas.size()-5)) ;
			
			if(totalRebound == 0)
				this.improvedRateOfRebound = 0;
			else
				this.improvedRateOfRebound = ( (reboundOf5/5) - (totalRebound / (datas.size()-5))) / (totalRebound / (datas.size()-5) ) ;
		
			if(totalAssist == 0)
				this.improvedRateOfAssist = 0 ;
			else
				this.improvedRateOfAssist = ((assistOf5/5)-(totalAssist /(datas.size()-5)))/(totalAssist /(datas.size()-5)) ;
		}
	}
	public void calculateFinalData(){
		TeamPO team = TeamListPO.findTeamByShortName(this.team) ;
		if(team==null){
			return;
		}
		totalPlayerData.calculatePlayerTotalDataInOneSeason(datas);
		averagePlayerData.calculatePlayerAverageDataInOneSeason(totalPlayerData,team.getTotalTeamData(season),dataOfOtherTeam);
        this.calculateImprovedRate();
 	}
	
	public void updateDataOfOtherData(int totalTime,TeamDataPO dataOfOtherTeam){
		this.dataOfOtherTeam.update(totalTime, dataOfOtherTeam) ;
	}
	public void addDataOfOneMatchOfOnePlayer(PlayerDataOfOneMatchPO onePlayer){
		datas.add(onePlayer);
	}
	public void setTeam(String team){
		this.team=team;
	}
	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public ArrayList<PlayerDataOfOneMatchPO> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<PlayerDataOfOneMatchPO> datas) {
		this.datas = datas;
	}
	public PlayerDataPO getTotalPlayerData() {
		return totalPlayerData;
	}
	public void setTotalPlayerData(PlayerDataPO totalPlayerData) {
		this.totalPlayerData = totalPlayerData;
	}
	public PlayerDataPO getAveragePlayerData() {
		return averagePlayerData;
	}
	public void setAveragePlayerData(PlayerDataPO averagePlayerData) {
		this.averagePlayerData = averagePlayerData;
	}
	public DataForFinalCalculationPO getDataOfOtherTeam() {
		return dataOfOtherTeam;
	}
	public void setDataOfOtherTeam(DataForFinalCalculationPO dataOfOtherTeam) {
		this.dataOfOtherTeam = dataOfOtherTeam;
	}
	public double getImprovedRateOfScore() {
		return improvedRateOfScore;
	}
	public void setImprovedRateOfScore(double improvedRateOfScore) {
		this.improvedRateOfScore = improvedRateOfScore;
	}
	public double getImprovedRateOfRebound() {
		return improvedRateOfRebound;
	}
	public void setImprovedRateOfRebound(double improvedRateOfRebound) {
		this.improvedRateOfRebound = improvedRateOfRebound;
	}
	public double getImprovedRateOfAssist() {
		return improvedRateOfAssist;
	}
	public void setImprovedRateOfAssist(double improvedRateOfAssist) {
		this.improvedRateOfAssist = improvedRateOfAssist;
	}
	public String getTeam() {
		return team;
	}
	
}
