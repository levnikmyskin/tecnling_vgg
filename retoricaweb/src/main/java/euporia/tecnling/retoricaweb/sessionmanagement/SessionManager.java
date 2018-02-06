package euporia.tecnling.retoricaweb.sessionmanagement;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 *
 * Abstract class which is extended by every class that handles sessions.
 * It also defines a getInstance method, which allows to retrieve an object from
 * the session.
 *
 * @author alessio
 */

@Deprecated
public abstract class SessionManager {

    public abstract void saveIntoSession(boolean create);

    public abstract void removeFromSession();

    /**
     * Return an object stored in the session, passing its AppConstants defined name. Cast the returned object
     * to your desired class. Eg. (SessionUser) SessionManager.getInstance(AppConstants.USER_SESSION);
     * @param SESSION_ATTRIBUTE_NAME Name of the object stored in session, taken from AppConstants
     * @return An instance of SessionManager, which should be casted to an actual session class
     */
    public static SessionManager getInstance(@NotNull final String SESSION_ATTRIBUTE_NAME) {
        HttpSession session = getSession(false);
        if(session != null)
            return (SessionManager) getSession(false).getAttribute(SESSION_ATTRIBUTE_NAME);
        return null;
    }

    static HttpSession getSession(boolean create){
        // Force casting to HttpSession
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
    }
}
