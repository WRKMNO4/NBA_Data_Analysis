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
	//以下方法为：根据标准（总数据、场均或姓名）和技术类型对球员进行排序
	public ArrayList<PlayerPO> sortPlayersByComprehension(String  standard,PlayerData dataType) ;
	//以下方法为：根据标准（总数据、场均或队伍全名或队伍胜率等）和技术类型对球队进行排序
	public ArrayList<TeamPO> sortTeamsOf13_14ByComprehension(String standard,TeamData dataType);
	//以下方法为：根据球员位置、东西部、具体分区和排序依据返回所有满足条件的前50名球员序列,其中standard和dataType参数同排序方法中的参数
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard,PlayerData dataType);   
}
