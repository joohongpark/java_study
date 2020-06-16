package connect;

import threadtest.Rx;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Connect {
    public static InetSocketAddress addr;
    public static PrintWriter printWriter;
    private static boolean isConnected = false;
    public static void setTCP(String IP, int port) {
        try {
            addr = new InetSocketAddress(IP, port);
            Socket s = new Socket();
            s.connect(addr, 5000);
            /*
            InetAddress inetAddr; // 접속 확인용
            if( (inetAddr = s.getInetAddress()) != null ) {
                System.out.println("서버 접속 성공");
            } else {
                System.out.println("서버 접속 실패");
            }

             */
            Thread thread = new Rx(s);
            thread.start();

            printWriter = new PrintWriter(s.getOutputStream());
            isConnected = true;

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static boolean isConnected() {
        return isConnected;
    }
}
