package tecnling.euporia.restful.euporiarestful.dsl;

import java.io.InputStream;

public interface UsableForTagging {
    boolean isValid(InputStream taggedData);

    String displayedName();
}
