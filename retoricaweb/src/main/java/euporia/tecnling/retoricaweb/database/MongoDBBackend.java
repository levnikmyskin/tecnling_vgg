package euporia.tecnling.retoricaweb.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

interface MongoDBBackend extends DBBackend{
    /**
     * Retrieve a single object from the collection, using the specified
     * unique field name and value. If the two parameters are not unique,
     * the method will return the first instance retrieved
     * @return org.bson.Document
     */
    Document retrieveFromDb();

    MongoDatabase getDatabase();

    MongoCollection<Document> getCollection();

    /**
     * Utility to change any model field
     * @param fieldName the name of the field that needs to be changed
     * @param oldValue the old value of the field
     * @param newValue the new value for the field
     * @return true if succesfully changed
     */
    boolean changeField(String fieldName, String oldValue, String newValue);
}
