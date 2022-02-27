package in.phonepe.assignment.cricket.entity;
/*
 * A basic player class
 * Abstraction can be used by adding Person interface
 * Contains variables related to batting
 *can be extended to add balling figures
 */
public class Player {
	private String name; 
	private int runsScored, ballsplayed, sixesCount , foursCount;
	private boolean isOut;
	
	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public int getBallsplayed() {
		return ballsplayed;
	}

	

	public int getSixesCount() {
		return sixesCount;
	}

	
	public int getFoursCount() {
		return foursCount;
	}

	
	public boolean isOut() {
		return isOut;
	}

	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIsOut() {
		return isOut;
	}

	public void setIsOut(boolean isnotOut) {
		this.isOut = isnotOut;
	}

	public Player(String name) {
		this.name=name;
		isOut=false;
	}
	
	public void updatescore(int run) {
		ballsplayed++;
		if(run==4) {
			foursCount++;
		}
		else if(run==6) {
			sixesCount++;
		}
		runsScored+=run;
		return ;
		
	}	
	public void PlayedBall() {
		ballsplayed++;
	}

	public String getName() {
		return name;
	}
	
	
	

}
