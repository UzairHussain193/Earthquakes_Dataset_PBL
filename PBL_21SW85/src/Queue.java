import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

import javax.print.FlavorException;
import javax.swing.plaf.ListUI;

interface Queue{
    public void add(Object obj);
    public Object first();
    public Object remove();
    public int size(); 
}
class Node{
    Object object;
    int year;
    String country;
    float magnitude;
    Node prev=null;
    Node next=null;
    Node(Object obj){
        this.object=obj;
    }
    Node(int year,String country,float magnitude){
        this.year=year;
        this.country=country;
        this.magnitude=magnitude;
    }
    Node(Object obj, Node n,Node p){
        object=obj;
        next=n;
        prev=p;
    }
    String getCountry() {
        return country;
    }

    float getMagnitude() {
        return magnitude;
    }
    int getYear(){
        return year;
    }
}

class LinkedQueue implements Queue{
    Node head;
    Node prev;
    int size;
    Node newnode;
     
    float[] highestmagnitudes = new float[52]; // Array to store highest magnitudes
    String[] countries = new String[52];
    int[] years = new int[52];
    ArrayList<Node> earthquake = new ArrayList<>();

    @Override
    public int size(){
        return size;
    }
    @Override
    public Object first(){
        if(size==0){
            throw new IllegalStateException();
        }
        return head.next.object;
    }
    @Override
    public void add(Object obj){
        head.prev.next=new Node(obj,head,head.prev);
        head.prev=head.prev.next;
        size++;
    }
    void addDetails(int year, String country,float magnitude) {
        Node newNode = new Node(year, country,magnitude);
        if (head == null) {
            head = newNode;
            prev = newNode;
        } else {
            prev.next = newNode;
            newNode.prev = prev;
            prev = newNode;
        }
    }
    void addFromArray(int[] years, String[] countries,float[] magnitudes ) {
        for (int i = 0; i < magnitudes.length; i++) {
            addDetails(years[i], countries[i], magnitudes[i]);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(size==0){
            throw new IllegalStateException();
        }
        for(Node t=head.next;t!=null;t=t.next){
            if(t.object.equals(obj)){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        StringBuilder b=new StringBuilder("[");
        for(Node t=head.next;t!=null;t=t.next){
            b.append(t.year + " : " + t.country + " : " + t.magnitude);
            if(t.next!=head){
                b.append(",");
            }
        }
        b.append("]");
        String s=b.toString();
        return s;       
    }
    public Object last(){
        if(size==0){
            throw new IllegalStateException();
        }
        return head.prev.object;
    }
    @Override
    public Object remove(){
        if(size==0){
            throw new IllegalStateException();
        }
        Object temp=head.next.object;
        head.next=head.next.next;
        head.next.prev=head;
        size--;
        return temp;
    }
    public boolean isEmpty(){
        return (head==null);
    }
    public Object[] toArray(){
        Object[] aa=new Object[size];
        Node t=head.next;
        for(int i=0;i<size;i++){
            aa[i]=t.object;
            t=t.next;
            
        }
        return aa;
    }
    void  highest() throws IOException {   
    // Node highest() throws IOException {       
        Collections earthquake = new Collections();
        int j=0; 
        
        for(int i = 1965; i <=2016; i++) {
            highestmagnitudes[i-1965] = 0; // Initialize to smallest possible float value
        }
        // for(int i = 1965; i <=2016; i++) {
        //     countries[i-1965] = ""; // Initialize to smallest possible string value
        // }
    
        // Loop through each year and find the highest magnitude for that year
        for(int i = 0; i < earthquake.size(); i++) {
            Node n = earthquake.get(i);
            while(n != null) {
                float high=highestmagnitudes[n.year-1965];
                if(n .magnitude > highestmagnitudes[n.year - 1965]) { // Update highest magnitude for the year
                     highestmagnitudes[n.year - 1965] = Math.max(n.magnitude, high);
                     countries[i]=n.country;
                     years[i]=n.year;
                    //  newnode = new Node(n.year, countries[i], highestmagnitudes[i]);
                }
                    // newnode= newnode.next;
                n = n.next;
                // System.out.println(high);
            }
        }
        
        
        for(int i = 0; i < 52; i++,j++, size++) {
            Node n1 = earthquake.get(i);
            // newnode = new Node(n1.year, countries[i], highestmagnitudes[i]);
            // System.out.println(n1.year + " : "  + highestmagnitudes[i]);
            // System.out.println(n1.getYear() + " : "+ countries[i] + " : "  + highestmagnitudes[i]);
            // System.out.println(n1.getYear() + " : "+ n1.getCountry() + " : "  + n1.getMagnitude());
        }
        // System.out.println(toString());
        // System.out.println(j);
        // return newnode;
        // return highestmagnitudes;
    }

    void display() throws IOException {
        highest(); 
        for(int i = 0; i < 52; i++, size++) {
        // //     // newnode = new Node(n1.year, countries[i], highestmagnitudes[i]);
        // //     // System.out.println(n1.year + " : "  + highestmagnitudes[i]);
            System.out.println(years[i] + " : "+ countries[i] + " : "  + highestmagnitudes[i]);
            // System.out.println(n1.year + " : "+ n1.country + " : "  + n1.magnitude);
        }
        // Node newnode = head;
        // while (newnode != null) {
        //     System.out.println(newnode.year + " : " + newnode.country + " : " + newnode.magnitude);
        //     newnode = newnode.next;
        // }
    }

    /// Problem # 02
    public void displayFrom_05_15() throws IOException{
        highest(); 
        int i=(2005-1965);  //  0040 and 52
        for(i=40 ; i < 51; i++, size++) {
        // //     // newnode = new Node(n1.year, countries[i], highestmagnitudes[i]);
        // //     // System.out.println(n1.year + " : "  + highestmagnitudes[i]);
            System.out.println(years[i] + " : "+ countries[i] + " : "  + highestmagnitudes[i]);
            // System.out.println(n1.year + " : "+ n1.country + " : "  + n1.magnitude);
        }
    }
    public static void main(String[] args) throws IOException {
        LinkedQueue list = new LinkedQueue();

        
        // list.addFromArray(list.years, list.countries, list.highestmagnitudes);
            // list.addFromArray(list.countries[i], null, args);
       
        // list.display();
        list.displayFrom_05_15();
        System.out.println(list.isEmpty());
        // list.highest();
        // list.display();
        // list.first();
        // list.toString();
        // System.out.println(list.toString());
        // list.first();
        
        // list.highest();
        // list2.display();
        // list2.highest();
        

    }
}
