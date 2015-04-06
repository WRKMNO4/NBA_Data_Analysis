package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import BusinessLogic.SortHelper.PlayerSortHelper;
import DataService.PlayerDataService.PlayerDataService;
import DataService.TeamDataService.TeamController;
import Enum.PlayerData;
import Enum.Season;
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
			Zone zone, String district, String standard,PlayerData dataType,Season season) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> results = new ArrayList<PlayerPO>();
		for(PlayerPO onePlayer: playerController.getAllPlayers()){
			TeamPO ofTeam = TeamListPO.findTeamByShortName(onePlayer.getTeam(season));
			if(ofTeam!=null && onePlayer.getPosition().contains(position) && (ofTeam.getZone().equals(zone) || 
					ofTeam.getDistrict().equals(district)))
				results.add(onePlayer);
		}
		Collections.sort(results, new PlayerSortHelper(standard, dataType,season));
		if(results.size()>50)
			results.subList(0, 50);
		return results;
	}

	@Override
	public ArrayList<PlayerPO> sortPlayersByComprehension(String standard,PlayerData dataType,Season season) {
		ArrayList<PlayerPO> results= (ArrayList<PlayerPO>) playerController.getAllPlayers().clone();
		Collections.sort(results,new PlayerSortHelper(standard, dataType,season));
		return results;
	}
	@Override
	public ArrayList<PlayerPO> getAllPlayers() {
		// TODO Auto-generated method stub
		return playerController.getAllPlayers();
	}
	

}
