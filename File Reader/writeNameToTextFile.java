import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class writeNameToTextFile
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner (System.in);
        FileWriter fw = new FileWriter("U:\\Computer Science\\Projects\\File Reader\\writefile.txt", true);
        BufferedWriter bw = new BufferedWriter (fw);
    
        for (int i = 0; i < 4; i++) {
            System.out.println ("Enter name please");
            String Name = sc.nextLine();
            bw.write (Name);
            bw.newLine();
        }
        bw.close();
        
    
        System.out.println("                           ");
        System.out.println("Names stored in write file:");
        FileReader fr = new FileReader ("U:\\Computer Science\\Projects\\File Reader\\writefile.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        
        do {
            System.out.println(line);
        } while ((line = br.readLine()) != null);
    
        br.close();
    }
}

    