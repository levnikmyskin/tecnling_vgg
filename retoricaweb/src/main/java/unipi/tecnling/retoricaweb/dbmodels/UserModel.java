package unipi.tecnling.retoricaweb.dbmodels;

import org.bson.Document;
import unipi.tecnling.retoricaweb.exceptions.ObjectDoesNotExistException;

/**
 * Model to manage users in the db, extends DbModel
 * @see unipi.tecnling.retoricaweb.dbmodels.DbModel
 *
 * @author alessio
 */

public class UserModel extends DbModel{
    private String username;
    private String password;
    private String name;
    private String surname;

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


    private void initUser() throws ObjectDoesNotExistException{
        Document user = this.retrieveFromDb();
        if(user == null)
            throw new ObjectDoesNotExistException("User " + username + " does not exist");

        this.username = user.getString("username");
        this.password = user.getString("password");
        this.name = user.getString("name");
        this.surname = user.getString("surname");
    }


}
