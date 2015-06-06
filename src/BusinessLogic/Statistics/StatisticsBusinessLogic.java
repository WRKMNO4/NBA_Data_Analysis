package BusinessLogic.Statistics;

import Enum.PlayerData;
import Enum.Season;
import PO.PlayerPO;

public interface StatisticsBusinessLogic {
	public boolean ifStableThenSelf(PlayerPO player,PlayerData dataType, Season season);
	public boolean ifBetterThenSelf(PlayerPO player,PlayerData dataType, Season season);
	
	public boolean ifStableThenAnother(PlayerPO player, PlayerPO anotherPlayer, PlayerData dataType, Season season);
	public boolean ifBetterThenAnother(PlayerPO player, PlayerPO anotherPlayer, PlayerData dataType, Season season);
}
