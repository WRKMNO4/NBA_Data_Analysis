package DataService.TeamDataService;

import java.util.ArrayList;

import Enum.ResultMessage;
import PO.TeamPO;

public interface TeamDataService {
	public ResultMessage addTeam(TeamPO oneTeam) ;
	public TeamPO findTeamByName(String name) ;
	public ResultMessage updateTeam(TeamPO oneTeam) ;
	public void calculateFinalData() ;
	public ArrayList<TeamPO> getAllTeamsOf13_14() ;
}
