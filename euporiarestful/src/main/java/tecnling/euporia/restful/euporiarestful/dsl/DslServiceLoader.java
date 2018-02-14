package tecnling.euporia.restful.euporiarestful.dsl;

import java.util.*;


public class DslServiceLoader {
    private static DslServiceLoader service;
    private ServiceLoader<UsableForTagging> loader;

    private DslServiceLoader(){
        loader = ServiceLoader.load(UsableForTagging.class);
    }

    public static synchronized DslServiceLoader getInstance(){
        if (service == null){
            service = new DslServiceLoader();
        }
        return service;
    }

    public ArrayList<String[]> getDslServices(){
        Iterator<UsableForTagging> iterator = loader.iterator();
        ArrayList<String[]> arrayList = new ArrayList<>();
        while(iterator.hasNext()){
            UsableForTagging u = iterator.next();
            String[] tuple = {u.displayedName(), u.getClass().getName()};
            arrayList.add(tuple);
        }
        return arrayList;
    }
}
