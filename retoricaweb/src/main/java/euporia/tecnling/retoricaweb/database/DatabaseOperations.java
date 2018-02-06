package euporia.tecnling.retoricaweb.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.utils.MongodbHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class DatabaseOperations {
    private Class<? extends DatabaseDAOModel> databaseDao;

    /**
     * Please double check that your {@link DatabaseDAOModel} extending classes overrides the Readable interface
     * static methods
     */
    public DatabaseOperations(Class<? extends DatabaseDAOModel> databaseDao){
        this.databaseDao = databaseDao;
    }

    public ArrayList<Class<? extends DatabaseDAOModel>> filterDataByField(String fieldName, Object fieldValue)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        MongoClient client = new MongodbHelper().connect();
        MongoDatabase database = client.getDatabase(AppConstants.DATABASE_NAME);
        String collectionName = (String) databaseDao.getMethod("getCollectionName").invoke(null);

        MongoCollection collection = database.getCollection(collectionName);


    }
}
