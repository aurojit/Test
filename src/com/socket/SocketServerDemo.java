package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;

public class SocketServerDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Welcome in ServerSocket");
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Waiting for client");
        while (true) {
            Socket s = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = br.readLine();
            Thread.sleep(5000);
            System.out.println("Client Data :" + str);
        }
    }
}
