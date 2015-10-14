package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		Frame frame = new Frame(firstThrow,secondThrow);
		this.addFrame(frame);
		
	}
	
	public int score(){
		int score = 0;
		
		int len = frames.size();
		for(int i =0 ; i<len;i++){
			Frame frame = frames.get(i);
			if(this.isNextFrameBonus(frame)){
				
			}else{
				
			}
		}
		return 0;
	}
	
	
	public boolean isNextFrameBonus(Frame frame){
		if(frame.isSpare()|| frame.isStrike()){
			return true;
		}
		return false;
	}
}
