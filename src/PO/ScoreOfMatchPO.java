package PO;

public class ScoreOfMatchPO {
	String scores;
	int firstScore;
	int secondScore;
	
	public ScoreOfMatchPO(String s){
		scores=s;
		String[] tmp=s.split("-");
		firstScore=Integer.parseInt(tmp[0]);
		secondScore=Integer.parseInt(tmp[1]);
	}
	public ScoreOfMatchPO(int first,int second){
		scores = first+"-"+second ;
		firstScore = first ;
		secondScore = second ;
	}

	public String getScores() {
		return scores;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}
	
	
}
