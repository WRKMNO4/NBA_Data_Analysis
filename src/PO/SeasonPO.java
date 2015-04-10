package PO;

import java.util.ArrayList;

import Enum.Season;

public class SeasonPO {
	Season season;
	MatchListPO matches;
	
	public SeasonPO(Season season){
		this.season=season;
		matches=new MatchListPO();
	}
	public void addMatch(MatchPO oneMatch){
		matches.addMatch(oneMatch);
	}
	public MatchPO findMatch(String date,String nameOfTeams){
		for(MatchPO match: matches.getMatches()){
			if(match.getDate().equals(date) && match.getName().contains(nameOfTeams)) 
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
