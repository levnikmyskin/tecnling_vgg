package euporia.tecnling.retoricaweb.utils;

import euporia.tecnling.retoricaweb.database.DocumentDAO;
import euporia.tecnling.retoricaweb.database.UserDAO;
import org.bson.Document;

import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import static euporia.tecnling.retoricaweb.utils.AppConstants.*;

/**
 *  Helper class to manage document upload and store it into database
 *
 *  @author andrea
 *  @author alessio
 */

/*
  TODO PLEASE DO NOT EDIT HERE, WE DO NOT NEED TO STORE TEXT IN DB
  I'LL DO IT ASAP
  Alessio
 */
public class DocumentHelper {

    public static boolean saveDocument(Part file, HashMap<String, Object> fields){
        Document wordsArray = getLines(file);
        DocumentDAO dmodel = initDocument(fields);

        // add lines to the DocumentDAO
        dmodel.setWordsArray(wordsArray);
        return dmodel.createNewEntry();
    }

    /**
     * It tokenizes text and returns document's instance related to text lines.
     * document structure:
     * Document lines: [word1, word2, word3, ... , wordN]
     */

    private static Document getLines(Part file){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            ArrayList<String> wordsArray = new ArrayList<String>();
            for (int i=0; (line = br.readLine()) != null; i++){

                // Sets ", '" as delimiters to the tokenization
                StringTokenizer stringTokenizer = new StringTokenizer(line, ", '");

                // Appends tokens to list lineArray
                while (stringTokenizer.hasMoreTokens()){
                    // TODO DISCARD EMPTY LINES ?
                    wordsArray.add(stringTokenizer.nextToken());
                }
            }
            return new Document("wordsArray", wordsArray);
        } catch(IOException e){
            return null;
        }
    }

    // Initializes document, without tags and lines
    private static DocumentDAO initDocument(HashMap<String, Object> fields){
        DocumentDAO dmodel = new DocumentDAO(null);
        dmodel.setTitle((String) fields.get(DOC_TITLE));
        dmodel.setAuthor((String) fields.get(DOC_AUTHOR));
        dmodel.setLanguage((String) fields.get(DOC_LANG));
        dmodel.setEdition((String) fields.get(DOC_ED_NAME));
        dmodel.setEditionType((String) fields.get(DOC_ED_TYPE));
        dmodel.setCompositionDate((Date) fields.get(DOC_DATE));

        String username = ((UserDAO) SessionHelper.getInstance(AppConstants.USER_SESSION)).getUsername();
        dmodel.setUploadedBy(username);
        return dmodel;
    }
}
