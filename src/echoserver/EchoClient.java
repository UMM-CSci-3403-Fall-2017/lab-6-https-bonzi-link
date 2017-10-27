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

                // a byte that will take the value of the standard input
                int myByte;

                /*
                These take the value of the input and output from the socket.
                 */
                InputStream serverIn = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                /*
                    until this loop doesn't receive a byte, it will write the standard input
                    to the output stream.
                 */
                while((myByte = System.in.read())!=-1){
                    out.write((byte)myByte);
                    System.out.write(serverIn.read());
                }

                //Flushing and closing the output streams to ensure that before the socket is closed, every last bit of
                // data is written.
                out.flush();
                System.out.flush();
                socket.close();
                serverIn.close();
                out.close();

        } catch (IOException ioe) {
            System.out.println("We caught an exception");
            System.err.println(ioe);
        }
    }
}