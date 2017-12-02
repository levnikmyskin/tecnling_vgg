package euporia.tecnling.retoricaweb.utils;

import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  Helper class to manage document upload and store it into database
 *
 *  @author andrea
 *  @author alessio
 */

// TODO to be complited
public class DocumentHelper {

    public static boolean saveDocument(String text){

        Document lines = getLines(text);

    }

    /**
     * It tokenizes text and returns document's instance related to text lines.
     * document structure:
     * Document lines: Document subLines{
     *     1: [word0, word1, .. wordN],
     *     2: [word0, word1, .. wordN],
     *     3: ....
     * }
     */

    private static Document getLines(String text){
        try{
            BufferedReader br = new BufferedReader(new FileReader(text));
            String line;
            Document subLines = new Document();
            int i = 0;
            while ((line = br.readLine()) != null){
                ArrayList<String> lineArray = new ArrayList<String>();

                // Sets ", '" as delimiters to the tokenization
                StringTokenizer stringTokenizer = new StringTokenizer(line, ", '");

                // Appends tokens to list lineArray
                while (stringTokenizer.hasMoreTokens()){
                    lineArray.add(stringTokenizer.nextToken());
                }

                // Appends to Document subLine key: line number, value: line words
                subLines.append(String.valueOf(i), lineArray);
                i++;
            }

            return new Document("lines", subLines);
        } catch(IOException e){
            return null;
        }
    }
}
