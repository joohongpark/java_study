package threadtest;

import main.mainClass;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class makeSession extends Thread {
    private Socket socket;
    public makeSession(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Thread thread = null;
        System.out.println("포트 바인딩");
        try {
            serverSocket = new ServerSocket(9000);
            while(true) {
                socket = serverSocket.accept();
                System.out.println("클라이언트 아이피 : " + socket.getInetAddress() + ":" + socket.getPort());
                thread = new sess(socket);
                thread.start();
                mainClass.threadArrayList.add(thread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
