package MySqlTest;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;

public class MatchDataController {
	
	java.sql.Connection con = null ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?"
            + "user=root&password=941104&useUnicode=true&characterEncoding=UTF8";
	java.sql.Statement stmt = null ;
	String string = "insert into matches(matchID,time,firstTeam,secondTeam,firstScore,secondScore)values" ;
//	String 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
				
			}
		}
	}
	
	private String getTheTime(String fileName){//根据比赛文件名返回比赛日期，YYYY-MM-DD
		String time = "" ;
		int month =Integer.parseInt(fileName.substring(6,8)) ;
		if(month>9){
			time += ("20"+fileName.substring(0,2)+"-");
		}else{
			time += ("20"+fileName.substring(0,2)+"-") ;
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
}
