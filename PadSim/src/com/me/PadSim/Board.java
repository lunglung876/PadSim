package com.me.PadSim;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Board {
	

	
	private Orb[][] Orbs;
	private Set clear_sets;
	public Board(){
		Orbs = new Orb[6][5];
		clear_sets = new HashSet();
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
	
	public void swap(int x1,int y1,int x2, int y2){
		Orb Temp = Orbs[x2][y2];
		Orbs[x2][y2] = Orbs[x1][y1];
		Orbs[x1][y1] = Temp;
	}
	
	public int check_row(int x, int y, int count, int color){
		if (count ==0){
			color = Orbs[x][y].getColor();
			return check_row(x+1,y,1,color);
		}
		else if (count == 5){
			if (Orbs[x][y].getColor() == color){
				return 6;
			}
			else{
				return 5;
			}
		}
		else{
			if(x != 5){
				if (Orbs[x][y].getColor() == color){
					return check_row(x+1,y,count+1,color);
				}
				else{
					return count;
				}
			}
			else{
				if (Orbs[x][y].getColor() == color){
					System.out.println(count+1);
					return count + 1;
				}
				else{
					return count;
				}
			}
		}
	}
	
	public int check_column(int x, int y, int count, int color){
		if (count ==0){
			color = Orbs[x][y].getColor();
			return check_column(x,y+1,1,color);
		}
		else if (count == 4){
			System.out.println("count =4");
			if (Orbs[x][y].getColor() == color){
				return 5;
			}
			else{
				return 4;
			}
		}
		else{
			if(y != 4){
				if (Orbs[x][y].getColor() == color){
					return check_column(x,y+1,count+1,color);
				}
				else{
					return count;
				}
			}
			else{
				if (Orbs[x][y].getColor() == color){
					return count + 1;
				}
				else{
					return count;
				}
			}
		}
	}
	
}
