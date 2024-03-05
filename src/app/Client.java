package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ENTER;

public class Client extends JFrame {
    private String userName;
    private String password;
    private static int clientID = 0;
    private static final int HEIGHT = 300;
    private static final int WIDTH = 400;
    private static final int  POS_X = 300;
    private static final int POS_Y = 300;
    private boolean isConnect = false;
    JButton btnStart = new JButton("Connect");
    JButton btnStop = new JButton("Disconnect");
    JPanel buttons = new JPanel();
    JPanel netProtocol = new JPanel(new GridLayout(2,2));
    JPanel bottomGroup = new JPanel(new GridLayout(2,1));
    JPanel buttonsGroup = new JPanel();
    JTextField inputField = new JTextField();
    JTextField userNameField = new JTextField("user");
    Client(){
        userName = userNameField.getText();
        clientID++;
        setTitle(getClientID());
        setBounds(POS_X, POS_Y,  WIDTH, HEIGHT);

        buttons.add(btnStart);
        buttons.add(btnStop);
        add(buttons, BorderLayout.SOUTH);
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    String txt = getUserName() +": " + inputField.getText();
                    Logs.saveToLogsFile(txt);
                    Server.setCurrentMessage(txt);
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

        add(new JTextArea());

        setVisible(true);
    }

    private String getClientID(){
        return "Client " + clientID;
    }
    private String getUserName(){
        return this.userName;
    }
    private void setUserName(String userName){
        this.userName = userName;
    }
    private void setConnection(){
        if (Server.isStart) isConnect = true;
        else serverIsNotAvalible();
    }
    private String serverIsNotAvalible(){
        return "Server is not avalible";
    }
}
