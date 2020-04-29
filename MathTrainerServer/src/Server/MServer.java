package Server;

import Questions.Questions;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import Questions.Eighth;
import Questions.Ninth;
import Questions.Seventh;
import Questions.Sixth;


/**
 * MathTainer Server class, controls logic/communications with the MathTrainer Clients.
 * @author abdulsamisahil
 * @version 1.5
 * @since 2020-03-31
 */
public class MServer extends Thread {

    private ServerSocket serverSocket;
    private boolean keepRunning;
    private int port;
    /**
     * MTServer Constructor
     * @param port server listening to this port
     */
    public MServer(int port) {
        this.port = port;
        keepRunning = true;

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

       // Starting server
        serverSocket = new ServerSocket(port);
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
        while (keepRunning) {

            try {

                Socket connect = serverSocket.accept();
                System.out.println("Connection successful");
                Thread t = new ClientHandler(connect);
                t.start();
            } catch (Exception e) {
                serverSocket.close();
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new MServer(22);
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
        private DataInputStream inputStream;
        private DataOutputStream outputStream;
        private List<Server.User> userList = new ArrayList<>();
        private ObjectInputStream ois;
        private ObjectOutputStream oos;
        private Server.Client client;

        /**
         * Constructor
         * @param server connects the client to server
         */
        public ClientHandler(Socket server) throws IOException {
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
                    Server.Course course = null;
                    Questions [] questions = null;
                    try {
                        //addUser();
                        userLogIn();
                        ois.readUTF();
                        String input = ois.readUTF();
                        if (input.equals("Login")) {

                            userLogIn();


                        }else if(input.equals("Questions")){
                            oos.writeUTF("Välj årskurs");
                            String answer = ois.readUTF();
                            if(answer.equals("årskurs 6")){
                                course = new Sixth();
                                oos.writeUTF("Välj typ av fråga");
                                String answerTypeOfQuestion = ois.readUTF();
                                if(answerTypeOfQuestion.equals("Geometry")){
                                    questions = course.getGeometryQuestions();
                                    takeTest(questions);
                                }else if(answerTypeOfQuestion.equals("Four counting ways")){
                                    questions = course.getFourCountQuestions();
                                    takeTest(questions);
                                }else if(answerTypeOfQuestion.equals("Statisk")){
                                    questions = course.getStatisticQuestion();
                                    takeTest(questions);
                                }
                            }else if(answer.equals("Årskurs 7")){
                               // course = new Seventh();
                            }
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
            outputStream.writeUTF("Enter your username");
            String username = inputStream.readUTF();
            outputStream.writeUTF("Enter your age");
            int userAge = inputStream.readInt(); //
            outputStream.writeUTF("Enter your id");
            String id = inputStream.readUTF();
            outputStream.writeUTF("Enter your email address");
            String userEmail = inputStream.readUTF();
            outputStream.writeUTF("Choose a password");
            String userPassword = inputStream.readUTF();
            outputStream.writeUTF("Enter your school name");
            String userSchool = inputStream.readUTF();
            outputStream.writeUTF("Enter your city");
            String userCity = inputStream.readUTF();
            //outputStream.writeUTF("Registration successful");

          //  outputStream.writeUTF("");
          //  outputStream.writeUTF("Mr " + username + ", you are admitted to the course, press enter!");
          //  outputStream.writeUTF("\nPress enter and enjoy your test!\n");
            //  outputStream.flush();

            User user = new User(username, userAge, userEmail, userPassword, userSchool, userCity, id);
            userList.add(user);
            System.out.println("User Mr " + username + " is added to the course");
        }

        /**
         * As soon as the user starts, this method starts the test
         * @param questions takes an array of Question class,
         * @throws IOException catches the errors
         */
        private void takeTest(Questions[] questions) throws IOException {
            int score = 0;
            for (int i = 0; i < questions.length; i++) {
                oos.writeUTF(questions[i].getQuestion());
                String answer = ois.readUTF();
                if (answer.equals(questions[i].getAnswer())) {
                    score++;
                }
            }
            String str = "Resultat ";
            oos.writeUTF(str + ", you got " + score + "/" + questions.length);
        }
        /**
         * This method initializes and setups the streams that holds/read/writes the data input from the users
         */
        private void setupStreams() throws IOException {
            ois = new ObjectInputStream(server.getInputStream());
            oos = new ObjectOutputStream(server.getOutputStream());

            oos.flush(); // skickar allt som användaren vill få fram

            /*
            inputStream = new DataInputStream(server.getInputStream());
            System.out.println(inputStream.readUTF());
            outputStream = new DataOutputStream(server.getOutputStream());
            outputStream.writeUTF("Thank you for connecting to " + server.getInetAddress().getHostName());
            outputStream.flush();*/
        }
        /**
         * If the user is already registered and wants to login to the system
         */
        private void userLogIn()
        {


        }

        /**
         * Start quiz
         */
       /* private void startQuiz()
        {
            Course course;
            try {
                outputStream.writeUTF("Which level do you want to start with?\n(d) Seventh\n(e) Eigth\n(f) Ninth\n(g) leave now\n(h) Close Server\n");
                String level = inputStream.readUTF();
                if (level.equals("d")) {
                    course = new Seventh();
                    //   addUser();
                    Questions[] questions = course.getQuestions();
                    takeTest(questions);
                } else if (level.equals("e")) {
                    //course = new Eighth();
                    //    addUser();
                    Questions[] questions = course.getQuestions();
                    takeTest(questions);
                } else if (level.equals("f")) {
                    //course = new Ninth();
                    //    addUser();
                    Questions[] questions = course.getQuestions();
                    takeTest(questions);
                }
                //QUIT CLIENT
                else if (level.equals("g"))
                {
                    closeClient();
                }
                //KILL SERVER
                else if (level.equals("h")) {
                    try {
                        System.out.println("Closing server...");
                        this.server.close();
                        this.inputStream.close();
                        this.outputStream.close();
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    outputStream.writeUTF("Invalid Option");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        /**
         * Quit User
         */ 
        private void closeClient()
        {
            try {
                System.out.println("Connection to " + this.server + " closed.");
                this.server.close();
                this.inputStream.close();
                this.outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}