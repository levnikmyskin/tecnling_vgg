package tecnling.euporia.restful.euporiarestful.database;

import org.bson.Document;
import org.json.JSONObject;
import tecnling.euporia.restful.euporiarestful.utils.AppConstants;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import static tecnling.euporia.restful.euporiarestful.utils.AppConstants.*;

/**
 * Model to save and update a document into the database.
 * @see DatabaseModelMongo
 *
 * @author andrea
 * @author alessio
 */

public class DocumentDAO extends DatabaseModelMongo implements DatabaseWritable, DatabaseReadable {
    private Document tags;
    private String title, author, edition, editionType, uploadedBy, dirName, language;
    private int compositionYear;

    private DocumentDAO(String uniqueFieldValue){
        super(getCollectionName(), getUniqueFieldName(), uniqueFieldValue);
    }

    private static DocumentDAO buildDocument(Builder builder){
        return initializeFields(builder);
    }

    public static DatabaseModelMongo initializeFromDbQuery(@NotNull Document document){
        return new Builder().buildFromDbQuery(document);
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

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(AppConstants.DOC_AUTHOR, author);
        jsonObject.put(DOC_DATE, compositionYear);
        jsonObject.put(DOC_LANG, language);
        jsonObject.put(DOC_ED_NAME, edition);
        jsonObject.put(DOC_ED_TYPE, editionType);
        jsonObject.put(DOC_UPD, uploadedBy);
        jsonObject.put(DOC_DIRNAME, dirName);
        return jsonObject;
    }

    public static String getCollectionName(){
        return "documents";
    }

    public static String getUniqueFieldName(){
        return "title";
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

    public String getDirName() {
        return dirName;
    }

    public Document getTags() {
        return tags;
    }

    public LanguageEnum getLanguage() {
        return LanguageEnum.valueOf(language);
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
        private String title, author, edition, editionType, uploadedBy, dirName, language;
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
            this.language = language.name();
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
            return buildDocument(this);
        }

        private DocumentDAO buildFromDbQuery(Document document){
            this.title(document.getString(DOC_TITLE));
            this.author(document.getString(DOC_AUTHOR));
            this.language = document.getString(DOC_LANG);
            this.edition(document.getString(DOC_ED_NAME));
            this.editionType(document.getString(DOC_ED_TYPE));
            this.uploadedBy(document.getString(DOC_UPD));
            this.compositionYear(document.getInteger(DOC_DATE));
            this.dirName(document.getString(DOC_DIRNAME));
            return buildDocument(this);
        }
    }

}

