import java.io.IOException;

interface Queue{
    public void addQueue(int year, String country, float magnitude);
    public int size(); 
}

class LinkedQueue implements Queue{
    private DataNode head= new DataNode(0, null, 0);    
    private int Queuesize;

    private static class DataNode{  // inner node class to add data
        
        int year;
        String country;
        float magnitude;
        DataNode prev=this;
        DataNode next=this;
    
        public DataNode(int year,String country,float magnitude){
            this.year=year;
            this.country=country;
            this.magnitude=magnitude;
        }
        // constructor to add data
        public DataNode(int year,String country,float magnitude,DataNode n, DataNode p){
            this.year=year;
            this.country=country;
            this.magnitude=magnitude;
            next=n;
            prev=p;
        }
        // method to display data
        public void display(){      
            System.out.println( year +" : "+country + " : " + magnitude);
        }
    }
    
    LinkedQueue(){
        
    }

    public int size(){
        return Queuesize;
    }
    public void addQueue(int year, String country,float magnitude) {
        head.prev.next = new DataNode(year, country, magnitude, head, head.prev);
        head.prev = head.prev.next;   
        ++Queuesize;
    }    
    public boolean isEmpty(){
        return (head==null);
    }
    
    // returns higest all yearly
    void  highest() throws IOException {
        Collections earthquake = new Collections();     
        LinkedQueue q=new LinkedQueue();
        int num=1;
        int year=0;  
        float highest=0;
        String Country="";
        
        for(int i = 0; i < earthquake.size(); i++) {
            LinkedNode n = earthquake.get(i);
            highest=0;
            while(n != null) {
                if(n.magnitude > highest) { // Update highest magnitude for the year
                    highest=n.magnitude;
                    Country=n.country;
                    year=n.year;
                }
                n = n.next; 
            }
            q.addQueue(year, Country, highest);
        }
        for(DataNode t=q.head.next;t!=q.head;t=t.next){
            System.out.print(num+ " : ");
            t.display();
            num++;
        }
    }

    // returns highest from 2005 to 2016
    void  highest2() throws IOException {
        LinkedQueue q=new LinkedQueue();
        Collections earthquake = new Collections();     
        int num=1; 
        int year=0;  
        float highest=0;
        String Country="";
        
        for(int i = 0; i < earthquake.size(); i++) {
            LinkedNode n = earthquake.get(i);
            highest=0;
            while(n != null) {

                if(n.magnitude > highest) { // Update highest magnitude for the year
                    highest=n.magnitude;
                    Country=n.country;
                    year=n.year;
                }
                n = n.next; 
            }
            q.addQueue(year, Country, highest);
        }
        for(DataNode t=q.head.next;t!=q.head;t=t.next){
            if(t.year>2004 && t.year<2016){
                System.out.print(num+ " : ");
                t.display();
                num++;
            }            
        }
    }
    // method to display earthquake all yearly
    void display_All() {
        try {
            highest(); 
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /// Problem # 02
    // method to display earthquake from 2005 to 2015
    public void displayFrom_05_15() {
        try {
            highest2(); 
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void main(String[] args) {
        LinkedQueue a = new LinkedQueue();
        a.display_All();
    }
}
