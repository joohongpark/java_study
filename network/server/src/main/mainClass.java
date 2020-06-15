package main;

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
		String str = null;
		threadArrayList = new ArrayList<Thread>();
		Socket socket = null;
		Thread makesession = new makeSession(socket);
		makesession.start();
		System.out.println("루프 진입 ");

		while(true) {
			Scanner scanner = new Scanner(System.in);
			str = scanner.nextLine();
			for (int i = 0; i < threadArrayList.size(); i++) {
					((sess)threadArrayList.get(i)).msg(str);
			}
		}

	}

}
