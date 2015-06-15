package PO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MatchListPO {
	public ArrayList<MatchPO> allMatchList ;
	
	public MatchListPO(){
		allMatchList = new ArrayList<MatchPO>();
	}
	
	public void addMatch(MatchPO newMatch){
		allMatchList.add(newMatch) ;
	}
	
	public ArrayList<MatchPO> getMatches(){
		return allMatchList;
	}
	
	public int getSizeOfMatches(){
		return allMatchList.size();
	}
}
