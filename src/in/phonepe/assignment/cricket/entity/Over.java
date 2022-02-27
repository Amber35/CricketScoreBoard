package in.phonepe.assignment.cricket.entity;
/*
 * Represent the over behavior 
 * After every 6th valid ball over increments.
 */
public class Over {
  public final int totalBalls=6;
  int currentBall;
  int over;
  
    
  public Over(){
	  this.currentBall=0;
	  this.over=1;
  }
  
  public void nextBall() {	
currentBall++;
	
	  
  }
  public int getOver() {
	  return over;
  }
  public int getCurrentBall() {
		return currentBall;
	 }



public void startNewOver() {
	currentBall=0;
	over++;
	
}
  

}
