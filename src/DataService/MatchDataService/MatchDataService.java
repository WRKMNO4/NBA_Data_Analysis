package DataService.MatchDataService;

import Enum.Season;
import PO.MatchPO;

public interface MatchDataService {
	public void addMatch(Season season , MatchPO oneMatch) ;
	public MatchPO findMatch(Season season,String date,String nameOfTeams) ;
}
