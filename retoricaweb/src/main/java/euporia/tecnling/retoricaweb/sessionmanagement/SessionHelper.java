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

public class SessionHelper<T> {
    private HttpSession session;


    public SessionHelper(HttpSession session) {
        this.session = session;
    }

    public static HttpSession fromFacesContext(boolean create){
        try{
            return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
        } catch (NullPointerException e){
            return null;
        }
    }

    public static HttpSession fromHttpRequest(HttpServletRequest request){
        try {
            return request.getSession();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Return an object stored in the session, passing its AppConstants defined name. Cast the returned object
     * to the T class.
     * @param SESSION_ATTRIBUTE_NAME Name of the object stored in session, taken from AppConstants
     * @return An instance of Object, which will be casted to T;
     */
    public T getObjectFromSession(@NotNull final String SESSION_ATTRIBUTE_NAME){
        if(session != null)
            return (T) session.getAttribute(SESSION_ATTRIBUTE_NAME);
        return null;
    }


    public HttpSession getSession() {
        return session;
    }
}
