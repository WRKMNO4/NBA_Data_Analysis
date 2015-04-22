package PO;

import java.util.ArrayList;

import Enum.Season;
import Enum.Zone;

public class TeamPO {
	String fullName;    
	String shortName;   
	String city;
	Zone zone;          
	String district;    
	String homeCourt;     
	int timeOfEstablishment;
	
	String teamLogoURL;   
	
	SeasonInfoForTeam seasonInfo12_13=new SeasonInfoForTeam(Season.season12_13);
	SeasonInfoForTeam seasonInfo13_14=new SeasonInfoForTeam(Season.season13_14);
	SeasonInfoForTeam seasonInfo14_15=new SeasonInfoForTeam(Season.season14_15);
	
	public void addPlayer(PlayerPO onePlayer,Season season){
		SeasonInfoForTeam seasonInfo=getSeasonInfo(season);
		seasonInfo.addPlayer(onePlayer);
	}
	
	public ArrayList<MatchPO> getMatches(Season season){
		SeasonInfoForTeam seasonInfo = getSeasonInfo(season) ;
		return seasonInfo.getMatches() ;
	}
	
	public void addMatch(MatchPO oneMatch,Season season){
		SeasonInfoForTeam seasonInfo=getSeasonInfo(season);
		seasonInfo.addMatch(oneMatch);
	}
	
	boolean ifContainThePlayer(PlayerPO onePlayer,Season season){
		SeasonInfoForTeam seasonInfo=getSeasonInfo(season);
		return seasonInfo.ifContainThePlayer(onePlayer);
	}
	
	public void calculateTeamDataInOneSeason(){
		seasonInfo12_13.calculateTeamDataInOneSeason();
		seasonInfo13_14.calculateTeamDataInOneSeason();
		seasonInfo14_15.calculateTeamDataInOneSeason();
	}
	
	public void updateOtherTeamData(double score,int totalTime,TeamDataPO otherTeamData,Season season){
		SeasonInfoForTeam seasonInfo=getSeasonInfo(season);
		seasonInfo.updateOtherTeamData(score, totalTime, otherTeamData);
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
	
	public TeamDataPO getTotalTeamData(Season season){
		SeasonInfoForTeam seasonInfo=getSeasonInfo(season);
		return seasonInfo.getTotalTeamData();
	}
	public TeamDataPO getAverageTeamData(Season season){
		SeasonInfoForTeam seasonInfo=getSeasonInfo(season);
		return seasonInfo.getAverageTeamData();
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
		seasonInfo12_13.setShortName(shortName);
		seasonInfo13_14.setShortName(shortName);
		seasonInfo14_15.setShortName(shortName);
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
}
