package euporia.tecnling.retoricaweb.database;

import org.bson.Document;

import static euporia.tecnling.retoricaweb.utils.AppConstants.*;

/**
 * Model to save and update a document into the database.
 * @see DatabaseDAOModel
 *
 * @author andrea
 * @author alessio
 */

public class DocumentDAO extends DatabaseDAOModel implements Writable, Readable{
    private Document tags;
    private String title, author, edition, editionType, uploadedBy, dirName;
    private int compositionYear;
    private LanguageEnum language;

    private DocumentDAO(String uniqueFieldValue){
        super(getCollectionName(), getUniqueFieldName(), uniqueFieldValue);
    }

    private static DocumentDAO fromFormData(Builder builder){
        return initializeFields(builder);
    }

    public boolean write(){
        Document document = new Document(DOC_TITLE, title)
                .append(DOC_AUTHOR, author)
                .append(DOC_DATE, compositionYear)
                .append(DOC_LANG, language)
                .append(DOC_ED_NAME, edition)
                .append(DOC_ED_TYPE, editionType)
                .append(DOC_UPD, uploadedBy)
                .append(DOC_DIRNAME, dirName);

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

    public int getCompositionYear() {
        return compositionYear;
    }


    public Document getTags() {
        return tags;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public static String getCollectionName(){
        return "documents";
    }

    public static String getUniqueFieldName(){
        return "title";
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
        documentDao.compositionYear = builder.compositionYear;
        documentDao.dirName = builder.dirName;

        return documentDao;
    }

    /*
     *******************
     * Builder
     *******************/

    public static class Builder{
        private Document tags;
        private String title, author, edition, editionType, uploadedBy, dirName;
        private LanguageEnum language;
        private int compositionYear;

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public Builder language(LanguageEnum language){
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

        public Builder compositionYear(int compositionYear){
            this.compositionYear = compositionYear;
            return this;
        }

        public Builder tags(Document tags){
            this.tags = tags;
            return this;
        }

        public Builder dirName(String dirName){
            this.dirName = dirName;
            return this;
        }

        public DocumentDAO build(){
            return fromFormData(this);
        }
    }

}

