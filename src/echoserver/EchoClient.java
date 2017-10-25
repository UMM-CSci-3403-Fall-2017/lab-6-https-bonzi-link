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



                File file = new File(args[0]);
                System.out.println(file.toString());
                File output = new File(args[1]);
                System.out.println(output.toString());
                InputStream fileInput = new FileInputStream(file);
                byte[] bytes = new byte[1024 * 128];
                OutputStream out = socket.getOutputStream();


                int count;
                while ((count = fileInput.read(bytes)) > 0) {
                    out.write(bytes, 0, count);
                    System.out.println(socket.getInputStream().toString());
                }


                out.close();
                fileInput.close();
                socket.close();

        } catch (IOException ioe) {
            System.out.println("We caught an exception");
            System.err.println(ioe);
        }
    }
}