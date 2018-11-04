import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Match implements Serializable{
	private Team team1, team2;
	private int team1Score, team2Score;
	private ArrayList<Score> scores1, scores2;
	private String date;
	private boolean homeAway;
	private String course;
	static final long serialVersionUID = 423L;
	
	public Match(Team team1, Team team2, String date, String course, boolean homeAway) {
		this.team1 = team1;
		this.team2 = team2;
		scores1 = new ArrayList<Score>();
		scores2 = new ArrayList<Score>();
		this.date = date;
		this.course = course;
		this.homeAway = homeAway;
	}
	
	public String getResult() {
		if(getTeamScore(toArr(scores1)) < getTeamScore(toArr(scores2))) {
			return "Win";
		}
		else if(getTeamScore(toArr(scores1)) > getTeamScore(toArr(scores2))) {
			return "Loss";
		}
		String s = Input.readString("Did we win in scorecard playoff?");
		if(s.substring(0, 1).equalsIgnoreCase("y")) {
			return "Win";
		}
		return "Loss";
	}
	public void calcScores() {
		team1Score = getTeamScore(toArr(scores1));
		team2Score = getTeamScore(toArr(scores2));
	}
	
	public String getHomeAway() {
		if(homeAway) {
			return "Home";
		}
		return "Away";
	}

	public void setHomeAway(boolean homeAway) {
		this.homeAway = homeAway;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<Score> getScores1() {
		return scores1;
	}

	public void setScores1(ArrayList<Score> scores1) {
		this.scores1 = scores1;
	}

	public ArrayList<Score> getScores2() {
		return scores2;
	}

	public void setScores2(ArrayList<Score> scores2) {
		this.scores2 = scores2;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	public int getTeamScore(int[] arr) {
		int max = 0;
		int index = 0;
		for(int i = 0; i < 3; i++) {
			max = 0;
			index = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			arr[index] = 0;
		}
		int sum = 0;
		for(int j = 0; j < arr.length; j++) {
			sum += arr[j];
		}
		return sum;
	}
	public int getTotalTeam1Score() {
		int sum = 0;
		for(int i = 0; i < 8; i++) {
			sum += scores1.get(i).getScore();
		}
		return sum;
	}
	public int getTotalTeam2Score() {
		int sum = 0;
		for(int i = 0; i < 8; i++) {
			sum += scores2.get(i).getScore();
		}
		return sum;
	}
	public int[] toArr(ArrayList<Score> scores) {
		int[] arr = new int[scores.size()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scores.get(i).getScore();
		}
		return arr;
	}
	
	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	public void addScore1(int par, int score, String date) {
		scores1.add(new Score(par, score, date));
	}
	public void addScore2(int par, int score, String date) {
		scores2.add(new Score(par, score, date));
	}

	public String toString() {
		String fin = team1.getTeamName() + " vs. " + team2.getTeamName();
		fin += "\n" + getResult();
		fin += "\n" + date;
		fin += "\n" + getHomeAway();
		fin += "\n" + course;
		fin += "\n\n" + String.format("%-11s|%-11s\n", team1.getTeamName(), team2.getTeamName());
		String score1;
		String score2;
		for(int i = 0; i < 8; i++) {
			score1 = Integer.toString(scores1.get(i).getScore());
			score2 = Integer.toString(scores2.get(i).getScore());
			if(scores1.get(i).isUsed()) {
				score1 += "*";
			}
			if(scores2.get(i).isUsed()) {
				score2 += "*";
			}
			fin += String.format((i + 1) + ". %-8s|" + (i + 1) + ". %-8s\n", score1, score2);
		}
		fin += String.format("   %-8d|   %-8d", team1Score, team2Score);
		fin += String.format("\n   %-8d|   %-8d", getTotalTeam1Score(), getTotalTeam2Score());
		return fin;
	}
}
