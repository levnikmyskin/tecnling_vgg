package euporia.tecnling.retoricaweb.sessionmanagement;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;

public interface SessionStorable {
    void saveIntoSession();

    /**
     * This method should be the preferred one over retrieveFromRequest to retrieve objects from session,
     * unless you got a HttpServletRequest instance.
     *
     * The default implementation throws a {@link NotImplementedException} exception to force implementation.
     * For more information about interface static methods, read here
     * https://www.intertech.com/Blog/java-8-tutorial-default-and-static-methods-guide/
     * https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html#static
     */
    static Object retrieveFromFacesContext(){
        throw new NotImplementedException();
    }

    static Object retrieveFromRequest(HttpServletRequest request){
        throw new NotImplementedException();
    }
}
