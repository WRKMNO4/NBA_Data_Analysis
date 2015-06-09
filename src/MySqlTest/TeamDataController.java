package MySqlTest;

import java.io.File;
import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DataService.FileHelper.FileHelper;
import Enum.Zone;
import PO.TeamPO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TeamDataController {
	
	java.sql.Connection con = null ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?"
            + "user=root&password=941104&useUnicode=true&characterEncoding=UTF8";
	java.sql.Statement stmt = null ;
    String string = "insert into teams(teamID,fullname,shortname,city,zone,district,homeCourt,timeOfEstablishment,teamLogoURL) values" ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamDataController tl = new TeamDataController() ;
		tl.init();
		tl.read("E:\\two\\software engineering\\迭代一\\迭代一数据");
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
		fileName = fileName+"/teams/teams" ;
		File file = new File(fileName) ;
		ArrayList<String> tempString = FileHelper.readByLine(file) ;
		System.out.println(tempString.size());
		for(int i = 1;i<tempString.size()-1 ;i++){
			ArrayList<String> data = FileHelper.analysisOfOneLine(tempString.get(i)) ;
			data.add("Data/teams/"+data.get(1)+".png") ;
			
			String insert = string+"("+(i-1)+",'"+data.get(0)+"','"+data.get(1)+"','"+data.get(2)+"','"+data.get(3)+"','"+data.get(4)+"','"+data.get(5)+"',"+Integer.parseInt(data.get(6))+",'"+data.get(7)+"')" ;
			System.out.println(insert);
			try {
				stmt.executeUpdate(insert) ;
				System.out.println("插入球队成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("插入球队失败");
				e.printStackTrace();
			}
		}
	
			
	}

}
