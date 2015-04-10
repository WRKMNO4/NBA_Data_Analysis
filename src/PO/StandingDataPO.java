package PO;

public class StandingDataPO {
	String playerName;
	String position;
	String team;
	
	double data;

	public StandingDataPO(String playerName, String position, String team, double data) {
		this.playerName = playerName;
		this.position = position;
		this.team = team;
		this.data = data;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPosition() {
		return position;
	}

	public String getTeam() {
		return team;
	}

	public double getData() {
		return data;
	}
	
	
	
	
}
