package com.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetMain {

    public static void main(String[] args) throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostAddress();

        System.out.println("hostname:" + hostname);

    }
}
