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
        boolean succesfully_split = splitDocument(file);
        if (succesfully_split) {
            DocumentDAO dmodel = initDocument(fields);
            return dmodel.write();
        }
        return false;
    }

    private static boolean splitDocument(Part file){
        try{
            int lineCounter = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;


            while((line = br.readLine()) != null){
                if (lineCounter < 50) {
                    manageTextLine(line, lineCounter);
                    lineCounter++;
                } else{
                    lineCounter = 0;
                }
            }
            return true;
        } catch(IOException e){
            return false;
        }
    }

    private static void manageTextLine(String line, int lineCounter){

    }

    // Initializes document, without tags and lines
    private static DocumentDAO initDocument(HashMap<String, Object> fields){
        return new DocumentDAO.Builder()
                .author((String) fields.get("author"))
                .title((String) fields.get("title"))
                .language((String) fields.get("language"))
                .edition((String) fields.get("edition"))
                .editionType((String) fields.get("editionType"))
                .compositionDate((Date) fields.get("compositionDate"))
                .uploadedBy((String) fields.get("uploadedBy"))
                .build();
    }
}
