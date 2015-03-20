package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.Zone;
import PO.PlayerPO;

public interface PlayerBusinessLogic {
	public void init();
	public ArrayList<PlayerPO> sortPlayersByComprehension(String standard,PlayerData dataType);  
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position, Zone zone, String district, String standard,PlayerData dataType);  //根据条件筛选球员
	public void calculateFinalData() ;
	public ArrayList<PlayerPO> getAllPlayers() ;
}
