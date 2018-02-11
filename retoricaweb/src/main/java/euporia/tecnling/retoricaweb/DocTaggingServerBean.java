package euporia.tecnling.retoricaweb;

import euporia.tecnling.retoricaweb.documentmanagement.DocumentServer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class DocTaggingServerBean implements Serializable{
    private static final long serialVersionUID = 5536099096227929989L;
    private String fileName;
    private int fileIndex;
    private List<String> fileLines;

    public void loadFile(){
        DocumentServer documentServer = new DocumentServer(fileName, fileIndex);
        this.fileLines = documentServer.getCurrentTextPortion();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileIndex() {
        return fileIndex;
    }

    public void setFileIndex(int fileIndex) {
        this.fileIndex = fileIndex;
    }

    public List<String> getFileLines() {
        return fileLines;
    }
}
