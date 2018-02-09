package euporia.tecnling.retoricaweb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneRadio;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class DocSearchBean implements Serializable{
    private static final long serialVersionUID = 4193074060628764917L;
    private String searchString;
    private boolean byAuthor, byTitle, byLang, byYear, byEditionType;
    private HtmlSelectOneRadio byAuthorRadio = new HtmlSelectOneRadio();

    @PostConstruct
    public void init(){
        byAuthorRadio.setValue(true);
    }

    public String doSearch(){
        return "";
    }

    public String getSearchString() {
        return searchString;
    }

    public boolean isByAuthor() {
        return byAuthor;
    }

    public void setByAuthor(boolean byAuthor) {
        this.byAuthor = byAuthor;
    }

    public boolean isByTitle() {
        return byTitle;
    }

    public void setByTitle(boolean byTitle) {
        this.byTitle = byTitle;
    }

    public boolean isByLang() {
        return byLang;
    }

    public void setByLang(boolean byLang) {
        this.byLang = byLang;
    }

    public boolean isByYear() {
        return byYear;
    }

    public void setByYear(boolean byYear) {
        this.byYear = byYear;
    }

    public boolean isByEditionType() {
        return byEditionType;
    }

    public void setByEditionType(boolean byEditionType) {
        this.byEditionType = byEditionType;
    }

    public HtmlSelectOneRadio getByAuthorChbx() {
        return byAuthorRadio;
    }

    public void setByAuthorChbx(HtmlSelectOneRadio byAuthorRadio){
        this.byAuthorRadio = byAuthorRadio;
    }
}
