package app;

import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {
    private static final int HEIGHT = 300;
    private static final int WIDTH = 400;
    private static final int  POS_X = 600;
    private static final int POS_Y = 600;
    JButton start = new JButton("Start session");
    JButton stop = new JButton("Close connection");
    JPanel buttons = new JPanel();

    Server(){
        setTitle("Server");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y,  WIDTH, HEIGHT);

        buttons.add(start);
        buttons.add(stop);
        add(buttons, BorderLayout.SOUTH);

        setVisible(true);
    }
}
