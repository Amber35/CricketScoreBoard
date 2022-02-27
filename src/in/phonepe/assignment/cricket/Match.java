package in.phonepe.assignment.cricket;
/**
 * 
 * @author amber.pandit
 * Match class can have two teams and control the flow
 * of every inning
 *
 */
public class Match {
	private final Inning firstInning , secondInning;	
	int noOfPlayersinEachTeam;
	public Match(int noOfPlayersinEachTeam, int noOfOvers) {
		this.noOfPlayersinEachTeam=noOfPlayersinEachTeam;
		firstInning = new Inning(noOfPlayersinEachTeam , noOfOvers , 1);
		secondInning = new Inning(noOfPlayersinEachTeam , noOfOvers , 2);
	    
	}
	/**
	 * 
	 */
	public void startMatch() {
		firstInning.initializeBattingOrder();
		firstInning.startInnings(-1);
		secondInning.initializeBattingOrder();
		secondInning.startInnings(firstInning.getScore());
	}

	public void getResult() {		
		
		if(firstInning.getScore()==secondInning.getScore()) {
			System.out.println("Result : Match is resulted in a tie");
		}
		else if(firstInning.getScore()<secondInning.getScore()) {
			System.out.println("Result : Team 2 won the match by "+ 
		(noOfPlayersinEachTeam-secondInning.getCurrentWickets()) + " wickets");
		}
		else {
			System.out.println("Result : Team 1 won the match by "+ (firstInning.getScore()-secondInning.getScore()) + " runs");
		}
		
	}
	
	
	
	
	
}


