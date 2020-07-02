package view;

import dao.MemberDao;
import view.join.joinView;
import view.mainview.mainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView extends JFrame implements ActionListener {
    private JTextField idTextF;
    private JPasswordField pwTextF;

    private JButton logBtn;
    private JButton accountBtn;

    public loginView() {
        super("로그인");

        setLayout(null);

        JLabel loginLabel = new JLabel("로그인 화면");
        loginLabel.setBounds(100, 10, 120, 15);
        add(loginLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(31, 60, 67, 15);
        add(idLabel);

        idTextF = new JTextField(10);
        idTextF.setBounds(100, 60, 150, 20);
        add(idTextF);

        JLabel passLabel = new JLabel("PW:");
        passLabel.setBounds(31, 104, 67, 15);
        add(passLabel);

        pwTextF = new JPasswordField();
        pwTextF.setBounds(100, 104, 150, 20);
        add(pwTextF);

        logBtn = new JButton("로그인");
        logBtn.setBounds(31, 150, 100, 40);
        logBtn.addActionListener(this);
        add(logBtn);

        accountBtn = new JButton("회원가입");
        accountBtn.setBounds(150, 150, 100, 40);
        accountBtn.addActionListener(this);
        add(accountBtn);

        setBounds(100, 100, 300, 280);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();

        if(btn == accountBtn) { // 회원가입
            new joinView();
            this.dispose();
        } else if(btn == logBtn) {
            String id = idTextF.getText().trim();
            String pass = pwTextF.getText().trim();
            if(id.equals("") && pass.equals("")) {
                JOptionPane.showMessageDialog(null, "아이디/비밀번호를 입력하세요");
            } else {
                MemberDao dao = MemberDao.getInstance();
                if(dao.login(id, pass)) {
                    new mainView(id);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "아이디/비밀번호를 확인하세요");
                }
            }
        }
    }
}
