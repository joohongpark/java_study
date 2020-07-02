package view.menuview;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class menuView extends JFrame {
    public menuView(String[] menu, int[] prices) {
        super("메뉴");
        JFrame j = this;
        setLayout(null);

        String[] colName = {"Espresso Beverages", "Short", "Tail", "Grande"};
        DefaultTableModel lists = new DefaultTableModel(colName,0);
        JScrollPane scrollPane = new JScrollPane(new JTable(lists));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 580, 350);
        add(scrollPane);

        for(int i = 0; i < menu.length; i++) {
            lists.addRow(new Object[] {
                    menu[i],
                    prices[i],
                    prices[i] + 500,
                    prices[i] + 1000
            });
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
