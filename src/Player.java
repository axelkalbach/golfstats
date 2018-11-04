import java.util.ArrayList;
import java.io.Serializable;

public class Player implements Serializable{
	
	static final long serialVersionUID = 420L;
	
	private String name;
	
	private String lastName;
	
	private double numericAverage;
	
	private double relativeAverage;
	
	private ArrayList<Score> scores;
	
	private int numUsed;
	
	private int seed;

	public Player(String n, int seed) {
		
		name = n;
		numericAverage = 0;
		relativeAverage = 0;
		scores = new ArrayList<Score>();
		this.seed = seed;
	}
	public Player(String n, String ln, int seed) {
		
		name = n;
		lastName = ln;
		numericAverage = 0;
		relativeAverage = 0;
		scores = new ArrayList<Score>();
		this.seed = seed;
	}
	
	public String toString(){
		
		String s = name + " " + lastName + "\n\n";
		s += "|Score |Date      |Course            |\n";
		for(int i = 0; i < scores.size(); i++) {
			s += scores.get(i) + "\n";
		}
		s += String.format("\nNumeric Average       |%.4f\n", numericAverage);
		s += String.format("Relative Average      |%s\n", getRelativeAverage());
		s += String.format("Home Average          |%s\n", getHomeRelativeAverage());
		s += String.format("Away Average          |%s\n", getAwayRelativeAverage());
		s += String.format("Number of Used Scores |%s\n", numUsed);
		s += String.format("Percent of Scores Used|%s\n", String.format("%.4f", 100.0 * numUsed / scores.size()) + "%");
		s += String.format("Number of Matches     |%s\n", scores.size());
		s += String.format("Num. of Wins ag. opp. |%s\n", getNumWins());
		s += String.format("Win Rate against opp. |%s\n", getWinRate());
		return s;
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void calcAverage() {
		double sum = 0;
		for(int i = 0; i < scores.size(); i++) {
			sum += scores.get(i).getScore();
		}
		if(sum > 0) numericAverage = sum / scores.size();
		sum = 0;
		for(int i = 0; i < scores.size(); i++) {
			sum += scores.get(i).getRelPar();
		}
		if(sum != 0) relativeAverage = sum / scores.size();
	}
	public String getHomeRelativeAverage() {
		double sum = 0;
		int count = 0;
		for(int i = 0; i < scores.size(); i++) {
			if(scores.get(i).getHa()) {
				sum += scores.get(i).getScore() - scores.get(i).getPar();
				count++;
			}
		}
		double f = sum / count;
		if(f > 0) {
			return "+" + String.format("%.5f", f);
		}
		else if(f < 0) {
			return "-" + String.format("%.5f", f);
		}
		else {
			return "E";
		}
	}
	
	public String getAwayRelativeAverage() {
		double sum = 0;
		int count = 0;
		for(int i = 0; i < scores.size(); i++) {
			if(!scores.get(i).getHa()) {
				sum += scores.get(i).getScore() - scores.get(i).getPar();
				count++;
			}
		}
		double f = sum / count;
		if(f > 0) {
			return "+" + String.format("%.5f", f);
		}
		else if(f < 0) {
			return "-" + String.format("%.5f", f);
		}
		else {
			return "E";
		}
	}
	
	public int getTotalScore() {
		int sum = 0;
		for(int i = 0; i < scores.size(); i++) {
			sum += scores.get(i).getScore();
		}
		return sum;
	}
	
	public String getPercentUsed() {
		if(scores.size() > 0) {
			double percent = 100.0 * numUsed / scores.size();
			return String.format("%.1f", percent) + "%";
		}
		return "0.0%";
		
	}
	public int getNumWins() {
		int numWins = 0;
		for(int i = 0; i < scores.size(); i++) {
			if(scores.get(i).getResult()) {
				numWins++;
			}
		}
		return numWins;
	}
	public String getWinRate() {
		return String.format("%.3f", ((double) getNumWins()) * 100 / scores.size()) + "%";
	}
	
	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}
	
	public int getNumUsed() {
		return numUsed;
	}

	public void setNumUsed(int numUsed) {
		this.numUsed = numUsed;
	}

	public void incrementUsed() {
		numUsed++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNumericAverage() {
		return numericAverage;
	}

	public void setNumericAverage(double numericAverage) {
		this.numericAverage = numericAverage;
	}

	public String getRelativeAverage() {
		String r = String.format("%.4f", relativeAverage);
		if(relativeAverage > 0) {
			return "+" + r;
		}
		else if(relativeAverage == 0) {
			return "E";
		}
		return r;
	}
	public double getRelativeAverageNumber() {
		return relativeAverage;
	}

	public void setRelativeAverage(double relativeAverage) {
		this.relativeAverage = relativeAverage;
	}
	public ArrayList<Score> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Score> scores) {
		this.scores = scores;
	}

	public void addScore(int par, int score, String date, String course, boolean used, boolean result, boolean ha) {
		scores.add(new Score(par, score, date, course, used, result, ha));
	}
	
	public void addScore(int par, int score, String date) {
		scores.add(new Score(par, score, date));
	}
	public void addScore(int par, int score, String date, String course) {
		scores.add(new Score(par, score, date, course));
	}
}
