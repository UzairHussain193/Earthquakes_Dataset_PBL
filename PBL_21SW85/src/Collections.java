import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

class LinkedNode{           // node class use in collections
    LinkedNode next;
    int year;
    String country,state;
    float magnitude;
    Object date;
    Object time;

    LinkedNode(){
        
    }
    // constructor to add data
    public LinkedNode(int year, String country,String state, Object date, float magnitude, Object time){
        this.year=year;
        this.country=country;
        this.magnitude=magnitude;
        this.state=state;
        this.time=time;
        this.date=date;
    }
    //method to display element in nodes
    public String display(){
        return year +" , "+country + " , " + state+" , "+ date + " , " + magnitude + " , " + time;
    }
}

class Collections {
    ArrayList<LinkedNode> earthquake = new ArrayList<>();       // collection to store earthquakes yearly
    
    // arrays to store data from columns and parsing
    float[] highestmagnitudes;
    String[] country;
    int[] years;
    
    // contructor of collection class to initialize process by just calling
    Collections() throws IOException{
    int Year;
    int count=0;
    String filepath= "E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Cleaned_Data.csv";
    String line;
    String splitBy = ",";
    String add;
    float magnitude;
   
    // Read the file and extract the year from the date in column 1
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            br.readLine();      // reada header line
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
               
                add="";
                String[] parts = line.split(splitBy); // use comma as separator
                magnitude= Float.parseFloat(parts[4]);  // reads magnitude column
                Year = Integer.parseInt(parts[0].substring(6));   //reads year from date column
                
                // add data in collection
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
    void display_Collections(){
        int Year;
        Scanner s=new Scanner(System.in);

        System.out.print("Enter Year :  ");
        Year=s.nextInt()-1965;
        
        LinkedNode n=earthquake.get(Year);
        int x=1;
        while(n!=null){
            System.out.println(x + " : " + n.time + " : " + n.year + " : " + n.country + " : " + n.state + " : " + n.magnitude);
            n.display();
            n=n.next;
            x++;
        }
    }
    void display_All_Collections(){
        for(int i=0;i<52;i++){     //  by using line 107, 108 we can see each year collection with thier count
        LinkedNode n=earthquake.get(i);
        int x=1;
        while(n!=null){
            System.out.println(x + " : " + n.time + " : " + n.year + " : " + n.country + " : " + n.state + " : " + n.magnitude);
            n.display();
            n=n.next;
            x++;
        }
    }
    }
    public int menu(){
        Scanner s = new Scanner(System.in);
        System.out.println("\n\tPBL Tasks ");
        System.out.println("1. Step 1 (Yearly Collections of Earthquakes.) ");
        System.out.println("2. Step 2 (Yearly Queue of Earthquakes.) ");
        System.out.println("3. Step 3 (Country Stacks of Earthquakes.) ");
        System.out.println("4. Step 4 (Recent Earthquake of each year.) ");
        System.out.println("5. Problem 1 (Most Vulnerable Country.) ");
        System.out.println("6: Problem 2 (Biggest Earthquakes from 2005 to 2015.) ");
        System.out.println("7: Problem 3 (Recent 5 Earthquakes.) ");
        System.out.println("8: Problem 4 (Most recent Earthquakes with magnitude above 6.) ");
        System.out.println("0. Exit");
        System.out.print("\nEnter Your Choice: ");
        int Choice=s.nextInt();

        return Choice;
    }
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
            }
        }
        
        for(int i = 0; i < 52; i++,j++) {
            LinkedNode n = earthquake.get(i);
            System.out.println(years[i]  + " : " + country[i] + " : " + highestmagnitudes[i]);
        }
        System.out.println(j);
    }

    int size(){
        return earthquake.size();
    }
    LinkedNode get(int index){
        return earthquake.get(index);
    }
    public static void main(String[] args) throws IOException {
        Collections a = new Collections();
        a.display_All_Collections();
    }
}