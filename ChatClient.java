/*
Compilação e Execução do Server:

javac ChatClient.java
java ChatClientjavac 

*/

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Client: ");
                String clientMessage = scanner.nextLine();
                out.println(clientMessage);

                String serverMessage = in.nextLine();
                System.out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}