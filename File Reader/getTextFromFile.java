import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class getTextFromFile
{
    public static void main (String [] args) throws IOException
    {
        FileReader fr = new FileReader ("U:\\Computer Science\\Projects\\File Reader\\text.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String myText = br.readLine();
        System.out.println(myText);
    }
}