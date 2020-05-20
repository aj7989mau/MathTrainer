package Server;

import sharedEntities.Questions;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Questions.Sixth;
import sharedEntities.User;


/**
 * MathTainer Server class, controls logic/communications with the MathTrainer Clients.
 *
 * @author abdulsamisahil, Motaz Kasem
 * @version 1.5
 * @since 2020-03-31
 */
public class MServer extends Thread {

    private ServerSocket serverSocket;
    private boolean keepRunning;
    private int port;
    private String fileLocation;
    private ArrayList<User> usersList;
    private User user;
    private boolean isUserNew = true;
    private boolean isLoginSucceeded;

    /**
     * MTServer Constructor
     *
     * @param port server listening to this port
     */
    public MServer(int port) throws FileNotFoundException {
        this.port = port;
        keepRunning = true;
        usersList = new ArrayList<>();
        fileLocation = System.getProperty("user.dir") + "/inloggningsUppgifter.dat";
        System.out.println(fileLocation);
        readFile(fileLocation);

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

    private void readFile(String fileLocation) throws FileNotFoundException {

        String line;
        String username = null;
        String password = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileLocation));

            while ((user = (User)ois.readObject()) != null) {

                /*String[] tokenize = line.split("\n");

                for (int i = 0; i < tokenize.length; i++) {
                    username = tokenize[i]; //Saving first
                    password = br.readLine();//saving second line after username to password
                }
                user = new User(username, password);*/

                usersList.add(user);
                System.out.println(user);
            }
            ois.close();
            System.out.println("Size of user array: " + usersList.size());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        new MServer(45679);
    }

    /**
     * The inner class the handles the users, we have not decided to build the product
     * server to handle different of users connected on different network (Multithreading),
     * but I will try to code,  in case we change our mind.
     *
     * @author abdulsamisahil, Motaz Kasem, Johanna Dahlborn
     * @version 3.0
     * @since 2020.04.29
     */
    class ClientHandler extends Thread {

        private Socket server;

        private ObjectInputStream ois;
        private ObjectOutputStream oos;


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
                Server.Course course = null;
                Questions[] questions = null;
                try {
                    String input = ois.readUTF();
                    if (input.equals("Login")) {
                        User user = (User) ois.readObject();
                        user = isLoginSucceeded(user);
                        if (user != null) {
                            System.out.println("Writing " + user);
                            oos.writeObject(user);
                        } else {
                            System.out.println("Login failed");
                            oos.writeObject("Inloggning misslyckad: Felaktigt användarnamn eller lösenord!");
                        }
                    } else if (input.equals("NewUser")) {

                        User user = (User) ois.readObject();
                        boolean isUserNew = newUser(user);
                        if (isUserNew) {
                            usersList.add(user);
                            //Adding new user to the text file as well
                            ObjectOutputStream fileStream = new ObjectOutputStream(new FileOutputStream(fileLocation));
                            fileStream.writeObject(user);
                            fileStream.flush();
                            //Sending it back to the client
                            oos.writeObject(user);

                        } else {
                            oos.writeObject("Inloggning misslyckad: Användarnamnet är upptaget");
                        }
                    } else if (input.equals("Questions")) {
                        System.out.println("Checking questions");
                        course = new Sixth();

                        String answerTypeOfQuestion = (String) ois.readObject();
                        System.out.println("Recieved: " + answerTypeOfQuestion);
                        if (answerTypeOfQuestion.equals("Geometry")) {
                            oos.writeObject(course.getGeometryQuestions());
                        } else if (answerTypeOfQuestion.equals("Counting")) {
                            oos.writeObject(course.getFourCountQuestions());
                        } else if (answerTypeOfQuestion.equals("Statistics")) {
                            oos.writeObject(course.getStatisticQuestion());
                        }
                        //Todo: else sats om något är ogiltigt har valts
                    } else if (input.equals("Result")) {

                    } else if (input.equals("UserStats")) {
                        //TODO: Vi skickar ett user objekt
                        // svara med en String med användarens statistik, ni får välja format själva :D
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        /**
         * Add a new user
         */
        private boolean newUser(User user) {
            for (int i = 0; i < usersList.size(); i++) {
                if (user.getUserName().equals(usersList.get(i).getUserName())) {
                    isUserNew = false;
                }
            }
            return isUserNew;
        }
       /* private void addUser() throws IOException {
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
        }*/

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

            oos.flush(); // sends everything that the user wants

        }

        /**
         * If the user is already registered and wants to login to the system
         */
        private User isLoginSucceeded(User receivedUser) throws IOException, ClassNotFoundException {
            String username = receivedUser.getUserName();
            String password = receivedUser.getPassword();
            //  System.out.println(username + " " + password);
            User user = null;
            for (int i = 0; i < usersList.size(); i++) {
                  System.out.println("Testing array -  " + usersList.get(i));
                   System.out.println("Usernames: " + usersList.get(i).getUserName());
                    System.out.println("Passwords: " + usersList.get(i).getPassword());
                if ((username.equals(usersList.get(i).getUserName())) && (password.equals(usersList.get(i).getPassword()))) {
                    user = usersList.get(i);
                }
            }
            return user;
            /*boolean login = false;
            String username = receivedUser.getUserName();
            String password = receivedUser.getPassword();

            for (int i = 0; i < usersList.size(); i++) {
                if (username.equals(usersList.get(i).getUserName())) {
                    if (password.equals(usersList.get(i).getPassword())) {
                        login = true;

                    }

                } else {
                    login = false;
                }
            }
            return login;*/
        }

        /**
         * Starts the quiz
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
        /*private void closeClient() {
            try {
                System.out.println("Connection to " + this.server + " closed.");
                this.server.close();
                this.inputStream.close();
                this.outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
    }
}