package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;

import Enum.Zone;
import PO.PlayerPO;

public interface PlayerBusinessLogic {
	public void init();
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position, Zone zone, String district);  //根据条件筛选球员
	public ArrayList<PlayerPO> sortPlayersByComprehension();   //此方法可删
}
