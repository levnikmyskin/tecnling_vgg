package euporia.tecnling.retoricaweb.documentmanagement;

import com.mongodb.client.MongoIterable;
import euporia.tecnling.retoricaweb.database.DatabaseOperations;
import euporia.tecnling.retoricaweb.database.DocumentDAO;
import euporia.tecnling.retoricaweb.database.LanguageEnum;
import euporia.tecnling.retoricaweb.utils.AppConstants;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;

public class TextServingHelper {

    public MongoIterable<DocumentDAO> getDocumentsByAuthor(String author){
        DatabaseOperations<DocumentDAO> dbOperation = new DatabaseOperations<>(DocumentDAO.class);
        try {
            return dbOperation.searchDataByFieldIgnoreCase(AppConstants.DOC_AUTHOR, author);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            return null;
        }

    }

    public ArrayList<DocumentDAO> getDocumentsByYear(int year){
        // STUB
        return null;
    }

    public ArrayList<DocumentDAO> getDocumentsByLanguage(LanguageEnum language){
        // STUB
        return null;
    }

}

