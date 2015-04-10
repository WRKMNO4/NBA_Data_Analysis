package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import Enum.Zone;
import PO.PlayerPO;
import PO.StandingDataPO;
import PO.TeamPO;

public interface PlayerBusinessLogic {
	public void init();
	public ArrayList<PlayerPO> sortPlayersByComprehension(String standard,PlayerData dataType,Season season);  
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position, Zone zone, String district, String standard,PlayerData dataType,Season season);  //根据条件筛选球员
	public void calculateFinalData() ;
	public ArrayList<PlayerPO> getAllPlayers() ;
	public ArrayList<PlayerPO> findPlayerByName(String name) ;
	public ArrayList<StandingDataPO> getDatasOfDailyStandingPlayers(Season season,String date, PlayerData dataType);
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season,
			PlayerData dataType);
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season,
			PlayerData dataType);
}
