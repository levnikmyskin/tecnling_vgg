package euporia.tecnling.retoricaweb;

import euporia.tecnling.retoricaweb.database.UserDAO;
import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.utils.SessionHelper;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloWorld", eager=true)
public class HelloWorld {

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        // testing session
        UserDAO user = (UserDAO) SessionHelper.getInstance(AppConstants.USER_SESSION);
        if (user != null)
            return "Welcome " + user.getName() + " " + user.getSurname();
        return "Hello heaven!";
    }
}