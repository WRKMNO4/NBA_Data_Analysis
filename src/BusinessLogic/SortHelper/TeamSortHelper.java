package BusinessLogic.SortHelper;

import java.util.Comparator;

import Enum.Season;
import Enum.TeamData;
import PO.TeamDataPO;
import PO.TeamPO;

public class TeamSortHelper implements Comparator<TeamPO>{
	String str ;
	TeamData dataType;
	Season season;
	public TeamSortHelper(String str,TeamData dataType,Season season) {
		// TODO Auto-generated constructor stub
		this.str = str ;
		this.dataType = dataType ;
		this.season=season;
	}
	@Override
	public int compare(TeamPO o1, TeamPO o2) {
		// TODO Auto-generated method stub
		//Sort by total team data. (Some data does not belong to a total one)
		if(str.equals("total")){     
			return compareTeamData(o1.getTotalTeamData(season), o2.getTotalTeamData(season));
		}
		//Sort by average team data.
		else if(str.equals("avg"))   {
			return compareTeamData(o1.getAverageTeamData(season), o2.getAverageTeamData(season));
		}
		//sort by the full name of the team
		else if(str.equals("name")){
			String name1=o1.getFullName();
			String name2=o2.getFullName();
			if(name1.compareTo(name2)>0)
				return 1;
			else if(name1.equals(name2))
				return 0;
			else
				return -1;
		}
		//Sort by number of matches
		else if(str.equals("matches")){
			int matches1=o1.getSeasonInfo(season).getNumberOfMatches();
			int matches2=o2.getSeasonInfo(season).getNumberOfMatches();
			if(matches1>matches2)
				return -1;
			else if(matches1==matches2)
				return 0;
			else 
				return 1;
		}
		//Sort by percentage of winning
		else if(str.equals("perOfWin")){ 
			double win1=o1.getSeasonInfo(season).getPercentageOfWinning();
			double win2=o2.getSeasonInfo(season).getPercentageOfWinning();
			if(win1>win2)
				return -1;
			else if(win1==win2)
				return 0;
			else
				return 1;
		}
		//Invalid
		else
			return 0;
	}
	
	
	public int compareTeamData(TeamDataPO o1,TeamDataPO o2){
		double data1 = 0,data2 = 0; //Initialization
		
		switch (dataType){
		case numberOfShooting:
			data1=o1.getNumberOfShooting();
			data2=o2.getNumberOfShooting();
			break;
		
		case numberOfShotAttempt:
			data1=o1.getNumberOfShotAttempt();
			data2=o2.getNumberOfShotAttempt();
			break;
			
		case numberOf3_point:
			data1=o1.getNumberOf3_point();
			data2=o2.getNumberOf3_point();
			break;
			
		case numberOf3_pointAttempt:
			data1=o1.getNumberOf3_pointAttempt();
			data2=o2.getNumberOf3_pointAttempt();
			break;
		
		case numberOfFreeThrow:
			data1=o1.getNumberOfFreeThrow();
			data2=o2.getNumberOfFreeThrow();
			break;
			
		case numberOfFreeThrowAttempt:
			data1=o1.getNumberOfFreeThrowAttempt();
			data2=o2.getNumberOfFreeThrowAttempt();
			break;
			
		case numberOfAttackRebound:
			data1=o1.getNumberOfAttackRebound();
			data2=o2.getNumberOfAttackRebound();
			break;
			
		case numberOfDefenseRebound:
			data1=o1.getNumberOfDefenseRebound();
			data2=o2.getNumberOfDefenseRebound();
			break;
			
		case numberOfRebound:
			data1=o1.getNumberOfRebound();
			data2=o2.getNumberOfRebound();
			break;
			
		case numberOfAssist:
			data1=o1.getNumberOfAssist();
			data2=o2.getNumberOfAssist();
			break;
			
		case numberOfSteal:
			data1=o1.getNumberOfSteal();
			data2=o2.getNumberOfSteal();
			break;
			
		case numberOfBlock:
			data1=o1.getNumberOfBlock();
			data2=o2.getNumberOfBlock();
			break;	
			
		case numberOfFault:
			data1=o1.getNumberOfFault();
			data2=o2.getNumberOfFault();
			break;
			
		case numberOfFoul:
			data1=o1.getNumberOfFoul();
			data2=o2.getNumberOfFoul();
			break;
			
		case score:
			data1=o1.getScore();
			data2=o2.getScore();
			break;
			
			//only average, except for roundOfAttack
		case percentageOfShooting:
			data1=o1.getPercentageOfShooting();
			data2=o2.getPercentageOfShooting();
			break;
			
		case percentageOf3_point:
			data1=o1.getPercentageOf3_point();
			data2=o2.getPercentageOf3_point();
			break;
			
		case percentageOfFreeThrow:
			data1=o1.getPercentageOfFreeThrow();
			data2=o2.getPercentageOfFreeThrow();
			break;
			
		case roundOfAttack:
			data1=o1.getRoundOfAttack();
			data2=o2.getRoundOfAttack();
			break;
			
		case efficiencyOfAttack:
			data1=o1.getEfficiencyOfAttack();
			data2=o2.getEfficiencyOfAttack();
			break;
			
		case efficiencyOfDefense:
			data1=o1.getEfficiencyOfDefense();
			data2=o2.getEfficiencyOfDefense();
			break;
			
		case efficiencyOfRebound:
			data1=o1.getEfficiencyOfRebound();
			data2=o2.getEfficiencyOfRebound();
			break;
			
		case efficiencyOfSteal:
			data1=o1.getEfficiencyOfSteal();
			data2=o2.getEfficiencyOfSteal();
			break;
			
		case efficiencyOfAssist:
			data1=o1.getEfficiencyOfAssist();
			data2=o2.getEfficiencyOfAssist();
			break;
			
		case efficiencyOfAttackRebound:
			data1=o1.getEfficiencyOfAttackRebound();
			data2=o2.getEfficiencyOfAttackRebound();
			break;
			
		case efficiencyOfDefenseRebound:
			data1=o1.getEfficiencyOfDefenseRebound();
			data2=o2.getEfficiencyOfDefenseRebound();
			break;
			
		default:
			break;
		}
		if(data1!=data1)
			data1=-1;
		if(data2!=data2)
			data2=-1;
		
		if(data1 > data2)
			return -1 ;
		else if(data1 == data2)
			return 0;
		else
			return 1;
	}
	
}
