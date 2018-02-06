package euporia.tecnling.retoricaweb.sessionmanagement;

import javax.servlet.http.HttpServletRequest;

public interface SessionStorable {
    void saveIntoSession();
    Object retrieveFromFacesContext();
    Object retrieveFromRequest(HttpServletRequest request);
}
