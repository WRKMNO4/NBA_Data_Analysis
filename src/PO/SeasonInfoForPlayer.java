package PO;

import java.util.ArrayList;

public class SeasonInfoForPlayer {
	ArrayList<PlayerDataOfOneMatchPO> datas=new ArrayList<PlayerDataOfOneMatchPO>();
	PlayerDataPO totalPlayerData = new PlayerDataPO();
	PlayerDataPO averagePlayerData = new PlayerDataPO() ;
	
	DataForFinalCalculationPO dataOfOtherTeam = new DataForFinalCalculationPO() ;
	String team="Unknown" ; 
	
	public void calculateFinalData(){
		TeamPO team = TeamListPO.findTeamByShortName(this.team) ;
		if(team==null){
			return;
		}
		totalPlayerData.calculatePlayerTotalDataInOneSeason(datas);
		averagePlayerData.calculatePlayerAverageDataInOneSeason(totalPlayerData,team.getTotalTeamData(),dataOfOtherTeam);
	}
	
	public void updateDataOfOtherData(int totalTime,TeamDataPO dataOfOtherTeam){
		this.dataOfOtherTeam.update(totalTime, dataOfOtherTeam) ;
	}
	public void addDataOfOneMatchOfOnePlayer(PlayerDataOfOneMatchPO onePlayer){
		datas.add(onePlayer);
	}
}
