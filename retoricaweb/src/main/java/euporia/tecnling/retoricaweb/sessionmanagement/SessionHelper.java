package euporia.tecnling.retoricaweb.sessionmanagement;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * Utility class to manage and get sessions. It could be further modeled to
 * give more functionality to it.
 *
 * @author alessio
 */

public class SessionHelper {
    private HttpSession session;

    private SessionHelper(HttpSession session){
        this.session = session;
    }

    public static SessionHelper fromFacesContext(boolean create){
        try{
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
            return new SessionHelper(session);
        } catch (NullPointerException e){
            return null;
        }
    }

    public static SessionHelper fromHttpRequest(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session == null){
            return null;
        } else {
            return new SessionHelper(session);
        }
    }


    public HttpSession getSession() {
        return session;
    }

    /**
     * Return an object stored in the session, passing its AppConstants defined name. Cast the returned object
     * to your desired class. Eg. (UserDAO) SessionHelper.getInstance(AppConstants.USER_SESSION);
     * @param SESSION_ATTRIBUTE_NAME Name of the object stored in session, taken from AppConstants
     * @return An instance of Object, which should be casted to an actual class
     */
    public Object getInstance(@NotNull final String SESSION_ATTRIBUTE_NAME) {
        if(session != null)
            return session.getAttribute(SESSION_ATTRIBUTE_NAME);
        return null;
    }

}
