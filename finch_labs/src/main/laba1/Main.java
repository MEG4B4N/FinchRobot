package main.laba1;

import main.finch.Finch;

public class Main {
	public static void main(String[] args) {
		System.out.println("program started");
		
		Finch f = new Finch();
		
		run(f);
		
		f.stopAll();
		f.disconnect();
		
		System.out.println("program finished");
	}
	
	public static void run(Finch f) {
		
		for (int i = 0; i < 4; i++) {
			f.setMove("F", 15.0, 40.0);
			f.setTurn("R", 90.0, 40.0);
		}
		
		for (int i = 0; i < 4; i++){
			f.setBeak(100, 100, 100);
			f.pause(0.5);
			f.setBeak(0, 0, 0);
			f.pause(0.5);
		}
		
	}
}
