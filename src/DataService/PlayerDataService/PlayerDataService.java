package DataService.PlayerDataService;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.ResultMessage;
import Enum.Season;
import PO.PlayerPO;

public interface PlayerDataService {
	public ResultMessage addPlayer(PlayerPO onePlayer);
	public ArrayList<PlayerPO> findPlayerByName(String name);
	public ArrayList<PlayerPO> getAllPlayers() ;
	public void calculateFinalData() ;
	public ArrayList<PlayerPO> getDailyStandingPlayers(Season season, String date, PlayerData dataType);
	
}
