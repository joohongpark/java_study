package threadtest;

import main.mainClass;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class makeSession extends Thread {
    public makeSession() { }
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Thread thread = null;
        System.out.println("포트 바인딩");
        try {
            serverSocket = new ServerSocket(9000);
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("신규 접속 : " + socket.getInetAddress() + ":" + socket.getPort());
                thread = new sess(socket);
                thread.start();
                mainClass.threadArrayList.add(thread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
