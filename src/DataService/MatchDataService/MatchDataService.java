package DataService.MatchDataService;

import java.util.ArrayList;

import Enum.Season;
import PO.MatchPO;

public interface MatchDataService {
	public void addMatch(Season season , MatchPO oneMatch) ;
	public MatchPO findMatch(Season season,String date,String nameOfTeams) ;
	public ArrayList<MatchPO> getAllMatches(Season season);
}
