package unipi.tecnling.retoricaweb.exceptions;

/**
 * @author alessio
 * Exception thrown when a MongoDb query returned null
 */

public class ObjectDoesNotExistException extends Exception{
    private static final long serialVersionUID = 6184904505979970003L;
    private String errorMessage;

    public ObjectDoesNotExistException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString(){
        return this.errorMessage;
    }
}
