package euporia.tecnling.retoricaweb.database;

import org.bson.Document;

import java.util.Date;

import static euporia.tecnling.retoricaweb.utils.AppConstants.*;
import euporia.tecnling.retoricaweb.database.DbModel.Writable;

/**
 * Model to save and update a document into the database.
 * @see DbModel
 *
 * @author andrea
 * @author alessio
 */

public class DocumentDAO extends DbModel implements Writable{
    private Document wordsArray;
    private Document tags;
    private String title, author, language, edition, editionType, uploadedBy;
    private Date compositionDate;

    public DocumentDAO(String uniqueFieldValue){
        super("documents", "title", uniqueFieldValue);
    }


    public boolean write(){
        Document document = new Document("title", title)
                .append(DOC_AUTHOR, author)
                .append(DOC_DATE, compositionDate)
                .append(DOC_LANG, language)
                .append(DOC_ED_NAME, edition)
                .append(DOC_ED_TYPE, editionType)
                .append(DOC_WORDS, wordsArray)
                .append(DOC_UPD, uploadedBy);

        getCollection().insertOne(document);
        return true;
    }

    /* GETTERS */

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public String getEditionType() {
        return editionType;
    }

    public Date getCompositionDate() {
        return compositionDate;
    }

    public Document getWordsArray() {
        return wordsArray;
    }

    public Document getTags() {
        return tags;
    }

    public String getLanguage() {
        return language;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    /* SETTERS */

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    public void setCompositionDate(Date compositionDate) {
        this.compositionDate = compositionDate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setWordsArray(Document wordsArray) {
        this.wordsArray = wordsArray;
    }

    public void setTags(Document tags) {
        this.tags = tags;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
