package euporia.tecnling.retoricaweb.database;

import euporia.tecnling.retoricaweb.sessionmanagement.SessionHelper;
import euporia.tecnling.retoricaweb.sessionmanagement.SessionStorable;
import euporia.tecnling.retoricaweb.utils.AppConstants;
import org.bson.Document;
import euporia.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;

import javax.servlet.http.HttpServletRequest;


/**
 * Model to manage users in the db, extends DatabaseDAOModel
 * @see DatabaseDAOModel
 *
 * @author alessio
 * @author andrea
 */

public class UserDAO extends DatabaseDAOModel implements SessionStorable, Readable{

    private String username;
    private String password;
    private String name;
    private String surname;
    private Document roles;

    public UserDAO(String uniqueFieldValue) throws ObjectDoesNotExistException{
        super(getCollectionName(), getUniqueFieldName(), uniqueFieldValue);
        initUser();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    /**
     * @return user's permissions in order to verify his actions
     */
    public Document getRoles() {
        return roles;
    }

    public static String getCollectionName(){
        return "users";
    }

    public static String getUniqueFieldName(){
        return "username";
    }

    private void initUser() throws ObjectDoesNotExistException{
        Document user = this.retrieveFromDb();
        if(user == null)
            throw new ObjectDoesNotExistException("User " + username + " does not exist");

        this.username = user.getString("username");
        this.password = user.getString("password");
        this.name = user.getString("name");
        this.surname = user.getString("surname");
        this.roles = (Document) user.get("roles");
    }

    public void saveIntoSession(){
        SessionHelper sessionHelper = SessionHelper.fromFacesContext(true);
        sessionHelper.getSession().setAttribute(AppConstants.USER_SESSION, this);
    }

    public static UserDAO retrieveFromFacesContext(){
        try {
            return (UserDAO) SessionHelper.fromFacesContext(false).getInstance(AppConstants.USER_SESSION);
        } catch (NullPointerException e){
            return null;
        }
    }

    public static UserDAO retrieveFromRequest(HttpServletRequest request){
       try{
           return (UserDAO) SessionHelper.fromHttpRequest(request).getInstance(AppConstants.USER_SESSION);
       } catch (NullPointerException e){
           return null;
       }
    }


}
