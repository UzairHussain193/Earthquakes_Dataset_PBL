import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class StackNode{
    int year;
    String country;
    float magnitude;

    StackNode prev=null;
    StackNode next=null;
    StackNode top=null;

    StackNode(){

    }

    StackNode(int year,String country,float magnitude){
        this.year=year;
        this.country=country;
        this.magnitude=magnitude;
    }
    StackNode(int year,float magnitude){
        this.year=year;
        this.magnitude=magnitude;
    }

    public void push1(int year2, String country2, float magnitude2) {

        this.year=year2;
        this.country=country2;
        this.magnitude=magnitude2;
    }

    public void display3() {
        System.out.println( year +" : "+ country+" : "+ magnitude);
    }

}


class Stacks{

    StackNode head;
    //Node top;
    int size;

    ArrayList<Stacks> countries= new ArrayList<>();
    ArrayList<Float> magnitudes = new ArrayList<>();
    ArrayList<Integer> year= new ArrayList<>();


    public void push2(int year,String Country, float magnitude) {
        StackNode temp = new StackNode( year, Country, magnitude);
        temp.next=head;
        head = temp;
        size++;
    }
    public void peek(){
        StackNode n=head;
        while(n!=null){
            System.out.println(n.country+ " : " + n.year + " : " + n.magnitude);
            n=n.next;
        }
    }
    boolean isEmpty(){
        return (head==null);
    }
    
    
    public void CountryStacks() throws IOException{
        // Stacks countryStacks = new Stacks();
        //Collections col = new Collections();

        int Year;
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
               
                
                magnitude= Float.parseFloat(parts[4]);
                Year = Integer.parseInt(parts[0].substring(parts[0].length()-4));
                country= parts[2];
              
                if(countries.size()!=0){
                    //System.out.println("In If 1");
                    for(int i=0;i<countries.size();i++){
                        if(countries.get(i).head.country.equals(country)){
                            countries.get(i).push2(Year, country, magnitude);
                            // System.out.println(countries.get(i).head.country);
                            break;
                        }
                        else if (i==countries.size()-1){
                            // System.out.println("in Else");
                            Stacks temp = new Stacks();
                            temp.push2(Year, country, magnitude);
                            countries.add(temp);
                            // System.out.println(countries.get(i).head.country);
                            break;
                        }
                    }
                    continue;
                }
                else{
                    //System.out.println("In If 2");
                    Stacks temp=new Stacks();
                    temp.push2(Year, country, magnitude);
                    countries.add(temp);
                    continue;
                }
                  
            }

        br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
            e.printStackTrace();
        }
    }
 
    void recent(){
        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }
        for(int i=1;i<countries.size();i++){
            StackNode x=countries.get(i).head;
            temp.next=new StackNode(x.year, x.country, x.magnitude);
            temp=temp.next;
        }

        for(StackNode z=r;z!=null;z=z.next){
            z.display3();            
        }
    }
    void recent_above_6(){
        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }
        for(int i=1;i<countries.size();i++){
            StackNode x=countries.get(i).head;
            temp.next=new StackNode(x.year, x.country, x.magnitude);
            temp=temp.next;
        }
        System.out.println("\n\tPrinting magnitudes from country stacks having magnitude above 6.\n");
        for(StackNode z=r;z!=null;z=z.next){
            if(z.magnitude>6 && z.next!=null){
            z.display3();
            }
        }
    }
    public float average(float quantity){
        float avg=(quantity/52);
        return  avg;
    }
    void average_earthquake(){
        float num=0;
        float result=0;
        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }
        for(int i=1;i<countries.size();i++){
            StackNode x=countries.get(i).head;
            // x.display3();
            temp.next=new StackNode(x.year, x.country, x.magnitude);
            temp=temp.next;
        }
        
        for(StackNode z=r;z!=null;z=z.next){
            for(int i=0;i<countries.size();i++){
                if(countries.get(i).head.country==z.country){
                    z.display3();  
                    num++;          
                }   
            }
        }
        System.out.println(num);   
    }
    void display_recent_5(){
        int num=0;
        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }
        for(int i=1;i<countries.size();i++){
            StackNode x=countries.get(i).head;
            // x.display3();
            temp.next=new StackNode(x.year, x.country, x.magnitude);
            temp=temp.next;
        }
        
        for(int i =0;i<countries.size();i++){
            StackNode a= countries.get(i).head;
            String temp2=a.country;
            if(countries.get(i).head.country==temp2 && num<5){
                a.display3();
                num++;
            }
            a=a.next; 
        }
    }
    public static void main(String[] args) throws IOException {
        
        Stacks st = new Stacks();
        st.CountryStacks();
        
        // st.display_recent_5();
        st.average_earthquake();
        // st.recent();
        // st.recent_above_6();
 
    }
}

   