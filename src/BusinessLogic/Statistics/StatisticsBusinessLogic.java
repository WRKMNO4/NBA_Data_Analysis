package BusinessLogic.Statistics;

import Enum.PlayerData;
import Enum.Season;
import PO.PlayerPO;

public interface StatisticsBusinessLogic {
	public boolean ifStableThanSelf(PlayerPO player,PlayerData dataType, Season season);
	public boolean ifBetterThanSelf(PlayerPO player,PlayerData dataType, Season season);
	
	public boolean ifStableThanAnother(PlayerPO player, PlayerPO anotherPlayer, 
			PlayerData dataType, Season season);
	public boolean ifBetterThanAnother(PlayerPO player, PlayerPO anotherPlayer, 
			PlayerData dataType, Season season);
	
	public int[] getRanksOfTeamByTeamFullName(String fullName);
}
