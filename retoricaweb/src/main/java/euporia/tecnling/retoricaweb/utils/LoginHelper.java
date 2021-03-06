package euporia.tecnling.retoricaweb.utils;

import euporia.tecnling.retoricaweb.sessionmanagement.SessionHelper;
import org.mindrot.jbcrypt.BCrypt;
import euporia.tecnling.retoricaweb.database.UserDAO;
import euporia.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;

/**
 *
 * Helper class for managing login and logout.
 * It logs the user in and saves it in the session.
 * It uses BCrypt in order to hash the passwords
 *
 * TODO session handling
 *
 * @author andrea
 * @author alessio
 */

public class LoginHelper {

    public static boolean login(String username, String password){
        try{
            UserDAO user = new UserDAO(username);

            if (BCrypt.checkpw(password, user.getPassword())) {
                user.saveIntoSession();
                return true;
            }

            return false;
        } catch(ObjectDoesNotExistException e){
            return false;
        }

    }

    public static boolean logout(){
        // STAB
        return true;
    }
}
