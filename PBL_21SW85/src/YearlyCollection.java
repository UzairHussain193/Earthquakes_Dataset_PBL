import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Node{
    int year;
    String date, time;
    float magnitude;
    Node next;
    String country;

    Node(int year, String date, String time, String country,float magnitude){
        this.year=year;
        this.date=date; 
        this.country=country;
        this.time=time; 
        this.magnitude=magnitude;
    }
    

    void display(){
        System.out.println("|Year: " + year + "| Date: " + date + "| Time: " + time + "| Magnitude: " + magnitude + "|");
    }

}

class YearlyCollection {
    public static void main(String[] args){
        ArrayList <Node> Earthquake=new ArrayList<>();

        String filepath= "E:\\2. Muet material\\3. 3rd Sem SW\\1. DSA\\4. DSA_PBL_SEM_ASSIGNMENT\\PBL_21SW085\\PBL_21SW85\\Cleaned_Data.csv";
        String line;
        String splitBy = ",";
        String add;
        int Y, year;
        float magnitude;

        Scanner s=new Scanner(System.in);

        System.out.print("Enter Year to see records (1965 to 2016):  ");
        year=s.nextInt()-1965;
        
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            br.readLine();      // reada header line
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                add="";
                String[] rowdata = line.split(splitBy); // use comma as separator

                for(int i=9;i<rowdata.length;i++){
                    add+=rowdata[i]+",";
                }
                
                magnitude=Float.parseFloat(rowdata[4]);
                // rowdata[0].length()-4, rowdata[0].length()
                Y=Integer.parseInt(rowdata[0].substring(6));
                // System.out.println(Y);
                // employee[0].);
                    if(Earthquake.size()!=0){
                        for(int i=0; i<Earthquake.size();i++){

                            if(Y==(Earthquake.get(i).year)){
                                Node temp=Earthquake.get(i);
                                while(temp.next!=null){
                                    temp=temp.next;
                                }
                                // Node(int year, String date, String time, String country,float magnitude){
                                temp.next=new Node(Y,rowdata[0],rowdata[1],rowdata[2],magnitude);
                                continue;
                            }
                            else if(i==Earthquake.size()-1){
                                Node temp2=new Node(Y,rowdata[0],rowdata[1],rowdata[2],magnitude);
                                Earthquake.add(temp2);
                                continue;
                            }
                        }
                    }
                    else if(Earthquake.size()==0){ 
                        Node temp1=new Node(Y,rowdata[0],rowdata[1],rowdata[2],magnitude);
                        Earthquake.add(temp1);
                }   
            }
            Node n=Earthquake.get((int)year);
            int x=1;
            while(n!=null){
                System.out.print(x + ". ");
                n.display();
                n=n.next;
                x++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.close();
    }
}