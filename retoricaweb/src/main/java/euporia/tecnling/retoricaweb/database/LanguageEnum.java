package euporia.tecnling.retoricaweb.database;

public enum LanguageEnum {
    ITA ("ITA"),
    ENG ("ENG"),
    GR ("GR"),
    FR ("FR"),
    DE ("DE");

    private final String tag;

    LanguageEnum(String tag){
        this.tag = tag;
    }

    private String tag(){ return tag; }

}
