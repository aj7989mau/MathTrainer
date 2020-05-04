package Server;

import sharedEntities.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * MathTainer UserResult class, stores the resultat for the different users.
 * @author JohannaDahlborn
 * @version 1.5
 * @since 2020-04-29
 */
public class UserResultat implements Result {
    private User user;
    private ArrayList<User> recipients;
    private Date timeReceived, timeDelivered;

    public UserResultat() {
        this.recipients = new ArrayList<>();
    }

    public UserResultat(User user, ArrayList<User> recipients, Date timeRecieved, Date timeDelivered) {
        this.user = user;
        this.recipients = recipients;
        this.timeReceived = timeRecieved;
        this.timeDelivered = timeDelivered;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<User> getRecipients() {
        return recipients;
    }

    public Date getTimeReceived() {
        return timeReceived;
    }

    public Date getTimeDelivered() {
        return timeDelivered;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTimeReceived(Date timeReceived) {
        this.timeReceived = timeReceived;
    }

    public void setTimeDelivered(Date timeDelivered) {
        this.timeDelivered = timeDelivered;
    }

    public void setRecipients(ArrayList<User> recipients) {
        this.recipients = recipients;
    }

    /*public UserResultat storedResult(User receiver) {
        ArrayList<User> receivers = new ArrayList<>();
        receivers.add(receiver);
        return new UserResultat(user, receivers, timeReceived, timeDelivered);
    }*/

    @Override
    public String toString() {
        return "UserResult{" +
                "user=" + user +
                ", recipients=" + recipients +
                ", timeRecieved=" + timeReceived +
                ", timeDelivered=" + timeDelivered +
                '}';
    }
}