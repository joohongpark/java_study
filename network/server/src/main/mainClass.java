package main;

import gui.GUIMain;
import threadtest.makeSession;
import threadtest.sess;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {
	public static ArrayList<Thread> threadArrayList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//  GUIMain.run();

		String str = null;
		threadArrayList = new ArrayList<Thread>();
		Thread makesession = new makeSession();
		makesession.start();
		System.out.println("루프 진입 ");

		while(true) {
			Scanner scanner = new Scanner(System.in);
			str = scanner.nextLine();
			for(Thread t : threadArrayList) {
				if(!((sess)t).isFinish) {
					((sess)t).msg(str);
				} else {
					threadArrayList.remove(t);
				}
			}
		}

	}

}
