import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;


/**
 * Sheet class pulls from a preset text file and seperates each line into an array element
 * 
 * @author Derek Xu
 * @version 9/20/19
 */ 

/**
 * Sheet class inputs "syntax.txt" and runs the BufferedReader method, 
 * when finished iterating through text file, returns the array as returnsWords
**/

public class Sheet { 
    public static ArrayList<String> main(String fileName) { 
        ArrayList<String> returnsWords = new ArrayList<String>();
        BufferedReader br;
        // loading resource using getResourceAsStream() method 
        //returnsWords.add("esks");
        try
        {
            URL path = Sheet.class.getClassLoader().getResource(fileName);
            InputStream input = path.openStream();
            br = new BufferedReader(new InputStreamReader(input));
        }
        catch (Exception e) { System.out.println("Scenario file missing"); return returnsWords; }
        try
        {
            String line = null;
            while ((line = br.readLine()) != null)  returnsWords.add(line);
            br.close();
        }
        catch (Exception e) { try { br.close(); } catch (Exception f) {} }
        //System.out.println(returnsWords);
        return returnsWords;
    } 
}
