package DataService.TeamDataService;

import java.util.ArrayList;

import PO.TeamListPO;
import PO.TeamPO;

public class TeamDriver {
	
	
	public static void main(String[] args){
		TeamController test=new TeamController();
		ArrayList<TeamPO> teams=test.teams.allTeamsOf13_14;
		for(int i=0;i<teams.size();i++){
			System.out.println(teams.get(i).getFullName()+" "+teams.get(i).getCity()+"  "+
		teams.get(i).getTimeOfEstablishment());
		}
		
	}
	
}
