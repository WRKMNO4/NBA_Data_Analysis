package BusinessLogic.TeamBusinessLogic;

import java.util.ArrayList;

import Enum.Season;
import Enum.TeamData;
import Enum.Zone;
import PO.MatchPO;
import PO.TeamPO;

public interface TeamBusinessLogic {
	public void init(String fileAddress);
	public void calculateFinalData() ;
	public ArrayList<TeamPO> getAllTeams() ;
	ArrayList<TeamPO> sortTeamsByComprehension(String standard,
			TeamData dataType,Season season);
	public ArrayList<TeamPO> findTeamByName(String name) ;
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,
			TeamData dataType);
	public ArrayList<MatchPO> getLatest5Matches(TeamPO team);
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,TeamData dataType, int number);
	public ArrayList<TeamPO> getTeamRankings(Season season, Zone zone);
	public ArrayList<Integer> getRankingOfOneTeamIn3Years(String teamShortName);
}
