package euporia.tecnling.retoricaweb.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import euporia.tecnling.retoricaweb.utils.AppConstants;
import euporia.tecnling.retoricaweb.utils.MongodbHelper;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

/**
 * Base class for Db modeling, using MongoDB as the DBMS. It has to be extended for every model in this package.
 * It deals with a single object from the collection, per instance.
 *
 * <p style="color: red">WARNING: Every subclass that can be read MUST "override" the {@link DatabaseReadable} static methods</p>
 *
 * @author alessio
 */

public class DatabaseModelMongo extends DatabaseDAOModel implements MongoDBBackend{


    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private String uniqueFieldName, uniqueFieldValue;

    /**
     * Think of the uniqueFields members as the key and value of
     * an HashMap: every DAO manages one row at a time, hence the need for a
     * primary key identifying this row uniquely. From the perspective of
     * a class outside of this package, the only argument needed is actually
     * the uniqueFieldValue
     * @param uniqueFieldValue Primary key value
     */
    DatabaseModelMongo(String collectionName, String uniqueFieldName, String uniqueFieldValue){
        // Keep access private to package
        MongoClient mongoClient = new MongodbHelper().connect();
        this.database = mongoClient.getDatabase(AppConstants.DATABASE_NAME);
        this.collection = this.database.getCollection(collectionName);
        this.uniqueFieldName = uniqueFieldName;
        this.uniqueFieldValue = uniqueFieldValue;
    }

    /**
     * Standard constructor to be used when constructing the object from an already retrieved
     * data set
     */
    DatabaseModelMongo(){}

    /**
     * Retrieve a single object from the collection, using the specified
     * unique field name and value. If the two parameters are not unique,
     * the method will return the first instance retrieved
     * @return org.bson.Document
     */
    @Override
    public Document retrieveFromDb(){
        return collection.find(eq(uniqueFieldName, uniqueFieldValue)).first();
    }

    /**
     * Utility to change any model field
     * @param fieldName the name of the field that needs to be changed
     * @param oldValue the old value of the field
     * @param newValue the new value for the field
     * @return true if succesfully changed
     */
    @Override
    public boolean changeField(String fieldName, String oldValue, String newValue){
        getCollection().updateOne(
                eq(fieldName, oldValue),
                combine(set(fieldName, newValue))
        );
        return true;
    }

    @Override
    public MongoDatabase getDatabase() {
        return database;
    }

    @Override
    public MongoCollection<Document> getCollection() {
        return collection;
    }

}
