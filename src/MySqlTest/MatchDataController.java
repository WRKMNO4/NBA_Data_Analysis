package MySqlTest;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MatchDataController {
	
	java.sql.Connection con = null ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?"
            + "user=root&password=941104&useUnicode=true&characterEncoding=UTF8";
	java.sql.Statement stmt = null ;
	String string = "insert into matches(matchID,time,firstTeam,secondTeam,firstScore,secondScore)values" ;
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
	}
}
