package MySqlTest;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import DataService.FileHelper.FileHelper;

public class MatchDataController {
	
	java.sql.Connection con = null ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?"
            + "user=root&password=941104&useUnicode=true&characterEncoding=UTF8";
	java.sql.Statement stmt = null ;
	String stringOfMatches = "insert into matches(matchID,time,firstTeam,secondTeam,firstScore,secondScore)values(?,?,?,?,?,?)" ;
	String stringOfScores = "insert into scoresOfOneMatch(matchID,scoreID,firstScore,secondScore) values" ;
	String stringOfPlayerDataOfOneMatch = "insert into playerDataOfOneMatch(matchID,team,name,position,ifStarting,persentTime,numberOfShooting,numberOfShotAttempt,numberOf3_point,numberOf3_pointAttempt"
			+ ",numberOfFreeThrow,numberOfFreeThrowAttempt,numberOfAttackRebound,numberOfDefenseRebound,numberOfRebound,numberOfAssist,numberOfSteal,numberOfBlock,numberOfFault,numberOfFoul,score)values" ;
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
	    	
	    	stmt = con.createStatement() ;
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
			
			for(int i = 0;i<allFiles.length;i++){
				ArrayList<String> tempString = FileHelper.readByLine(allFiles[i]) ;
				
				int id = i ;
				
				//match
				String date = getTheTime(allFiles[i].getName()) ;
				String[] strs = tempString.get(0).split(";") ;
				String[] teams = strs[1].split("-") ;
				String[] scoresOfString = strs[2].split("-") ;
				int[] scores = {Integer.parseInt(scoresOfString[0]),Integer.parseInt(scoresOfString[1])} ;
				String insertOfMatches = stringOfMatches + "("+id+",'"+date+"','"+teams[0]+"','"+teams[1]+"',"+scores[0]+","+scores[1]+")" ;
				System.out.println(insertOfMatches);
				try {
					stmt.executeUpdate(insertOfMatches) ;
					System.out.println("插入比赛");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("比赛插入失败");
					e.printStackTrace();
				}
				
				//scroes
				strs = tempString.get(1).split(";") ;
				for(int j = 0;j<strs.length;j++){
					String s = strs[j] ;
					scoresOfString = s.split("-") ;
				    int[] scores2 = {Integer.parseInt(scoresOfString[0]),Integer.parseInt(scoresOfString[1])} ;
				    String insertOfScores = stringOfScores+"("+id+","+j+","+scores2[0]+","+scores2[1]+")" ;
				    System.out.println(insertOfScores);
				    try {
						stmt.executeUpdate(insertOfScores) ;
						System.out.println("插入分数");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("插入分数失败");
						e.printStackTrace();
					}
				}
				
				
				//playerData
				String team = teams[0] ;
				int ifStarting = 5 ;
				for(int j1 = 3;j1<tempString.size();j1++){
					String[] onePlayer = tempString.get(j1).split(";") ;
					if(onePlayer.length<2){
						team = teams[1] ;
						ifStarting = 5 ;
						continue ;
					}
					ArrayList<String> dataOfStr = new ArrayList<>() ;
					ArrayList<Integer> dataOfInt = new ArrayList<>() ;
					
					dataOfInt.add(id) ;
					if(ifStarting>0)
				    	dataOfInt.add(1) ;
					else
						dataOfInt.add(0) ;
					for(int k = 3;k<onePlayer.length;k++){
						try{
							dataOfInt.add(Integer.parseInt(onePlayer[k])) ;
						}catch(Exception e){
							if(k==onePlayer.length)
								dataOfInt.add(2*dataOfInt.get(2)+dataOfInt.get(4)+dataOfInt.get(6)) ;
							dataOfInt.add(0) ;
						}
					}
					
					dataOfStr.add(team) ;
					dataOfStr.add(checkString(onePlayer[0])) ;
					dataOfStr.add(onePlayer[1]) ;
					dataOfStr.add(onePlayer[2]) ;
					
					String insertPlayerData = stringOfPlayerDataOfOneMatch +"("+dataOfInt.get(0)+",'"+dataOfStr.get(0)+"','"+dataOfStr.get(1)+"','"+dataOfStr.get(2)+"',"+dataOfInt.get(1)+",'"+dataOfStr.get(3)+"',"+
					dataOfInt.get(2)+","+dataOfInt.get(3)+","+dataOfInt.get(4)+","+dataOfInt.get(5)+","+dataOfInt.get(6)+","+dataOfInt.get(7)+","+dataOfInt.get(8)+","+dataOfInt.get(9)+","+dataOfInt.get(10)+","+dataOfInt.get(11)+","+
					dataOfInt.get(12)+","+dataOfInt.get(13)+","+dataOfInt.get(14)+","+dataOfInt.get(15)+","+dataOfInt.get(16)+")" ;
					System.out.println(insertPlayerData);
					try {
						stmt.executeUpdate(insertPlayerData) ;
						System.out.println("插入球员信息");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("插入球员信息失败");
					}
				}
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
}
