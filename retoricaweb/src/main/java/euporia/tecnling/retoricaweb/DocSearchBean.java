package euporia.tecnling.retoricaweb;

import com.mongodb.client.MongoIterable;
import euporia.tecnling.retoricaweb.database.DocumentDAO;
import euporia.tecnling.retoricaweb.database.LanguageEnum;
import euporia.tecnling.retoricaweb.documentmanagement.TextSearchingHelper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class DocSearchBean implements Serializable{
    private static final long serialVersionUID = 4193074060628764917L;
    private String searchString, searchParameter;
    private String[] searchParameters = {"By author", "By title", "By language", "By year", "By edition type"};
    private Iterable<DocumentDAO> documents;

    public void doSearch(){
        this.documents = manageSearchRequest();
    }

    public Iterable<DocumentDAO> getDocuments() {
        return documents;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString){
        this.searchString = searchString;
    }

    public String[] getSearchParameters() {
        return searchParameters;
    }

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }

    private Iterable<DocumentDAO> manageSearchRequest(){
        TextSearchingHelper textSearchingHelper = new TextSearchingHelper();
        switch (searchParameter){
            case "By author":
                return textSearchingHelper.getDocumentsByAuthor(searchString);
            case "By title":
                return null;
            case "By language":
                return textSearchingHelper.getDocumentsByLanguage(LanguageEnum.valueOf(searchString.toUpperCase()));
            default:
                return null;
        }
    }
}
