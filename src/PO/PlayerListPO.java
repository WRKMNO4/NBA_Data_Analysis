package PO;

import java.util.ArrayList;

import Enum.ResultMessage;

public class PlayerListPO {
	public static ArrayList <PlayerPO> allPlayers;
	public PlayerListPO(){
		allPlayers = new ArrayList<PlayerPO>() ;
	}
	
	public static ResultMessage addPlayer(PlayerPO thePlayer){
		for(PlayerPO onePlayer : allPlayers){
			if(onePlayer.getName().equals(thePlayer.getName()))
		    	return ResultMessage.add_failure ;
		}
		allPlayers.add(thePlayer) ;
		return ResultMessage.add_success ;
			
	}
	
	public ArrayList<PlayerPO> findPlayerFaintly(String name){
		ArrayList<PlayerPO> result = new ArrayList<>() ;
		for(PlayerPO onePlayer : allPlayers){
			if(onePlayer.getName().contains(name))
				result.add(onePlayer) ;
		}
		return result ;
	}
	public static PlayerPO findPlayerAccurately(String name){
		for(PlayerPO onePlayer:allPlayers){
			if(onePlayer.getName().equals(name)){
				return onePlayer ;
			}
		}
		return null ;
	}
	

	public static ArrayList<PlayerPO> getAllPlayers() {
		return allPlayers;
	}
	
	
	
}
