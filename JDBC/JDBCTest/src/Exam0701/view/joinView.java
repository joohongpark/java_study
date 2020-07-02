package Exam0701.view;

import Exam0701.dao.MemberDao;
import Exam0701.dto.MemberDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class joinView extends JFrame {
    JTextField IDField;
    JTextField PassField;
    JTextField NameField;
    JTextField EmailField;
    public joinView() {
        super("회원 가입");

        ActionListener idDuplicationCheck = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IDField.getText().trim();
                if(id.equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
                } else {
                    MemberDao dao = MemberDao.getInstance();
                    if(dao.isExist(id)) {
                        JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");
                    } else {
                        JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
                    }
                }
            }
        };

        ActionListener memberJoin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IDField.getText().trim();
                String pass = PassField.getText().trim();
                String name = NameField.getText().trim();
                String email = EmailField.getText().trim();

                if ( id.equals("") && pass.equals("") && name.equals("") && email.equals("") ) {
                    JOptionPane.showMessageDialog(null, "누락된 필드를 채워 주세요");
                } else {
                    MemberDao dao = MemberDao.getInstance();
                    MemberDto memberDto = new MemberDto(id, pass, name, email, 0);
                    if (dao.addMember(memberDto)) {
                        JOptionPane.showMessageDialog(null, "가입 성공");
                    } else {
                        JOptionPane.showMessageDialog(null, "가입 실패");
                    }
                }
            }
        };


        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 0;

        constraints.gridx = 0;
        loginPanel.add(new JLabel("ID: "), constraints);

        constraints.gridx = 1;
        constraints.weightx = 0.1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        IDField = new JTextField();
        loginPanel.add(IDField, constraints);

        constraints.gridx = 2;
        constraints.weightx = 0;
        JButton checkButton = new JButton("중복 체크");
        checkButton.addActionListener(idDuplicationCheck);
        loginPanel.add(checkButton, constraints);


        constraints.gridy = 1;
        constraints.gridx = 0;
        loginPanel.add(new JLabel("PW: "), constraints);

        constraints.gridx = 1;
        PassField = new JTextField(20);
        loginPanel.add(PassField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        loginPanel.add(new JLabel("이름: "), constraints);

        constraints.gridx = 1;
        NameField = new JTextField(20);
        loginPanel.add(NameField, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        loginPanel.add(new JLabel("Email: "), constraints);

        constraints.gridx = 1;
        EmailField = new JTextField(20);
        loginPanel.add(EmailField, constraints);

        constraints.gridy = 4;
        JButton joinButton = new JButton("회원가입");
        joinButton.addActionListener(memberJoin);
        loginPanel.add(joinButton, constraints);

        add(loginPanel);
        //setBounds(100, 100, 300, 280);
        setSize(400,400);
        setVisible(true);

    }
}
