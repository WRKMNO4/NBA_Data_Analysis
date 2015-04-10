package DataService.TeamDataService;

import java.util.ArrayList;

import Enum.ResultMessage;
import PO.TeamPO;

public interface TeamDataService {
	public ResultMessage addTeam(TeamPO oneTeam) ;
	public ResultMessage updateTeam(TeamPO oneTeam) ;
	public void calculateFinalData() ;
	public ArrayList<TeamPO> getAllTeams() ;
	public TeamPO findTeamByName(String name) ;
}
