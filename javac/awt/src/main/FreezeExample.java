package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FreezeExample extends JFrame
{
    public static void main(String[] args)
    {
        FreezeExample example = new FreezeExample();
        example.setVisible(true);
    }

    public FreezeExample()
    {
        super("Freeze Example");

        final JButton button = new JButton("Take a nap !");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                button.setText("Sleeping...");
                try {Thread.sleep(10000);}
                catch (Exception ignored) {}
                button.setText("Slept !");
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new GridBagLayout());
        c.add(button);

        setSize(300,200);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = getSize();
        int x = (screen.width - size.width) >> 1;
        int y = (screen.height - size.height) >> 1;
        setLocation(x, y);
    }
}