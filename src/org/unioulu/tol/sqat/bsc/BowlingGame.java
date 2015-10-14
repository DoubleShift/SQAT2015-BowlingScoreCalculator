package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int score;
	
	public BowlingGame(){
		this.score = 0;
	}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		Frame frame = new Frame(firstThrow,secondThrow);
		this.addFrame(frame);
		
		//set lastFramflat
		int size = frames.size();
		if(size == 10){
			frame.setLastFrame();
		}
		
	}
	
	public int score(){
		int tempScore = 0;
		int len = frames.size();
		for(int i =0 ; i<len;i++){
			Frame frame = frames.get(i);
			if(!frame.isLastFrame()){
				if(frame.isSpare()){
					frame.bonus(this.getNextThrow(i));
				}else if(frame.isStrike()){
					frame.bonus(this.getNextTwoThrows(i));
				}
			}else{
				//Todo tenth frame
			}
			
			this.score = frame.score();
			
		}
		return this.score;
	}
	
	
	public boolean isNextFrameBonus(Frame frame){
		if(frame.isSpare()|| frame.isStrike()){
			return true;
		}
		return false;
	}
	
	public int getNextTwoThrows(int index){
		int score = 0;
		Frame frame = this.frames.get(index+1);
		if(frame.getSecondThrow() != -1){
			score = frame.getFirstThrow() + frame.getSecondThrow();
		}else{
			Frame nextFrame = this.frames.get(index+2);
			score = frame.getFirstThrow()+nextFrame.getFirstThrow();
		}
		return score;
	}
	
	public int getNextThrow(int index){
		Frame frame = this.frames.get(index+1);

		return frame.getFirstThrow();
	}
	
}
