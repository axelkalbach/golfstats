import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Driver {

	static ArrayList<Team> teams;

	static Team subs;

	static Team sf;
	/**
	 * reads user input and does appropriate actions
	 * @param args arguments form the command line
	 * @throws IOException exceptions thrown when input is bad
	 */
	public static void main(String[] args) throws IOException {

		int input = 0;
		teams = new ArrayList<Team>();
		read();
		sf = teams.get(0);
		subs = teams.get(1);
//		sf.getPlayers().get(0).setNumUsed(sf.getPlayers().get(0).getNumUsed() - 1);
//		sf.getPlayers().get(1).setNumUsed(sf.getPlayers().get(1).getNumUsed() - 1);
//		sf.getPlayers().get(2).setNumUsed(sf.getPlayers().get(2).getNumUsed() - 1);
//		sf.getPlayers().get(3).setNumUsed(sf.getPlayers().get(3).getNumUsed() - 1);
//		sf.getPlayers().get(5).setNumUsed(sf.getPlayers().get(5).getNumUsed() - 1);
//		sf.getPlayers().get(0).getScores().remove(sf.getPlayers().get(0).getScores().size() - 1);
//		sf.getPlayers().get(1).getScores().remove(sf.getPlayers().get(1).getScores().size() - 1);
//		sf.getPlayers().get(2).getScores().remove(sf.getPlayers().get(2).getScores().size() - 1);
//		sf.getPlayers().get(3).getScores().remove(sf.getPlayers().get(3).getScores().size() - 1);
//		sf.getPlayers().get(4).getScores().remove(sf.getPlayers().get(4).getScores().size() - 1);
//		sf.getPlayers().get(5).getScores().remove(sf.getPlayers().get(5).getScores().size() - 1);
//		sf.getPlayers().get(6).getScores().remove(sf.getPlayers().get(6).getScores().size() - 1);
//		sf.getPlayers().get(7).getScores().remove(sf.getPlayers().get(7).getScores().size() - 1);
//		sf.getMatches().remove(sf.getMatches().size()- 1); 
//		sf.getTwosomes().get(0).getScores1().remove(sf.getTwosomes().get(0).getScores1().size() - 1);
//		sf.getTwosomes().get(0).getScores2().remove(sf.getTwosomes().get(0).getScores2().size() - 1);
//		sf.getTwosomes().get(1).getScores1().remove(sf.getTwosomes().get(1).getScores1().size() - 1);
//		sf.getTwosomes().get(1).getScores2().remove(sf.getTwosomes().get(1).getScores2().size() - 1);
//		sf.getTwosomes().get(2).getScores1().remove(sf.getTwosomes().get(2).getScores1().size() - 1);
//		sf.getTwosomes().get(2).getScores2().remove(sf.getTwosomes().get(2).getScores2().size() - 1);
//		sf.getTwosomes().get(3).getScores1().remove(sf.getTwosomes().get(3).getScores1().size() - 1);
//		sf.getTwosomes().get(3).getScores2().remove(sf.getTwosomes().get(3).getScores2().size() - 1);
		for(int i = 0; i < subs.getTwosomes().size(); i++) {
			System.out.println(subs.getTwosomes().get(i));
		}
		Player temp = sf.getPlayers().get(6);
		sf.getPlayers().set(6, sf.getPlayers().get(7));
		sf.getPlayers().set(7, temp);
		sf.getTwosomes().get(3).setPlayer1(sf.getTwosomes().get(3).getPlayer2());
		sf.getTwosomes().get(3).setPlayer2(temp);
		while(input != 7) {
			input = processInput();
		}

		write();
	}
	/**
	 * processes input
	 * @return input from user
	 */
	public static int processInput() {

		int choose = Input.readNum("\n1. Team Stats\n2. Player Stats\n3. Twosome Stats\n4. All Stats\n5. Add Match\n6. Other Options\n7. Quit\n\n>", 1, 7);
		if(choose == 1) {
			teamStats();
		}

		else if(choose == 2) {
			playerStats();
		}

		else if(choose == 3) {
			twosomeStats();
		}

		else if(choose == 4) {
			allStats();
		}

		else if(choose == 5) {
			addMatch();
		}

		else if(choose == 6) {
			otherOptions();
		}

		return choose;
	}

	public static void swap(ArrayList<Player> arr, int i, int j) {
		Player temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

	public static void teamStats() {
		int choose2 = 0;
		System.out.println("\n     T E A M   S T A T S\n");
		System.out.printf("Average Match Score      | %.4f\n", sf.getScoringAverage());
		System.out.printf("Average Match Rel Score  | +%.4f\n", sf.getRelAverage());
		System.out.printf("Average Home Score       | +%.4f\n", sf.getHomeAverage());
		System.out.printf("Average Away Score       | +%.4f\n", sf.getAwayAverage());
		System.out.printf("Average Total Score      | %.4f\n", sf.getTotalAverage());
		System.out.printf("Average Indiv. Used Score| %.4f\n", sf.getIndividualUsedAverage());
		System.out.printf("Average Indiv. Score     | %.4f\n", sf.getIndividualAverage());
		
		while(choose2 != sf.getMatches().size() + 1) {
			System.out.println("\n                       M A T C H E S\n");
			System.out.println("|#  |Result|Opponent       |Score  |Par|Date      |Home/Away|Course            |");
			int i = 0;
			for(i = 0; i < sf.getMatches().size(); i++) {
				System.out.printf("|%-3s|%-6s|%-15s|%-7s|%-3s|%-10s|%-9s|%-18s|\n", i + 1 + ".", sf.getMatches().get(i).getResult(), sf.getMatches().get(i).getTeam2().getTeamName(),
						sf.getMatches().get(i).getTeam1Score() + "-" + sf.getMatches().get(i).getTeam2Score(), sf.getMatches().get(i).getScores1().get(0).getPar(), sf.getMatches().get(i).getDate(), sf.getMatches().get(i).getHomeAway(),
						sf.getMatches().get(i).getCourse());
			}
			choose2 = Input.readNum("\n|" + (i + 1) + ".|Back\n\n>", 1, i + 1);

			if(choose2 < sf.getMatches().size() + 1) {
				System.out.println("\n" + sf.getMatches().get(choose2 - 1));
			}
		}
	}

	public static void playerStats() {
		int choose2 = 0;
		while(choose2 != sf.getPlayers().size() + 1) {
			System.out.println("\n                P L A Y E R   S T A T S\n");
			System.out.println("|# |Name   |Num Avg|Rel Avg|Num Used|% Used|Num Wins|Win Rate|Home Avg|Away Avg|");
			int i = 0;
			for(i = 0; i < sf.getPlayers().size(); i++) {
				System.out.printf("|%-2s|%-7s|%-7.4f|%-7s|%-8s|%-6s|%-8s|%-8s|%-8s|%-8s|\n", i + 1 + ".", sf.getPlayers().get(i).getName(), sf.getPlayers().get(i).getNumericAverage(),
						sf.getPlayers().get(i).getRelativeAverage(), sf.getPlayers().get(i).getNumUsed() + "/" + sf.getPlayers().get(i).getScores().size(), sf.getPlayers().get(i).getPercentUsed(), 
						sf.getPlayers().get(i).getNumWins() + "/" + sf.getPlayers().get(i).getScores().size(),
						sf.getPlayers().get(i).getWinRate(), sf.getPlayers().get(i).getHomeRelativeAverage(), sf.getPlayers().get(i).getAwayRelativeAverage());
			}
			choose2 = Input.readNum("\n|" + (i + 1) + ".|Back\n\n>", 1, i + 1);
			if(choose2 < sf.getPlayers().size() + 1) {
				System.out.println("\n" + sf.getPlayers().get(choose2 - 1));
			}
		}

	}

	public static void twosomeStats() {
		int choose2 = 0;

		while(choose2 != sf.getTwosomes().size() + 1) {
			System.out.println("\n                T W O S O M E   S T A T S\n");
			System.out.println("|#'s|Name 1|Name 2|Avg Comb|Avg   |Num Wins|Win Rate|");
			int i = 0;
			for(i = 0; i < sf.getTwosomes().size(); i++) {
				Twosome ts = sf.getTwosomes().get(i);
				System.out.printf("|%-3s|%-6s|%-6s|%-8.5f|%-6.3f|%-8s|%-8s|\n", ts.getSeed1() + "-" + ts.getSeed2(), ts.getPlayer1().getName(), ts.getPlayer2().getName(), ts.getAvgComb(),
						ts.getAvg(), ts.getNumWins() + "/" + ts.getNumMatches(), ts.getWinRate() + "%");
			}
			choose2 = Input.readNum("\n|" + (i + 1) + ".|Back\n\n>", 1, i + 1);

			if(choose2 < sf.getTwosomes().size() + 1) {
				System.out.println("\n" + sf.getTwosomes().get(choose2 - 1));
			}
		}
	}

	public static void allStats() {
		System.out.println("\n     T E A M   S T A T S\n");
		System.out.printf("Average Match Score      | %.4f\n", sf.getScoringAverage());
		System.out.printf("Average Match Rel Score  | +%.4f\n", sf.getRelAverage());
		System.out.printf("Average Home Score       | +%.4f\n", sf.getHomeAverage());
		System.out.printf("Average Away Score       | +%.4f\n", sf.getAwayAverage());
		System.out.printf("Average Total Score      | %.4f\n", sf.getTotalAverage());
		System.out.printf("Average Indiv. Used Score| %.4f\n", sf.getIndividualUsedAverage());
		System.out.printf("Average Indiv. Score     | %.4f\n", sf.getIndividualAverage());


		System.out.println("\n                       M A T C H E S\n");
		System.out.println("|#  |Result|Opponent       |Score  |Par|Date      |Home/Away|Course            |");
		int i = 0;
		for(i = 0; i < sf.getMatches().size(); i++) {
			System.out.printf("|%-3s|%-6s|%-15s|%-7s|%-3s|%-10s|%-9s|%-18s|\n", i + 1 + ".", sf.getMatches().get(i).getResult(), sf.getMatches().get(i).getTeam2().getTeamName(),
					sf.getMatches().get(i).getTeam1Score() + "-" + sf.getMatches().get(i).getTeam2Score(), sf.getMatches().get(i).getScores1().get(0).getPar(), sf.getMatches().get(i).getDate(), sf.getMatches().get(i).getHomeAway(),
					sf.getMatches().get(i).getCourse());
		}
		System.out.println("\n                P L A Y E R   S T A T S\n");
		System.out.println("|# |Name   |Num Avg|Rel Avg|Num Used|% Used|Num Wins|Win Rate|Home Avg|Away Avg|");
		for(i = 0; i < sf.getPlayers().size(); i++) {
			System.out.printf("|%-2s|%-7s|%-7.4f|%-7s|%-8s|%-6s|%-8s|%-8s|%-8s|%-8s|\n", i + 1 + ".", sf.getPlayers().get(i).getName(), sf.getPlayers().get(i).getNumericAverage(),
					sf.getPlayers().get(i).getRelativeAverage(), sf.getPlayers().get(i).getNumUsed() + "/" + sf.getPlayers().get(i).getScores().size(), sf.getPlayers().get(i).getPercentUsed(), 
					sf.getPlayers().get(i).getNumWins() + "/" + sf.getPlayers().get(i).getScores().size(),
					sf.getPlayers().get(i).getWinRate(), sf.getPlayers().get(i).getHomeRelativeAverage(), sf.getPlayers().get(i).getAwayRelativeAverage());
		}
		System.out.println("\n                T W O S O M E   S T A T S\n");
		System.out.println("|#'s|Name 1|Name 2|Avg Comb|Avg   |Num Wins|Win Rate|");
		for(i = 0; i < sf.getTwosomes().size(); i++) {
			Twosome ts = sf.getTwosomes().get(i);
			System.out.printf("|%-3s|%-6s|%-6s|%-8.5f|%-6.3f|%-8s|%-8s|\n", ts.getSeed1() + "-" + ts.getSeed2(), ts.getPlayer1().getName(), ts.getPlayer2().getName(), ts.getAvgComb(),
					ts.getAvg(), ts.getNumWins() + "/" + ts.getNumMatches(), ts.getWinRate() + "%");
		}
		ArrayList<Player> arr = new ArrayList<Player>();
		for(i = 0; i < sf.getPlayers().size(); i++) {
			arr.add(sf.getPlayers().get(i));
		}
		for(i = 0; i < arr.size(); i++) {

			for(int j = 0; j < arr.size() - i - 1; j++) {

				if(arr.get(j).getNumericAverage() > (arr.get(j + 1).getNumericAverage())) {
					swap(arr, j, j + 1);
				}
			}
		}
		System.out.println("\n  L E A D E R B O A R D");
		System.out.println("\n|# |Name  |Sd|Num Avg|Rel Avg|Pts Back|");
		for(i = 0; i < arr.size(); i++) {
			System.out.printf("|%s.|%-6s|%s.|%-7.4f|%-7s|%-8s|\n", (i + 1), arr.get(i).getName(), arr.get(i).getSeed(), 
					arr.get(i).getNumericAverage(), arr.get(i).getRelativeAverage(), arr.get(i).getTotalScore() - arr.get(0).getTotalScore());
		}
	}

	public static void addMatch() {
		System.out.println("\nAdding New Match...\n");
		String date = Input.readString("Date: ");
		String opp = Input.readString("Opponent: ");
		String ha = Input.readString("Home or Away: ");
		boolean homeAway = true;
		if(ha.substring(0, 1).equalsIgnoreCase("a")) {
			homeAway = false;
		}
		String course;
		int par;
		if(!homeAway) {
			course = Input.readString("Course: ");
			par = Input.readNum(9, "Par: ");
		}
		else {
			course = "Turtle Creek";
			par = 36;
		}
		Team opponent = new Team(opp, false); 
		teams.add(opponent);
		Match match = new Match(sf, opponent, date, course, homeAway);
		int score;

		int[] arr = new int[8];
		int[] arr2 = new int[8];
		for(int i = 0; i < 8; i++) {
			score = Input.readNum(9, match.getTeam1().getPlayers().get(i).getName() + ": ");
			if(i % 2 == 0) {
				sf.getTwosomes().get((int) Math.floor(i / 2)).getScores1().add(new Score(par, score, date));
			}
			else {
				sf.getTwosomes().get((int) Math.floor(i / 2)).getScores2().add(new Score(par, score, date));
			}
			arr[i] = score;
		}
		for(int i = 0; i < 8; i++) {
			score = Input.readNum(9, match.getTeam2().getPlayers().get(i).getName() + ": ");
			match.getTeam2().getPlayers().get(i).addScore(par, score, date);
			arr2[i] = score;
		}

		int max = 0;
		int index = 0;
		for(int i = 0; i < 3; i++) {
			max = 0;
			index = 0;
			for(int j = arr.length - 1; j >= 0; j--) {
				if(arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			arr[index] -= 2 * arr[index];
		}
		for(int i = 0; i < 3; i++) {
			max = 0;
			index = 0;
			for(int j = arr2.length - 1; j >= 0; j--) {
				if(arr2[j] > max) {
					max = arr2[j];
					index = j;
				}
			}
			arr2[index] -= 2 * arr2[index];
		}
		boolean result;
		for(int j = 0; j < arr.length; j++) {
			result = true;
			if(Math.abs(arr[j]) > Math.abs(arr2[j])) {
				result = false;
			}
			if(arr[j] > 0) {
				match.getTeam1().getPlayers().get(j).addScore(par, arr[j], date, course, true, result, homeAway);
				match.getScores1().add(new Score(par, arr[j], date, course, true, result, homeAway));
				match.getTeam1().getPlayers().get(j).incrementUsed();
			}
			else {
				match.getTeam1().getPlayers().get(j).addScore(par, arr[j] - 2 * arr[j], date, course, false, result, homeAway);
				match.getScores1().add(new Score(par, arr[j] - 2 * arr[j], date, course, false, result, homeAway));
			}
			if(arr2[j] > 0) {
				match.getScores2().add(new Score(par, arr2[j], date, true));
			}
			else {
				match.getScores2().add(new Score(par, arr2[j] - 2 * arr2[j], date, false));
			}
			match.getTeam1().getPlayers().get(j).calcAverage();
		}
		for(int i = 0; i < 4; i++) {
			//if twosome won
			if(match.getScores1().get(i * 2).getScore() + match.getScores1().get(i * 2 + 1).getScore() < match.getScores2().get(i * 2).getScore() + match.getScores2().get(i * 2 + 1).getScore()) {
				sf.getTwosomes().get(i).addWin();
			}
			//if they lost
			else{
				sf.getTwosomes().get(i).addLoss();
			}
		}
		sf.getMatches().add(match);
		match.calcScores();
	}

	public static void otherOptions() {
		int choose2 = 0;
		while(choose2 != 8) {
			System.out.println("");
			choose2 = Input.readNum("1. Clear all\n2. Display Players in Order of Average\n3. Change Seedings\n"
					+ "4. Get Recent Match Summary\n5. Remove Match\n6. Sub\n7. Add Individual Scores\n8. Back\n\n>", 1, 8);
			if(choose2 == 1) {
				teams.clear();
				teams.add(new Team("Spring-Ford", true));
				teams.add(new Team("Subs"));
			}
			else if(choose2 == 2) {
				ArrayList<Player> arr = new ArrayList<Player>();
				for(int i = 0; i < sf.getPlayers().size(); i++) {
					arr.add(sf.getPlayers().get(i));
				}
				for(int i = 0; i < arr.size(); i++) {

					for(int j = 0; j < arr.size() - i - 1; j++) {

						if(arr.get(j).getNumericAverage() > (arr.get(j + 1).getNumericAverage())) {
							swap(arr, j, j + 1);
						}
					}
				}
				System.out.println("\n|# |Name  |Sd|Num Avg|Rel Avg|Pts Back|");
				for(int i = 0; i < arr.size(); i++) {
					System.out.printf("|%s.|%-6s|%s.|%-7.4f|%-7s|%-8s|\n", (i + 1), arr.get(i).getName(), arr.get(i).getSeed(), 
							arr.get(i).getNumericAverage(), arr.get(i).getRelativeAverage(), arr.get(i).getTotalScore() - arr.get(0).getTotalScore());
				}
			}
			else if(choose2 == 3) {
				ArrayList<Twosome> kept = new ArrayList<Twosome>();
				ArrayList<Player> change = new ArrayList<Player>();
				for(int i = 0; i < 4; i++) {
					System.out.println(sf.getTwosomes().get(i).getPlayer1().getName() + " and " + sf.getTwosomes().get(i).getPlayer2().getName());
					String keep = Input.readString("Keep? ");
					if(keep.substring(0, 1).equalsIgnoreCase("y")) {
						kept.add(sf.getTwosomes().get(i));
					}
					else  {
						change.add(sf.getTwosomes().get(i).getPlayer1());
						change.add(sf.getTwosomes().get(i).getPlayer2());
					}

				}
				for(int i = 0; i < kept.size(); i++) {
					System.out.println(kept.get(i).getPlayer1().getName() + " and " + kept.get(i).getPlayer2().getName());
					int choose3 = Input.readNum("Seed: " , 1, 4);
					sf.getTwosomes().set(choose3 - 1, kept.get(i));
				}
				while(change.size() > 0) {
					for(int j = 0; j < change.size(); j++) {
						System.out.println((j + 1) + ". " + change.get(j).getName());
					}
					int one = Input.readNum("\nTwosome:\nFirst Player in Twosome: ", 1, change.size());
					int two = Input.readNum("Second Player Player in Twosome: ", 1, change.size());
					int seed = Input.readNum("Seed of Twosome: ", 1, change.size());
					sf.getTwosomes().set(seed - 1, new Twosome(change.get(one - 1), change.get(two - 1)));
					if(two > one) {
						change.remove(two - 1);
						change.remove(one - 1);
					}
					else {
						change.remove(one - 1);
						change.remove(two - 1);
					}
				}
				for(int i = 0; i < 4; i++) {
					sf.getPlayers().set(i * 2, sf.getTwosomes().get(i).getPlayer1());
					sf.getPlayers().set(i * 2 + 1, sf.getTwosomes().get(i).getPlayer2());
					sf.getTwosomes().get(i).setSeed1(i * 2 + 1);
					sf.getTwosomes().get(i).setSeed2(i * 2 + 2);
				}
				for(int i = 0; i < 8; i++) {
					sf.getPlayers().get(i).setSeed(i + 1);
				}
				for(int i = 0; i < 4; i++) {
					sf.getTwosomes().get(i).getPlayer1().setSeed(i * 2 + 1);
					sf.getTwosomes().get(i).getPlayer2().setSeed(i * 2 + 2);
				}
			}
			else if(choose2 == 4) {
				Match match = sf.getMatches().get(sf.getMatches().size() - 2);
				System.out.println("\n" + match + "\n");
				String ab;
				String ab2;
				if(match.getTeam1Score() > sf.getScoringAverage()) {
					ab = "Above Average";
				}
				else if(match.getTeam1Score() < sf.getScoringAverage()) {
					ab = "Below Average";
				}
				else {
					ab = "Average";
				}
				if(match.getHomeAway().equals("Home")) {
					if(match.getTeam1Score() - 5 * match.getScores1().get(0).getPar() > sf.getHomeAverage()) {
						ab2 = "Above Home Average";
					}
					else if(match.getTeam1Score() - 5 * match.getScores1().get(0).getPar() < sf.getHomeAverage()) {
						ab2 = "Below Home Average";
					}
					else {
						ab2 = "Average for Home";
					}
				}
				else {
					if(match.getTeam1Score() - 5 * match.getScores1().get(0).getPar() > sf.getAwayAverage()) {
						ab2 = "Above Away Average";
					}
					else if(match.getTeam1Score() - 5 * match.getScores1().get(0).getPar() < sf.getAwayAverage()) {
						ab2 = "Below Away Average";
					}
					else {
						ab2 = "Average for Away";
					}
				}
				System.out.println(match.getTeam1Score() + ": " + ab + ", " + ab2 + "\n");
				if(match.getTotalTeam1Score() > sf.getTotalAverage()) {
					ab = "Above Average";
				}
				else if(match.getTotalTeam1Score() < sf.getTotalAverage()) {
					ab = "Below Average";
				}
				else {
					ab = "Average";
				}

				System.out.println(match.getTotalTeam1Score() + ": " + ab);
				for(int i = 0; i < 8; i++) {
					if(match.getScores1().get(i).getScore() > sf.getPlayers().get(i).getNumericAverage()) {
						ab = "Above Average";
					}
					else if(match.getScores1().get(i).getScore() < sf.getPlayers().get(i).getNumericAverage()) {
						ab = "Below Average";
						
					}
					else {
						ab = "Average";
					}
					System.out.printf("\n%-6s|%-2s|%-13s|", sf.getPlayers().get(i).getName(), match.getScores1().get(i).getScore(), ab);
				}
				System.out.println("");
			}
			else if(choose2 == 5) {
				for(int i = 0; i < sf.getMatches().size(); i++) {
					System.out.println((i + 1) + ". " + sf.getMatches().get(i).getTeam2().getTeamName()); 

				}
				int choose3 = Input.readNum("Remove: ", 1, sf.getMatches().size());
				sf.getMatches().remove(choose3 - 1);
			}
			else if(choose2 == 6) {
				int choose3 = Input.readNum("1. New\n2. Old\n3. Old Twosome", 1, 3);
				if(choose3 == 1) {
					String n = Input.readString("First Name: ");
					String ln = Input.readString("Last Name: ");
					Player temp = sf.getPlayers().remove(7);
					sf.getPlayers().add(new Player(n, ln, 8));
					subs.getPlayers().add(temp);
					Twosome t = sf.getTwosomes().remove(3);
					subs.getTwosomes().add(t);
					sf.getTwosomes().add(new Twosome(sf.getPlayers().get(6), sf.getPlayers().get(7)));
				}
				else if(choose3 == 3) {
					for(int i = 0; i < subs.getTwosomes().size(); i++) {
						System.out.println((i + 1) + ": " + subs.getTwosomes().get(i).getPlayer1().getName() + " and " + subs.getTwosomes().get(i).getPlayer2().getName()); 
					}
					int choose4 = Input.readNum(">", 1, subs.getTwosomes().size());
					Twosome t = sf.getTwosomes().remove(3);
					sf.getTwosomes().add(subs.getTwosomes().remove(choose4 - 1));
					subs.getTwosomes().add(t);
					Player temp = sf.getPlayers().remove(7);
					sf.getPlayers().add(sf.getTwosomes().get(3).getPlayer2());
					sf.getPlayers().set(6, sf.getTwosomes().get(3).getPlayer1());
					subs.getPlayers().add(temp);
				}
			}
			else if(choose2 == 7) {
				String date = Input.readString("Date: ");
				String course = Input.readString("Course: ");
				int par = Input.readNum(9, "Par: ");
				int score;
				for(int i = 0; i < 8; i++) {
					score = Input.readNum(9, sf.getPlayers().get(i).getName() + ": ");
					sf.getPlayers().get(i).addScore(par, score, date, course);
					sf.getPlayers().get(i).calcAverage();
				}
			}
		}
	}
	/**
	 * writes the list to a .dat file 
	 * @throws IOException exception thrown if input is bad
	 */
	public static void write() throws IOException {
		try {
			FileOutputStream outputStream = new FileOutputStream("C:\\Eclipse\\GolfStats\\src\\file.dat");
			ObjectOutputStream output = new ObjectOutputStream(outputStream);

			output.writeObject(teams);

			output.close();
			outputStream.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("Cannot write to file");
		}
	}
	/**
	 * reads the list from the .dat file
	 * @throws IOException exception thrown if file is bad
	 */
	public static void read() throws IOException {
		try {
			FileInputStream inputStream = new FileInputStream("C:\\Eclipse\\GolfStats\\src\\file.dat");
			ObjectInputStream input = new ObjectInputStream(inputStream);

			try {
				teams = (ArrayList<Team>)input.readObject();
			} 

			catch (IOException | ClassNotFoundException e) {
				System.out.println("Cannot read file");
			} 

			input.close();
			inputStream.close();

		} 

		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("No existing file");
		} 
	}
}