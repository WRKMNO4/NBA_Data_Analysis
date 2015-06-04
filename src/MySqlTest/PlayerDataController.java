package MySqlTest;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DataService.FileHelper.FileHelper;
import PO.PlayerListPO;
import PO.PlayerPO;

public class PlayerDataController {

	java.sql.Connection con = null ;
	String url = "jdbc:mysql://localhost:3306/NBA_DATA?"
            + "user=root&password=941104&useUnicode=true&characterEncoding=UTF8";
	java.sql.Statement stmt = null ;
	 String insert = "insert into players(lname,fname,number,position,height,weight,birth,age,exp,school) values";
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
	
	public static void main(String[] args){
		PlayerDataController pl = new PlayerDataController() ;
		pl.init();
		pl.read("E:\\two\\software engineering\\迭代一\\迭代一数据");
	}
   
	public void read(String fileName){
		fileName = fileName+"/players/info" ;
		File file=new File(fileName);
		if(file.isDirectory()){
			File[] allFiles=file.listFiles();
			for(int i=0;i<allFiles.length;i++){   
				ArrayList<String> tempString=FileHelper.readByLine(allFiles[i]);
				
				ArrayList<String> datas = new ArrayList<>() ;
				for(int j = 0;j<tempString.size();j++){
					if(j%2 ==0)
						continue ;
					datas.add(getDataOfOneLine(tempString.get(j))) ;
				}
				for(String str:datas){
					System.out.print(str+" ");
				}
				insert = insert + "("+datas.get(0)+Integer.parseInt(datas.get(1))+datas.get(2)+datas.get(3)+Integer.parseInt(datas.get(4))+datas.get(5)+Integer.parseInt(datas.get(6))+Integer.parseInt(datas.get(7))+datas.get(8)+")";
                try {
					int result = stmt.executeUpdate(insert) ;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}
	private String getDataOfOneLine(String oneLine){
		oneLine = oneLine.substring(1,oneLine.length()-1) ;
		System.out.println(oneLine+"-------");
		String[] strs = oneLine.split("│") ;
		return strs[1].trim() ;
	}
	

}
