package window;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import game.game;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener, ActionListener {

    Label computer, player, scoreBar;
    Button rock, scissor, paper;

    public WindowTest() {

        setLayout(null);

		/*
			resource(자원) : button, label, textfield -> Handle(번호)
		*/

        /* 가위, 바위, 보 버튼 */

        int buttonStartPosition = 30;
        int buttonHeight = 30;
        int margin = 20;

        scissor = new Button("Scissor");
        rock = new Button("rock");
        paper = new Button("paper");

        scissor.setBounds(buttonStartPosition, buttonStartPosition, 80, buttonHeight);
        rock.setBounds(buttonStartPosition + 100, buttonStartPosition, 80, buttonHeight);
        paper.setBounds(buttonStartPosition + 200, buttonStartPosition, 80, buttonHeight);

        scissor.addActionListener(this);
        rock.addActionListener(this);
        paper.addActionListener(this);

        add(scissor);
        add(rock);
        add(paper);

        // 스코어
        computer = new Label("");
        player = new Label("");
        scoreBar = new Label("");

        computer.setBounds(buttonStartPosition, buttonStartPosition + buttonHeight + margin, 140, 30);
        player.setBounds(buttonStartPosition + 140 + margin, buttonStartPosition + buttonHeight + margin, 140, 30);
        scoreBar.setBounds(buttonStartPosition, buttonStartPosition + buttonHeight + margin + 40, 280 + margin, 30);

        computer.setBackground(Color.PINK);
        player.setBackground(Color.CYAN);
        scoreBar.setBackground(Color.GREEN);

        add(computer);
        add(player);
        add(scoreBar);


        setSize(350, 200);
        setLocation(0, 0);

        setVisible(true);

        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //	JOptionPane.showMessageDialog(null, "버튼 클릭");
        int rand = game.rand();

        Button btn = (Button)e.getSource();
        String btnTitle = btn.getLabel();

        switch (btnTitle) {
            case "Scissor":
                game.play(rand, 0);
                break;
            case "rock":
                game.play(rand, 1);
                break;
            case "paper":
                game.play(rand, 2);
                break;
        }
        player.setText(btnTitle);
        computer.setText(game.convertToString(rand));
        scoreBar.setText(game.getScore());
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        System.exit(0);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}
