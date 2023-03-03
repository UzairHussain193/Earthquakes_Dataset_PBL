import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;

class LinkedList {
    static class Node {
        Node next;
        Object country;
        Object city;
        Object magnitude;
        Node(){

        }
        Node(Object country,Object city, Object magnitude){
            this.country=country;
            this.city=city;
            this.magnitude=magnitude;
        }
    }
    Node insertAtLast(Node start, Object country,Object city, Object magnitude){
        Node n;
        for(n=start;n.next!=null;n=n.next){
        }
        n.next=new Node(country,city,magnitude);
        return start;
    }
    void display(Node head){
        Node current = head;
        while(current!=null){
            System.out.println(current.country+""+current.city+""+current.magnitude);
            current=current.next;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList list = new LinkedList();
        Node head = new Node();
        double lat=51.772,lon=174.696;


        Address ab;
        NominatimReverseGeocodingJAPI n = new NominatimReverseGeocodingJAPI();
        Scanner sc = new Scanner(new File("E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\database.csv"));  
        
        while (sc.hasNext()){
            ab = n.getAdress(lat, lon);
            System.out.println(ab);
        }  
        

        


        
    }
}
