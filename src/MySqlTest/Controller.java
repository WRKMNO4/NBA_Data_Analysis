package MySqlTest;

import PO.MatchListPO;
import PO.PlayerListPO;
import PO.SeasonListPO;
import PO.TeamListPO;

public class Controller {
	
	PlayerDataToPO ptp  ;
	TeamDataToPO ttp  ;
	MatchDataToPO mtp  ;
	SeasonListPO seasons ;
       
	public static void main(String[] args){
			long begin = System.currentTimeMillis() ;
			
			Controller c = new Controller() ;
			c.initDataToPO();
			
			System.out.println(TeamListPO.allTeams.size());
			System.out.println(PlayerListPO.allPlayers.size());
//			System.out.println(MatchListPO.allMatchList.size());
//			System.out.println(MatchListPO.allMatchList.get(0).getName());
			
			long end = System.currentTimeMillis() ;
			System.out.println("运行时间："+(end-begin));
	}

	/**
	 * 将数据从数据库转为PO
	 */
	public void initDataToPO(){
		seasons = new SeasonListPO() ;
		ptp = new PlayerDataToPO() ;
		ptp.init();
		ptp.read();
		
		ttp = new TeamDataToPO() ;
		ttp.init();
		ttp.read();
		
		mtp = new MatchDataToPO() ;
		mtp.init();
		mtp.read();
	}

	
	/**
	 *  将源数据插入数据库
	 * @param fileAddress 数据源地址 子目录下含players,teams,matches数据
	 */
	public void insertIntoDatabase(String fileAddress){
		
		long begin = System.currentTimeMillis() ;
		
		MatchDataController mc = new MatchDataController() ;
		mc.init();
		mc.read(fileAddress);
		
		PlayerDataController pc = new PlayerDataController() ;
		pc.init();
		pc.read(fileAddress);
		
		TeamDataController tc = new TeamDataController() ;
		tc.init();
		tc.read(fileAddress);
		
		long end = System.currentTimeMillis() ;
		System.out.println("运行时间："+(end-begin));
	}
}
