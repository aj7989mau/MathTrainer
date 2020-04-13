import java.net.*;
import java.io.*;
import java.util.Scanner;


public class MClient {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Socket connection;
    private InetAddress serverIp;
    private int port;
    private boolean keepRunning;
    public MClient(InetAddress s, int port){
        this.serverIp = s;
        this.port = port;
        keepRunning = true;

        try {
            //Connecting to server
            System.out.println("Connecting to " + serverIp + " on port " + port);
            connection = new Socket(serverIp, port);
            System.out.println("Just connected to the server");

            //Setup streams
            inputStream = new DataInputStream(connection.getInputStream());
            outputStream = new DataOutputStream(connection.getOutputStream());
            //Send a msg to server to confirm connection
            outputStream.writeUTF("Hello from " + connection.getLocalAddress().getHostName());
            outputStream.flush();
            //Receive a thank for connection from server and print it to the screen
            System.out.println("Server says " + inputStream.readUTF() + "\n");
            whileConnected();

        }catch (Exception e){

        }
    }
    private void whileConnected() throws Exception{
        Scanner userInput = new Scanner(System.in);
        String userChoice;
        while (keepRunning){
          //  System.out.print("*");
            System.out.println(inputStream.readUTF());
            userChoice = userInput.nextLine();
            outputStream.writeUTF(userChoice);
        }
    }
    public static void main(String[] args) throws IOException {
        InetAddress serverName = InetAddress.getLocalHost();
        int port = 22;
        new MClient(serverName, port);
    }
}