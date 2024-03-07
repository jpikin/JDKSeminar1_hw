package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Client extends JFrame {
    private boolean isOnline = false;
    private String clientName;
    private String userName;
    private String password;
    private static int clientID = 0;
    private static final int HEIGHT = 300;
    private static final int WIDTH = 400;
    private static final int POS_X = 300;
    private static final int POS_Y = 300;
    JButton btnStart = new JButton("Connect");
    JButton btnStop = new JButton("Disconnect");
    JPanel buttons = new JPanel();
    JPanel netProtocol = new JPanel(new GridLayout(2, 2));
    JPanel bottomGroup = new JPanel(new GridLayout(2, 1));
    JPanel buttonsGroup = new JPanel();
    JTextField inputField = new JTextField();
    JTextField userNameField = new JTextField("user");
    JTextArea chat = new JTextArea();

    Client() {
        userName = userNameField.getText();
        clientID++;
        clientName = getClientID();
        setTitle(getClientID());
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);

        buttons.add(btnStart);
        buttons.add(btnStop);
        add(buttons, BorderLayout.SOUTH);
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (isOnline) {
                    if (e.getKeyChar() == '\n') {
                        String txt = getUserName() + ": " + inputField.getText();
                        Server.setCurrentMessage(txt);
                        inputField.setText("");
                    }
                } else {
                    chat.setText("Not connected to server");
                    inputField.setText("");
                }
            }
        });
        userNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                userName = userNameField.getText();
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Server.isStarted) {
                    isOnline = true;
                    chat.setText("Connected to server\n" + Server.chat.getText());
                } else {
                    chat.setText("Server is not available");
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOnline) {
                    isOnline = false;
                    chat.setText("Disconnected from server");
                }
            }
        });

        bottomGroup.add(inputField, BorderLayout.NORTH);
        buttonsGroup.add(btnStart);
        buttonsGroup.add(btnStop);
        bottomGroup.add(buttonsGroup);
        add(bottomGroup, BorderLayout.SOUTH);


        netProtocol.add(new JTextField("server"));
        netProtocol.add(new JTextField("ip"));
        netProtocol.add(userNameField);
        netProtocol.add(new JTextField("password"));
        add(netProtocol, BorderLayout.NORTH);

        add(chat);

        setVisible(true);
    }

    private String getClientID() {
        return "Client " + clientID;
    }

    private String getUserName() {
        return this.userName;
    }

    @Override
    public String toString() {
        return getClientID();
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public static void disconnect() {
        for (Client c : Server.clientList){
            if (c.isOnline) {
                c.isOnline = false;
                c.chat.setText("Server was shutdown");
            }
        }
    }
}
