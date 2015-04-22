package PO;

import java.util.ArrayList;

import Enum.Season;

public class SeasonInfoForTeam {
	Season season;
	String shortName;
	TeamDataPO totalTeamData = new TeamDataPO();
	TeamDataPO averageTeamData = new TeamDataPO() ;
	
	DataForFinalCalculationPO dataOfOtherTeams = new DataForFinalCalculationPO() ;
	
	int numberOfMatches;
	int numberOfWinning;
	double percentageOfWinning ; 
	
	ArrayList<PlayerPO> players = new ArrayList<PlayerPO>() ;
	ArrayList<MatchPO> matches = new ArrayList<MatchPO>(); 

	public SeasonInfoForTeam(Season season){
		this.season=season;
	}
	public void addPlayer(PlayerPO onePlayer){
		if(ifContainThePlayer(onePlayer)){
			;
		}else{
			players.add(onePlayer) ;
		}
	}
	public void addMatch(MatchPO oneMatch){
		matches.add(oneMatch) ;
		numberOfMatches++;
		if(oneMatch.getNameOfWinner().equals(shortName))
			numberOfWinning++;
	}
	
	boolean ifContainThePlayer(PlayerPO onePlayer){
		for(PlayerPO thePlayer:players){
			if(thePlayer.getName().equals(onePlayer.getName())){
				return true ;
			}
		}
		return false ;
	}
	
	public void calculateTeamDataInOneSeason(){
		percentageOfWinning = (double)numberOfWinning / matches.size() ;
		totalTeamData=new TeamDataPO();
		averageTeamData=new TeamDataPO();
		totalTeamData.calculateTeamTotalDataInOneSeason(matches, shortName);
		averageTeamData.calculateTeamAverageDataInOneSeason(totalTeamData, matches.size(),dataOfOtherTeams);
	}
	
	public void updateOtherTeamData(double score,int totalTime,TeamDataPO otherTeamData){
		dataOfOtherTeams.update(score) ;
		dataOfOtherTeams.update(totalTime, otherTeamData);
	}
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public TeamDataPO getTotalTeamData() {
		return totalTeamData;
	}
	public void setTotalTeamData(TeamDataPO totalTeamData) {
		this.totalTeamData = totalTeamData;
	}
	public TeamDataPO getAverageTeamData() {
		return averageTeamData;
	}
	public void setAverageTeamData(TeamDataPO averageTeamData) {
		this.averageTeamData = averageTeamData;
	}
	public DataForFinalCalculationPO getDataOfOtherTeams() {
		return dataOfOtherTeams;
	}
	public void setDataOfOtherTeams(DataForFinalCalculationPO dataOfOtherTeams) {
		this.dataOfOtherTeams = dataOfOtherTeams;
	}
	public int getNumberOfMatches() {
		return numberOfMatches;
	}
	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}
	public int getNumberOfWinning() {
		return numberOfWinning;
	}
	public void setNumberOfWinning(int numberOfWinning) {
		this.numberOfWinning = numberOfWinning;
	}
	public double getPercentageOfWinning() {
		return percentageOfWinning;
	}
	public void setPercentageOfWinning(double percentageOfWinning) {
		this.percentageOfWinning = percentageOfWinning;
	}
	public ArrayList<PlayerPO> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<PlayerPO> players) {
		this.players = players;
	}
	public ArrayList<MatchPO> getMatches() {
		return matches;
	}
	public void setMatches(ArrayList<MatchPO> matches) {
		this.matches = matches;
	}
	
	
}
