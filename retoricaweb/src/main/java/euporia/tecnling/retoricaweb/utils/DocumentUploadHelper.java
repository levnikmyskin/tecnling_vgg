package euporia.tecnling.retoricaweb.utils;

import euporia.tecnling.retoricaweb.database.DocumentDAO;
import euporia.tecnling.retoricaweb.database.UserDAO;
import euporia.tecnling.retoricaweb.sessionmanagement.SessionHelper;

import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *  Helper class to manage document upload and store it into database. First, a directory with the file name is created,
 *  then every 50 lines, the file is split and several smaller files are created.
 *  Eg. filetitle_0.txt, filetitle_1.txt, filetitle_2.txt etc.
 *
 *  @author andrea
 *  @author alessio
 */

public class DocumentUploadHelper {
    private String author, title, language, edition, editionType, compositionYear;

    public DocumentUploadHelper(String author, String title, String language, String edition, String editionType,
                                String compositionYear){
        this.author = author;
        this.title = title;
        this.language = language;
        this.edition = edition;
        this.editionType = editionType;
        this.compositionYear = compositionYear;
    }

    public void saveDocument(Part file) throws IOException{

        String dirPath = createDirectory();
        boolean succesfully_split = splitDocument(file, dirPath);
        if (succesfully_split) {
            writeDocument();
        }
    }

    private String createDirectory() throws IOException{
        String author = replaceWhiteSpaces(this.author);
        String title = replaceWhiteSpaces(this.title);
        String dirName = String.format("%s_%s_%s", author, title, compositionYear);
        String path = String.format("%s/%s/", AppConstants.DOCUMENT_DIRECTORY, dirName);
        Files.createDirectories(Paths.get(path));
        return path;
    }

    private boolean splitDocument(Part file, String dirPath)
            throws IOException{
        int lineCounter = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        ArrayList<String> fiftyLineList = new ArrayList<String>();
        int fileCounter = 0;

        while((line = br.readLine()) != null){
            if (lineCounter < 50) {
                fiftyLineList.add(line);
                lineCounter++;
            } else{
                newTextFile(fiftyLineList, dirPath, fileCounter);
                lineCounter = 0;
                fileCounter++;
                fiftyLineList.clear();
            }
        }

        // Save the last lines of the document
        if (!fiftyLineList.isEmpty()){
            newTextFile(fiftyLineList, dirPath, fileCounter);
        }

        return true;
    }

    private void newTextFile(ArrayList<String> fiftyLineList, String dirPath, int fileCounter)
            throws IOException{
        String author = replaceWhiteSpaces(this.author);
        String title = replaceWhiteSpaces(this.title);
        String fileName = String.format("%s_%s_%s_%d.txt", author, title, compositionYear, fileCounter);
        Files.write(
                Paths.get(dirPath + fileName),
                fiftyLineList,
                Charset.forName("UTF-8")
        );
    }

    private void writeDocument(){

        UserDAO uploader = UserDAO.retrieveFromFacesContext();
        DocumentDAO document = new DocumentDAO.Builder()
                .author(author)
                .title(title)
                .language(language)
                .edition(edition)
                .editionType(editionType)
                .compositionYear(compositionYear)
                .uploadedBy(uploader.getUsername())
                .build();

        document.write();
    }

    private String replaceWhiteSpaces(String string){
        return string.replaceAll(" ", "_");
    }
}
