import java.io.*;  
import java.util.Scanner;
import com.opencsv.CSVWriter;
import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;  

class Store_CSV{  
    public static void main(String[] args) throws Exception{  

    double lat=51.772,lon=174.696;
    Address ab;
    NominatimReverseGeocodingJAPI n1= new NominatimReverseGeocodingJAPI();
    
   
    Scanner sc = new Scanner(new File("E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\database.csv"));  
   
    sc.useDelimiter("  ,  ");
   
    while (sc.hasNext()){  
        ab=n1.getAdress(lat, lon);
        System.out.print(ab); 
    } 
    sc.close(); 
    }   
}