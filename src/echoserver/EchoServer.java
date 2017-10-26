package echoserver;

//import jdk.internal.util.xml.impl.Input;

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSock = new ServerSocket(6013);

            //InputStream fileInput = sock.getI
            Socket client = serverSock.accept();
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            while (inStream.read() != -1) {
                System.out.println("Got a request!");
                int count;

                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(inStream.read());
            }
            client.close();

        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}