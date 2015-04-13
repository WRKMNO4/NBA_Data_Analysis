package BusinessLogic.MatchBusinessLogic;

import java.util.ArrayList;

import Enum.Season;
import PO.MatchPO;

public class MatchController implements MatchBusinessLogic{
	DataService.MatchDataService.MatchDataService matchController;
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
	@Override
	public ArrayList<MatchPO> getAllMatches(Season season) {
		// TODO Auto-generated method stub
		return matchController.getAllMatches(season);
	}
	
}
