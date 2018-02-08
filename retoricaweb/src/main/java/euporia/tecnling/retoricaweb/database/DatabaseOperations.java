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

/**
 * Utility class to manage database operations, using the DatabaseDAOs. Every public method shall return
 * a {@link MongoIterable}&lt;DatabaseDAOModel&gt;
 *
 * @author alessio
 */
public class DatabaseOperations{
    private Class<? extends DatabaseDAOModel> databaseDao;

    private Function<Document, DatabaseDAOModel> mapFunction = new Function<Document, DatabaseDAOModel>() {
        @Override
        public DatabaseDAOModel apply(Document document) {
            try {
                return (DatabaseDAOModel) databaseDao.getMethod("initializeFromDbQuery", Document.class)
                        .invoke(null, document);
            } catch (Exception e) {
                return null;
            }
        }
    };

    /**
     * Please double check that your {@link DatabaseDAOModel} extending classes overrides the Readable interface
     * static methods
     */
    public DatabaseOperations(Class<? extends DatabaseDAOModel> databaseDao){
        this.databaseDao = databaseDao;
    }

    public MongoIterable<DatabaseDAOModel> searchDataByField(String fieldName, Object fieldValue)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        MongoClient client = new MongodbHelper().connect();
        MongoDatabase database = client.getDatabase(AppConstants.DATABASE_NAME);
        String collectionName = (String) databaseDao.getMethod("getCollectionName").invoke(null);

        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find(eq(fieldName, fieldValue)).map(this.mapFunction);
    }
}
