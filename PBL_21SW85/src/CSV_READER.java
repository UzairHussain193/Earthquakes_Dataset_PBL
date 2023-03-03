import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;  

class CSV_READER {
    public static void main(String[] args) {
        String filename = "data.csv";
        int column1Index = 0; // Index of the column to store
        int column2Index = 2; // Index of another column to store
        Address ab;
        NominatimReverseGeocodingJAPI n1= new NominatimReverseGeocodingJAPI();

        List<String> column1Values = new ArrayList<>();
        List<String> column2Values = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                column1Values.add(values[column1Index]);
                column2Values.add(values[column2Index]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Do something with the column values...
        for (String string : column1Values) {
            System.out.println(column1Values);
            
        }
    }
}