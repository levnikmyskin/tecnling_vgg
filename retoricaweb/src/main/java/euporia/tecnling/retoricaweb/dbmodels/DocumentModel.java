package euporia.tecnling.retoricaweb.dbmodels;

import org.bson.Document;

import java.util.HashMap;

/**
 * Model to save and update a document into the database.
 * @see DbModel
 *
 * @author andrea
 * @author alessio
 */

public class DocumentModel extends DbModel{
    private Document lines;
    private Document tags;

    public DocumentModel(String uniqueFieldValue){
        super("documents", "title", uniqueFieldValue);
    }

    /**
     * @param fields it needs to contain author, compositionDate, language, edition and lines
     */

    @Override
    public boolean createNewEntry(HashMap<String, Object> fields){
        Document document = new Document("title", fields.get("title"))
                .append("author", fields.get("author"))
                .append("compositionDate", fields.get("compositionDate"))
                .append("language", fields.get("language"))
                .append("edition", fields.get("edition"))
                .append("lines", fields.get("lines"));

        getCollection().insertOne(document);
        return true;
    }
}
