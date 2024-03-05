package app;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
    private static int clientID = 0;
    private static final int HEIGHT = 300;
    private static final int WIDTH = 400;
    private static final int  POS_X = 300;
    private static final int POS_Y = 300;
    JButton start = new JButton("Connect");
    JButton stop = new JButton("Disconnect");
    JPanel buttons = new JPanel();
    JPanel netProtocol = new JPanel(new GridLayout(2,2));
    Client(){
        clientID++;
        setTitle(getClientID());
        setBounds(POS_X, POS_Y,  WIDTH, HEIGHT);

        buttons.add(start);
        buttons.add(stop);
        add(buttons, BorderLayout.SOUTH);


        netProtocol.add(new JTextField("server"));
        netProtocol.add(new JTextField("ip"));
        netProtocol.add(new JTextField("user"));
        netProtocol.add(new JTextField("password"));
        add(netProtocol, BorderLayout.NORTH);

        add(new JTextArea());

        setVisible(true);
    }

    private String getClientID(){
        return "Client " + clientID;
    }
}
