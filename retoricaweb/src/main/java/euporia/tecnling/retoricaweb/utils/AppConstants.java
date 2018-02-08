package euporia.tecnling.retoricaweb.utils;

/**
 * Constants values which should be used throughout the application
 * to allow more flexibility
 *
 * @author alessio
 */

public final class AppConstants {

    public static final String USER_SESSION = "loggedUser";
    public static final String DATABASE_NAME = "retoricaweb";
    public static final String DOCUMENT_DIRECTORY = "/home/alessio/euporia/documents";

    // DOCUMENTDAO's CONSTANT STRINGS
    public static final String DOC_AUTHOR = "docAuthor";
    public static final String DOC_TITLE = "docTitle";
    public static final String DOC_DATE = "docDate";
    public static final String DOC_ED_NAME = "docEditionName";
    public static final String DOC_ED_TYPE = "docEditionType";
    public static final String DOC_LANG = "docLanguage";
    public static final String DOC_UPD = "docUploader";
    public static final String DOC_DIRNAME = "docDirName";

    // USERDAO's CONSTANT STRINGS
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USER_FIRSTNAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_ROLES = "roles";




    // Prevent instantiating
    private AppConstants(){}

}
