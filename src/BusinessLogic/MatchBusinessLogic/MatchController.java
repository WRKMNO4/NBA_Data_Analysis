package BusinessLogic.MatchBusinessLogic;

public class MatchController implements MatchBusinessLogic{
	DataService.MatchDataService.MatchController matchController;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		matchController = new DataService.MatchDataService.MatchController();
	}
	
}
