import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVWriter;
import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;  


        // Un Cleaned files address
class Read_CSV{  
    public static void main(String[] args) throws Exception{  

    int i=9631;
    
    // Scanner sc = new Scanner(new File("E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Valid countries and cities.csv"));  
    String csvFilePath = "E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Addresses.csv";
    String line;
    String csvDelimiter = ","; // or ";" depending on your file

    int year;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
            FileWriter writer = new FileWriter("Cleaned_Data.csv")) {
        br.readLine();
        while ((line = br.readLine()) != null) {
            
            String[] values = line.split(csvDelimiter);
            // System.out.println(br.readLine());
            year=Integer.parseInt(values[0].substring(6));
            System.out.println(String.valueOf(year));
            // String add= values[0].toString();
            //     if(add.contains("-")){
            //         add.replace('-', '/');
            //         // continue;
            //     }
            //     System.out.println(add);
            // writer.write(add);
            // writer.write(System.lineSeparator());
            i++;
            }
            br.close();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }  
}   