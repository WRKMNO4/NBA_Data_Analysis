package PO;

import java.util.ArrayList;

import Enum.Season;

public class PlayerPO {
	String name = "Unknown";   
	String position = "Unknown"; 
	
	String number = "Unknown";       
	String height = "Unknown";    
	String weight = "Unknown";       
	String birth = "Unknown";     
	String age = "Unknown";
	String exp = "Unknown";         
	String school = "Unknown";                          
	
	String portraitURL="Unknown";    
	String actionURL="Unknown";     
	
	SeasonInfoForPlayer seasonInfo12_13=new SeasonInfoForPlayer(Season.season12_13);
	SeasonInfoForPlayer seasonInfo13_14=new SeasonInfoForPlayer(Season.season13_14);
	SeasonInfoForPlayer seasonInfo14_15=new SeasonInfoForPlayer(Season.season14_15);
	
	
	public void calculateFinalData(){
		seasonInfo12_13.calculateFinalData();
		seasonInfo13_14.calculateFinalData();
		seasonInfo14_15.calculateFinalData();
	}
	public void addMatch(Season season,MatchPO match){
		SeasonInfoForPlayer seasonInfo = getSeasonInfo(season) ;
		seasonInfo.addMatch(match);
	}
	public void updateDataOfOtherData(int totalTime,TeamDataPO dataOfOtherTeam,Season season){
		SeasonInfoForPlayer seasonInfo=getSeasonInfo(season);
		seasonInfo.updateDataOfOtherData(totalTime, dataOfOtherTeam);
	}
	public void addDataOfOneMatchOfOnePlayer(PlayerDataOfOneMatchPO onePlayer,Season season){
		SeasonInfoForPlayer seasonInfo=getSeasonInfo(season);
		seasonInfo.addDataOfOneMatchOfOnePlayer(onePlayer);
	}
	public SeasonInfoForPlayer getSeasonInfo(Season season){
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
	public void setTeam(String team,Season season){
		SeasonInfoForPlayer seasonInfo=getSeasonInfo(season);
		seasonInfo.setTeam(team);
	}
	public String getTeam(Season season){
		SeasonInfoForPlayer seasonInfo=getSeasonInfo(season);
		return seasonInfo.getTeam();
	}
	public String getName() {
		return name;
	}
	public ArrayList<MatchPO> getMatches(Season season){
		SeasonInfoForPlayer seasonInfo = getSeasonInfo(season) ;
		return seasonInfo.getMatches() ;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String  getWeight() {
		return weight;
	}

	public void setWeight(String  weight) {
		this.weight = weight;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String  getAge() {
		return age;
	}

	public void setAge(String  age) {
		this.age = age;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPortraitURL() {
		return portraitURL;
	}

	public void setPortraitURL(String portraitURL) {
		this.portraitURL = portraitURL;
	}

	public String getActionURL() {
		return actionURL;
	}

	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}
	
}
