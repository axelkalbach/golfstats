import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable{
	static final long serialVersionUID = 422L;
	private String teamName;
	private ArrayList<Player> players;
	private ArrayList<Twosome> twosomes;
	private ArrayList<Match> matches;
	private int numWins; 
	private boolean side;
	
	public Team(String name, boolean side) {
		teamName = name;
		players = new ArrayList<Player>();
		matches = new ArrayList<Match>();
		twosomes = new ArrayList<Twosome>();
		numWins = 0;
		if(!side) {
			players.add(new Player(teamName + " Player 1", 1));
			players.add(new Player(teamName + " Player 2", 2));
			players.add(new Player(teamName + " Player 3", 3));
			players.add(new Player(teamName + " Player 4", 4));
			players.add(new Player(teamName + " Player 5", 5));
			players.add(new Player(teamName + " Player 6", 6));
			players.add(new Player(teamName + " Player 7", 7));
			players.add(new Player(teamName + " Player 8", 8));
			this.side = false;
		}
		else {
			players.add(new Player("Luke", "Watson", 1));
			players.add(new Player("Josh", "Brauer", 2));
			players.add(new Player("Nate", "Pierce", 3));
			players.add(new Player("Axel", "Kalbach", 4));
			players.add(new Player("Steven", "Stumpo", 5));
			players.add(new Player("Drew", "Clifford", 6));
			players.add(new Player("George", "Wicks", 7));
			players.add(new Player("Alex", "Johns", 8));
			twosomes.add(new Twosome(players.get(0), players.get(1)));
			twosomes.add(new Twosome(players.get(2), players.get(3)));
			twosomes.add(new Twosome(players.get(4), players.get(5)));
			twosomes.add(new Twosome(players.get(6), players.get(7)));
			this.side = true;
		}
	}
	public Team(String name) {
		teamName = name;
		players = new ArrayList<Player>();
		matches = new ArrayList<Match>();
		twosomes = new ArrayList<Twosome>();
		numWins = 0;
	}
	
	public ArrayList<Twosome> getTwosomes() {
		return twosomes;
	}

	public void setTwosomes(ArrayList<Twosome> twosomes) {
		this.twosomes = twosomes;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getNumWins() {
		return numWins;
	}
	public void setNumWins(int numWins) {
		this.numWins = numWins;
	}
	public boolean isSide() {
		return side;
	}
	public void setSide(boolean side) {
		this.side = side;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public ArrayList<Match> getMatches() {
		return matches;
	}
	public double getScoringAverage() {
		double sum = 0;
		for(int i = 0; i < matches.size(); i++) {
			sum += matches.get(i).getTeam1Score();
		}
		return sum / matches.size();
	}
	public double getRelAverage() {
		double sum = 0;
		for(int i = 0; i < matches.size(); i++) {
			sum += matches.get(i).getTeam1Score() - 5 * matches.get(i).getScores1().get(0).getPar();
		}
		return sum / matches.size();
	}
	public double getTotalAverage() {
		double sum = 0;
		for(int i = 0; i < matches.size(); i++) {
			for(int j = 0; j < matches.get(i).getScores1().size(); j++) {
				sum += matches.get(i).getScores1().get(j).getScore();
			}	
		}
		return sum / matches.size();
	}
	public double getHomeAverage() {
		double sum = 0;
		int numHomeMatches = 0;
		for(int i = 0; i < matches.size(); i++) {
			if(matches.get(i).getHomeAway().equals("Home")) {
				sum += matches.get(i).getTeam1Score() - 5 * matches.get(i).getScores1().get(0 ).getPar();
				numHomeMatches++;
			}
		}
		return sum / numHomeMatches;
	}
	public double getAwayAverage() {
		double sum = 0;
		int numAwayMatches = 0;
		for(int i = 0; i < matches.size(); i++) {
			if(matches.get(i).getHomeAway().equals("Away")) {
				sum += matches.get(i).getTeam1Score() - 5 * matches.get(i).getScores1().get(0).getPar();
				numAwayMatches++;
			}
		}
		return sum / numAwayMatches;
	}
	public double getIndividualAverage() {
		return getTotalAverage() / 8;
	}
	public double getIndividualUsedAverage() {
		return getScoringAverage() / 5;
	}
	
	
	public String toString() {
		return teamName;
	}
}
