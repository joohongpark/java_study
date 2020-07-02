package Exam0701.view;

import Exam0701.dao.GoodsDao;
import Exam0701.dto.GoodsDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class viewByDate extends JFrame {
    private JTextArea textArea;
    private JTextField startField;
    private JTextField stopField;
    public viewByDate(String user) {
        super("기간별 내역 조회 - " + user);
        JFrame j = this;

        setLayout(null);


        String[] colName = {"ID", "수입지출", "금액", "설명", "날짜"};
        DefaultTableModel model = new DefaultTableModel(colName,0);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 430, 260);
        //scrollPane.setPreferredSize(new Dimension(400, 600));
        add(scrollPane);

        startField = new JTextField(10);
        startField.setBounds(10, 290, 100, 20);
        add(startField);

        JLabel payLabel = new JLabel("부터");
        payLabel.setBounds(120, 290, 40, 20);
        add(payLabel);

        stopField = new JTextField(10);
        stopField.setBounds(170, 290, 100, 20);
        add(stopField);

        JLabel descLabel = new JLabel("까지");
        descLabel.setBounds(280, 290, 40, 20);
        add(descLabel);

        JButton searchButton = new JButton("검색");
        searchButton.addActionListener(e -> {
            GoodsDto[] data;
            String start = startField.getText().trim();
            String stop = stopField.getText().trim();
            GoodsDao goodsDao = GoodsDao.getInstance();
            if(start.equals("") || stop.equals("")) {
                data = goodsDao.getGoodsById(user);
            } else {
                data = goodsDao.getGoodsByDataRange(start, stop);
            }
            model.getDataVector().removeAllElements();
            for(GoodsDto obj : data) {
                if(obj != null) {
                    if(user.equals(obj.getId())) {
                        model.addRow(new Object[]{obj.getId(), obj.getIo_kind(), obj.getAmount(), obj.getContent(), obj.getWdate()});
                    }
                }
            }
        });
        searchButton.setBounds(10, 320, 430, 60);
        add(searchButton);

        JButton backButton = new JButton("메뉴로 돌아가기");
        backButton.addActionListener(e -> {
            new mainView(user);
            j.dispose();
        });
        backButton.setBounds(10, 380, 430, 60);
        add(backButton);

        setBounds(10, 10, 450, 480);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
