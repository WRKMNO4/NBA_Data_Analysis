package MySqlTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import Enum.Zone;
import PO.TeamDataPO;
import PO.TeamListPO;
import PO.TeamPO;

public class TeamDataToPO {

	String url = "jdbc:mysql://localhost:3306/NBA_DATA?user=root&password=941104&useUnicode=true&characterEncoding=UTF8" ;
	java.sql.Connection con = null ;
	java.sql.Statement stmt = null ;
	TeamListPO teams  ;
	
	public TeamDataToPO(){
		teams = new TeamListPO() ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamDataToPO tp = new TeamDataToPO() ;
		tp.init();
		tp.read();
		System.out.println(TeamListPO.allTeams.size());
	}

	public void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			System.out.println("加载MySQL驱动");
			
			con = DriverManager.getConnection(url) ;
			System.out.println("链接数据库");
			
			stmt = con.createStatement() ;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("链接数据库失败");
			e.printStackTrace();
		}
		
	}
	
	public void read(){
		int id = 0 ;
		String query = "select * from teams where teamID =" ;
		try {
			ResultSet rs = stmt.executeQuery(query+id) ;
			
			while(rs.next()){
				System.out.println(rs.getString(2)+"  "+rs.getString(8));
				TeamPO oneTeam = new TeamPO() ;
				oneTeam.setFullName(rs.getString(2));
				oneTeam.setShortName(rs.getString(3));
				oneTeam.setCity(rs.getString(4));
				oneTeam.setZone(getZone(rs.getString(5)));
				oneTeam.setDistrict(rs.getString(6));
				oneTeam.setHomeCourt(rs.getString(7));
				oneTeam.setTimeOfEstablishment(getETime(rs.getString(8)));
				oneTeam.setTeamLogoURL(rs.getString(9));
				teams.addTeam(oneTeam) ;
				id++ ;
				rs = stmt.executeQuery(query+id) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Zone getZone(String zone){
		if(zone.equals("E"))
			return Zone.E ;
		else
			return Zone.W ;
	}
	private int getETime(String time){
		return Integer.parseInt(time.substring(0,4)) ;
	}
}
