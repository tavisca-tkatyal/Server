package com.tavisca.http;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(5000);
            Socket socket = server.accept();//establish connection and wait for clients
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Hi Client, I am Server");
            String messageReceivedFromClient = (String)dataInputStream.readUTF();
            System.out.println("message from client is "+messageReceivedFromClient);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}