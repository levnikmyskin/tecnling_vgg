package euporia.tecnling.retoricaweb.dsl.dsltest;

import euporia.tecnling.retoricaweb.dsl.UsableForTagging;

import java.io.InputStream;

public class DslTestValidator implements UsableForTagging{

    @Override
    public boolean isValid(InputStream taggedData) {
        return false;
    }
}
