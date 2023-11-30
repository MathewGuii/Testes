/*
Compilação e Execução do Server:

javac ChatServer.java
java ChatServer

*/

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running. Waiting for clients...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            Scanner in = new Scanner(clientSocket.getInputStream());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                String clientMessage = in.nextLine();
                System.out.println("Client: " + clientMessage);

                System.out.print("Server: ");
                String serverMessage = scanner.nextLine();
                out.println(serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}