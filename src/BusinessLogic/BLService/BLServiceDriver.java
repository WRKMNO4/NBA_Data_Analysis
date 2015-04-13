package BusinessLogic.BLService;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import PO.MatchPO;
import PO.PlayerPO;
import PO.StandingDataPO;
import PO.TeamPO;

public class BLServiceDriver {
	
	public void drive(){
		BLService bl=new BLServiceController();
		bl.init();
		
		}
	
	public static void main(String[] args){
		
		BLServiceDriver driver= new BLServiceDriver();
		driver.drive();
	}
	
}
