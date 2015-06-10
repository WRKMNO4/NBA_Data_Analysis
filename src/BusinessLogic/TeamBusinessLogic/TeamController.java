package BusinessLogic.TeamBusinessLogic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import com.kmno4.common.Config;

import BusinessLogic.SortHelper.TeamSortHelper;
import DataService.FileHelper.FileHelper;
import DataService.TeamDataService.TeamDataService;
import Enum.Season;
import Enum.TeamData;
import Enum.Zone;
import PO.MatchPO;
import PO.SeasonListPO;
import PO.TeamListPO;
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
	
	public ArrayList<TeamPO> getTeamRankings(Season season, Zone zone){
		ArrayList<TeamPO> initialTeam = TeamListPO.allTeams;
		ArrayList<TeamPO> zoneTeam = new ArrayList<TeamPO>();
		TeamPO[] results = new TeamPO[15];
		for(TeamPO team: initialTeam){
			if(team.getZone()==zone)
				zoneTeam.add(team);
		}
		for(TeamPO theTeam : zoneTeam){
			ArrayList<String> lines = FileHelper.readByLine(new File("Data/highInfo/ranks/2015"));
			for(String eachLine: lines){
				if(eachLine.contains(theTeam.getFullName())){
					String[] splitStr = eachLine.split(" ");
					results[Integer.parseInt(splitStr[0])-1] = theTeam;
					break;
				}
			}
		}
		
//		Collections.sort(zoneTeam,new TeamSortHelper("perOfWin", null, season));
//		ArrayList<TeamPO> results = new ArrayList<>();
//		int pointer = 0 ;
//		results.add(zoneTeam.get(pointer));
//		zoneTeam.remove(pointer);
//		for(;results.size()<3;pointer++ ){
//			if(results.size()==1){
//				if(zoneTeam.get(pointer).getDistrict().equals(results.get(0).getDistrict()))
//					break;
//				else{
//					results.add(zoneTeam.get(pointer));
//					zoneTeam.remove(pointer);
//					pointer--;
//				}
//			}
//			if(results.size()==2){
//				if(zoneTeam.get(pointer).getDistrict().equals(results.get(0).getDistrict())||
//						zoneTeam.get(pointer).getDistrict().equals(results.get(1).getDistrict()))
//					break;
//				else{
//					results.add(zoneTeam.get(pointer));
//					zoneTeam.remove(pointer);
//					pointer--;
//				}
//			}	
//		}

		ArrayList<TeamPO> returnResult = new ArrayList<>();
		for(TeamPO oneTeam : results)
			returnResult.add(oneTeam);
		
		System.out.println(returnResult.size());
		return returnResult;
	}

	@Override
	public ArrayList<Integer> getRankingOfOneTeamIn3Years(String teamShortName) {
		ArrayList<Integer> results = new ArrayList<>();
		TeamPO theTeam = TeamListPO.findTeamByShortName(teamShortName);
		for(int i=0;i<3;i++){
			Season season = SeasonListPO.seasons.get(i).getSeason();
			int tmp = findTeamRanking(getTeamRankings(season, theTeam.getZone()), teamShortName);
			results.add(tmp);
		}
		return results;
	}
	
	public int findTeamRanking(ArrayList<TeamPO> teams, String teamShortName){
		for(int i = 0;i < teams.size();i++){
			if(teams.get(i).getShortName().equals(teamShortName))
				return i+1;
			else
				continue;
		}
		return 0;
	}
	
}
