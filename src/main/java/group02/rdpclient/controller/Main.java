package group02.rdpclient.controller;

import group02.rdpclient.socket.Client;

public class Main {
    public static void main(String[] args) {
        Client.connect();
        Client.getKeyStrokeOn();
        try {
            Thread.sleep(10000);
            Client.getKeyStrokeOff();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
