package threadtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class sess extends Thread {
    private Socket socket;
    private String objectName;
    public boolean isFinish;
    public sess(Socket socket) {
        this.socket = socket;
        isFinish = false;
    }

    @Override
    public void run() {
        super.run();
        String recv;
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            objectName = socket.getInetAddress() +  ":" + socket.getPort();
            while (true) {
                recv = r.readLine();
                System.out.println("[" + objectName + "] " + recv);
            }
        } catch (IOException e) {
            System.out.println("[" + objectName + "] 연결이 끊어졌습니다.");
            isFinish = true;
        }
    }

    public void msg(String str) {
        try {
            PrintWriter p = new PrintWriter(socket.getOutputStream());
            p.println(str);
            p.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
