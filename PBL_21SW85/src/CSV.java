import java.io.*;  
import java.util.Scanner;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;  
class CSV{  
    public static void main(String[] args) throws Exception{  

    Address ab;
    NominatimReverseGeocodingJAPI n1= new NominatimReverseGeocodingJAPI();

    //parsing a CSV file into Scanner class constructor  
    Scanner sc = new Scanner(new File("E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\database.csv"));  
    
    sc.useDelimiter(",");   //sets the delimiter pattern  
   
    while (sc.hasNext())  //returns a boolean value  
    {  
        ab=n1.getAdress(19.246,145.616);
        System.out.print(sc.next());  //find and returns the next complete token from this scanner  
    }   
    sc.close();  //closes the scanner  
    }  
}   
