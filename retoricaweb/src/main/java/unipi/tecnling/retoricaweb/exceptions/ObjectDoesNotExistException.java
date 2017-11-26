package unipi.tecnling.retoricaweb.exceptions;

public class ObjectDoesNotExistException extends Exception{
    private String errorMessage;

    public ObjectDoesNotExistException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString(){
        return this.errorMessage;
    }
}
