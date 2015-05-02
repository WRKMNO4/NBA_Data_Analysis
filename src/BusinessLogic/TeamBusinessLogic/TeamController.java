package BusinessLogic.TeamBusinessLogic;

import java.util.ArrayList;
import java.util.Collections;

import com.kmno4.common.Config;

import BusinessLogic.SortHelper.PlayerSortHelper;
import BusinessLogic.SortHelper.TeamSortHelper;
import DataService.TeamDataService.TeamDataService;
import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import PO.MatchPO;
import PO.PlayerPO;
import PO.TeamPO;

public class TeamController implements TeamBusinessLogic{
	TeamDataService teamController;
	@Override
	public void init(String fileAddress) {
		// TODO Auto-generated method stub
		teamController = new DataService.TeamDataService.TeamController(fileAddress);
	}
	@Override
	public void calculateFinalData() {
		// TODO Auto-generated method stub
		teamController.calculateFinalData() ;
	}
	@Override
	public ArrayList<TeamPO> getAllTeams() {
		// TODO Auto-generated method stub
		return teamController.getAllTeams();
	}
	@Override
	public ArrayList<TeamPO> sortTeamsByComprehension(String standard,TeamData dataType,Season season) {
		// TODO Auto-generated method stub
		if(dataType==TeamData.teamFullName)
			standard="name";
		else if(dataType==TeamData.numberOfMatches)
			standard="matches";
		else if(dataType==TeamData.percentageOfWinning)
			standard="perOfWin";
		ArrayList<TeamPO> results= (ArrayList<TeamPO>) teamController.getAllTeams().clone();
		Collections.sort(results,new TeamSortHelper(standard, dataType,season));
		return results;
	}
	@Override
	public ArrayList<TeamPO> findTeamByName(String name) {
		// TODO Auto-generated method stub
		/*
		 * 舟舟说不写
		 */
		return null ;
	}
	@Override
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,
			TeamData dataType) {
		// TODO Auto-generated method stub
		ArrayList<TeamPO> allTeams = teamController.getAllTeams() ;
		Collections.sort(allTeams,new TeamSortHelper("avg", dataType, season));
		ArrayList<TeamPO> result = new ArrayList<>(allTeams.subList(0, 5)) ;
		return result ;
	}
	
	@Override
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,
			TeamData dataType, int number) {
		ArrayList<TeamPO> allTeams = teamController.getAllTeams() ;
		Collections.sort(allTeams,new TeamSortHelper("avg", dataType, season));
		ArrayList<TeamPO> result = new ArrayList<>(allTeams.subList(0, number)) ;
		return result ;
	}
	@Override
	public ArrayList<MatchPO> getLatest5Matches(TeamPO team) {
		// TODO Auto-generated method stub
		ArrayList<MatchPO> allMatches = team.getMatches(Config.LASTEST_SEASON) ;
		if(allMatches.size()<5){
			return allMatches ;
		}
		ArrayList<MatchPO> latest5Matches = new ArrayList<>(allMatches.subList(allMatches.size()-5, allMatches.size())) ;
		return latest5Matches ;
	}

	
}
