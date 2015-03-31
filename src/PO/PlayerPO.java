package PO;

import java.util.ArrayList;

import Enum.Season;

public class PlayerPO {
	String name = "Unknown";   //定义为Unknown是因为有些球员是在比赛中找到的，而球员数据中没有，所有需要使其有初始值
	String position = "Unknown";  //λ��
	
	String number = "Unknown";       //���º���(��String����Ϊ��Щ�˵ĺ���Ϊ"N/A")
	String height = "Unknown";    //���(Ӣ��-Ӣ��)
	String weight = "Unknown";       //����(��)
	String birth = "Unknown";     //����(��/��/��)
	String age = "Unknown";
	String exp = "Unknown";         //����
	String school = "Unknown";    //��ҵѧУ                          
	
	String portraitURL="Unknown";    //ͷ��ĵ�ַ
	String actionURL="Unknown";      //������Ƭ�ĵ�ַ
	
	ArrayList<PlayerDataOfOneMatchPO> datas=new ArrayList<PlayerDataOfOneMatchPO>();
	PlayerDataPO totalPlayerData = new PlayerDataPO();
	PlayerDataPO averagePlayerData = new PlayerDataPO() ;
	
	DataForFinalCalculationPO dataOfOtherTeam = new DataForFinalCalculationPO() ;
	String team="Unknown" ; //������ӣ�����nameȥfind TeamPO��
	
	SeasonInfoForPlayer seasonInfo12_13;
	SeasonInfoForPlayer seasonInfo13_14;
	SeasonInfoForPlayer seasonInfo14_15;
	
	
	public void calculateFinalData(){
		TeamPO team = TeamListPO.findTeamByShortName(this.team) ;
		if(team==null){
//			System.out.println(this.team+"  "+this.name);
			return;
		}
//		System.out.println(this.name+" "+this.team);
//		System.out.println(team.getFullName());
		totalPlayerData.calculatePlayerTotalDataInOneSeason(datas);
		averagePlayerData.calculatePlayerAverageDataInOneSeason(totalPlayerData,team.getTotalTeamData(),dataOfOtherTeam);
	}
	
	public void updateDataOfOtherData(int totalTime,TeamDataPO dataOfOtherTeam){
		this.dataOfOtherTeam.update(totalTime, dataOfOtherTeam) ;
	}
	public void addDataOfOneMatchOfOnePlayer(PlayerDataOfOneMatchPO onePlayer){
		datas.add(onePlayer);
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
	public String getName() {
		return name;
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
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	
	
}
