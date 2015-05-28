package PO;

import java.util.ArrayList;
import java.util.Collections;

import BusinessLogic.SortHelper.PlayerSortHelper;
import Enum.PlayerData;
import Enum.Season;

public class SeasonInfoForTeam {
	Season season;
	String shortName;
	TeamDataPO totalTeamData = new TeamDataPO();
	TeamDataPO averageTeamData = new TeamDataPO() ;
	
	DataForFinalCalculationPO dataOfOtherTeams = new DataForFinalCalculationPO() ;
	
	int numberOfMatches;
	int numberOfWinning;
	double percentageOfWinning;
	
	int numberOfHostWinning;  //主场胜场
	int numberOfGuestWinning; //客场胜场
	
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
		if(oneMatch.getNameOfWinner().equals(shortName)){
			numberOfWinning++;
			if(oneMatch.getFirstTeam().equals(shortName))
				numberOfHostWinning++;
			else
				numberOfGuestWinning++;
		}
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
	
	public ArrayList<PlayerPO> getTeamLeaders(PlayerData playerData){
		Collections.sort(players, new PlayerSortHelper("total", playerData, season));
		return new ArrayList<PlayerPO>(players);
	}
	
	public int getWinningStreak(){
		int result = 0;
		int tmp = 0;
		for(MatchPO oneMatch : matches){
			if(oneMatch.getNameOfWinner().equals(this.shortName)){
				tmp++;
			}
			else{
				if(tmp > result)
					result = tmp ;
				tmp = 0;
				continue ;
			}
			if(tmp > result)
				result = tmp ;
		}
		return result;
	}
	
	public int getLosingStreak(){
		int result = 0;
		int tmp = 0;
		for(MatchPO oneMatch : matches){
			if(!oneMatch.getNameOfWinner().equals(this.shortName)){
				tmp++;
			}
			else{
				if(tmp > result)
					result = tmp ;
				tmp = 0;
				continue ;
			}
			if(tmp > result)
				result = tmp ;
		}
		return result;
	}

	public int getNumberOfWinningInRecent10Matches(){
		int result = 0;
		int count = 0;  //统计已经遍历了几场比赛
		for(int i=matches.size()-1;i >= 0 && count < 10;i--){
			MatchPO oneMatch = matches.get(i);
			if(oneMatch.getNameOfWinner().equals(this.shortName))
				result++;
			count++;
		}
		return result;
	}
	
	public int getNumberOfHostWinningInRecent10Matches(){
		int count = 0;
		int result = 0;
		for(int i=matches.size()-1;i >= 0&&count < 10;i--){
			MatchPO oneMatch = matches.get(i);
			if(oneMatch.getSecondTeam().equals(this.shortName))
				continue ;
			if(oneMatch.getNameOfWinner().equals(this.shortName))
				result++;
			count++;
		}
		return result ;
	}
	
	public int getNumberOfGuestWinningInRecent10Matches(){
		int count = 0;
		int result = 0;
		for(int i=matches.size()-1;i >= 0&&count < 10;i--){
			MatchPO oneMatch = matches.get(i);
			if(oneMatch.getFirstTeam().equals(this.shortName))
				continue ;
			if(oneMatch.getNameOfWinner().equals(this.shortName))
				result++;
			count++;
		}
		return result ;
	}
	
	public double getLosingPointsPerMatch(){  //场均失分
		double totalLosingPoints=dataOfOtherTeams.getScoreOfOtherTeam();
		return totalLosingPoints/matches.size();
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
	public int getNumberOfHostWinning() {
		return numberOfHostWinning;
	}
	public int getNumberOfGuestWinning() {
		return numberOfGuestWinning;
	}
	
	
}
