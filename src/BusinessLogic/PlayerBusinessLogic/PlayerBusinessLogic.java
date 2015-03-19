package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;

import Enum.Zone;
import PO.PlayerPO;

public interface PlayerBusinessLogic {
	public void init();
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position, Zone zone);  //根据球员的位置和所属联盟（东西部）筛选
	public ArrayList<PlayerPO> sortPlayersByComprehension();   // 根据得分/篮板/助攻排序
}
