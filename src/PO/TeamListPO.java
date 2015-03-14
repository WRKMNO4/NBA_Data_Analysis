package PO;

import java.util.ArrayList;

import Enum.ResultMessage;

public class TeamListPO {
	public static ArrayList<TeamPO> allTeamsOf13_14 ;
	public TeamListPO(){
		allTeamsOf13_14= new ArrayList<TeamPO>() ;
	}
	
	public ResultMessage addTeam(TeamPO theTeam){
		for(TeamPO oneTeam:allTeamsOf13_14){
			if(oneTeam.getFullName().equals(theTeam.getFullName()))
				return ResultMessage.add_failure ;
		}
		allTeamsOf13_14.add(theTeam) ;
		return ResultMessage.add_success ;
	}
	
	public ResultMessage updateTeam(TeamPO theTeam){
		return null ;
	}
	
	public static TeamPO findTeamByShortName(String name){
		for(TeamPO oneTeam:allTeamsOf13_14){
			if(oneTeam.getShortName().equals(name)){
				return oneTeam ;
			}
		}
		return null ;
	}
}
