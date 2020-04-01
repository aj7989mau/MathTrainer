import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * MathTainer Server class, controls logic/communications with the MathTrainer Clients.
 * @author abdulsamisahil
 * @version 1.5
 * @since 2020-03-31
 *
 */
public class MServer extends Thread {

    private ServerSocket serverSocket;
 //   private DataOutputStream out;
 //   private DataInputStream in;
 //   private Socket server;
    private int port;
    /**
     * MTServer Constructor
     * @param port server listening to this port
     */
    public MServer(int port) {
        this.port = port;

        try {
            startServer();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is connecting the MTServer
     */
    private void startServer() throws IOException {

       // int port = 220;
        serverSocket = new ServerSocket(port);

        while (true) {

            try {
                Socket connect = serverSocket.accept();
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
               // waitForClient();
                ClientHandler t = new ClientHandler(connect);
                t.start();
                //  setupStreams();
            } catch (Exception e) {
                serverSocket.close();
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new MServer(220);
    }

    /**
     * The inner class the handles the users, we have not decided to build the product
     * server to handle different of users connected on different network (Multithreading),
     * but I will try to code,  in case we change our mind.
     * @author abdulsamisahil
     * @version 1.0
     * @since 2020.03.31
     *
     */
    class ClientHandler extends Thread {

        private Socket server;
        private DataInputStream in;
        private DataOutputStream out;
        private List<User> userList;

        /**
         * Constructor
         * @param server connects the client to server
         */
        public ClientHandler(Socket server) {
            this.server = server;
            try {
                setupStreams();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * This run method starts the thread that connects the server and users
         * The server listens to users as long as the ServerSocket is opened.
         */
        public void run() {
            try {
                while (server.isConnected()) {
                    try {
                        Course course = null;
                        // System.out.println("Which level do you want to start with?\n(a) Seventh\n(b) Eigth\n(c) Ninth\n");
                        out.writeUTF("Which level do you want to start with?\n(a) Seventh\n(b) Eigth\n(c) Ninth\n(d) leave now\n(e) Close Server\n");
                        String level = in.readUTF();
                        if (level.equals("a")) {
                            course = new Seventh();
                            addUser();
                            Questions[] questions = course.getQuestions();
                            takeTest(questions);
                        } else if (level.equals("b")) {
                            course = new Eighth();
                            addUser();
                            Questions[] questions = course.getQuestions();
                            takeTest(questions);
                        } else if (level.equals("c")) {
                            course = new Ninth();
                            addUser();
                            Questions[] questions = course.getQuestions();
                            takeTest(questions);
                        }
                        //QUIT CLIENT
                        else if (level.equals("d")) {
                            try {
                                System.out.println("Connection to " + this.server + " closed.");
                                this.server.close();
                                this.in.close();
                                this.out.close();
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        //KILL SERVER
                        else if (level.equals("e")) {
                            try {
                                System.out.println("Closing server...");
                                this.server.close();
                                this.in.close();
                                this.out.close();
                                System.exit(0);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            out.writeUTF("Invalid Option");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                System.out.println("Check me exception in server");
            }
        }

        /**
         * This method adds the user to a collection
         * @throws IOException catches exceptions
         */
        private void addUser() throws IOException {
            out.writeUTF("Please enter your username");
            String username = in.readUTF();
            out.writeUTF("Please enter your age");
            int userAge = in.readInt();
            out.writeUTF("Please enter your id");
            String id = in.readUTF();


            User user = new User(username, userAge, id);
            userList = new ArrayList<>();
            userList.add(user);

            out.writeUTF("Mr " + username + ", you are admitted to the course");
            out.writeUTF("\nEnjoy your test!\n");
        }

        /**
         * As soon as the user starts, this method starts the test
         * @param questions takes an array of Question class,
         * @throws IOException catches the errors
         */
        private void takeTest(Questions[] questions) throws IOException {
            int score = 0;

            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                String answer = in.readUTF();
                if (answer.equals(questions[i].getAnswer())) {
                    score++;
                }
            }
            String str = "Dear Mr ";
            out.writeUTF(str + ", you got" + score + "/" + questions.length);
        }
        /**
         * This method runs once MTServer gets active and awaits for any user to turn up!
         * Once any user is trying to connect the MTServer accepts it.
         *
         */
        private void waitForClient() throws Exception {
            server = serverSocket.accept();
            System.out.println("Just connected to " + server.getInetAddress().getHostName());
         //   setupStreams();
        }
        /**
         * This method initializes and setups the streams that holds/read/writes the data input from the user
         */
        private void setupStreams() throws IOException {
            in = new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to " + server.getInetAddress().getHostName());
            out.flush();
        }
    }
}