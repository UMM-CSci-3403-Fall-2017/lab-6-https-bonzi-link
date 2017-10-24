package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6013);
            byte[] bytes = new byte[1024];
            //InputStream fileInput = sock.getI
            while (true) {
                System.out.println("Got a request!");
                Socket client = sock.accept();

                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                writer.println(new java.util.Date().toString());

                client.close();
            }

        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}