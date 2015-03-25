package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import BusinessLogic.SortHelper.PlayerSortHelper;
import DataService.PlayerDataService.PlayerDataService;
import DataService.TeamDataService.TeamController;
import Enum.PlayerData;
import Enum.Zone;
import PO.PlayerPO;
import PO.TeamListPO;
import PO.TeamPO;

public class PlayerController implements PlayerBusinessLogic{
	PlayerDataService playerController;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		playerController = new DataService.PlayerDataService.PlayerController() ;
	}
	public void calculateFinalData(){
		playerController.calculateFinalData() ;
	}
	
	
	
	@Override
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard,PlayerData dataType) {
		// TODO Auto-generated method stub
		System.out.println(position+" "+zone.toString()+" "+standard +" "+dataType.toString());
		ArrayList<PlayerPO> results = new ArrayList<PlayerPO>();
		System.out.println("size"+playerController.getAllPlayers().size());
		for(PlayerPO onePlayer: playerController.getAllPlayers()){
			TeamPO ofTeam = TeamListPO.findTeamByShortName(onePlayer.getTeam());
			if(ofTeam!=null && onePlayer.getPosition().contains(position) && (ofTeam.getZone().equals(zone) || 
					ofTeam.getDistrict().equals(district)))
				results.add(onePlayer);
		}
		System.out.println(results.size());
		Collections.sort(results, new PlayerSortHelper(standard, dataType));
		if(results.size()>50)
			results.subList(0, 50);
		System.out.println(results.size());
		System.out.println(results.get(0).getTotalPlayerData().getScore());
		System.out.println(results.get(1).getTotalPlayerData().getScore());
		System.out.println(results.get(2).getTotalPlayerData().getScore());
		return results;
	}

	@Override
	public ArrayList<PlayerPO> sortPlayersByComprehension(String standard,PlayerData dataType) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> results= (ArrayList<PlayerPO>) playerController.getAllPlayers().clone();
		Collections.sort(results,new PlayerSortHelper(standard, dataType));
		return results;
	}
	@Override
	public ArrayList<PlayerPO> getAllPlayers() {
		// TODO Auto-generated method stub
		return playerController.getAllPlayers();
	}
	

}
