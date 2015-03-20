package DataService.PlayerDataService;

import java.util.ArrayList;

import Enum.ResultMessage;
import PO.PlayerPO;

public interface PlayerDataService {
	public ResultMessage addPlayer(PlayerPO onePlayer);
	public PlayerPO findPlayerByName(String name);
	public ArrayList<PlayerPO> getAllPlayers() ;
	public void calculateFinalData() ;
	
}
