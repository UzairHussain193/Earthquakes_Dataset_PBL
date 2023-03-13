import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Collections list = new Collections();       // object of collection class ( step 1 )
        LinkedQueue queue= new LinkedQueue();       // object of linked queue class ( step 2 )
        Stacks stack = new Stacks();               // object of stacks class ( step 3 & 4 )


        int ch=0;

        do{
            ch=list.menu();                     // calls menu method from collection class
            switch(ch){
                case 1:
                    list.display_Collections();         // method to display collection yearly
                    break;
                case 2:
                    queue.display_All();                //  method to display collection 
                    break;
                case 3:
                    stack.display_Yearly_Stacks();      // display country stacks country wise
                    break;
                case 4:
                    stack.recent_stacks();              //  display stacks recent ones         
                    break;
                case 5:
                    stack.average_earthquake();         // returns most vulnerable countries
                    break;
                case 6:
                    queue.displayFrom_05_15();          // shows earthquakes of 2005 to 2015
                    break;
                case 7:
                    stack.display_recent_5();           // displays recent five from each stacks
                    break;
                case 8:
                    stack.recent_above_6();             // display recenet earthquakes with magnitude greater than 6
                    break;
                case 0: 
                    ch=0; 
                    break;

                default: System.out.println("\nInvalid Choice");
            }
            if(ch==0){
                System.out.println("Thank You!");
                break;
            }
            System.out.print("\nPress any no. to continue \n      or 0 to exit \n\nChoice:");
            ch=s.nextInt();
        }while(ch!=0);

        
    }
    
}
