package euporia.tecnling.retoricaweb.utils;

import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DocumentHelper {

    public static boolean saveDocument(String text){

        Document lines = getLines(text);

    }

    private static Document getLines(String text){
        try{
            BufferedReader br = new BufferedReader(new FileReader(text));
            String line;
            Document subLines = new Document();
            int i = 0;
            while ((line = br.readLine()) != null){
                int index = 0;
                ArrayList<String> lineArray = new ArrayList<String>();
                StringTokenizer stringTokenizer = new StringTokenizer(line, ", '");

                while (stringTokenizer.hasMoreTokens()){
                    lineArray.add(stringTokenizer.nextToken());
                    index++;
                }

                subLines.append(String.valueOf(i), lineArray);
                i++;
            }

            return new Document("lines", subLines);
        } catch(IOException e){
            return null;
        }
    }
}
