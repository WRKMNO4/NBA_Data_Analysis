package MySqlTest;

import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.python.antlr.base.stmt;

import DataService.FileHelper.FileHelper;

public class MatchDataController {
	
	java.sql.Connection con = null ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?"
            + "user=root&password=941104&useUnicode=true&characterEncoding=UTF8";
	java.sql.PreparedStatement stmtMatch = null ;
	PreparedStatement stmtScore = null ;
	PreparedStatement stmtPlayerData = null ;
	String stringOfMatches = "insert into matches(matchID,time,firstTeam,secondTeam,firstScore,secondScore)values(?,?,?,?,?,?)" ;
	String stringOfScores = "insert into scoresOfOneMatch(matchID,firstScore,secondScore) values(?,?,?)" ;
	String stringOfPlayerDataOfOneMatch = "insert into playerDataOfOneMatch(matchID,team,name,position,ifStarting,persentTime,numberOfShooting,numberOfShotAttempt,numberOf3_point,numberOf3_pointAttempt"
			+ ",numberOfFreeThrow,numberOfFreeThrowAttempt,numberOfAttackRebound,numberOfDefenseRebound,numberOfRebound,numberOfAssist,numberOfSteal,numberOfBlock,numberOfFault,numberOfFoul,score)values"
			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatchDataController ml = new MatchDataController() ;
		ml.init();
		ml.read("E:\\two\\software engineering\\迭代一\\迭代一数据");
	}

	public void init(){
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver") ;
			System.out.println("加载MySQL驱动");
			
	    	con = DriverManager.getConnection(url);
	    	System.out.println("链接数据库");
	    	con.setAutoCommit(false) ;
	    	
	    	stmtMatch = con.prepareStatement(stringOfMatches,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY) ;
	    	stmtScore = con.prepareStatement(stringOfScores,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY) ;
	    	stmtPlayerData = con.prepareStatement(stringOfPlayerDataOfOneMatch,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY) ;
	    }
	    catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void read(String fileName){
		fileName = fileName+"/matches" ;
		File file = new File(fileName) ;
		if(file.isDirectory()){
			File[] allFiles = file.listFiles() ;
			Arrays.sort(allFiles,new CompareByTime());
			
			
			int count = 1000 ;
		
			try {
				for(int i =0;i<allFiles.length;i++){
					ArrayList<String> tempString = FileHelper.readByLine(allFiles[i]) ;
					String firstLine = tempString.get(0) ;
					String[] strs = firstLine.split(";") ;
					String[] scores = strs[2].split("-") ;
					stmtMatch.setInt(1, i) ;
					stmtMatch.setString(2, getTheTime(allFiles[i].getName()));
					stmtMatch.setString(3,strs[1].substring(0,3));
					stmtMatch.setString(4, strs[1].substring(4));
					stmtMatch.setInt(5, Integer.parseInt(scores[0]));
					stmtMatch.setInt(6, Integer.parseInt(scores[1]));
					stmtMatch.addBatch();
					count-- ;
					
					String secondLine = tempString.get(1) ;
					scores =secondLine.split(";") ;
					for(String str :scores){
						String[] s = str.split("-") ;
						stmtScore.setInt(1, i);
						stmtScore.setInt(2, Integer.parseInt(s[0]));
						stmtScore.setInt(3,Integer.parseInt(s[1]));
						stmtScore.addBatch();
						count-- ;
					}
					
					String team = tempString.get(2) ;
					int ifStarting = 5 ;
					for(int j=3;j<tempString.size();j++){
						String[] onePlayer = tempString.get(j).split(";") ;
						if(onePlayer.length<2){
							team = tempString.get(j) ;
							ifStarting = 5 ;
							continue ;
						}
						stmtPlayerData.setInt(1, i);
						stmtPlayerData.setString(2, team);
						stmtPlayerData.setString(3, checkString(onePlayer[0]));
						stmtPlayerData.setString(4, onePlayer[1]);
						stmtPlayerData.setInt(5, (ifStarting>0)?1:0);
						stmtPlayerData.setString(6, onePlayer[2]);
						stmtPlayerData.setInt(7,checkInt(onePlayer[3]));
						stmtPlayerData.setInt(8, checkInt(onePlayer[4]));
						stmtPlayerData.setInt(9, checkInt(onePlayer[5]));
						stmtPlayerData.setInt(10, checkInt(onePlayer[6]));
						stmtPlayerData.setInt(11, checkInt(onePlayer[7]));
						stmtPlayerData.setInt(12, checkInt(onePlayer[8]));
						stmtPlayerData.setInt(13, checkInt(onePlayer[9]));
						stmtPlayerData.setInt(14, checkInt(onePlayer[10]));
						stmtPlayerData.setInt(15, checkInt(onePlayer[11]));
						stmtPlayerData.setInt(16, checkInt(onePlayer[12]));
						stmtPlayerData.setInt(17, checkInt(onePlayer[13]));
						stmtPlayerData.setInt(18, checkInt(onePlayer[14]));
						stmtPlayerData.setInt(19, checkInt(onePlayer[15]));
						stmtPlayerData.setInt(20, checkInt(onePlayer[16]));
						try{
							stmtPlayerData.setInt(21, Integer.parseInt(onePlayer[17]));
						}catch(NumberFormatException e){
							int goal = Integer.parseInt(onePlayer[3])*2+Integer.parseInt(onePlayer[5])+Integer.parseInt(onePlayer[7]) ;
							stmtPlayerData.setInt(21, goal);
						}
						stmtPlayerData.addBatch();
						count-- ;
						
						
					}
					if(count<0){
						stmtMatch.executeBatch() ;
						stmtScore.executeBatch() ;
						stmtPlayerData.executeBatch() ;
						con.commit();
					}
				}
				stmtMatch.executeBatch() ;
				stmtScore.executeBatch() ;
				stmtPlayerData.executeBatch() ;
				con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private String getTheTime(String fileName){//根据比赛文件名返回比赛日期，YYYY-MM-DD
		String time = "" ;
		int month =Integer.parseInt(fileName.substring(6,8)) ;
		if(month>9){
			time += ("20"+fileName.substring(0,2)+"-");
		}else{
			time += ("20"+fileName.substring(3,5)+"-") ;
		}
		time += fileName.substring(6,11) ;
		return time ;
	}
	class CompareByTime implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			File file1 = (File)o1 ;
			File file2 = (File)o2 ;
			String time1 = getTheTime(file1.getName()) ;
			String time2 =  getTheTime(file2.getName()) ;
			return time1.compareTo(time2) ;
		}
		
	}

	private String checkString(String string){//检查插入的字符串中是否有单引号，从而添加转义符
		if(string.contains("'")){
			int i = string.indexOf("'") ;
			string = string.substring(0,i)+"\\"+string.substring(i);
		}
		return string ;
	}
	private int checkInt(String number){
		try{
			return Integer.parseInt(number) ;
		}catch(Exception e){
			return 0 ;
		}
	}
}
