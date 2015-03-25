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
		System.out.println(position+" "+zone.toString()+" ");
		ArrayList<PlayerPO> results = new ArrayList<PlayerPO>();
		for(PlayerPO onePlayer: playerController.getAllPlayers()){
			TeamPO ofTeam = TeamListPO.findTeamByShortName(onePlayer.getTeam());
			System.out.println(ofTeam==null);
			if(ofTeam!=null && onePlayer.getPosition().contains(position) && (ofTeam.getZone().equals(zone) || 
					ofTeam.getDistrict().equals(district)))
				results.add(onePlayer);
		}
		System.out.println(results.size()+"q");
		Collections.sort(results, new PlayerSortHelper(standard, dataType));
		if(results.size()>50)
			results.subList(0, 50);
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
