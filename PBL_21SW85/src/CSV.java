import java.io.*;  
import java.util.Scanner;  
public class CSV{  
    public static void main(String[] args) throws Exception{  
    //parsing a CSV file into Scanner class constructor  
    Scanner sc = new Scanner(new File("E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW085\\database.csv"));  
    sc.useDelimiter(",");   //sets the delimiter pattern  
    while (sc.hasNext())  //returns a boolean value  
    {  
    System.out.print(sc.next());  //find and returns the next complete token from this scanner  
    }   
    sc.close();  //closes the scanner  
    }  
}   
