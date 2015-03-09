package DataService.TeamDataService;

import PO.TeamPO;

public interface TeamDataService {
	public void addTeam(TeamPO oneTeam) ;
	public TeamPO findTeamByName(String name) ;
}
