package PO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MatchListPO {
	public ArrayList<MatchPO> allMatchListOf13_14 ;
	
	public MatchListPO(){
		allMatchListOf13_14 = new ArrayList<MatchPO>();
	}
	
	public void addMatch(MatchPO newMatch){
		allMatchListOf13_14.add(newMatch) ;
	}
	
	public ArrayList<MatchPO> getMatches(){
		return allMatchListOf13_14;
	}
	
}
