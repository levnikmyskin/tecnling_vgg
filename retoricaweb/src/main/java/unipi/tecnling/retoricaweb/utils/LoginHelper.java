package unipi.tecnling.retoricaweb.utils;

import org.mindrot.jbcrypt.BCrypt;
import unipi.tecnling.retoricaweb.dbmodels.UserModel;
import unipi.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;


/*
 * @author Andrea
 *
 * Helper class for managing login and logout
 * It logs the user in and saves it in the session
 * It uses BCrypt in order to hash the passwords
 *
 * TODO session handling
 */

public class LoginHelper {

    public static boolean login(String username, String password){
        try{
            UserModel user = new UserModel("users", "username", username);
            String hashedPwd = BCrypt.hashpw(password, BCrypt.gensalt());

            return hashedPwd == user.getPassword();
        } catch(ObjectDoesNotExistException e){
            return false;
        }

    }

    public static boolean logout(){
        // STAB
        return true;
    }
}
