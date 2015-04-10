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
//		ArrayList<PlayerPO> players = bl.getSeasonStandingPlayer(Season.season13_14, PlayerData.score) ;
//		for(int i = 0 ;i<players.size() ; i++){
//			System.out.println(players.get(i).getSeasonInfo(Season.season13_14).getAveragePlayerData().getScore()+" "+players.get(i).getName()) ; 
//		}
		ArrayList<PlayerPO> players = bl.getMostImprovePlayer(Season.season13_14, PlayerData.improveRateOfRebound );
		for(int i = 0 ;i < players.size(); i++){
		System.out.println(players.get(i).getSeasonInfo(Season.season13_14).getImprovedRateOfScore());
		}
	}
	public static void main(String[] args){
		BLServiceDriver driver= new BLServiceDriver();
		driver.drive();
	}
	
}
