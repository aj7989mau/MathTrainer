package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/** Class Network handles the outgoing and incoming information to and from the server. It connects with a socket,
 * sets up streams and has two inner classes handling the monitoring for new information to send or recieve.
 * @author Niklas Hultin
 * @version 1.0
 */

public class NetworkController {
    private Socket socket;
    private String IP;
    private static final int PORT = 45678;

    /**
     * Creates the socket that connects to the server, gets buffers (from MainController) and starts the threads for
     * communicating with the server.
     */
    public NetworkController(){



    }

    private void establishConnection(){
        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            socket = new Socket(IP, PORT);
        } catch (IOException e) {
            System.out.println("Error trying to connect");
            e.printStackTrace();
        }
    }

    public Object sendRequest(String request){
        establishConnection();

        NetworkHandler networkHandler = new NetworkHandler(request);
        return networkHandler.sendRequest();
    }

    public Object sendRequest(String request, Object object){
        establishConnection();

        NetworkHandler networkHandler = new NetworkHandler(request, object);
        return networkHandler.sendRequest();
    }

    /**
     * Receives the incoming messages from the server and adds them to the incoming buffer.
     */
    private class NetworkHandler{

        private String request;
        private Object object;

        public NetworkHandler(String request) {
            this.request = request.substring(0,request.indexOf(' '));
            this.object = request.substring(request.indexOf(' ')+1);
        }


        public NetworkHandler(String request, Object object) {
            this.request = request;
            this.object = object;
        }


        public Object sendRequest(){
            ObjectOutputStream objectOutputStream;
            ObjectInputStream objectInputStream;

            Object returnValue = null;
            try {
               objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
               objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream.writeUTF(request);
                System.out.println("Sent " + request);
                objectOutputStream.writeObject(object);
                System.out.println("Sent " + object);
                objectOutputStream.flush();
                returnValue = objectInputStream.readObject();
                System.out.println(returnValue);
                objectOutputStream.close();
                objectInputStream.close();


            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error in network communcation");
                e.printStackTrace();
            }
            System.out.println("Received " + returnValue);
        return returnValue;

        }
    }
}
