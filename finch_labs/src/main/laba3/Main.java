package main.laba3;

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
		f.setMotors(-3, 3);
		for (int i = 0; i < 800; i++) {
			f.pause(0.005);
			int n = Math.max(100-f.getDistance()*2, 0);
			f.setBeak(n, n, n);
			System.out.println(n);
		}
	}
}
