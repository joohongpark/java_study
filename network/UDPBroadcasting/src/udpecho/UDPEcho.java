package udpecho;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEcho {
    private int Port;
    private DatagramSocket socket;
    private DatagramPacket packet;
    public UDPEcho(){};
    public UDPEcho(int Port) {
        this.Port = Port;
        try {
            socket = new DatagramSocket();
            socket.setBroadcast(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String data) {
        byte[] buffer = data.getBytes();
        try {
            packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), Port);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exit() {
        socket.close();
    }
}
