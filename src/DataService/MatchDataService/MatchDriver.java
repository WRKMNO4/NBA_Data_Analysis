package DataService.MatchDataService;

import jdk.nashorn.internal.runtime.FindProperty;
import DataService.PlayerDataService.PlayerController;
import DataService.TeamDataService.TeamController;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.TeamListPO;
import PO.TeamPO;

public class MatchDriver {

	
	public static void main(String[] args){
		TeamController teams= new TeamController();
		
		PlayerController players=new PlayerController();
		
		System.out.println(players.getAllPlayers().size());
		System.out.println(players.getAllPlayers().get(447).getName());
	
		MatchController test= new MatchController();
//		System.out.println(test.matches.allMatchListOf13_14.size());
//		TeamPO team = TeamListPO.findTeamByShortName("MIL");
//		System.out.println(team.getMatches().size()+" matches");
		System.out.println(players.getAllPlayers().size()+" players");
		System.out.println(players.getAllPlayers().get(448).getName());
//		
		PlayerPO player= PlayerListPO.findPlayerByName("Alex Len");
//		System.out.println(player.getDatas().size()+" matches");
//		System.out.println(player.getTeam());
//		for(int i =0 ;i<player.getDatas().size();i++){
//			System.out.println(player.getDatas().get(i).getEfficiencyOfShooting());
//		}
		
	}
}
