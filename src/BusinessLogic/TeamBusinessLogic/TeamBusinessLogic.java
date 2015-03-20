package BusinessLogic.TeamBusinessLogic;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.TeamData;
import PO.TeamPO;

public interface TeamBusinessLogic {
	public void init();
	public void calculateFinalData() ;
	public ArrayList<TeamPO> getAllTeamsOf13_14() ;
	ArrayList<TeamPO> sortTeamsOf13_14ByComprehension(String standard,
			TeamData dataType);
}
