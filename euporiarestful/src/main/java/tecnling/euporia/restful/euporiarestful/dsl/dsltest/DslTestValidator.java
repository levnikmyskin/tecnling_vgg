package tecnling.euporia.restful.euporiarestful.dsl.dsltest;

import tecnling.euporia.restful.euporiarestful.dsl.UsableForTagging;

import java.io.InputStream;

public class DslTestValidator implements UsableForTagging{

    @Override
    public boolean isValid(InputStream taggedData) {
        return false;
    }

    @Override
    public String displayedName() {
        return "DslTest";
    }
}
