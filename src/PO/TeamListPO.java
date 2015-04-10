package PO;

import java.util.ArrayList;

import Enum.ResultMessage;

public class TeamListPO {
	public static ArrayList<TeamPO> allTeams ;
	public TeamListPO(){
		allTeams= new ArrayList<TeamPO>() ;
	}
	
	public ResultMessage addTeam(TeamPO theTeam){
		for(TeamPO oneTeam:allTeams){
			if(oneTeam.getFullName().equals(theTeam.getFullName()))
				return ResultMessage.add_failure ;
		}
		allTeams.add(theTeam) ;
		return ResultMessage.add_success ;
	}
	
	public ResultMessage updateTeam(TeamPO theTeam){
		return null ;
	}
	
	public static TeamPO findTeamByShortName(String name){
		for(TeamPO oneTeam:allTeams){
			if(oneTeam.getShortName().equals(name)){
				return oneTeam ;
			}
		}
		return null ;
	}
	public ArrayList<TeamPO> getAllTeams(){
		return allTeams ;
	}
}
