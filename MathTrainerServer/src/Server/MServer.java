package Server;

import sharedEntities.Questions;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import Questions.Sixth;
import sharedEntities.User;


/**
 * MathTainer Server class, controls logic/communications with the MathTrainer Clients.
 *
 * @author abdulsamisahil
 * @version 1.5
 * @since 2020-05-27
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
     * Constructs MServer
     * @param port that the server will be listening on
     */
    public MServer(int port) throws FileNotFoundException {
        this.port = port;
        keepRunning = true;
        usersList = new ArrayList<>();
        usersList.add(new User("admin", "admin"));
        fileLocation = System.getProperty("user.dir") + "/inloggningsUppgifter.dat";
        System.out.println(fileLocation);
        try {
            startServer();
            readFile(fileLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is activating the MServer, Server accepts any client that wants to communicate
     */
    private void startServer() throws IOException {

        // Starting server
        serverSocket = new ServerSocket(port);
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
        //creating a thread pool that generates threads for clients demand
       // ExecutorService executor = Executors.newCachedThreadPool();
        while (keepRunning) {

            try {

                Socket connect = serverSocket.accept();
                System.out.println("Connection successful");
               // executor.execute(new ClientHandler(connect));
                Thread t = new ClientHandler(connect);
                t.start();
               /* if (!keepRunning)
                {
                    executor.shutdown();
                }*/
            } catch (Exception e) {
                serverSocket.close();
                e.printStackTrace();
            }
        }
    }

    /**
     * As soon as the MServer gets connected, this method goes through a text file which includes
     * the existing users of the system and puts them to a collection called userList,
     * @param fileLocation the text file location
     */
    private void readFile(String fileLocation) {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileLocation));

            while ((user = (User)ois.readObject()) != null)
            {
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
        new MServer(4560);
    }

    /**
     * The inner class the handles the users, we have not decided to build the product
     * server to handle different of users connected on different network (Multithreading),
     * but I will try to code,  in case we change our mind.
     *
     * @author abdulsamisahil
     * @version 1.5
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
         * Through this method a client starts operating/communicating with the server, the start method of the thread.
         */
        public synchronized void run() {
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
                            //Thread safety, if more clients wants to access this shared array userList, only one client
                            //at a time will be added to added.
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
                        //TODO: Klienten skickar ett User-objekt
                        // Kolla i user-array tills du hittar den med samma användarnamn
                        // Ersätt den med det objekt klienten skickade
                        // Skicka tillbaka samma User-objekt till klienten
                        // Om ingen användaren hittas skicka en vanlig string
                        User user =(User) ois.readObject();
                        user = result(user);
                        if (user != null)
                        {
                            System.out.println("Writing user's results " + user);
                            oos.writeObject(user);
                        }
                        else {
                            oos.writeUTF("Dessvärre hittar inte användaren");
                        }

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
         * This method is taking the user object as an argument and checking it if it is not
         * already there in the list of users, so this method returns true, otherwise false
         * @author parprogramming sami, johanna and Motaz
         */
        private boolean newUser(User user) {
            for (int i = 0; i < usersList.size(); i++) {
                if (user.getUserName().equals(usersList.get(i).getUserName())) {
                    isUserNew = false;
                }
            }
            return isUserNew;
        }
        /**
         * This method is taking the user as an argument and checking it
         * if the user is already registered in the system, will be returned
         * @author parprogramming sami, johanna and Motaz
         */
        private User isLoginSucceeded(User receivedUser) {
            String username = receivedUser.getUserName();
            String password = receivedUser.getPassword();
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
        }

        /**
         * Checking if the user is in the collection
         * @author Abdul Sami Sahil
         * @param receivedUser if receivedUser is there in the collection, it will be initiated to the one in the list.
         * @return sends back the initiated user to the client.
         */
        private User result (User receivedUser)
        {
            User user = null;
            String username = receivedUser.getUserName();
            System.out.println(usersList.toString());
            for (User u: usersList)
            {
                System.out.println(usersList.toString());
                if (username.equals(u.getUserName())){
                    user = receivedUser;
                    usersList.set(usersList.indexOf(u), user);
                }
            }
            System.out.println(usersList.toString());
            return user;
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

            oos.flush(); // sends everything that the user wants

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