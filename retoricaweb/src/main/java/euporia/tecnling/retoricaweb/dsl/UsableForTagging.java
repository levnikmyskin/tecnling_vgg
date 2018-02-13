package euporia.tecnling.retoricaweb.dsl;

import java.io.InputStream;

public interface UsableForTagging {
    boolean isValid(InputStream taggedData);
}
