package BusinessLogic.MatchBusinessLogic;

import Enum.Season;
import PO.MatchPO;

public interface MatchBusinessLogic {
	public void init();
	public MatchPO findMatch(Season season,String date,String nameOfTeams) ;
}
