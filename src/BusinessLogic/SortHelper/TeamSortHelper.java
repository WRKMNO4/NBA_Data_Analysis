package BusinessLogic.SortHelper;

import java.util.Comparator;

import PO.TeamDataPO;
import PO.TeamPO;

public class TeamSortHelper implements Comparator<TeamPO>{
	String str ;
	public TeamSortHelper(String str) {
		// TODO Auto-generated constructor stub
		this.str = str ;
	}
	@Override
	public int compare(TeamPO o1, TeamPO o2) {
		// TODO Auto-generated method stub
		if(str.equals("total")){     //Sort by total team data.
			return compareTeamData(o1.getTotalTeamData(), o2.getAverageTeamData());
		}
		
		else if(str.equals("avg"))   {//Sort by average team data.
			return compareTeamData(o1.getAverageTeamData(), o2.getAverageTeamData());
		}
		
		else if(str.equals(""))
		return 0;
	}
	
	
	public int compareTeamData(TeamDataPO o1,TeamDataPO o2){
		return 0;
	}
}
