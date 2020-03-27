import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * MathTainer Server class
 * @author abdulsamisahil
 * @version 1.4
 * @since 2020-03-26
 *
 */
public class MServer extends Thread {

    private ServerSocket serverSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private Socket server;

    public MServer() {
        try {
            startServer();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startServer() throws IOException {

        int port = 220;
        serverSocket = new ServerSocket(port);

        while (true) {
            server = null;
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                waitForClient();
                Thread t = new ClientHandler(server, in, out);
                t.start();
                //  setupStreams();
            } catch (Exception e) {
                server.close();
                e.printStackTrace();
            }
        }
    }

    private void waitForClient() throws Exception {
        server = serverSocket.accept();
        System.out.println("Just connected to " + server.getInetAddress().getHostName());
        setupStreams();
    }

    private void setupStreams() throws IOException {
        in = new DataInputStream(server.getInputStream());
        System.out.println(in.readUTF());
        out = new DataOutputStream(server.getOutputStream());
        out.writeUTF("Thank you for connecting to " + server.getInetAddress().getHostName());
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        new MServer();
    }

    class ClientHandler extends Thread {

        private Socket connection;
        private DataInputStream in;
        private DataOutputStream out;
        private List<User> userList;

        public ClientHandler(Socket connection, DataInputStream in, DataOutputStream out) {
            this.connection = connection;
            this.in = in;
            this.out = out;
        }

        public void run() {
            try {
                while (connection.isConnected()) {
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
                                System.out.println("Connection to " + this.connection + " closed.");
                                this.connection.close();
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
                                this.connection.close();
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
    }
}