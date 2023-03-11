// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
// import com.opencsv.CSVWriter;
// import eu.bitm.NominatimReverseGeocoding.Address;
// import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;  

// class CLeanCSV{  
//     public static void main(String[] args) throws Exception{  

//     int i=0;
//     double lat=27.357,lon=87.867;
//     Address add;
//     NominatimReverseGeocodingJAPI n1= new NominatimReverseGeocodingJAPI();

//     // Scanner sc = new Scanner(new File("E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Valid countries and cities.csv"));  
//     String csvFilePath = "E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Valid countries and cities.csv";
//     String line;
//     String csvDelimiter = ","; // or ";" depending on your file
//     String outputCsvFile = "Addresses_Cleaned.csv";
//     String headerRow = "Count,Year,Time,Latitude,Longitude,Country,City,Magnitude";

//     try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
//             FileWriter writer = new FileWriter(outputCsvFile)) {
//             writer.write(headerRow);
//             writer.write(System.lineSeparator());
//             br.readLine();
//             while ((line = br.readLine()) != null) {
//                 String[] values = line.split(csvDelimiter);
//                 // Access the values by index (e.g., values[0] for the first column)
//                 double latitude = Double.parseDouble(values[3]);
//                 double longitude = Double.parseDouble(values[4]);
//                 // Do something with the column values
//                 add=n1.getAdress(latitude, longitude);
//                 // System.out.print(i+" ");
//                 System.out.print(add+"\n");
                
//                 // String address = String.valueOf(add);
//                 // writer.write(address);
//                 // String add = String.valueOf(ab);
//                 String country= add.getCountry();
//                 String city = add.getCity();

//                 // writer.write(add);
//                 // writer.write(csvDelimiter);
//                 writer.write(String.valueOf(i+1));
//                 writer.write(csvDelimiter);
//                 writer.write(values[1]);
//                 writer.write(csvDelimiter);
//                 writer.write(values[2]);
//                 writer.write(csvDelimiter);
//                 writer.write(values[3]);
//                 writer.write(csvDelimiter);
//                 writer.write(values[4]);
//                 writer.write(csvDelimiter);
//                 writer.write(country);
//                 writer.write(csvDelimiter);
//                 writer.write(city);
//                 writer.write(csvDelimiter);
//                 writer.write(values[9]);
//                 writer.write(System.lineSeparator());  
//                 i++; 
//             }
//         } catch (IllegalStateException e) {
//             e.printStackTrace();
//         }
//         System.out.println("Number of rows are : "+i);
//     }  
// }   