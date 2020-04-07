import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Client class was needed to test the Server side
 * @author abdulsamisahil
 * @since 2020-04-06
 */
public class MClient {
    public static void main(String[] args) throws IOException {
        // String serverName = args[0];
        InetAddress serverName = InetAddress.getLocalHost();
        //int port = Integer.parseInt(args[1]);
        int port = 22;
        Scanner userInput = new Scanner(System.in);
        String userChoice = "";

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream outputStream = new DataOutputStream(outToServer);

            outputStream.writeUTF("Hello from " + client.getLocalSocketAddress());
            outputStream.flush();

            InputStream inFromServer = client.getInputStream();
            DataInputStream inputStream = new DataInputStream(inFromServer);

            System.out.println("Server says " + inputStream.readUTF());


            while(true) {
                DataInputStream inputStream1 = new DataInputStream(client.getInputStream());
                System.out.print(">");
                //       userChoice = userInput.nextLine();
                System.out.println(inputStream.readUTF());
                userChoice = userInput.nextLine();
                outputStream.writeUTF(userChoice);
                //  System.out.println(inputStream.readUTF());
                //  userChoice = userInput.nextLine();
                //  outputStream.writeUTF(userChoice);
                //  System.out.println(inputStream.readUTF());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}