package Server;

import sharedEntities.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * ReadUserFile, handles all the users and stores in a arraylist. Only a testfile for education
 * @version 1.5
 * @since 2020-05-03
 */
public class ReadUserFile {
    private FileHandler FHandler;
    private SimpleFormatter date;
    private Logger logger;
    private User user;
    private String alltext;

    private ArrayList<User> recipients;


    public ReadUserFile(User user, ArrayList<User> receivers, String alltext) {
        this.recipients = recipients;
        this.alltext = alltext;
        try {
            //skapar en ny fil, med ett nytt filnamn
            FHandler = new FileHandler("Users/member.log");
            date = new SimpleFormatter();
            FHandler.setFormatter(date);
            logger = Logger.getLogger("member");
            logger.addHandler(FHandler);
            result();


        } catch (IOException e) {

        }
    }

    public void result() { logger.info(alltext); }

    public ArrayList<User> getRecipients() {
        return recipients;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRecipients(ArrayList<User> recipients) {
        this.recipients = recipients;
    }

    public void setText(String alltext) {
        this.alltext = alltext;
    }

    public ReadUserFile storedUser(User receiver) {
        ArrayList<User> receivers = new ArrayList<>();
        receivers.add(receiver);
        return new ReadUserFile(user, receivers, alltext);
    }


    public String toString() {
        return "ReadUserFile{" +
                "user=" + user +
                ", recipients=" + recipients +
                ", alltext='" + alltext + '\'' +
                '}';
    }

}

