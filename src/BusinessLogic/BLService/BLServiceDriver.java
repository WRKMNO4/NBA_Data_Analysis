package BusinessLogic.BLService;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import PO.MatchPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.StandingDataPO;
import PO.TeamPO;

public class BLServiceDriver {
	
	public void drive(){
		BLService bl=new BLServiceController("Data");
		bl.init();
		ArrayList<MatchPO> m = bl.getAllMatches(Season.season13_14);
//		System.out.println(m.get(10).getName());
		}
	
	public static void main(String[] args){
		
		BLServiceDriver driver= new BLServiceDriver();
		driver.drive();
	}
	
}
