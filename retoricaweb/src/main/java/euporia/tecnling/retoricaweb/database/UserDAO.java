package euporia.tecnling.retoricaweb.database;

import org.bson.Document;
import euporia.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;


/**
 * Model to manage users in the db, extends DbModel
 * @see DbModel
 *
 * @author alessio
 * @author andrea
 */

public class UserDAO extends DbModel{
    private String username;
    private String password;
    private String name;
    private String surname;
    private Document roles;

    public UserDAO(String uniqueFieldValue) throws ObjectDoesNotExistException{
        super("users", "username", uniqueFieldValue);
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


}
