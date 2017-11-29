package unipi.tecnling.retoricaweb;

import unipi.tecnling.retoricaweb.dbmodels.UserModel;
import unipi.tecnling.retoricaweb.utils.AppConstants;
import unipi.tecnling.retoricaweb.utils.SessionHelper;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloWorld", eager=true)
public class HelloWorld {

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        // testing session
        UserModel user = (UserModel) SessionHelper.getInstance(AppConstants.USER_SESSION);
        if (user != null)
            return "Welcome " + user.getName() + " " + user.getSurname();
        return "Hello heaven!";
    }
}