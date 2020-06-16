package threadtest;

import gui.GUIMain;
import gui.Tray;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;

public class Rx extends Thread {
    private Socket socket;
    public Rx(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        String msg = null;
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                msg = r.readLine();
                if (SystemTray.isSupported()) {
                    try{
                        Tray.displayTray(msg);
                    }catch(AWTException ex){

                    }catch(MalformedURLException ex){

                    }
                } else {
                    System.err.println("System tray not supported!");
                }
                GUIMain.textArea.append("[" + socket.getInetAddress() + "] " + msg + "\n");
                GUIMain.textArea.setCaretPosition(GUIMain.textArea.getDocument().getLength());
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
