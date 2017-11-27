package unipi.tecnling.retoricaweb;

import unipi.tecnling.retoricaweb.utils.LoginHelper;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


/**
 * @author Alessio
 * ManagedBean to handle login and logout, using {@link LoginHelper} to handle logic
 * It either redirects to the index page or to the login page, showing the error
 */

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    private static final long serialVersionUID = -2195739161575166025L;
    private String username, password;

    public String login(){
        if(LoginHelper.login(username, password)){
           return "/index.jsf";
        } else {
            FacesMessage msg = new FacesMessage("Login error", "Login error, please try again");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("loginForm", msg);
            return "/login.jsf";
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
