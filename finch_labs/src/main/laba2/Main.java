package main.laba2;

import main.finch.Finch;

import java.util.ArrayList;

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
		/*ArrayList<Integer> arr = new ArrayList<Integer>();
		
		f.setMotors(-2, 2);
		for (int i = 0; i<200; i++) {
			arr.add(f.getDistance());
			f.pause(0.02);
		}
		
		for(int i : arr) {
			for(int j = 0; j<i/3; j++) System.out.print("#");
			System.out.println();
		}*/
		
		//ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			f.pause(0.02);
			int n = (f.getLight("L") - f.getLight("R"))/3;
			f.setMotors(-n, n);
			System.out.println(i);
		}
		
		
	}
}
