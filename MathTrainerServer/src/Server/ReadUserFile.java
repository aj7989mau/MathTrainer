package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ReadUserFile {
    private FileHandler FHandler;
    private SimpleFormatter date;
    private Logger logger;
    private User user;
    private String alltext;


    public ReadUserFile(String alltext) {
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

    public void result() {
        logger.info(alltext);

    }
    public void removeUser(){
        //hur vi tar bort en användare
    }


    //Sparar ett userobjekt och resulatat/svar
    //ska läsa och skriva filer, skapa en ny fil av en användare
    //läsa samma fil

    public static void main(String[] args) {
        ReadUserFile f;
        for(int i= 0; i<10; i++){
            f = new ReadUserFile("user" +i);
        }
    }
}

