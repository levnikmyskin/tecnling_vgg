package tecnling.euporia.restful.euporiarestful.database;

import org.bson.Document;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.validation.constraints.NotNull;

interface DatabaseReadable {
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
