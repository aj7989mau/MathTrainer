package controllers;

import entity.Buffer;
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
    Socket socket;
    private String IP;
    private static final int PORT = 45678;

    /**
     * Creates the socket that connects to the server, gets buffers (from MainController) and starts the threads for
     * communicating with the server.
     */
    public NetworkController(){



    }

    public Object SendRequest(String Request){

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

        NetworkHandler networkHandler = new NetworkHandler(Request);
        return networkHandler.SendRequest();
    }

    /**
     * Receives the incoming messages from the server and adds them to the incoming buffer.
     */
    private class NetworkHandler{

        private String request;
        private Object object;

        public NetworkHandler(String request) {

            if (request.indexOf(' ') != -1) {
                this.request = request.substring(0, request.indexOf(' '));
                object = request.substring(request.indexOf(' ') + 1);
            } else {
                this.request = request;
                //TODO object behöver defineras
            }
        }

        public Object SendRequest(){
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
                returnValue = objectInputStream.readObject();
                System.out.println(returnValue);



            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error in network communcation");
                e.printStackTrace();
            }
        return returnValue;

        }
    }
}
