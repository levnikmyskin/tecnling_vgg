package euporia.tecnling.retoricaweb.database;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

interface Readable {
    static String getCollectionName(){
        throw new NotImplementedException();
    }

    static String getUniqueFieldName(){
        throw new NotImplementedException();
    }
}
