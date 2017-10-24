package echoserver;

//import jdk.internal.util.xml.impl.Input;

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSock = new ServerSocket(6013);
            byte[] bytes = new byte[1024*128];
            //InputStream fileInput = sock.getI
            while (true) {
                System.out.println("Got a request!");
                Socket client = serverSock.accept();
                InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();
                int count;
                while((count = inStream.read(bytes)) > 0) {
                    outStream.write(bytes, 0, count);
                }


                //PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                //writer.println(new java.util.Date().toString());

                client.close();
            }

        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}