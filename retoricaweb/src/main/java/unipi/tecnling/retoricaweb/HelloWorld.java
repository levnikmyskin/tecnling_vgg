package unipi.tecnling.retoricaweb;

import com.mongodb.MongoClient;
import org.bson.Document;
import unipi.tecnling.retoricaweb.sessionmodels.SessionManager;
import unipi.tecnling.retoricaweb.sessionmodels.SessionUser;
import unipi.tecnling.retoricaweb.utils.AppConstants;
import unipi.tecnling.retoricaweb.utils.MongodbHelper;

import javax.faces.bean.ManagedBean;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

@ManagedBean(name="helloWorld", eager=true)
public class HelloWorld {

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        // testing session
        SessionUser user = (SessionUser) SessionManager.getInstance(AppConstants.USER_SESSION);
        if (user != null)
            return "Welcome " + user.getName() + " " + user.getSurname();
        return "Hello heaven!";
    }
}