package gui;

import connect.Connect;
import main.mainClass;
import threadtest.Rx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.Scanner;

public class GUIMain {
    public static JTextArea textArea;
    public static JTextField chatField;
    public static void run() {
        loginBox();
    }

    public static void loginBox() {
        JFrame loginFrame = new JFrame("로그인");

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        loginPanel.add(new JLabel("IP: "), constraints);

        constraints.gridx = 1;
        JTextField IPField = new JTextField(20);
        loginPanel.add(IPField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        loginPanel.add(new JLabel("Port: "), constraints);

        constraints.gridx = 1;
        JTextField PortField = new JTextField(20);
        loginPanel.add(PortField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton loginButton = new JButton("join");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect.setTCP(IPField.getText(), Integer.parseInt(PortField.getText()));
                if(Connect.isConnected()) {
                    mainChat();
                    loginFrame.dispose();
                } else {
                    System.out.println("연결 실패");
                }
            }
        };
        loginButton.addActionListener(listener);

        loginPanel.add(loginButton, constraints);

        loginPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));


        loginFrame.add(loginPanel);
        loginFrame.setSize(400,200);
        loginFrame.setVisible(true);
    }

    public static void mainChat() {
        JFrame chatFrame = new JFrame("채팅");
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.setLayout(new FlowLayout());

        JPanel chatPanel = new JPanel(new GridBagLayout());


        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10 && chatField.getText() != "") {
                    transmit();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 600));
        chatPanel.add(scrollPane);

        JPanel idPanel = new JPanel();


        chatField = new JTextField(20);
        chatField.addKeyListener(keyListener);
        idPanel.add(chatField);

        JButton loginButton = new JButton("전송");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transmit();
            }
        };
        loginButton.addActionListener(listener);

        idPanel.add(loginButton);
        chatFrame.add(chatPanel);
        chatFrame.add(idPanel);
        chatFrame.setSize(420,800);

        chatFrame.setVisible(true);
    }

    public static void transmit() {
        GUIMain.textArea.append("[나] " + chatField.getText() + "\n");
        GUIMain.textArea.setCaretPosition(GUIMain.textArea.getDocument().getLength());
        Connect.printWriter.println(chatField.getText());
        Connect.printWriter.flush();
        chatField.setText("");
    }
}
