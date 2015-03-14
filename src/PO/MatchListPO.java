package PO;

import java.util.ArrayList;

public class MatchListPO {
	public static ArrayList<MatchPO> allMatchListOf13_14 ;
	
	public MatchListPO(){
		allMatchListOf13_14 = new ArrayList<MatchPO>();
	}
	
	public void addMatch(MatchPO newMatch){
		allMatchListOf13_14.add(newMatch) ;
	}
	
}
