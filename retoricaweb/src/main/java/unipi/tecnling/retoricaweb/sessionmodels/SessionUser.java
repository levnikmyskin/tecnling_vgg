package unipi.tecnling.retoricaweb.sessionmodels;

import org.bson.Document;
import unipi.tecnling.retoricaweb.utils.AppConstants;
import javax.servlet.http.HttpSession;

/**
 * Class to store, retrieve and remove logged users from the session
 *
 * It should be decided whether to keep separate classes for managing users from db and
 * users from session (to achieve DRY https://en.wikipedia.org/wiki/Don%27t_repeat_yourself).
 *
 * @author alessio
 * @see unipi.tecnling.retoricaweb.sessionmodels.SessionManager
 */

public class SessionUser extends SessionManager{
    private String username, name, surname;
    private Document roles;

    public SessionUser(String username, String name, String surname, Document roles){
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.roles = roles;
    }

    @Override
    public void saveIntoSession(boolean create){
        HttpSession session = SessionManager.getSession(create);
        session.setAttribute(AppConstants.USER_SESSION, this);
    }

    @Override
    public void removeFromSession() {
        SessionManager.getSession(false).removeAttribute(AppConstants.USER_SESSION);
    }

    /* Getters */

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Document getRoles() {
        return roles;
    }
}
