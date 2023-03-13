// import java.util.ArrayList;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Scanner;

// class Data{
//     int Year;
//     String Date, Time, Country, Address;
//     float Magnitude;
//     Data next;

//     Data(int Y, String D, String T, float M, String C, String A){
//         Year=Y;
//         Date=D; 
//         Time=T; 
//         Magnitude=M;
//         Country=C;
//         Address=A;
//     }

//     void display(){
//         System.out.println("|Year: " + Year + "| Date: " + Date + "| Time: " + Time + "| Country: " + Country + "| Address: " + Address + "| Magnitude: " + Magnitude + "|");
//     }
// }

// class Yearly {
//     ArrayList <Data> YearlyEarthquake=new ArrayList<>();

//     Yearly(){
//         String line = "";
//         String splitBy = ",";
//         String add;
//         int Y;
//         float Magnitude;

//         try {
//             BufferedReader br = new BufferedReader(new FileReader("Data.csv"));
//             br.readLine();
//             while ((line = br.readLine()) != null) // returns a Boolean value
//             {
//                 add="";
//                 String[] employee = line.split(splitBy); // use comma as separator

//                 for(int i=9;i<employee.length;i++){
//                     add+=employee[i];
//                 }
                
//                 Magnitude=Float.parseFloat(employee[8]);
//                 Y=Integer.parseInt(employee[0].substring(employee[0].length()-4, employee[0].length()));
                
//                     if(YearlyEarthquake.size()!=0){
//                         for(int i=0; i<YearlyEarthquake.size();i++){

//                             if(Y==(YearlyEarthquake.get(i).Year)){
//                                 Data t=YearlyEarthquake.get(i);
//                                 while(t.next!=null){
//                                     t=t.next;
//                                 }
//                                 t.next=new Data(Y,employee[0],employee[1],Magnitude,employee[employee.length-1], add);
//                                 continue;
//                             }
//                             else if(i==YearlyEarthquake.size()-1){
//                                 Data t=new Data(Y,employee[0],employee[1],Magnitude,employee[employee.length-1], add);
//                                 YearlyEarthquake.add(t);
//                                 break;
//                             }
//                         }
//                     }
//                     else if(YearlyEarthquake.size()==0){ 
//                         Data t=new Data(Y,employee[0],employee[1],Magnitude,employee[employee.length-1], add);;
//                         YearlyEarthquake.add(t);
//                     }   
//             }
//             br.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     void display(){
//         int Year;
//         Scanner s=new Scanner(System.in);

//         System.out.println("Enter Year: ");
//         Year=s.nextInt()-1965;

//         Data n=YearlyEarthquake.get(Year);
//         int x=1;
//         while(n!=null){
//             System.out.print(x + ". ");
//             n.display();
//             n=n.next;
//             x++;
//         }
//     }

//     int size(){
//         return YearlyEarthquake.size();
//     }

//     Data get(int index){
//         return YearlyEarthquake.get(index);
//     }
// }