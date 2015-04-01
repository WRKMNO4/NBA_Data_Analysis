package PO;

import java.util.ArrayList;

import Enum.Season;
import Enum.Zone;

public class TeamPO {
	String fullName;    //ȫ��
	String shortName;   //��д��
	String city;        //���ڳ���
	Zone zone;          //������������������
	String district;     //���������ϲ����в���̫ƽ������ȣ�
	String homeCourt;     //����
	int timeOfEstablishment;   //�������
	
	String teamLogoURL;     //���Logo��ַ
	
	TeamDataPO totalTeamData = new TeamDataPO();
	TeamDataPO averageTeamData = new TeamDataPO() ;
	
	DataForFinalCalculationPO dataOfOtherTeams = new DataForFinalCalculationPO() ;
	
	int numberOfMatches;
	int numberOfWinning;
	double percentageOfWinning ; 
	
	ArrayList<PlayerPO> players = new ArrayList<PlayerPO>() ;
	ArrayList<MatchPO> matches = new ArrayList<MatchPO>();  
	
	SeasonInfoForTeam seasonInfo12_13=new SeasonInfoForTeam();
	SeasonInfoForTeam seasonInfo13_14=new SeasonInfoForTeam();
	SeasonInfoForTeam seasonInfo14_15=new SeasonInfoForTeam();
	
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
		totalTeamData.calculateTeamTotalDataInOneSeason(matches, shortName);
		averageTeamData.calculateTeamAverageDataInOneSeason(totalTeamData, matches.size(),dataOfOtherTeams);
	}
	
	public SeasonInfoForTeam getSeasonInfo(Season season){
		switch(season){
		case season12_13:
			return seasonInfo12_13;
		case season13_14:
			return seasonInfo13_14;
		case season14_15:
			return seasonInfo14_15;
		}
		return null;
	}
	
	public void updateOtherTeamData(double score,int totalTime,TeamDataPO otherTeamData){
		dataOfOtherTeams.update(score) ;
		dataOfOtherTeams.update(totalTime, otherTeamData);
	}

	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getHomeCourt() {
		return homeCourt;
	}
	public void setHomeCourt(String homeCourt) {
		this.homeCourt = homeCourt;
	}
	public int getTimeOfEstablishment() {
		return timeOfEstablishment;
	}
	public void setTimeOfEstablishment(int timeOfEstablishment) {
		this.timeOfEstablishment = timeOfEstablishment;
	}
	public String getTeamLogoURL() {
		return teamLogoURL;
	}
	public void setTeamLogoURL(String teamLogoURL) {
		this.teamLogoURL = teamLogoURL;
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
	public int getNumberOfMatches() {
		return numberOfMatches;
	}
	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
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
