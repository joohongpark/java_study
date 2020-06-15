package main;

import dto.DTOtest;
import dto.MemberDTO;
import threadtest.Rx;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		//InetSocketAddress addr = new InetSocketAddress("192.168.7.55", 9000);
		InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 9000);
		Socket s = new Socket();
		try {
			s.connect(addr, 5000);
			InetAddress inetAddr; // 접속 확인용
			if( (inetAddr = s.getInetAddress()) != null ) {
				System.out.println("서버 접속 성공");
			} else {
				System.out.println("서버 접속 실패");
			}
			//DTOtest.run(s);

			Thread thread = new Rx(s);
			thread.start();

			PrintWriter p = new PrintWriter(s.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			while(true) {
				p.println(scanner.next());
				p.flush();
			}

		} catch (IOException e) {
			System.out.println(e);
		}


	}
}
