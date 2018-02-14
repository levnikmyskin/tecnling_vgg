package tecnling.euporia.restful.euporiarestful.database;

import org.json.JSONObject;
import tecnling.euporia.restful.euporiarestful.sessionmanagement.SessionHelper;
import tecnling.euporia.restful.euporiarestful.sessionmanagement.SessionStorable;
import tecnling.euporia.restful.euporiarestful.utils.AppConstants;
import org.bson.Document;
import tecnling.euporia.restful.euporiarestful.exceptions.ObjectDoesNotExistException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Model to manage users in the db, extends DatabaseDAOModel
 * @see DatabaseDAOModel
 *
 * @author alessio
 * @author andrea
 */

public class UserDAO extends DatabaseModelMongo implements SessionStorable, DatabaseReadable, Serializable {
    private static final long serialVersionUID = -6339679382618922173L;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Document roles;

    public UserDAO(String uniqueFieldValue) throws ObjectDoesNotExistException{
        super(getCollectionName(), getUniqueFieldName(), uniqueFieldValue);
        initUser(this.retrieveFromDb());
    }

    private UserDAO(Document document){
        initUser(document);
    }


    @Override
    public void saveIntoSession(){
        SessionHelper<UserDAO> sessionHelper = new SessionHelper<>(SessionHelper.fromFacesContext(true));
        sessionHelper.getSession().setAttribute(AppConstants.USER_SESSION, this);
    }

    public static DatabaseModelMongo initializeFromDbQuery(@NotNull Document document){
        return new UserDAO(document);
    }

    @Override
    public JSONObject toJson() {
        return null;
    }

    public static String getCollectionName(){
        return "users";
    }

    public static String getUniqueFieldName() {
        return "username";
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

    private void initUser(Document user){
        if(user == null)
            throw new ObjectDoesNotExistException("User " + username + " does not exist");

        this.username = user.getString("username");
        this.password = user.getString("password");
        this.name = user.getString("name");
        this.surname = user.getString("surname");
        this.roles = (Document) user.get("roles");
    }
}
