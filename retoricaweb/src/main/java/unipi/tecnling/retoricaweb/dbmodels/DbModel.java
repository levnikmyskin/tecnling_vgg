package unipi.tecnling.retoricaweb.dbmodels;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import org.bson.Document;
import unipi.tecnling.retoricaweb.utils.MongodbHelper;

public class DbModel {

    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private String uniqueFieldName, uniqueFieldValue;

    // Keep access private to package
    DbModel(String collection, String uniqueFieldName, String uniqueFieldValue){
        MongoClient mongoClient = new MongodbHelper().connect();
        this.database = mongoClient.getDatabase("retoricaweb");
        this.collection = this.database.getCollection(collection);
        this.uniqueFieldName = uniqueFieldName;
        this.uniqueFieldValue = uniqueFieldValue;
    }

    Document retrieveFromDb(){
        return collection.find(eq(uniqueFieldName, uniqueFieldValue)).first();
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
