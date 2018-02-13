package euporia.tecnling.retoricaweb.database;

import com.mongodb.Function;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.utils.MongodbHelper;
import org.bson.Document;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

/**
 * Utility class to manage database operations, using the DatabaseDAOs. Every public method shall return
 * a {@link MongoIterable}&lt;DatabaseDAOModel&gt;
 *
 * @author alessio
 */
public class DatabaseOperations<T extends DatabaseDAOModel>{
    private Class<? extends DatabaseDAOModel> databaseDao;

    private Function<Document, T> mapFunction = new Function<Document, T>() {
        @Override
        public T apply(Document document) {
            try {
                return (T) databaseDao.getMethod("initializeFromDbQuery", Document.class)
                        .invoke(null, document);
            } catch (Exception e) {
                return null;
            }
        }
    };

    /**
     * Please double check that your {@link DatabaseDAOModel} extending classes overrides the DatabaseReadable interface
     * static methods
     */
    public DatabaseOperations(Class<? extends DatabaseDAOModel> databaseDao){
        this.databaseDao = databaseDao;
    }

    public Iterable<T> searchDataByField(String fieldName, Object fieldValue)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        MongoCollection<Document> collection = getCollection(fieldName, fieldValue);
        return collection.find(eq(fieldName, fieldValue)).map(this.mapFunction);
    }

    /**
     * This method uses a regex expression to ignore case. This also means that it will return data
     * which is not strictly equal to the value passed
     *
     * @param fieldValue The value to look for, passed as a string. It will be inserted in a regex as is.
     */
    public Iterable<T> searchDataByFieldIgnoreCase(String fieldName, String fieldValue)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        MongoCollection<Document> collection = getCollection(fieldName, fieldValue);
        return collection.find(regex(fieldName, fieldValue, "i")).map(this.mapFunction);
    }

    private MongoCollection<Document> getCollection(String fieldName, Object fieldValue)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        MongoClient client = new MongodbHelper().connect();
        MongoDatabase database = client.getDatabase(AppConstants.DATABASE_NAME);
        String collectionName = (String) databaseDao.getMethod("getCollectionName").invoke(null);

        return database.getCollection(collectionName);
    }
}
