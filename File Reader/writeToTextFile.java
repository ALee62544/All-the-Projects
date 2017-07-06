import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class writeToTextFile
{
    public static void main(String[] args) throws IOException
    {
         FileWriter fw = new FileWriter("U:\\Computer Science\\Projects\\File Reader\\writefile.txt", true);
         BufferedWriter bw = new BufferedWriter (fw);
    
         String content = "This is the content so write into file";
    
         bw.newLine();
         bw.write(content);
         bw.close();
    
         System.out.println("Done");
    }
}
    