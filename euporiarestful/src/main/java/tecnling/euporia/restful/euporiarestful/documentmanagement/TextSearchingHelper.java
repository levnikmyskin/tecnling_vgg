package tecnling.euporia.restful.euporiarestful.documentmanagement;

import com.mongodb.client.MongoIterable;
import tecnling.euporia.restful.euporiarestful.database.DatabaseOperations;
import tecnling.euporia.restful.euporiarestful.database.DocumentDAO;
import tecnling.euporia.restful.euporiarestful.database.LanguageEnum;
import tecnling.euporia.restful.euporiarestful.utils.AppConstants;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;

public class TextSearchingHelper {

    public Iterable<DocumentDAO> getDocumentsByAuthor(String author){
        DatabaseOperations<DocumentDAO> dbOperation = new DatabaseOperations<>(DocumentDAO.class);
        try {
            return dbOperation.searchDataByFieldIgnoreCase(AppConstants.DOC_AUTHOR, author);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            return null;
        }

    }

    public Iterable<DocumentDAO> getDocumentsByYear(int year){
        // STUB
        return null;
    }

    public Iterable<DocumentDAO> getDocumentsByLanguage(LanguageEnum language){
        DatabaseOperations<DocumentDAO> dbOperation = new DatabaseOperations<>(DocumentDAO.class);
        try{
            return dbOperation.searchDataByField(AppConstants.DOC_LANG, language.name());
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            return null;
        }
    }

}

