package BusinessLogic.BLService;

import Enum.TeamData;

public class BLServiceDriver {
	public static void main(String[] args){
		BLService bl=new BLServiceController();
		bl.init();
		System.out.println(bl.sortTeamsOf13_14ByComprehension("avg", TeamData.percentageOfShooting).get(24).getAverageTeamData().getPercentageOfShooting());
		
		
	}
	
}
