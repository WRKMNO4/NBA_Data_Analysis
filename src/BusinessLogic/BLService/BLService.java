package BusinessLogic.BLService;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.TeamData;
import Enum.Zone;
import PO.PlayerPO;
import PO.TeamPO;

public interface BLService {
	public void init();
	public ArrayList<PlayerPO> getAllPlayers() ;
	public ArrayList<TeamPO> getAllTeamsOf13_14() ;
	/**
	 * 
	 * @param standard 标准（总数据、场均或姓名）
	 * @param dataType 技术类型
	 * @return 球队的排序结果
	 */
	public ArrayList<PlayerPO> sortPlayersByComprehension(String  standard,PlayerData dataType) ;
	/**
	 * 
	 * @param standard 标准（总数据、场均或队伍全名或队伍胜率等）
	 * @param dataType 技术类型
	 * @return 球员的排序结果
	 */
	public ArrayList<TeamPO> sortTeamsOf13_14ByComprehension(String standard,TeamData dataType);
	//以下方法为：根据球员位置、东西部、具体分区和排序依据返回所有满足条件的前50名球员序列,其中standard和dataType参数同排序方法中的参数
	/**
	 * 
	 * @param position 球员位置
	 * @param zone 东西部
	 * @param district 具体分区（界面上可以不选择，如果不选择，则传null）
	 * @param standard 排序依据的标准（总数据、场均或队伍全名或队伍胜率等）
	 * @param dataType 技术类型
	 * @return 球员的筛选结果
	 */
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard,PlayerData dataType);   
}
