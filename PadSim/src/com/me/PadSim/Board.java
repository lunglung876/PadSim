package com.me.PadSim;


public class Board {
	private Orb[][] Orbs;
	public Board(){
		Orbs = new Orb[6][5];
		for (int x =0; x<6; x++) {
			for (int y =0; y<5; y++){
				Orb orb = new Orb();
				Orbs[x][y] = orb;
			}
		}
	}
	public int getColor(int x,int y){
		int color = Orbs[x][y].getColor();
		return color;
		
	}
	
}
