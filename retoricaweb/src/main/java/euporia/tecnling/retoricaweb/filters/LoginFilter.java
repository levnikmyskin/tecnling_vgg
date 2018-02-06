package euporia.tecnling.retoricaweb.filters;

import euporia.tecnling.retoricaweb.database.UserDAO;
import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.sessionmanagement.SessionHelper;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Read https://stackoverflow.com/questions/8480100/how-implement-a-login-filter-in-jsf and
 * https://www.journaldev.com/7252/jsf-authentication-login-logout-database-example for reference
 */

@WebFilter(filterName = "LoginFilter", urlPatterns = {"*.xhtml", "*.jsf"})
public class LoginFilter implements Filter{


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String loginUrl = request.getContextPath() + "/login.xhtml";

        boolean isLoggedIn = UserDAO.retrieveFromRequest(request) != null;
        boolean isLoginRequest = request.getRequestURI().equals(loginUrl);

        if (isLoggedIn || isLoginRequest){
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0); // Proxies.

            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(loginUrl);
        }

    }

    public void destroy() {

    }
}
