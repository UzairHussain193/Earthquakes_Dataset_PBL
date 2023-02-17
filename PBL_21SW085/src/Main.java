import eu.bitm.NominatimReverseGeocoding.Address;

public class Main{
    public static void main(String[] args) {
        Address a;
        NominatimReverseGeocodingJAPI nominatim1 = new NominatimReverseGeocodingJAPI(); //create instance with default zoom level (18)

        NominatimReverseGeocodingJAPI nominatim2 = new NominatimReverseGeocodingJAPI(); //create instance with given zoom level
        
        a=nominatim1.getAdress(1.863,127.352); //returns Address object for the given position
        System.out.println(a);

    }
}