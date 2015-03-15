package DataService.Calculation;

import java.util.ArrayList;

import PO.MatchPO;
import PO.TeamDataPO;
import PO.TeamPO;

public class TeamCalculation {
	TeamPO theTeam;
	TeamDataPO datas;
	ArrayList<MatchPO> matches;
	
	public TeamCalculation(TeamPO oneTeam){
		theTeam=oneTeam;
		
		matches=theTeam.getMatches();
	}
	
	public void calculate(){
		for(int i=0;i<matches.size();i++){
			MatchPO tempMatch=matches.get(i);
			
			
		}
	}
	
	
	
}
