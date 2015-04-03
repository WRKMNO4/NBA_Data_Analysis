package BusinessLogic.SortHelper;

import java.util.Comparator;

import Enum.PlayerData;
import Enum.Season;
import PO.PlayerDataPO;
import PO.PlayerPO;
import PO.SeasonInfoForPlayer;

public class PlayerSortHelper implements Comparator<PlayerPO>{
	String str ;
	PlayerData dataType ;
	Season season ;
	public PlayerSortHelper(String standard,PlayerData dataType,Season season){
		this.str = standard ;
		this.dataType = dataType ;
		this.season = season ;
	}
	@Override
	public int compare(PlayerPO o1, PlayerPO o2) {
		// TODO Auto-generated method stub
		if(str.equals("total")){
			return comparePlayerData(o1.getSeasonInfo(season),o2.getSeasonInfo(season),1) ;
		}
		
		if(str.equals("avg")){
			return comparePlayerData(o1.getSeasonInfo(season),o2.getSeasonInfo(season),2) ;
		}
		
		if(str.equals("name")){
			if(o1.getName().compareTo(o2.getName()) > 0){
				return 1;
			}
			if(o1.getName().compareTo(o2.getName()) == 0){
				return 0 ;
			}
			if(o1.getName().compareTo(o2.getName()) < 0){
				return -1 ;
			}
		}
		/*
		if(str.equals("nameOfTeam")){
			if(o1.getTeam().compareTo(o2.getTeam())>0){
				return 1 ;
			}
			if(o1.getTeam().compareTo(o2.getTeam()) == 0){
				return 0 ;
			}
			if(o1.getTeam().compareTo(o2.getTeam()) < 0){
				return -1 ;
			}
		}*/
		return 0;
	}
	int comparePlayerData(SeasonInfoForPlayer firstPlayer,SeasonInfoForPlayer secondPlayer,int mark){
		//参数mark表示总数或者平均值，当mark = 1 时，代表求总数。
		PlayerDataPO player1 = null ;
		PlayerDataPO player2 = null ;
		if(mark == 1){
			player1 = firstPlayer.getTotalPlayerData() ;
			player2 = secondPlayer.getTotalPlayerData() ;
		}else{
			player1 = firstPlayer.getAveragePlayerData() ;
			player2 = secondPlayer.getAveragePlayerData() ;
		}
	
		double number1 = 0 ;
		double number2 = 0 ;
		switch(dataType){
		case numberOfMatchs:
			number1 = player1.getNumberOfMatch() ;
			number2 = player2.getNumberOfMatch() ;
			break ;
		case numberOfStarting:
			number1 = player1.getNumberOfStarting() ;
			number2 = player2.getNumberOfStarting() ;
			break;
		case numberOfRebound:
			number1 = player1.getNumberOfRebound() ;
			number2 = player2.getNumberOfRebound() ;
			break ;
		case numberOfAssist:
			number1 = player1.getNumberOfAssist() ;
			number2 = player2.getNumberOfAssist() ;
			break ;
		case presentTime:
			number1 = transform(player1.getPresentTime());
			number2 = transform(player2.getPresentTime()) ;
			break ;
		case percentageOfShooting:
			number1 = player1.getPercentageOfShooting() ;
			number2 = player2.getPercentageOfShooting() ;
			break ;
		case percentageOf3_Point:
			number1 = player1.getPercentageOf3_Point();
			number2 = player2.getPercentageOf3_Point() ;
			break ;
		case percentageOfFreeThrow:
			number1 = player1.getPercentageOffreeThrow() ;
			number2 = player2.getPercentageOffreeThrow() ;
			break ;
		case numberOfAttack:
			number1 = player1.getNumberOfAttack() ;
			number2 = player2.getNumberOfAttack() ;
			break ;
		case numberOfDefense:
			number1 = player1.getNumberOfDefense() ;
			number2 = player2.getNumberOfDefense() ;
			break ;
		case numberOfSteal:
			number1 = player1.getNumberOfSteal() ;
			number2 = player2.getNumberOfSteal() ;
			break ;
		case numberOfBlock :
			 number1 = player1.getNumberOfBlock() ;
			 number2 = player2.getNumberOfBlock() ;
			 break ;
		case numberOfFault:
			number1 = player1.getNumberOfFault() ;
			number2 = player2.getNumberOfFault() ;
			break ;
		case numberOfFoul:
			number1 = player1.getNumberOfFoul() ;
			number2 = player2.getNumberOfFoul() ;
			break ;
		case score:
			number1 = player1.getScore() ;
			number2 = player2.getScore() ;
			break ;
		case efficiency:
			number1 = player1.getEfficiency() ;
			number2 = player2.getEfficiency() ;
			break ;
		case efficiencyOfGmSc:
			number1 = player1.getEfficiencyOfGmSc() ;
			number2 = player2.getEfficiencyOfGmSc() ;
			break ;
		case percentageOfTrueShooting:
			number1 = player1.getPercentageOfTrueShooting() ;
			number2 = player2.getPercentageOfTrueShooting() ;
			break ;
		case efficiencyOfShooting:
			number1 = player1.getEfficiencyOfShooting() ;
			number2 = player2.getEfficiencyOfShooting() ;
			break ;
		case percentageOfRebound:
			number1 = player1.getPercentageOfRebound();
			number2 = player2.getPercentageOfRebound() ;
			break ;
		case percentageOfAttackingRebound:
			number1 = player1.getPercentageOfAttackingRebound() ;
			number2 = player2.getPercentageOfAttackingRebound() ;
			break ;
		case percentageOfDefenseRebound:
			number1 = player1.getPercentageOfDefenseRebound() ;
			number2 = player2.getPercentageOfDefenseRebound() ;
			break ;
		case percentageOfAssist:
			number1 = player1.getPercentageOfAssist() ;
			number2 = player2.getPercentageOfAssist() ;
			break ;
		case percentageOfSteal:
			number1 = player1.getPercentageOfSteal() ;
			number2 = player2.getPercentageOfSteal() ;
			break ;
		case percentageOfBlock:
			number1 = player1.getPercentageOfBlock() ;
			number2 = player2.getPercentageOfBlock() ;
			break ;
		case percentageOfFault:
			number1 = player1.getPercentageOfFault() ;
			number2 = player2.getPercentageOfFault() ;
			break ;
		case percentageOfUse:
			number1 = player1.getPercentageOfUse() ;
			number2 = player2.getPercentageOfUse() ;
			break ;
		case numberOfShooting:
			number1 = player1.getNumberOfShooting() ;
			number2 = player2.getNumberOfShooting() ;
			break ;
		case numberOf3_Point:
			number1 =player1.getNumberOf3_point() ;
			number2 = player2.getNumberOf3_point() ;
			break ;
		case numberOfFreeThrow:
			number1 = player1.getNumberOfFreeThrow() ;
			number2 = player2.getNumberOfFreeThrow() ;
			break ;
		case double_double:
			number1 = player1.getDouble_double() ;
			number2 = player2.getDouble_double() ;
			break ;
		case comprehension:
			number1 = player1.getComprehension() ;
			number2 = player2.getComprehension() ;
			break ;
		case improveRateOfScore :
			number1 = firstPlayer.getImprovedRateOfScore() ;
			number2 = secondPlayer.getImprovedRateOfScore() ;
			break ;
		case improveRateOfRebound :
		    number1 = firstPlayer.getImprovedRateOfRebound() ;
	    	number2 = secondPlayer.getImprovedRateOfRebound() ;
	    	break ;
		case improveRateOfAssist :
			number1 = firstPlayer.getImprovedRateOfAssist() ;
			number2 = secondPlayer.getImprovedRateOfAssist() ;
			break ;
		default:
			break ;
		}
		if(number1!=number1){      //判断number1是否为NaN
			number1=-1;
		}
		if(number2!=number2)      //判断number2是否为NaN
			number2=-1;
		
		if(number1>number2){
			return -1;
		}
		else if(number1 == number2 )
			return 0 ;
		else
			return 1 ;
	}
	int transform(String time){
		if(time!=null){
			String[] strs = time.split(":");
			int seconds = Integer.parseInt(strs[0])*60+Integer.parseInt(strs[1]) ;
			return seconds ;
		}
		return 0;
	}
}
