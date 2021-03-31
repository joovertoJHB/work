package za.co.wethinkcode.examples.server;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        try (
                Socket socket = new Socket("localhost", 5000);
                PrintStream out = new PrintStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
        )
        {
            System.out.println("Enter a message for the server");
            String msg = scanner.nextLine();
            out.println(msg);
            out.flush();
            String messageFromServer = in.readLine();
            System.out.println("Response: "+messageFromServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}