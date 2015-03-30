package BusinessLogic.TeamBusinessLogic;

import java.util.ArrayList;
import java.util.Collections;

import BusinessLogic.SortHelper.PlayerSortHelper;
import BusinessLogic.SortHelper.TeamSortHelper;
import DataService.TeamDataService.TeamDataService;
import Enum.PlayerData;
import Enum.TeamData;
import PO.PlayerPO;
import PO.TeamPO;

public class TeamController implements TeamBusinessLogic{
	TeamDataService teamController;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		teamController = new DataService.TeamDataService.TeamController();
	}
	@Override
	public void calculateFinalData() {
		// TODO Auto-generated method stub
		teamController.calculateFinalData() ;
	}
	@Override
	public ArrayList<TeamPO> getAllTeamsOf13_14() {
		// TODO Auto-generated method stub
		return teamController.getAllTeamsOf13_14();
	}
	@Override
	public ArrayList<TeamPO> sortTeamsOf13_14ByComprehension(String standard,TeamData dataType) {
		// TODO Auto-generated method stub
		if(dataType==TeamData.teamFullName)
			standard="name";
		else if(dataType==TeamData.numberOfMatches)
			standard="matches";
		else if(dataType==TeamData.percentageOfWinning)
			standard="perOfWin";
		ArrayList<TeamPO> results= (ArrayList<TeamPO>) teamController.getAllTeamsOf13_14().clone();
		Collections.sort(results,new TeamSortHelper(standard, dataType));
		return results;
	}
	
}
