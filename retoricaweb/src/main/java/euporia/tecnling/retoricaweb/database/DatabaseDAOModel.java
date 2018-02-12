package euporia.tecnling.retoricaweb.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.utils.MongodbHelper;
import org.bson.Document;

/**
 * Base class for Db modeling. It has to be extended for every model in this package.
 * It deals with a single object from the collection, per instance.
 *
 * <p style="color: red">WARNING: Every subclass that can be read MUST "override" the {@link DatabaseReadable} static methods</p>
 *
 * @author alessio
 */

public abstract class DatabaseDAOModel implements DatabaseReadable {

    /**
     * Retrieve a single object from the collection/database, using the specified
     * unique field name and value(for SQL this should be a primary key). If the two parameters are not unique,
     * the method will return the first instance retrieved
     */
    abstract Object retrieveFromDb();

    /**
     * Utility to change any model field
     * @param fieldName the name of the field (or table column) that needs to be changed
     * @param oldValue the old value of the field
     * @param newValue the new value for the field
     * @return true if succesfully changed
     */
    abstract public boolean changeField(String fieldName, String oldValue, String newValue);

    abstract public Object getDatabase();

    abstract Object getCollection();

}


