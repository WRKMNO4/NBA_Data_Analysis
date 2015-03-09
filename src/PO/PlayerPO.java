package PO;

public class PlayerPO {
	String name;
	String position;  //位置
	
	int number;       //球衣号码
	String height;    //身高(英尺-英寸)
	int weight;       //体重(磅)
	String birth;     //生日(月/日/年)
	int age;
	int exp;         //球龄
	String school;    //毕业学校
	
	String portraitURL;    //头像的地址
	String actionURL;      //动作照片的地址
	
	PlayerDataPO playerData;
	PlayerDataOfOneMatchPO playerDataOfOneMatch ;
	TeamPO team ; //所属球队
	
	
}
