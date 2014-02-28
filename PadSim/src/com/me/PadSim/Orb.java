package com.me.PadSim;
import java.util.Random;


public class Orb {
	Random rand = new Random();
	public int color;
	public Orb(){
		color = rand.nextInt(6);
	}
	public int getColor(){
		return color;
	}
}
