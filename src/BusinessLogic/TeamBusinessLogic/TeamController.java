package BusinessLogic.TeamBusinessLogic;

public class TeamController implements TeamBusinessLogic{
	DataService.TeamDataService.TeamController teamController;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		teamController = new DataService.TeamDataService.TeamController();
	}

	
}
