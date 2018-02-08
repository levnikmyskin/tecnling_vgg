package euporia.tecnling.retoricaweb.database;

import org.bson.Document;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.validation.constraints.NotNull;

interface Readable{
    static String getCollectionName(){
        throw new NotImplementedException();
    }

    static String getUniqueFieldName(){
        throw new NotImplementedException();
    }

    static DatabaseDAOModel initializeFromDbQuery(@NotNull Document document){
        throw new NotImplementedException();
    }
}
