package Server;
import java.io.*;
import java.net.Socket;

/**
 * Used to keep track of a client's socket and its corresponding input and output streams. //stream eller inte
 * @author JohannaDahlborn
 * @version
 * @since 2020-04-21
 */

public class Client extends Thread {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Client(Socket socket) throws IOException {
        this.socket = socket;

        //strömmarna som kopplade
        input = new ObjectInputStream(socket.getInputStream());
        output = new ObjectOutputStream(socket.getOutputStream());
    }

    public void run(){
        //skriv vad den ska hämta
    }

    /**
     * Attempts to disconnect this client's socket.
     */
    public void disconnect() {
        try {
            socket.close();
        } catch (IOException ignore) {
            // Ignored because a client is removed from clients even if the socket close fails.
        }
    }

    /**
     * @return a User object from the input stream.
     * @throws IOException
     */
    public User readUser() throws IOException {
        try {
            return (User) input.readObject();
        } catch (ClassNotFoundException e) {
            // ClassNotFoundException here is a programming error which would be caused by
            // missing or unmatched User classes between client and server. Because it's
            // a programming error, it's appropriate to wrap it in a RuntimeException.
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads from the client's input stream and expects a Result.
     * @return a result read from the client's input stream.
     * @throws IOException
     */
    public Result readResult() throws IOException {
        try {
            return (Result) input.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Client{" + "socket=" + socket + '}';
    }

}
