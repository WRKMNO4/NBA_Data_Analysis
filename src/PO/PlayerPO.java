package PO;

import java.util.ArrayList;

public class PlayerPO {
	String name;
	String position;  //位置
	
	String number;       //球衣号码(用String是因为有些人的号码为"N/A")
	String height;    //身高(英尺-英寸)
	String weight;       //体重(磅)
	String birth;     //生日(月/日/年)
	String age;
	String exp;         //球龄
	String school;    //毕业学校                          
	
	String portraitURL;    //头像的地址
	String actionURL;      //动作照片的地址
	
	ArrayList<PlayerDataOfOneMatchPO> datas;
	PlayerDataPO playerData;
	
	String team ; //所属球队（可用name去find TeamPO）
	
	
	public void addDataOfOneMatchOfOnePlayer(PlayerDataOfOneMatchPO onePlayer){
		datas.add(onePlayer);
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

	public PlayerDataPO getPlayerData() {
		return playerData;
	}

	public void setPlayerData(PlayerDataPO playerData) {
		this.playerData = playerData;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	
	
}
