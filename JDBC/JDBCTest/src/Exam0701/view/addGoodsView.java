package Exam0701.view;

import Exam0701.dao.GoodsDao;
import Exam0701.dao.MemberDao;
import Exam0701.dto.GoodsDto;
import Exam0701.dto.MemberDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addGoodsView extends JFrame {
    private String user;
    JPanel radioPanel = new JPanel();
    JTextField payTextField;
    JTextField descTextField;
    String[] radio_name = {"수입", "지출"};
    JRadioButton[] radio = new JRadioButton[radio_name.length];
    public addGoodsView(String user) {
        super("상품 추가 - " + user);
        this.user = user;
        JFrame j = this;

        ActionListener goodsAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pay = payTextField.getText().trim();
                String desc = descTextField.getText().trim();
                String io = "+"; // 추후에
                if(pay.equals("") && desc.equals("")) {
                    JOptionPane.showMessageDialog(null, "내용을 입력하세요");
                } else if(!addGoodsView.isDigit(pay)) {
                    JOptionPane.showMessageDialog(null, "금액 란에는 정수민 입력해야 합니다.");
                } else {
                    GoodsDao dao = GoodsDao.getInstance();
                    GoodsDto dto = new GoodsDto(0, user, io, Integer.parseInt(pay), desc, null);
                    if(dao.addGoods(dto)) {
                        JOptionPane.showMessageDialog(null, "추가되었습니다.");
                    } else {
                        JOptionPane.showMessageDialog(null, "저장 실패");
                    }
                }
            }
        };

        ActionListener back = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mainView(user);
                j.dispose();
            }
        };
        setLayout(null);

        ButtonGroup group = new ButtonGroup();

        for(int i=0; i<radio.length; i++){
            radio[i] = new JRadioButton(radio_name[i]);
            group.add(radio[i]);
            radioPanel.add(radio[i]);
        }

        radio[0].setSelected(true);
        radioPanel.setBounds(10, 10, 280, 30);
        add(radioPanel);

        JLabel payLabel = new JLabel("금액");
        payLabel.setBounds(10, 50, 40, 20);
        add(payLabel);

        payTextField = new JTextField(10);
        payTextField.setBounds(70, 50, 320, 20);
        add(payTextField);

        JLabel descLabel = new JLabel("내용");
        descLabel.setBounds(10, 80, 50, 20);
        add(descLabel);

        descTextField = new JTextField(10);
        descTextField.setBounds(70, 80, 320, 20);
        add(descTextField);

        JButton addButton = new JButton("추가");
        addButton.addActionListener(goodsAdd);
        addButton.setBounds(10, 110, 380, 60);
        add(addButton);

        JButton backButton = new JButton("메뉴로 돌아가기");
        backButton.addActionListener(back);
        backButton.setBounds(10, 180, 380, 60);
        add(backButton);

        setBounds(10, 10, 400, 280);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static Boolean isDigit(String str) {
        for(int i = 0; i < str.length(); i++) {
            if( (str.charAt(i) < '0') || (str.charAt(i) > '9') ) {
                return false;
            }
        }
        return true;
    }
}
