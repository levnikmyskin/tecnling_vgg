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

    private static DocumentDAO fromFormData(Builder builder){
        return initializeFields(builder);
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

    private static DocumentDAO initializeFields(Builder builder){
        DocumentDAO documentDao = new DocumentDAO(null);
        documentDao.title = builder.title;
        documentDao.author = builder.author;
        documentDao.language = builder.language;
        documentDao.edition = builder.edition;
        documentDao.editionType = builder.editionType;
        documentDao.uploadedBy = builder.uploadedBy;
        documentDao.tags = builder.tags;
        documentDao.compositionDate = builder.compositionDate;

        return documentDao;
    }

    public static class Builder{
        private Document wordsArray;
        private Document tags;
        private String title, author, language, edition, editionType, uploadedBy;
        private Date compositionDate;

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public Builder language(String language){
            this.language = language;
            return this;
        }

        public Builder edition(String edition){
            this.edition = edition;
            return this;
        }

        public Builder editionType(String editionType){
            this.editionType = editionType;
            return this;
        }

        public Builder uploadedBy(String uploadedBy){
            this.uploadedBy = uploadedBy;
            return this;
        }

        public Builder compositionDate(Date compositionDate){
            this.compositionDate = compositionDate;
            return this;
        }

        public Builder tags(Document tags){
            this.tags = tags;
            return this;
        }

        public DocumentDAO build(){
            return fromFormData(this);
        }
    }

}
