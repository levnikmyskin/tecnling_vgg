package euporia.tecnling.retoricaweb.dbmodels;

import org.bson.Document;
import euporia.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;

import java.util.HashMap;


/**
 * Model to manage users in the db, extends DbModel
 * @see DbModel
 *
 * @author alessio
 * @author andrea
 */

public class UserModel extends DbModel{
    private String username;
    private String password;
    private String name;
    private String surname;
    private Document roles;

    public UserModel(String uniqueFieldValue) throws ObjectDoesNotExistException{
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

    // This webapp is not allowed to create users
    @Override
    public boolean createNewEntry(){
        return false;
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
