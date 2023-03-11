import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Node{
    int year;
    String country;
    float magnitude;

    Node prev=null;
    Node next=null;

    Node(){

    }

    Node(int year,String country,float magnitude){
        this.year=year;
        this.country=country;
        this.magnitude=magnitude;
    }
}
class Stacks{
    Node head;
    int size;
    public Stacks(){
        head=null;
        size=0;
    }
    public void push(int year,String country,float magnitude) {
        Node newNode = new Node( year, country, magnitude);
        newNode.next=head;
        head = newNode;
    }
    Node peek(){
        return head;
    }
    // String pop(){
    //     if(head==null){
    //         System.out.println("List is empty");
    //     }
    //     String result=head;
    //     size--;
    //     return result;
    // }
    boolean isEmpty(){
        return (head==null);
    }
    int size(){
        return size;
    }
    // public Object[] toArrayStack(){
    //     Object[] a=new Object[size];
    //     Node current=head;
    //     int i;
    //     for(current=head,i=0;current!=null;current=current.next,i++){
    //         a[i]=current.data;
    //     }
    //     return a;
    // }

    public void CountryStacks() throws IOException{
        Collections earthquake = new Collections();
        Stacks countryStacks = new Stacks();
        int Year;
        int count=0;
        String country;
        String filepath= "E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Cleaned_Data.csv";
        String line;
        String splitBy = ",";
        String add;
        float magnitude;
    
        // Define an ArrayList to store the nodes
       
        // Read the file and extract the year from the date in column 1
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            br.readLine();      // reada header line
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
               
                add="";
                String[] parts = line.split(splitBy); // use comma as separator
               
                // ystem.out.println(parts[0] + parts[2]);
                magnitude= Float.parseFloat(parts[4]);
                Year = Integer.parseInt(parts[0].substring(parts[0].length()-4));
                country= parts[2];
                // System.out.println(count +" : "+ String.valueOf(year));

                if(earthquake.size()!=0){
                    for(int i=0;i<earthquake.size();i++){
                        if(country==(countryStacks.head.country)){
                        //  countryStacks.push(Year, country, magnitude);
                        System.out.println("Hello");
                        }
                        else if(i!=earthquake.size()-1){
                           
                        }
                    }
                }
                else if(earthquake.size()==0){
                    
                }   
            }
        br.close();
        count++;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
            e.printStackTrace();
        }
    }
   
    public static void main(String[] args) throws IOException {
       Stacks st = new Stacks();
       
       st.CountryStacks();
    }
}

   