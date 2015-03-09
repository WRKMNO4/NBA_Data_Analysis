package DataService.PlayerDataService;

import PO.PlayerPO;

public interface PlayerDataService {
	public void addPlayer(PlayerPO onePlayer);
	public PlayerPO findPlayerByName(String name);
	
	
}
