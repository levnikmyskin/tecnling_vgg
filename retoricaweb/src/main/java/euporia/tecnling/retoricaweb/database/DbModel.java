package euporia.tecnling.retoricaweb.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import euporia.tecnling.retoricaweb.utils.MongodbHelper;
import org.bson.Document;

/**
 * Base class for Db modeling. It has to be extended for every model in this package.
 * It deals with a single object from the collection, per instance.
 *
 * @author alessio
 */

public abstract class DbModel {

    /**
     * Implemented by those DAOs for which this app is allowed to write
     * on the DB.
     */
    interface Writable{
        boolean write();
    }

    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private String uniqueFieldName, uniqueFieldValue;

    /**
     * Think of the uniqueFields members as the key and value of
     * an HashMap: every DAO manages one row at a time, hence the need for a
     * primary key identifying this row uniquely. From the perspective of
     * a class outside of this package, the only argument needed is actually
     * the uniqueFieldValue
     * @param collection collection (table) name as defined on the db
     * @param uniqueFieldName Primary key name
     * @param uniqueFieldValue Primary key value
     */
    DbModel(String collection, String uniqueFieldName, String uniqueFieldValue){
        // Keep access private to package
        MongoClient mongoClient = new MongodbHelper().connect();
        this.database = mongoClient.getDatabase("retoricaweb");
        this.collection = this.database.getCollection(collection);
        this.uniqueFieldName = uniqueFieldName;
        this.uniqueFieldValue = uniqueFieldValue;
    }

    /**
     * Retrieve a single object from the collection, using the specified
     * unique field name and value. If the two parameters are not unique,
     * the method will return the first instance retrieved
     * @return org.bson.Document
     */
    Document retrieveFromDb(){
        return collection.find(eq(uniqueFieldName, uniqueFieldValue)).first();
    }

    /**
     * Utility to change any model field
     * @param key the field name
     * @param oldValue the old value of the field
     * @param newValue the new value for the field
     * @return true if succesfully changed
     */
    public boolean changeField(String key, String oldValue, String newValue){
        getCollection().updateOne(
                eq(key, oldValue),
                combine(set(key, newValue))
        );
        return true;
    }


    public MongoDatabase getDatabase() {
        return database;
    }

    MongoCollection<Document> getCollection() {
        return collection;
    }

}


