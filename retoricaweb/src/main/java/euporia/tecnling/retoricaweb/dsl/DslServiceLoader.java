package euporia.tecnling.retoricaweb.dsl;

import java.util.Iterator;
import java.util.ServiceLoader;

public class DslServiceLoader {

    public Iterator loadProvider(){
        ServiceLoader serviceLoader = ServiceLoader.load(UsableForTagging.class);
        return serviceLoader.iterator();
    }
}
