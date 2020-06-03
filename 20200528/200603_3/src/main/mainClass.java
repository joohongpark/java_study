package main;

import modules.*;

public class mainClass {

	public static void main(String[] args) {
		Robot[] arr = {
				new DanceRobot(),
				new SingRobot(),
				new DrawRobot() };
		for(int i=0; i< arr.length;i++)
		action(arr[i]);
	}
	public static void action(Robot obj) {
		if (obj instanceof DanceRobot) {
			((DanceRobot)obj).dance();
		} else if (obj instanceof SingRobot) {
			((SingRobot)obj).sing();
		} else {
			((DrawRobot)obj).draw();
		}
	}
}
