package unipi.tecnling.retoricaweb;

import com.mongodb.MongoClient;
import unipi.tecnling.retoricaweb.utils.MongodbHelper;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloWorld", eager=true)
public class HelloWorld {

    public HelloWorld() {
        MongodbHelper mdbHelper = new MongodbHelper();
        MongoClient instance = mdbHelper.connect();

        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        System.out.println("prova");
        return "Hello heaven!";
    }


}