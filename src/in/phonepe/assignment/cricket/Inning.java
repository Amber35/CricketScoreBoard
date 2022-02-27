package in.phonepe.assignment.cricket;

import java.util.*;

import in.phonepe.assignment.cricket.entity.Over;
import in.phonepe.assignment.cricket.entity.Player;
/**
 * 
 * @author amber.pandit
 * The class is responsible for managing all innings related features
 * 
 */
public class Inning {
	private List<Player> players;
	private final int noOfOvers;
	private final int noOfPlayersinEachTeam;
	private int currentWickets = 0;
	private int teamScore;
	private Player onStrikePlayer, offStrikePlayer;
	private Over overs;
	private int target;
	private int nextPlayer;
	private final int teamNumber;
	private Scanner sc;

	public Inning(int noOfPlayersinEachTeam, int noOfOvers, int teamNumber) {
		players = new ArrayList<Player>();
		this.noOfOvers = noOfOvers;
		this.noOfPlayersinEachTeam = noOfPlayersinEachTeam;
		this.target = Integer.MAX_VALUE;
		this.overs = new Over();
		this.nextPlayer = 0;
		
		this.teamNumber = teamNumber;
	}

	public void initializeBattingOrder() {
		System.out.println("Batting Order for team " + teamNumber + " :");
		sc = new Scanner(System.in);
		for (int i = 1; i <= noOfPlayersinEachTeam; i++) {
			System.out.print("Enter Player " + i + " name ");
			String name = sc.nextLine();
			System.out.println();
			players.add(new Player(name));
		}
		onStrikePlayer = getNextPlayer();
		offStrikePlayer = getNextPlayer();
	}

	public void startInnings(int target) {
		if (target != -1)
			this.target = target;
		while (!isInningOver()) {
			if (overs.getCurrentBall() == 0)
				System.out.print("Over :" + overs.getOver());
			System.out.println();
			String action = sc.nextLine();
			updateStats(action);
			if (overs.getCurrentBall() == 6) {
				changeStrike();
				printScoreBoard();
				overs.startNewOver();
				
			}
			if(isInningOver() && overs.getCurrentBall()!=0) {
				printScoreBoard();
			}
		}
	}

	public void printScoreBoard() {
		System.out.println("Score for team " + teamNumber + " :");
		System.out.println("PlayerNames	Score	4s	6s	Balls");
		for (Player p : players) {
			if (p == onStrikePlayer || p == offStrikePlayer)
				System.out.println(p.getName() + "*" + "		" + p.getRunsScored() + "	" + p.getFoursCount()
						+ "	" + p.getSixesCount() + "	" + p.getBallsplayed());
			else
				System.out.println(p.getName() + "		" + p.getRunsScored() + "	" + p.getFoursCount() + "	"
						+ p.getSixesCount() + "	" + p.getBallsplayed());
		}
		System.out.println("Total: " + getScore() + "/" + currentWickets);
		if(overs.getCurrentBall() == 6)
			System.out.println("Over : " + overs.getOver());
		else 
			System.out.println("Over : " + (overs.getOver() - 1) +"."+overs.getCurrentBall());
		System.out.println();
		System.out.println();

	}

	private void updateStats(String action) {
		switch (action) {
		case "Wd":
			teamScore++;
			break;

		case "Nb":
			teamScore++;
			break;

		case "0":
			onStrikePlayer.PlayedBall();
			overs.nextBall();
			break;

		case "W":
			onStrikePlayer.PlayedBall();
			onStrikePlayer.setIsOut(true);
			overs.nextBall();
			currentWickets++;
			onStrikePlayer = getNextPlayer();
			break;

		default:
			int runs = Integer.parseInt(action);
			overs.nextBall();
			teamScore += runs;
			onStrikePlayer.updatescore(runs);
			if (runs % 2 == 1) {
				changeStrike();
			}
		}

	}

	private void changeStrike() {
		Player placeHolder = onStrikePlayer;
		onStrikePlayer = offStrikePlayer;
		offStrikePlayer = placeHolder;

	}

	private Player getNextPlayer() {
		if (nextPlayer <= noOfPlayersinEachTeam - 1)
			return players.get(nextPlayer++);
		return null;
	}

	public int getScore() {
		return teamScore;
	}

	private boolean isInningOver() {
		if (getScore() > target || overs.getOver()> noOfOvers || currentWickets == noOfPlayersinEachTeam - 1)
			return true;
		else
			return false;
	}

	public int getCurrentWickets() {
		return currentWickets;
	}

}
