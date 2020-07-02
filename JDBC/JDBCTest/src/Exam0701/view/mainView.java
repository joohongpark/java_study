package Exam0701.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View : Front-end Part
 */

public class mainView extends JFrame {
    private JButton addButton;
    private JButton viewButton;
    private JButton searchButton;
    private String user;
    public mainView(String user) {
        super("메인 메뉴 - " + user);
        this.user = user;
        JFrame t = this;

        ActionListener addClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addGoodsView(user);
                t.dispose();
            }
        };

        ActionListener viewClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewByDate(user);
                t.dispose();
            }
        };

        ActionListener searchClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewByKeyword(user);
                t.dispose();
            }
        };

        setLayout(null);

        JLabel loginLabel = new JLabel("가계부 앱");
        loginLabel.setBounds(100, 10, 250, 15);
        add(loginLabel);

        addButton = new JButton("항목 추가");
        addButton.setBounds(31, 50, 250, 40);
        addButton.addActionListener(addClick);
        add(addButton);

        viewButton = new JButton("기간별 내역 조회");
        viewButton.setBounds(31, 100, 250, 40);
        viewButton.addActionListener(viewClick);
        add(viewButton);

        searchButton = new JButton("항목별 검색");
        searchButton.setBounds(31, 150, 250, 40);
        searchButton.addActionListener(searchClick);
        add(searchButton);

        setBounds(150, 150, 300, 280);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
