package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int score;
	private int bonus;
	private boolean lastFrame;
	private int firstThrow;
	private int secondThrow;
	
	//only for theth throw
	private int thirdThrow;

	// secondThrow = -1 means firstThrow = 10
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		
		this.score = 0;
		this.bonus = 0;
		this.lastFrame = false;

	}
	

	public int getSecondThrow() {
		return this.secondThrow;
	}



	public int getFirstThrow() {
		return this.firstThrow;
	}



	//the score of a single frame
	public int score(){
		score = this.firstThrow + this.bonus;
		
		if(this.secondThrow >=0 && this.secondThrow <= 10){
			score += this.secondThrow;
		}
		return score;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		if(this.firstThrow!= 10 && this.firstThrow + this.secondThrow >= 10){
			return true;
		}
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		if(this.firstThrow == 10){
			return true;
		}
		return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		return this.lastFrame;
	}
	
	public void setLastFrame(){
		this.lastFrame = true;
	}

	//bonus throws
	public int bonus(int bonus){
		this.bonus = bonus;
		return this.bonus;
	}
	

}
