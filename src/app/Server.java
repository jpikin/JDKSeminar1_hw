package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ENTER;

public class Server extends JFrame {
    private static final int HEIGHT = 300;
    private static final int WIDTH = 400;
    private static final int  POS_X = 600;
    private static final int POS_Y = 600;
    public static boolean isStart = false;
    public static String currentMessage = "";
    JButton btnStart = new JButton("Start server");
    JButton btnStop = new JButton("Close server");
    JPanel bottomGroup = new JPanel(new GridLayout(2,1));
    JPanel netProtocol = new JPanel(new GridLayout(2,2));
    JPanel buttonsGroup = new JPanel();
    static JTextArea chat = new JTextArea();



    Server(){
        setTitle("Server");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y,  WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStart = true;
                Logs.readLogs();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStart = false;
            }
        });


        buttonsGroup.add(btnStart);
        buttonsGroup.add(btnStop);

        add(buttonsGroup, BorderLayout.SOUTH);



        netProtocol.add(new JTextField("server"));
        netProtocol.add(new JTextField("ip"));
        netProtocol.add(new JTextField("user"));
        netProtocol.add(new JTextField("password"));
        add(netProtocol, BorderLayout.NORTH);


        add(chat);

        setVisible(true);
    }
    public static void setCurrentMessage(String txt){
        currentMessage = txt;
        chat.setText(txt + '\n');

    }
}
