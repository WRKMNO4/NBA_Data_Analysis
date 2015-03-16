package PO;

import java.util.ArrayList;

import Enum.Zone;

public class TeamPO {
	String fullName;    //全名
	String shortName;   //缩写名
	String city;        //所在城市
	Zone zone;          //赛区（东部或西部）
	String district;     //分区（西南部、中部、太平洋地区等）
	String homeCourt;     //主场
	int timeOfEstablishment;   //建立年份
	
	String teamLogoURL;     //球队Logo地址
	
	TeamDataPO teamData;
	
	int numberOfMatches=0;
	double percentageOfWinning ; //胜率 
	
	ArrayList<PlayerPO> players = new ArrayList<PlayerPO>() ;//球员集合
	ArrayList<MatchPO> matches = new ArrayList<MatchPO>();  //比赛集合
	
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
	}
	
	boolean ifContainThePlayer(PlayerPO onePlayer){
		for(PlayerPO thePlayer:players){
			if(thePlayer.getName().equals(onePlayer.getName())){
				return true ;
			}
		}
		return false ;
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
	public TeamDataPO getTeamData() {
		return teamData;
	}
	public void setTeamData(TeamDataPO teamData) {
		this.teamData = teamData;
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
