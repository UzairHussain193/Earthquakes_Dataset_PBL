// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
// import com.opencsv.CSVWriter;
// import eu.bitm.NominatimReverseGeocoding.Address;
// import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;  


//         // Un Cleaned files address
// class CSV{  
//     public static void main(String[] args) throws Exception{  

//     int i=9631;
//     Address ab;
//     NominatimReverseGeocodingJAPI n1= new NominatimReverseGeocodingJAPI();

//     // Scanner sc = new Scanner(new File("E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Valid countries and cities.csv"));  
//     String csvFilePath = "E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\database.csv";
//     String line;
//     String csvDelimiter = ","; // or ";" depending on your file

//     String outputCsvFile = "Addresses.csv";

//     try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
//              FileWriter writer = new FileWriter(outputCsvFile)) {
//             // String[] header = {"S.No,Date,Time,Country,Magnitude,Address"}; // Write the header row for the output CSV file
//             // writer.write(header[0]);
//             // writer.write(System.lineSeparator());
//             br.readLine();
//         while ((line = br.readLine()) != null && i>=9631) {
            
//             String[] values = line.split(csvDelimiter);
//                 // Access the values by index (e.g., values[0] for the first column)
                
//                 double latitude = Double.parseDouble(values[2]);
//                 double longitude = Double.parseDouble(values[3]);
                   
//                 // Do something with the column values
//                 ab=n1.getAdress(latitude,  longitude);
//                 System.out.print(ab);

//                 String add= ab.toString();
//                 if(add.equals("")){
//                     continue;
//                 }
            


//                 String country= ab.getCountry();
//                 String city = ab.getCity();
//                 String state= ab.getState();
                
//                 // writer.write(String.valueOf(i+1));
//                 // writer.write(csvDelimiter);
//                 // writer.write(values[0]);
//                 // writer.write(csvDelimiter);
//                 // writer.write(values[1]);
//                 // writer.write(csvDelimiter);
//                 // writer.write(country);
//                 // // writer.write(csvDelimiter);
//                 // // writer.write(city);
//                 // // writer.write(csvDelimiter);
//                 // // writer.write(state);
//                 // writer.write(csvDelimiter);
//                 // writer.write(values[8]);
//                 // writer.write(csvDelimiter);
//                 // writer.write(add);
//                 // writer.write(System.lineSeparator()); 
//                 i++; 
//             }
//             br.close();
//         } catch (IllegalStateException e) {
//             e.printStackTrace();
//         }
//         System.out.println(i);
//     }  
// }   