package in.phonepe.assignment.cricket.app;

import java.util.Scanner;

import in.phonepe.assignment.cricket.Match;
/*
 * Driver class to maintain scoreboard
 * initializes a match with players and inning
 * plays both innings
 * get the result
 */
public class ScoreBoard {
	
	public static void main(String[] args) {		
		Scanner sc= new Scanner(System.in);
		System.out.print("No of players for each team : ");
		int noOfPlayers= sc.nextInt();
		System.out.print("No of overs : ");
		int noOfOvers=sc.nextInt();
		
		Match match = new Match(noOfPlayers, noOfOvers);
		match.startMatch();
		match.getResult();
		sc.close();
		

	}

}
