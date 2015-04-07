package BusinessLogic.MatchBusinessLogic;

import Enum.Season;
import PO.MatchPO;

public class MatchController implements MatchBusinessLogic{
	DataService.MatchDataService.MatchController matchController;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		matchController = new DataService.MatchDataService.MatchController();
	}
	@Override
	public MatchPO findMatch(Season season, String date, String nameOfTeams) {
		// TODO Auto-generated method stub
		return matchController.findMatch(season, date, nameOfTeams) ;
	}
	
}
