package DataService.PlayerDataService;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.ResultMessage;
import Enum.Season;
import PO.PlayerPO;
import PO.StandingDataPO;

public interface PlayerDataService {
	public ResultMessage addPlayer(PlayerPO onePlayer);
	public ArrayList<PlayerPO> findPlayerByName(String name);
	public ArrayList<PlayerPO> getAllPlayers() ;
	public void calculateFinalData() ;
	public ArrayList<StandingDataPO> getDatasOfDailyStandingPlayers(Season season, String date, PlayerData dataType);
	
}
