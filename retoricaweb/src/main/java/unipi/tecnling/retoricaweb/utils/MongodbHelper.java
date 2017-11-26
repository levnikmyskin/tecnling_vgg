package unipi.tecnling.retoricaweb.utils;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;

import java.io.*;
import java.util.Collections;
import java.util.Properties;


/*
 * @author Alessio
 *
 * Helper class for connection and management of MongoDb.
 * The instance returned by the connect() method should be used
 * throughout the application
 */

public class MongodbHelper {

    public MongoClient connect(){
        String[] configs = getConfigs();
        String user = configs[0];
        String db = configs[1];
        char[] pwd = configs[2].toCharArray();  // password needs to be a char array
        String host = configs[3];
        int port = Integer.parseInt(configs[4]);  // ServerAddress port must be an int

        MongoCredential credentials = MongoCredential.createCredential(user, db, pwd);
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();

        return new MongoClient(new ServerAddress(host, port),
                Collections.singletonList(credentials),
                options);
    }

    private String[] getConfigs(){
        String[] configs = new String[5];
        Properties properties = new Properties();
        InputStream input;
        try {
            // get relative path of file and throw exception if it's null
            String path = MongodbHelper.class.getClassLoader().getResource("config.properties").getFile();
            if (path == null){
                throw new IOException();
            }

            File file = new File(path);

            input = new FileInputStream(file);
            properties.load(input);
            configs[0] = properties.getProperty("user");
            configs[1] = properties.getProperty("database");
            configs[2] = properties.getProperty("passwd");
            configs[3] = properties.getProperty("host");
            configs[4] = properties.getProperty("port");

            input.close();
            return configs;
        } catch (IOException e){
            throw new RuntimeException("Could not parse config.properties file. Please check it is available in" +
                    " the resource folder");
        }
    }
}
