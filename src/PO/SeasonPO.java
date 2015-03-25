package PO;

import java.util.ArrayList;

import Enum.Season;

public class SeasonPO {
	Season season;
	ArrayList<MatchPO> matches;
	
	public SeasonPO(Season season){
		this.season=season;
		matches=new ArrayList<MatchPO>();
	}
	public void addMatch(MatchPO oneMatch){
		matches.add(oneMatch);
	}
	public MatchPO findMatchByName(String matchName){
		for(MatchPO match: matches){
			if(match.getName().equals(matchName))
				return match;
		}
		return null;
	}
	public Season getSeason() {
		return season;
	}
	public ArrayList<MatchPO> getMatches() {
		return matches;
	}
	
	
	
}
