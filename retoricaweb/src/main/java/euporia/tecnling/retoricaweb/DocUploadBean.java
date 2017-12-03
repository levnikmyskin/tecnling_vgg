package euporia.tecnling.retoricaweb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.Date;


@ManagedBean
@RequestScoped
public class DocUploadBean implements Serializable{
    private static final long serialVersionUID = -2539533438288647286L;
    private String docAuthor;
    private Date docCompDate;
    private String editionName;
    private String editionType;
    private Part file;



    public void uploadDocument(){
        System.out.println("prova");
    }

    /*
     * GETTERS
     */

    public String getDocAuthor() {
        return docAuthor;
    }

    public Date getDocCompDate() {
        return docCompDate;
    }

    public String getEditionName() {
        return editionName;
    }

    public String getEditionType() {
        return editionType;
    }

    public Part getFile() {
        return file;
    }

    /*
     * SETTERS
     */

    public void setDocAuthor(String docAuthor) {
        this.docAuthor = docAuthor;
    }

    public void setDocCompDate(Date docCompDate) {
        this.docCompDate = docCompDate;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
