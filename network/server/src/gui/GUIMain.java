package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {
    public static void mainChat() {
        JFrame chatFrame = new JFrame("채팅");
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.setLayout(new FlowLayout());

        JPanel chatPanel = new JPanel(new GridBagLayout());


        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 600));
        chatPanel.add(scrollPane);

        JPanel idPanel = new JPanel();


        JTextField chatField = new JTextField(20);
        idPanel.add(chatField);

        JButton loginButton = new JButton("전송");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println();
            }
        };
        loginButton.addActionListener(listener);

        idPanel.add(loginButton);

        chatFrame.add(chatPanel);
        chatFrame.add(idPanel);
        chatFrame.setSize(420,800);

        chatFrame.setVisible(true);
    }
}
