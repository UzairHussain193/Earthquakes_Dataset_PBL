import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;
class Earthquake {
    private String city;
    private String country;
    private int year;
    private double magnitude;

    public Earthquake(String city, String country, int year, double magnitude) {
        this.city = city;
        this.country = country;
        this.year = year;
        this.magnitude = magnitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getMagnitude() {
        return magnitude;
    }
}

public class CollectionPractice {
    public static void main(String[] args) {
        // Create 52 EarthquakeLinkedList collections, one for each year
        CollectionPractice[] yearlyCollections = new CollectionPractice[52];
        for (int i = 0; i < yearlyCollections.length; i++) {
            yearlyCollections[i] = new CollectionPractice();
        }

        // Read earthquake data from CSV file
        String csvFile = "earthquake_data.csv";
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] earthquakeData = line.split(csvSplitBy);
                double latitude = Double.parseDouble(earthquakeData[1]);
                double longitude = Double.parseDouble(earthquakeData[2]);
                String[] locationData = getLocationData(latitude, longitude);
                int year = getYear(earthquakeData[0]);
                double magnitude = Double.parseDouble(earthquakeData[4]);
                Earthquake earthquake = new Earthquake(locationData[0], locationData[1], year, magnitude);
                yearlyCollections[year - 1965].addEarthquake(earthquake);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total earthquakes processed: " + yearlyCollections[0].getSize());
    }

    
    
    private static String[] getLocationData(double latitude, double longitude) {
        // TODO: Use reverse geocoding library to get city and country from coordinates
        NominatimReverseGeocodingJAPI n= new NominatimReverseGeocodingJAPI();
        Address a;
        a=n.getAdress(latitude,longitude);
        String city = a.getCity();
        String country = a.getCountry();
        String[] locationData = {city, country};
        return locationData;
    }

    private static int getYear(String date) {
        return Integer.parseInt(date.substring(0, 4));
    }
}
