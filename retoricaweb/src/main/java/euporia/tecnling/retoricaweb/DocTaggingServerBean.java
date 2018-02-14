package euporia.tecnling.retoricaweb;

import euporia.tecnling.retoricaweb.documentmanagement.DocumentServer;
import euporia.tecnling.retoricaweb.dsl.DslServiceLoader;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class DocTaggingServerBean implements Serializable{
    private static final long serialVersionUID = 5536099096227929989L;
    private String fileName;
    private int fileIndex;
    private List<String> fileLines;
    private ArrayList<String[]> availableDslPlugins;
    private ArrayList<String> enabledPlugins;

    public void loadFile(){
        DocumentServer documentServer = new DocumentServer(fileName, fileIndex);
        this.fileLines = documentServer.getCurrentTextPortion();
        this.availableDslPlugins = DslServiceLoader.getInstance().getDslServices();
        this.enabledPlugins = new ArrayList<>();
    }

    public void enablePlugin(){
        String plugin = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("plugin");
        enabledPlugins.add(plugin);
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

    public ArrayList<String[]> getAvailableDslPlugins() {
        return availableDslPlugins;
    }
}
