import java.util.ArrayList;
import java.io.Serializable;

public class Twosome implements Serializable{
	static final long serialVersionUID = 424L;
	
	private Player player1;
	private Player player2;
	private ArrayList<Score> scores1;
	private ArrayList<Score> scores2;
	private int seed1;
	private int seed2;
	private int numWins;
	private int numMatches;
	
	public Twosome(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		seed1 = player1.getSeed();
		seed2 = player2.getSeed();
		scores1 = new ArrayList<Score>();
		scores2 = new ArrayList<Score>();
		numWins = 0;
		numMatches = 0;
	}

	public int getNumMatches() {
		return numMatches;
	}

	public void setNumMatches(int numMatches) {
		this.numMatches = numMatches;
	}

	public void setNumWins(int numWins) {
		this.numWins = numWins;
	}

	public int getSeed1() {
		return seed1;
	}

	public void setSeed1(int seed1) {
		this.seed1 = seed1;
	}

	public int getSeed2() {
		return seed2;
	}

	public void setSeed2(int seed2) {
		this.seed2 = seed2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public ArrayList<Score> getScores1() {
		return scores1;
	}

	public ArrayList<Score> getScores2() {
		return scores2;
	}

	public void setScores2(ArrayList<Score> scores2) {
		this.scores2 = scores2;
	}

	public void setScores1(ArrayList<Score> scores) {
		this.scores1 = scores;
	}

	public double getAvgComb() {
		double sum = 0;
		for(int i = 0; i < scores1.size(); i++) {
			sum += scores1.get(i).getScore() + scores2.get(i).getScore();
		}
		return sum / scores1.size();
	}

	public double getAvg() {
		return getAvgComb() / 2;
	}
	
	public int getNumWins() {
		return numWins;
	}
	public String getWinRate() {
		return String.format("%.3f", 100.0 * numWins / numMatches);
	}
	public void addWin() {
		numWins++;
		numMatches++;
	}
	public void addLoss() {
		numMatches++;
	}
	public String toString() {
		String s = "";
		s += player1.getName() + " " + player2.getName() + "average" + getAvgComb() + " " + numWins + " " + numMatches; 
		return s;
	}
}
