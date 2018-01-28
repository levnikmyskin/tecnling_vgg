package euporia.tecnling.retoricaweb.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * Utility class to manage and get sessions. It could be further modeled to
 * give more functionality to it.
 *
 * @author alessio
 */

public class SessionHelper {

    /**
     * Return an object stored in the session, passing its AppConstants defined name. Cast the returned object
     * to your desired class. Eg. (UserDAO) SessionHelper.getInstance(AppConstants.USER_SESSION);
     * @param SESSION_ATTRIBUTE_NAME Name of the object stored in session, taken from AppConstants
     * @return An instance of Object, which should be casted to an actual model class
     */
    public static Object getInstance(@NotNull final String SESSION_ATTRIBUTE_NAME) {
        HttpSession session = getSession(false);
        if(session != null)
            return session.getAttribute(SESSION_ATTRIBUTE_NAME);
        return null;
    }

    static HttpSession getSession(boolean create){
        // Force casting to HttpSession
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
    }
}
