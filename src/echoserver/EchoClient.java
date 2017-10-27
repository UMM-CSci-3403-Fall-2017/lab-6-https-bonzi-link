package echoserver;



import java.net.*;
import java.io.*;


public class EchoClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("Acrylic.morris.umn.edu", 6013);
            // You can change 127.0.0.1 to a machine name if you want to try this across
            // the network to another machine.
            // Socket socket = new Socket("some.machine.edu", 6013);
                int myByte;
                InputStream serverIn = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                while((myByte = System.in.read())!=-1){
                    out.write((byte)myByte);
                    System.out.write(serverIn.read());
                }

                socket.close();

        } catch (IOException ioe) {
            System.out.println("We caught an exception");
            System.err.println(ioe);
        }
    }
}