package unipi.tecnling.retoricaweb.utils;

import org.mindrot.jbcrypt.BCrypt;
import unipi.tecnling.retoricaweb.dbmodels.UserModel;
import unipi.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;

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
            UserModel user = new UserModel(username);

            if (BCrypt.checkpw(password, user.getPassword())) {
                // Store user in session
                SessionHelper.getSession(true).setAttribute(AppConstants.USER_SESSION, user);
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
