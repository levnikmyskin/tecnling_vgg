package euporia.tecnling.retoricaweb;

import euporia.tecnling.retoricaweb.database.UserDAO;
import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.sessionmanagement.SessionHelper;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloWorld", eager=true)
public class HelloWorld {

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        // testing session
        SessionHelper<UserDAO> sessionHelper = new SessionHelper<>(SessionHelper.fromFacesContext(false));
        UserDAO user = sessionHelper.getObjectFromSession(AppConstants.USER_SESSION);
        if (user != null)
            return "Welcome " + user.getName() + " " + user.getSurname();
        return "Hello heaven!";
    }
}