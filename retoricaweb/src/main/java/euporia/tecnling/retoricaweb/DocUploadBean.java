package euporia.tecnling.retoricaweb;

import euporia.tecnling.retoricaweb.database.LanguageEnum;
import euporia.tecnling.retoricaweb.utils.DocumentUploadHelper;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@ManagedBean
@RequestScoped
public class DocUploadBean implements Serializable{
    private static final long serialVersionUID = -2539533438288647286L;
    private String docTitle;
    private String docAuthor;
    private LanguageEnum docLang;
    private int docYear;
    private String editionName;
    private String editionType;
    private Part file;



    public String uploadDocument(){
        try{
            DocumentUploadHelper documentUploadHelper = new DocumentUploadHelper(docAuthor, docTitle, docLang, editionName,
                    editionType, docYear);

            documentUploadHelper.saveDocument(file);
            return "/upload_succesful.xhtml";
        } catch (IOException e){
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

    public LanguageEnum getDocLang() {
        return docLang;
    }

    public int getDocYear() {
        return docYear;
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

    public void setDocLang(LanguageEnum docLang) {
        this.docLang = docLang;
    }

    public void setDocYear(int docYear) {
        this.docYear = docYear;
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
