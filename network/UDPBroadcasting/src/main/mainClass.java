package main;

import udpecho.UDPEcho;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UDPEcho t = new UDPEcho(9112);
		t.send("{127.0.0.1,8080,'푸주홍'}");

	}

}
