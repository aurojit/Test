package com.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9999);

        String str = "Aurojit Basak";

        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(str);
        pw.flush();
    }
}
