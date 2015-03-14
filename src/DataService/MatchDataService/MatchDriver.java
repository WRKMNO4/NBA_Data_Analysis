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
	
		MatchController test= new MatchController();
		System.out.println(test.matches.allMatchListOf13_14.size());
		
		TeamPO team = TeamListPO.findTeamByShortName("MIL");
		System.out.println(team.getMatches().size()+" matches");
		System.out.println(team.getPlayers().size()+" players");
		
		PlayerPO player= PlayerListPO.findPlayerByName("LeBron James");
		System.out.println(player.getDatas().size()+" matches");
		
		
	}
}
