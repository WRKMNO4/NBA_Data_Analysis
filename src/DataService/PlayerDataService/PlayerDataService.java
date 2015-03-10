package DataService.PlayerDataService;

import Enum.ResultMessage;
import PO.PlayerPO;

public interface PlayerDataService {
	public ResultMessage addPlayer(PlayerPO onePlayer);
	public PlayerPO findPlayerByName(String name);
	
	
}
