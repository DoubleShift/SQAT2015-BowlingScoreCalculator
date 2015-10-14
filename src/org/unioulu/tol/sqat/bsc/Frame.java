package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int bonusThrow;

	// secondThrow = -1 means firstThrow = 10
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;

	}
	

	
	//the score of a single frame
	public int score(){
		if(this.secondThrow == -1){
			return this.firstThrow;
		}else if(this.bonusThrow >=0 && this.bonusThrow <= 10){
			return this.firstThrow + this.secondThrow + this.bonusThrow;
		}
		return this.firstThrow + this.secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		if(this.firstThrow + this.secondThrow >= 10){
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
		if(this.bonusThrow <11){
			return true;
		}
		return false;
	}

	//bonus throws
	public int bonus(int bonus){
		this.bonusThrow = bonus;
		return this.bonusThrow;
	}
}
