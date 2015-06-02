package PO;

import java.util.ArrayList;

import Enum.ResultMessage;
import Enum.Zone;

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
	
	public static TeamPO findTeamByFullName(String name){
		for(TeamPO oneTeam:allTeams){
			if(oneTeam.getFullName().equals(name))
				return oneTeam ;
		}
		return null;
	}
	
	public ArrayList<TeamPO> getAllTeams(){
		return allTeams ;
	}
	
	public ArrayList<TeamPO> getAllWestTeams(){
		ArrayList<TeamPO> teams = new ArrayList<TeamPO>();
		for(TeamPO oneTeam:allTeams)
			if(oneTeam.getZone() == Zone.W)
				teams.add(oneTeam);
		return teams;
	}
	
	public ArrayList<TeamPO> getAllEastTeams(){
		ArrayList<TeamPO> teams = new ArrayList<TeamPO>();
		for(TeamPO oneTeam:allTeams)
			if(oneTeam.getZone() == Zone.E)
				teams.add(oneTeam);
		return teams;
	}
}
