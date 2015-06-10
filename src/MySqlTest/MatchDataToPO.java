package MySqlTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kenai.jaffl.annotations.In;

import sun.reflect.generics.scope.ClassScope;
import Enum.Season;
import PO.MatchListPO;
import PO.MatchPO;

public class MatchDataToPO {
	MatchListPO matches ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?user=root&password=941104&useUnicode=true&characterEncoding=UTF8" ;
	java.sql.Connection con = null ;
	java.sql.PreparedStatement stmtMatch = null ;
	java.sql.PreparedStatement stmtScore = null ;
	java.sql.PreparedStatement stmtPlayerData = null ;
	String queryMatch = "select * from matches where playerID =?" ;
	String queryScore = "select * from scoresofonematch where " ;
	String queryPlayerData = "select * from playerdataofonematch where ";
	 
	public MatchDataToPO(){
		matches = new MatchListPO() ;
	}
	 
	public void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver" ) ;
			System.out.println("加载MySQL驱动");
			
			con = DriverManager.getConnection(url) ;
			System.out.println("链接数据库");
			
			stmtMatch = con.prepareStatement(queryMatch) ;
			stmtScore = con.prepareStatement(queryScore) ;
			stmtPlayerData = con.prepareStatement(queryPlayerData) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("链接数据库失败");
			e.printStackTrace();
		}
		
	}
	
	public void read(){
		int id = 0 ;
		
		try {
			stmtMatch.setInt(1, id);
			ResultSet rsM = stmtMatch.executeQuery() ;
			while(rsM.next()){
				MatchPO oneMatch = new MatchPO() ;
				oneMatch.setName(getName(rsM.getString("time"), rsM.getString("firstTeam"), rsM.getString("secondTeam")));
				oneMatch.setSeason(getSeason(rsM.getString("time")));
				oneMatch.setDate(rsM.getString("time").substring(5));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getName(String date,String firstTeam,String secondTeam){
		String name = getSeason(date).toString() ;
		name = name+"_"+date.substring(5)+"_"+firstTeam+"-"+secondTeam ;
		return name ;
		
	}
	
	private Season getSeason(String date){
		Season season = null;
		int year= Integer.parseInt(date.substring(0, 4)) ;
		int month = Integer.parseInt(date.substring(5,7)) ;
		switch(year){
		case 2012:
			if(month>9)
		    	season =  Season.season12_13 ;
			break ;
		case 2013:
			if(month>9)
		    	season = Season.season13_14 ;
			else
				season = Season.season12_13 ;
			break ;
		case 2014:
			if(month>9)
				season = Season.season14_15 ;
			else
				season = Season.season13_14 ;
			break ;
		case 2015:
			if(month>9) 
				;
			else
				season = Season.season14_15 ;
			break ;
		}
		return season ;
		
	}

	public static void main(String[] args){
		Season s = Season.season12_13 ;
		String str = s.toString() ;
		System.out.println(str);
	}
}
