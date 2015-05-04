package PO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

	public void sortPlayerByName() {
		Collections.sort(allPlayers, new CompareByPlayerName());
		for(int i=0;i<allPlayers.size();i++)
			System.out.println(allPlayers.get(i).getName());
	}
	
	
	class CompareByPlayerName implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String name1=((PlayerPO)o1).getName();
			String name2=((PlayerPO)o2).getName();
			String[] splitName1=name1.split(" ");
			String[] splitName2=name2.split(" ");
			String sortName1=splitName1[splitName1.length-1];
			String sortName2=splitName2[splitName2.length-1];
			if(sortName1.compareTo(sortName2)>0)
				return 1;
			else if(sortName1.equals(sortName2))
				return 0;
			else
				return -1;
		}
	}
}
