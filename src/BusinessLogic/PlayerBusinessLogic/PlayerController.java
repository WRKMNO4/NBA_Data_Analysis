package BusinessLogic.PlayerBusinessLogic;

import java.util.ArrayList;

import DataService.TeamDataService.TeamController;
import PO.PlayerPO;
import PO.TeamListPO;
import PO.TeamPO;

public class PlayerController implements PlayerBusinessLogic{
	DataService.PlayerDataService.PlayerController playerController;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		playerController = new DataService.PlayerDataService.PlayerController();
	}
	
	@Override
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			String district) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> results = new ArrayList<PlayerPO>();
		for(PlayerPO onePlayer: playerController.getAllPlayers()){
			PlayerPO thePlayer = onePlayer;   //
			TeamPO ofTeam = TeamListPO.findTeamByShortName(onePlayer.getTeam());
			if(onePlayer.getPosition().equals(position) && ofTeam.getDistrict().equals(district))
				results.add(onePlayer);
		}
		return results;
	}

	@Override
	public ArrayList<PlayerPO> sortPlayersByComprehension() {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> results= (ArrayList<PlayerPO>) playerController.getAllPlayers().clone();
		
		return null;
	}
	

}
