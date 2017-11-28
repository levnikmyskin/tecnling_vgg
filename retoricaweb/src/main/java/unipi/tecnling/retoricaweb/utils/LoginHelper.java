package unipi.tecnling.retoricaweb.utils;

import org.mindrot.jbcrypt.BCrypt;
import unipi.tecnling.retoricaweb.dbmodels.UserModel;
import unipi.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;
import unipi.tecnling.retoricaweb.sessionmodels.SessionUser;


/**
 *
 * Helper class for managing login and logout
 * It logs the user in and saves it in the session
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
            UserModel user = new UserModel(username);

            // Store user in session
            new SessionUser(user.getUsername(), user.getName(), user.getSurname()).saveIntoSession(true);
            return BCrypt.checkpw(password, user.getPassword());
        } catch(ObjectDoesNotExistException e){
            return false;
        }

    }

    public static boolean logout(){
        // STAB
        return true;
    }
}
