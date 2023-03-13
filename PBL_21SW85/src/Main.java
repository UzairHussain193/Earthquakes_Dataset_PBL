import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Collections list = new Collections();
        LinkedQueue queue= new LinkedQueue();
        Stacks stack = new Stacks();


        int ch=0;

        do{
            ch=list.menu();
            switch(ch){
                case 1:
                    list.display_Collections();
                    break;
                case 2:
                    queue.display_All();
                    break;
                case 3:
                    stack.display_Yearly_Stacks();
                    break;
                case 4:
                    stack.display_Yearly_Stacks();
                    break;
                case 5:
                    stack.average_earthquake();
                    break;
                case 6:
                    queue.displayFrom_05_15();
                    break;
                case 7:
                    stack.display_recent_5();
                    break;
                case 8:
                    stack.recent_above_6();
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
