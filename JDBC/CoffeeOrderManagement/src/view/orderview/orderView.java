package view.orderview;

import dao.CoffeeDao;
import dto.CoffeeDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class orderView extends JFrame {
    public orderView(String user) {
        super("주문 내역 조회 - " + user);
        JFrame j = this;

        setLayout(null);

        String[] colName = {"Espresso Beverages", "시럽", "크기", "샷 추가", "휘핑크림", "잔", "총액"};
        DefaultTableModel lists = new DefaultTableModel(colName,0);
        JScrollPane scrollPane = new JScrollPane(new JTable(lists));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 580, 350);
        add(scrollPane);

        CoffeeDao dao = CoffeeDao.getInstance();
        CoffeeDto[] dto = dao.getCoffeeAll(user);
        for(CoffeeDto obj : dto) {
            if(obj != null) {
                lists.addRow(new Object[] {
                        obj.getMenuName(),
                        obj.getSyrup(),
                        obj.getSize(),
                        (obj.getAddShot() ? "추가" : "안함"),
                        (obj.getAddCream() ? "추가" : "안함"),
                        obj.getAmount(),
                        obj.getPay()
                });
            }
        }

        JButton button = new JButton("확인");
        button.setBounds(50, 360, 400, 45);
        button.addActionListener(e -> {
            j.dispose();
        });
        add(button);

        setBounds(10, 10, 600, 450);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
