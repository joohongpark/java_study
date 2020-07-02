package view.mainview;

import dao.CoffeeDao;
import dto.CoffeeDto;
import tools.Tools;
import view.menuview.menuView;
import view.orderview.orderView;

import javax.swing.*;
import java.awt.*;

/**
 * View : Front-end Part
 */

public class mainView extends JFrame {
    private JButton addButton;
    private JButton viewButton;
    private JButton searchButton;
    private String user;
    private final static String[] coffeeMenuLists = {
            "헤이즐넛 카라멜 모카",
            "카라멜 마끼아또",
            "화이트 초콜릿 모카",
            "카라멜 모카",
            "카페 모카",
            "카라멜 라떼",
            "카페 라떼",
            "카푸치노",
            "아메리카노",
            "오늘의 커피"
    };
    private final static int[] coffeePriceLists = {
            4800,
            4300,
            4300,
            4300,
            3800,
            3800,
            3300,
            3300,
            2800,
            2500
    };
    public mainView(String user) {
        super("푸주커피 - " + user);
        this.user = user;
        JFrame t = this;

        setLayout(null);

        JLabel titleLabel = new JLabel("Puju Coffee");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        titleLabel.setBounds(25, 10, 200, 35);
        add(titleLabel);

        JButton showMenuButton = new JButton("메뉴");
        showMenuButton.setBounds(270, 5, 120, 45);
        showMenuButton.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, e.getActionCommand());
            new menuView(coffeeMenuLists, coffeePriceLists);
        });
        add(showMenuButton);



        JComboBox coffeeComboBox = new JComboBox(coffeeMenuLists);
        coffeeComboBox.setEditable(true);
        coffeeComboBox.setBounds(10, 70, 390, 20);
        /*
        coffeeComboBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            System.out.println(e.getSource());
            String petName = (String)cb.getSelectedItem();
            JOptionPane.showMessageDialog(null, petName);
        });

         */
        add(coffeeComboBox);

        // 메뉴 상세

        JPanel sizePanel = new JPanel();
        ButtonGroup sizeGroup = new ButtonGroup();
        JRadioButton coffeeSizeShort = new JRadioButton("Short");
        JRadioButton coffeeSizeTail = new JRadioButton("Tail");
        JRadioButton coffeeSizeGrande = new JRadioButton("Grande");
        coffeeSizeShort.setSelected(true);
        sizeGroup.add(coffeeSizeShort);
        sizeGroup.add(coffeeSizeTail);
        sizeGroup.add(coffeeSizeGrande);

        sizePanel.add(coffeeSizeShort);
        sizePanel.add(coffeeSizeTail);
        sizePanel.add(coffeeSizeGrande);
        //sizePanel.add(sizeGroup);
        sizePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "커피 사이즈"));
        sizePanel.setBounds(10, 100, 120, 130);
        add(sizePanel);

        // 시럽
        JPanel syrupPanel = new JPanel();
        ButtonGroup syrupGroup = new ButtonGroup();
        JRadioButton syrupButtonOne = new JRadioButton("바닐라");
        JRadioButton syrupButtonTwo = new JRadioButton("캬라멜");
        JRadioButton syrupButtonThree = new JRadioButton("헤이즐넛");
        syrupGroup.add(syrupButtonOne);
        syrupGroup.add(syrupButtonTwo);
        syrupGroup.add(syrupButtonThree);

        syrupPanel.add(syrupButtonOne);
        syrupPanel.add(syrupButtonTwo);
        syrupPanel.add(syrupButtonThree);
        syrupPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "시럽"));
        syrupPanel.setBounds(140, 100, 120, 130);
        add(syrupPanel);

        //  기타
        JPanel etcPanel = new JPanel();
        JCheckBox etcButtonOne = new JCheckBox("샷 추가");
        JCheckBox etcButtonTwo = new JCheckBox("휘핑크림 추가");
        etcPanel.add(etcButtonOne);
        etcPanel.add(etcButtonTwo);
        etcPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "기타"));
        etcPanel.setBounds(270, 100, 120, 130);
        add(etcPanel);

        JTextField qtyField = new JTextField(10);
        qtyField.setBounds(10, 240, 150, 20);
        add(qtyField);

        JLabel qtyLabel = new JLabel("잔");
        qtyLabel.setBounds(170, 240, 20, 20);
        add(qtyLabel);

        JButton orderButton = new JButton("주문");
        orderButton.setBounds(230, 230, 120, 35);
        orderButton.addActionListener(e -> {
            /* 무결성 검사는 생략함. */
            int selectedIndex = 0;
            CoffeeDao dao = CoffeeDao.getInstance();
            int totalPay;
            String coffeeSize = "";
            String coffeeSyrup;
            String qty = qtyField.getText().trim();
            String coffeeName = (String)coffeeComboBox.getSelectedItem();
            if(!Tools.isDigit(qty)) {
                return;
            }
            for (; selectedIndex < coffeeMenuLists.length; selectedIndex++) {
                if(coffeeMenuLists[selectedIndex].equals(coffeeName)) {
                    break;
                }
            }
            totalPay = coffeePriceLists[selectedIndex];
            if(coffeeSizeShort.isSelected()) {
                coffeeSize = "Short";
            } else if(coffeeSizeGrande.isSelected()) {
                // +500
                totalPay += 500;
                coffeeSize = "Grande";
            } else if(coffeeSizeTail.isSelected()) {
                // +1000
                totalPay += 1000;
                coffeeSize = "Tall";
            }

            if(syrupButtonOne.isSelected()) {
                coffeeSyrup = "바닐라";
            } else if(syrupButtonTwo.isSelected()) {
                coffeeSyrup = "캬라멜";
            } else if(syrupButtonThree.isSelected()) {
                coffeeSyrup = "헤이즐넛";
            } else {
                coffeeSyrup = "없음";
            }
            CoffeeDto dto = new CoffeeDto(
                    0,
                    user,
                    coffeeMenuLists[selectedIndex],
                    totalPay * Integer.parseInt(qty),
                    coffeeSyrup,
                    coffeeSize,
                    etcButtonOne.isSelected(),
                    etcButtonTwo.isSelected(),
                    Integer.parseInt(qty));

            dao.addCoffee(dto);
            System.out.println(coffeeSizeShort.isSelected());
            new orderView(user);
        });
        add(orderButton);

        setBounds(150, 150, 410, 330);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
