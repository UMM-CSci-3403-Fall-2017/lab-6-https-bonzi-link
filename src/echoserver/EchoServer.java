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
            int myByte;
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            System.out.println("Got a request!");
            while ((myByte =inStream.read()) != -1) {
                outStream.write(myByte);
            }


            outStream.flush();
            System.out.flush();
            client.close();

        } catch (IOException ioe) {
            System.err.println("OUCH!");
            System.err.println(ioe);
        }
    }
}