package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Server extends JFrame {
    private static final int HEIGHT = 300;
    private static final int WIDTH = 400;
    private static final int POS_X = 600;
    private static final int POS_Y = 600;
    public static boolean isStarted = false;
    public static String currentMessage = "";
    static ArrayList<Client> clientList = new ArrayList<>();
    JButton btnStart = new JButton("Start server");
    JButton btnStop = new JButton("Close server");
    JPanel netProtocol = new JPanel(new GridLayout(2, 2));
    JPanel buttonsGroup = new JPanel();
    static JTextArea chat = new JTextArea();


    Server() {
        setTitle("Server");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStarted = true;
                Logs.readLogs();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStarted = false;
                Client.disconnect();
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

    /**
     * Метод формирует текущее сообщение, вызывает метод логирования и метод отправки текущего сообщения всем клиентам.
     * @param txt Текущее сообщение.
     */
    public static void setCurrentMessage(String txt) {
        currentMessage = txt;
        chat.setText(chat.getText()  + txt + '\n');
        sendChat();
        Logs.saveLogs(txt + '\n');
    }

    /**
     * Метод отправляет текущее сообщение всем клиентам ОНЛАЙН.
     */
    private static void sendChat(){
        for (Client c : clientList) {
            if (c.getIsOnline())
                c.chat.setText(chat.getText());
        }
    }

}
