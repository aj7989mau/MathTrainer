package controllers;

import entity.Buffer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/** Class Network handles the outgoing and incoming information to and from the server. It connects with a socket,
 * sets up streams and has two inner classes handling the monitoring for new information to send or recieve.
 * @author Niklas Hultin
 * @version 1.0
 */

//git

public class NetworkController {
    Socket socket;
    private static final String IP = "";
    private static final int PORT = 0;

    //Ej säkert att buffrarna under blir String, men det får vara så så länge. Buffrarna är samma som i MainController-klassen
    private Buffer<String> incomingBuffer; //Tanken är att denna klass bara ska lägga in objekt i denna buffer
    private Buffer<String> outgoingBuffer; //Tanken är att denna klass bara ska hämta objekt från denna buffer

    /**
     * Creates the socket that connects to the server, gets buffers (from MainController) and starts the threads for
     * communicating with the server.
     * @param incoming Buffer shared with MainController. Network only adds incoming messages from the server to it.
     * @param outgoing Buffer shared with MainController. Network only gets outgoing messages to the server from it.
     */
    public NetworkController(Buffer<String> incoming, Buffer<String> outgoing){
        try {
            socket = new Socket(IP, PORT);
        } catch (IOException e) {
            System.out.println("Error trying to connect");
            e.printStackTrace();
        }

        this.incomingBuffer = incoming;
        this.outgoingBuffer = outgoing;

        new InputThread().start();
        new OutputThread().start();
    }


    /**
     * Receives the incoming messages from the server and adds them to the incoming buffer.
     */
    private class InputThread extends Thread{

        public void run(){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                while (!Thread.interrupted()){
                    incomingBuffer.put(objectInputStream.readUTF()); //Vi får komma överens om hur vi ska kommunicera, readUTF kanske ej blir rätt
                }
            } catch (IOException e) {
                System.out.println("Error in input stream");
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds the outgoing messages from the outgoing buffer to the output stream for the server to receive.
     */
    private class OutputThread extends Thread{

        public void run(){
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                while (!Thread.interrupted()){
                    objectOutputStream.writeUTF(outgoingBuffer.get()); //Vi får komma överens om hur vi ska kommunicera, readUTF kanske ej blir rätt
                }
            } catch (IOException e) {
                System.out.println("Error in output stream");
                e.printStackTrace();
            } catch (InterruptedException e) {
                System.out.println("Error in buffer");
                e.printStackTrace();
            }
        }
    }
}
