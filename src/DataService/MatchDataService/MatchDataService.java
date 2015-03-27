package DataService.MatchDataService;

import PO.MatchPO;

public interface MatchDataService {
	public void addMatch(MatchPO oneMatch) ;
	public MatchPO findMatchByName(String name) ;
}
