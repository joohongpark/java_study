package window;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window1 implements WindowListener {
    public Window1() {
        Frame frame = new Frame();
        frame.setTitle("푸주홍의 윈도우 ^^");
        frame.setSize(100, 100);
        frame.setLocation(300, 300);
        frame.setBackground(Color.MAGENTA);

        frame.setVisible(true);
        frame.addWindowListener(this);

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
