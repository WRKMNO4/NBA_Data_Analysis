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
			c.init();
			
			System.out.println(TeamListPO.allTeams.size());
			System.out.println(PlayerListPO.allPlayers.size());
			System.out.println(MatchListPO.allMatchList.size());
			System.out.println(MatchListPO.allMatchList.get(0).getName());
			
			long end = System.currentTimeMillis() ;
			System.out.println("运行时间："+(end-begin));
	}

	public void init(){
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

}
