import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

class earthquake {
    private String country;
    private String state;
    private double magnitude;
    private int year;

    public earthquake(int year,String country, String state, double magnitude) {
        this.year=year;
        this.country = country;
        this.state = state;
        this.magnitude = magnitude;
    }

    public String getCountry(){
        return country;
    }
    
    public String getstate(){
        return state;
    }
    
    public double getmagnitude(){
        return magnitude;
    }
    public int getYear(){
        return year;
    }
}
public class GPTCollection {
    public static void main(String[] args) {
        int NUM_YEARS = 52;
        ArrayList<earthquake>[] yearToEarthquakesArray = new ArrayList[NUM_YEARS];

        try (CSVReader reader = new CSVReader(new FileReader("Cleaned_Data.csv"))) {
            String[] header = reader.readNext(); // skip header row

            String[] row;
            while ((row = reader.readNext()) != null) {
                int year = Integer.parseInt(row[0].substring(row[0].length()-4));
                String country = row[2];
                String state = row[3];
                double magnitude = Double.parseDouble(row[4]);

                earthquake earthquake = new earthquake(year,country, state, magnitude);

                if (yearToEarthquakesArray[year - 1965] == null) {
                    yearToEarthquakesArray[year - 1965] = new ArrayList<>();
                }
                yearToEarthquakesArray[year - 1965].add(earthquake);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Access the ArrayList for a specific year
        int yearToAccess = 2016;
        List<earthquake> earthquakesList = yearToEarthquakesArray[yearToAccess - 1970];

        for (earthquake earthquake2 : earthquakesList) {
            System.out.println(earthquake2.getCountry());
            System.out.println(earthquake2.getmagnitude());
            // Do something with the earthquake data for the specific year
        }
    }
}


