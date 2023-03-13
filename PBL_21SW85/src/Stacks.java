import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


class StackNode{
    int year;
    int size;
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
    // public int size(){
    //     return size;
    // }
    public void display3() {
        System.out.println( year +" : "+ country+" : "+ magnitude);
    }

}

class Stacks{

    StackNode head;
    ArrayList<Stacks> countries= new ArrayList<>();
    int size;
    
    
    

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
 
    void display_Yearly_Stacks(){
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
       
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
        int num=1;
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }

        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
       
        for(int i=1;i<countries.size();i++){
            StackNode x=countries.get(i).head;
            temp.next=new StackNode(x.year, x.country, x.magnitude);
            temp=temp.next;
        }
        System.out.println("\n\tPrinting magnitudes from country stacks having magnitude above 6.\n");
        for(StackNode z=r;z!=null;z=z.next){
            if(z.magnitude>6 && z.next!=null){
                System.out.print(num+ " : ");
                z.display3();
                num++;
            }
        }
    }
    public float average(float quantity){
        float avg=(quantity/52);
        return  avg;
    }
    void average_earthquake(){
        int count=0;
        String country_vulnerable = "";
        float result=0;
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }
        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
    
        for(int i=1;i<countries.size();i++){
            StackNode x=countries.get(i).head;
            // x.display3();
            temp.next=new StackNode(x.year, x.country, x.magnitude);
            temp=temp.next;
        }
        for(int i=0;i<countries.size();i++){
            count=0;
            // System.out.println(countries.get(i).size);
            StackNode a = countries.get(i).head;
            country_vulnerable=a.country;
            a=a.next;
            count=countries.get(i).size;                
            if(a==null){
                break;
            }   
            count/=2;
            result=(float)(count/52);
            System.out.println(country_vulnerable  + " : "+count + " : " + result );
        }
        
    }
    void display_recent_5(){
        int num=1;
        try {
            CountryStacks();
        } catch (Exception e) {
            // TODO: handle exception
        }
        StackNode t=countries.get(0).head;
        StackNode r=new StackNode(t.year, t.country, t.magnitude);
        StackNode temp=r;
        
        for(int i=1;i<countries.size();i++){
            StackNode x=countries.get(i).head;
            // x.display3();
            temp.next=new StackNode(x.year, x.country, x.magnitude);
            temp=temp.next;
        }
        for(int i=0;i<countries.size();i++){
            StackNode a = countries.get(i).head;
            for(num=0;num<6;num++){
                a.display3();
                a=a.next;
                if(a==null){
                   break;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        
        Stacks st = new Stacks();
        st.CountryStacks();
        
        // st.display_recent_5();
        // st.stacks_by_country();
        // st.display_Yearly_Stacks();
        st.average_earthquake();
        // st.recent();
        // st.recent_above_6();
 
    }
}

   