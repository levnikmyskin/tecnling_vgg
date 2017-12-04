package euporia.tecnling.retoricaweb;

import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.utils.DocumentHelper;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;


import static euporia.tecnling.retoricaweb.utils.AppConstants.*;


@ManagedBean
@RequestScoped
public class DocUploadBean implements Serializable{
    private static final long serialVersionUID = -2539533438288647286L;
    private String docTitle;
    private String docAuthor;
    private String docLang;
    private Date docCompDate;
    private String editionName;
    private String editionType;
    private Part file;



    public String uploadDocument(){
        HashMap<String, Object> fields = new HashMap<String, Object>();
        fields.put(DOC_TITLE, docTitle);
        fields.put(DOC_AUTHOR, docAuthor);
        fields.put(DOC_LANG, docLang);
        fields.put(DOC_DATE, docCompDate);
        fields.put(DOC_ED_NAME, editionName);
        fields.put(DOC_ED_TYPE, editionType);

        if (DocumentHelper.saveDocument(file, fields)){
            return "/upload_succesful.xhtml";
        } else {
            FacesMessage msg = new FacesMessage("Upload error", "An error occurred while uploading your" +
                    "document, please try again in a few minutes");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("loginForm", msg);
            return "/doc_upload.jsf";
        }
    }

    /*
     * GETTERS
     */

    public String getDocTitle() {
        return docTitle;
    }

    public String getDocAuthor() {
        return docAuthor;
    }

    public String getDocLang() {
        return docLang;
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

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public void setDocAuthor(String docAuthor) {
        this.docAuthor = docAuthor;
    }

    public void setDocLang(String docLang) {
        this.docLang = docLang;
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
