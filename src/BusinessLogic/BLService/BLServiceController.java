package BusinessLogic.BLService;

import java.util.ArrayList;

import BusinessLogic.MatchBusinessLogic.MatchBusinessLogic;
import BusinessLogic.PlayerBusinessLogic.PlayerBusinessLogic;
import BusinessLogic.TeamBusinessLogic.TeamBusinessLogic;
import DataService.MatchDataService.MatchController;
import DataService.MatchDataService.MatchDataService;
import DataService.PlayerDataService.PlayerController;
import DataService.PlayerDataService.PlayerDataService;
import DataService.TeamDataService.TeamController;
import DataService.TeamDataService.TeamDataService;
import Enum.PlayerData;
import Enum.TeamData;
import Enum.Zone;
import PO.PlayerPO;
import PO.TeamPO;

import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;

public class BLServiceController implements BLService{
	TeamBusinessLogic teamController ;
	PlayerBusinessLogic playerController ;
	MatchBusinessLogic matchController ;
	
	public BLServiceController() {
		this.teamController = new BusinessLogic.TeamBusinessLogic.TeamController() ;
		this.playerController = new BusinessLogic.PlayerBusinessLogic.PlayerController() ;
		this.matchController = new BusinessLogic.MatchBusinessLogic.MatchController() ;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		teamController.init();
		playerController.init();
		matchController.init();
		teamController.calculateFinalData();
		playerController.calculateFinalData();
	}

	@Override
	public ArrayList<PlayerPO> getAllPlayers() {
		// TODO Auto-generated method stub
		return playerController.getAllPlayers();
	}

	@Override
	public ArrayList<TeamPO> getAllTeamsOf13_14() {
		// TODO Auto-generated method stub
		return teamController.getAllTeamsOf13_14();
	}

	@Override
	public ArrayList<PlayerPO> sortPlayersByComprehension(String standard,
			PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.sortPlayersByComprehension(standard, dataType);
	}

	@Override
	public ArrayList<TeamPO> sortTeamsOf13_14ByComprehension(String standard,
			TeamData dataType) {
		// TODO Auto-generated method stub
		return teamController.sortTeamsOf13_14ByComprehension(standard, dataType) ;
	}

	@Override
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard, PlayerData dataType) {
		// TODO Auto-generated method stub
		return playerController.pickUpPlayersByCondition(position, zone, district,standard, dataType);
	}
	
	

	
}
