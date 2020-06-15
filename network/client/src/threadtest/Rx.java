package threadtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Rx extends Thread {
    private Socket socket;
    public Rx(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                System.out.println(r.readLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
