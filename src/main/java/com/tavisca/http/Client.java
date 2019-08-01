package com.tavisca.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String args[]) {

        try {
            Socket socket = new Socket("localhost", 5000);
            DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
            dout.writeUTF("Hello Server");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String str = (String)dataInputStream.readUTF();
            System.out.println("Message from Server is "+str);
            dout.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}