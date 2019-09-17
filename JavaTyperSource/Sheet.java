  import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;


/**
 * Write a description of class Sheet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
/*
public class Sheet  
{

    
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Sheet
     */
    /*
    public Sheet()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    /*public static ArrayList<String> sampleMethod(String fileName)
    {
        try
        {
            BufferedReader br = null;
            URL path = getClass().getClassLoader().getResource("filename.txt");
            InputStream input = path.openStream();
            br = new BufferedReader(new InputStreamReader(input));
        }
        catch (Exception e) { System.out.println("Scenario file missing"); return; }
        try
        {
            String line = null;
            while ((line = br.readLine()) != null)  line.add(line);
            br.close();
        }
        catch (Exception e) { try { br.close(); } catch (Exception f) {} }

    }
}*/

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
        return returnsWords;
    } 
}
