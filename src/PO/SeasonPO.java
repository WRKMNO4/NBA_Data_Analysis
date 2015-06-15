package PO;

import java.util.ArrayList;

import Enum.Season;

public class SeasonPO {
	Season season;
	MatchListPO matches;

	
	
	
	/*
	 * 返回该赛季所有球员的场均得分，场均篮板，场均助攻，场均抢断，场均盖帽，场均失误，场均犯规
	 */
	public ArrayList<Double> getAvgDataOfAllPlayer(){
		double avgOfScore = 0;
		double avgOfNumberOfRebound = 0;
		double avgOfNumberOfAssist = 0 ;
		double avgOfNumberOfSteal = 0 ;
		double avgOfNumberOfBlock = 0 ;
		double avgOfNumberOfFault = 0 ;
		double avgOfNumberOfFoul = 0 ;
		
		
		ArrayList<PlayerPO> players = PlayerListPO.getAllPlayers() ;
		for(PlayerPO onePlayer : players){
			PlayerDataPO avgData = onePlayer.getSeasonInfo(this.season).getAveragePlayerData();
			avgOfScore += ifNaN(avgData.getScore()) ;
			avgOfNumberOfRebound += ifNaN(avgData.getNumberOfRebound()) ;
			avgOfNumberOfAssist += ifNaN(avgData.getNumberOfAssist()) ;
			avgOfNumberOfSteal += ifNaN(avgData.getNumberOfSteal()) ;
			avgOfNumberOfBlock += ifNaN(avgData.getNumberOfBlock()) ;
			avgOfNumberOfFault += ifNaN(avgData.getNumberOfFault()) ;
			avgOfNumberOfFoul += ifNaN(avgData.getNumberOfFoul()) ;
		}
		avgOfScore = avgOfScore/players.size() ;
		avgOfNumberOfRebound = avgOfNumberOfRebound / players.size() ;
		avgOfNumberOfAssist = avgOfNumberOfAssist / players.size() ;
		avgOfNumberOfSteal = avgOfNumberOfSteal / players.size() ;
		avgOfNumberOfBlock = avgOfNumberOfBlock / players.size() ;
		avgOfNumberOfFault = avgOfNumberOfFault / players.size() ;
		avgOfNumberOfFoul = avgOfNumberOfFoul / players.size() ;
		
		ArrayList<Double> results = new ArrayList<>() ;
		results.add(avgOfScore) ;
		results.add(avgOfNumberOfRebound) ;
		results.add(avgOfNumberOfAssist) ;
		results.add(avgOfNumberOfSteal) ;
		results.add(avgOfNumberOfBlock) ;
		results.add(avgOfNumberOfFault) ;
		results.add(avgOfNumberOfFoul) ;
		return results ;
	}
	private double ifNaN(double number){
		if(number == Double.NaN)
			return 0;
		else 
			return number ;
	}
	
	
	
	
	
	public SeasonPO(Season season){
		this.season=season;
		matches=new MatchListPO();
	}
	
	public void addMatch(MatchPO oneMatch){
		matches.addMatch(oneMatch);
	}
	
	public MatchPO findMatch(String date,String nameOfTeams){
		for(MatchPO match: matches.getMatches()){
			if(match.getDate().equals(date) && match.getFirstTeam().equals(nameOfTeams.substring(0,3))) 
				return match;
		}
		return null;
	}
	
	public Season getSeason() {
		return season;
	}
	
	public ArrayList<MatchPO> getMatches() {
		return matches.getMatches();
	}
	
	
	
}
