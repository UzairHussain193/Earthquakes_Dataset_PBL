import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

class LinkedNode{
    LinkedNode next;
    int year;
    String country,state;
    float magnitude;
    Object date;
    Object time;

    LinkedNode(){
        
    }
    public LinkedNode(int year, String country,String state, Object date, float magnitude, Object time){
        this.year=year;
        this.country=country;
        this.magnitude=magnitude;
        this.state=state;
        this.time=time;
        this.date=date;
    }
    public String display(){
        return year +" , "+country + " , " + state+" , "+ date + " , " + magnitude + " , " + time;
    }
}

class Collections {
    ArrayList<LinkedNode> earthquake = new ArrayList<>();
    // LinkedQueue lq= new LinkedQueue();
    float[] highestmagnitudes;
    String[] country;
    int[] years;
    
    Collections() throws IOException{
    int Year;
    int count=0;
    int startyear;
    StackNode head;
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
                // System.out.println(count +" : "+ String.valueOf(year));

                if(earthquake.size()!=0){
                    for(int i=0;i<earthquake.size();i++){
                        if(Year==(earthquake.get(i).year)){
                            LinkedNode temp = earthquake.get(i);
                            while(temp.next!=null){
                                temp=temp.next;
                            }
                            temp.next= new LinkedNode(Year, parts[2], parts[3], parts[0], magnitude, parts[0]);
                            continue;
                        }
                        else if(i==earthquake.size()-1){
                            LinkedNode temp= new LinkedNode(Year, parts[2], parts[3], parts[0], magnitude, parts[0]);
                            earthquake.add(temp);
                            break;
                        }
                    }
                }
                else if(earthquake.size()==0){
                    LinkedNode temp = new LinkedNode(Year, parts[2], parts[3], parts[0], magnitude, parts[0]);
                    earthquake.add(temp);
                }   
            }
        br.close();
        count++;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
            e.printStackTrace();
        }
    }
    void display(){
        int Year;
        Scanner s=new Scanner(System.in);

        System.out.print("Enter Year :  ");
        Year=s.nextInt()-1965;
        // for(int i=0;i<52;i++){     //  by using line 107, 108 we can see each year collection with thier count
        // Node n=earthquake.get(i);
        LinkedNode n=earthquake.get(Year);
        int x=1;
        while(n!=null){
            System.out.println(x + " : " + n.time + " : " + n.year + " : " + n.country + " : " + n.state + " : " + n.magnitude);
            n.display();
            n=n.next;
            x++;
        }
    // }
    }
    // float[] highest() {
    void highest() {   
        int j=0; 
        highestmagnitudes = new float[52]; // Array to store highest magnitudes
        country = new String[52];
        years = new int[52];
        for(int i = 1965; i <=2016; i++) {
            highestmagnitudes[i-1965] = 0; // Initialize to smallest possible float value
        }

    
        // Loop through each year and find the highest magnitude for that year
        for(int i = 0; i < earthquake.size(); i++) {
            LinkedNode n = earthquake.get(i);
            while(n != null) {
                float high=highestmagnitudes[n.year-1965];
                if(n.magnitude > highestmagnitudes[n.year - 1965]) { // Update highest magnitude for the year
                    highestmagnitudes[n.year - 1965] = Math.max(n.magnitude, high);
                    country[i]=(String)n.country;
                    years[i]= n.year;
                }
                n = n.next;
                // System.out.println(high);
            }
        }
        
        for(int i = 0; i < 52; i++,j++) {
            LinkedNode n = earthquake.get(i);
            // System.out.println("Highest magnitude for each year -->  "+(i + 1965)  +  " : " + highestmagnitudes[i]);
            System.out.println(years[i]  + " : " + country[i] + " : " + highestmagnitudes[i]);
        }
        System.out.println(j);
        // return highestmagnitudes;
    }

    // void addFromArray(int[] years, String[] countries,float[] magnitudes ) {
    //     for (int i = 0; i < magnitudes.length; i++) {
    //         lq.addDetails(years[i], countries[i], magnitudes[i]);
    //     }
    // }

    
    
    
        int size(){
            return earthquake.size();
        }
        LinkedNode get(int index){
            return earthquake.get(index);
        }


    public static void main(String[] args) throws IOException {
        Collections list = new Collections();

      
        list.display();     // to see yearly collection
        // list.highest();
        
        
    }
}