package app;

public class App {
    public static void main(String[] args) {
        new Server();

        Client client1 = new Client();
        Client client2 = new Client();

        Server.clientList.add(client1);
        Server.clientList.add(client2);
    }
}
