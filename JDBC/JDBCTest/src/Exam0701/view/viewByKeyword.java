package Exam0701.view;

import Exam0701.dao.GoodsDao;
import Exam0701.dto.GoodsDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewByKeyword extends JFrame {
    private JTextField keywordField;
    public viewByKeyword(String user) {
        super("항목별 검색 - " + user);
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

        JLabel payLabel = new JLabel("검색어");
        payLabel.setBounds(10, 290, 50, 20);
        add(payLabel);

        keywordField = new JTextField(10);
        keywordField.setBounds(80, 290, 200, 20);
        add(keywordField);

        JButton searchButton = new JButton("검색");
        searchButton.addActionListener(e -> {
            GoodsDto[] data;
            String keyword = keywordField.getText().trim();
            GoodsDao goodsDao = GoodsDao.getInstance();
            if(keyword.equals("")) {
                data = goodsDao.getGoodsById(user);
            } else {
                data = goodsDao.getGoodsByKeyword(keyword);
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
