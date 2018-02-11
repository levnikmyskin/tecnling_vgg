package euporia.tecnling.retoricaweb.documentmanagement;

import euporia.tecnling.retoricaweb.sessionmanagement.SessionHelper;
import euporia.tecnling.retoricaweb.sessionmanagement.SessionStorable;
import euporia.tecnling.retoricaweb.utils.AppConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DocumentServer implements SessionStorable{
    private String filePathTemplate;
    private int currentTextIndex;
    private int nextTextIndex;

    public DocumentServer(String fileName, int currentTextIndex){
        this.filePathTemplate = String.format("%s/%s", AppConstants.DOCUMENT_DIRECTORY, fileName);
        this.currentTextIndex = currentTextIndex;
        this.nextTextIndex = this.currentTextIndex + 1;
    }

    public List<String> getCurrentTextPortion(){
        try{
            return getTextPortion(currentTextIndex);
        } catch (IOException e){
            return null;
        }
    }

    public List<String> getNextTextPortion(){
        try{
            return getTextPortion(nextTextIndex);
        } catch (IOException e){
            return null;
        }
    }

    @Override
    public void saveIntoSession() {
        SessionHelper<DocumentServer> sessionHelper = new SessionHelper<>(SessionHelper.fromFacesContext(true));
        HttpSession session = sessionHelper.getSession();
        session.setAttribute(AppConstants.DOCUMENTSERVER_SESSION, this);
    }

    private List<String> getTextPortion(int portionIndex) throws IOException{
        Path file = Paths.get(filePathTemplate + portionIndex + ".txt");
        return Files.readAllLines(file);
    }
}
