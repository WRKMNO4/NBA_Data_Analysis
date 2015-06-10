package MySqlTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import PO.PlayerListPO;
import PO.PlayerPO;

public class PlayerDataToPO {
	PlayerListPO players  ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?user=root&password=941104&useUnicode=true&characterEncoding=UTF8" ;
	java.sql.Connection con = null ;
	java.sql.PreparedStatement stmt = null ;
	String query = "select * from players where playerID =?" ;
	
	public PlayerDataToPO(){
		players = new PlayerListPO() ;
	}
	
	public void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			System.out.println("加载MySQL驱动");
			
			con = DriverManager.getConnection(url) ;
			System.out.println("链接数据库");
			
			stmt = con.prepareStatement(query) ;
		
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
		
		try {
			stmt.setInt(1,id) ;
			ResultSet rs = stmt.executeQuery() ;
			while(rs.next()){
				PlayerPO onePlayer = new PlayerPO() ;
				onePlayer.setName(rs.getString(2));
				onePlayer.setNumber(rs.getString(3));
				onePlayer.setPosition(rs.getString(4));
				onePlayer.setHeight(rs.getString(5));
				onePlayer.setWeight(rs.getString(6));
				onePlayer.setBirth(rs.getString(7));
				onePlayer.setAge(rs.getString(8));
				onePlayer.setExp(rs.getString(9));
				onePlayer.setSchool(rs.getString(10));
				onePlayer.setPortraitURL(rs.getString(11));
				onePlayer.setActionURL(rs.getString(12));
				players.addPlayer(onePlayer) ;
				id++ ;
				stmt.setString(1, String.valueOf(id));
				rs = stmt.executeQuery() ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		PlayerDataToPO pp = new PlayerDataToPO() ;
		pp.init();
		pp.read();
		System.out.println(PlayerListPO.allPlayers.size());
		
	}
	
}
