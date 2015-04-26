package BusinessLogic.MatchBusinessLogic;

import java.util.ArrayList;

import Enum.Season;
import PO.MatchPO;

public interface MatchBusinessLogic {
	public void init(String fileAddress);
	public MatchPO findMatch(Season season,String date,String nameOfTeams) ;
	public ArrayList<MatchPO> getAllMatches(Season season);
}
