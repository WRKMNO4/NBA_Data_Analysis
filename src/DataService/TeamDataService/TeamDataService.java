package DataService.TeamDataService;

import Enum.ResultMessage;
import PO.TeamPO;

public interface TeamDataService {
	public ResultMessage addTeam(TeamPO oneTeam) ;
	public TeamPO findTeamByName(String name) ;
	public ResultMessage updateTeam(TeamPO oneTeam) ;
}
