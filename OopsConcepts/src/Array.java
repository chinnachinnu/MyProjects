import java.util.Scanner; 

 class Array{
   public static void main(String args[]) {
     double sum = 0;
     double avg = 0;
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter how many students are in the class? ");
     int ArraySize = sc.nextInt();
     int[] marks = new int[ArraySize];
     System.out.println("Enter the marks:");

     for(int i = 0; i < ArraySize; i++) {
       marks[i] = sc.nextInt();
       sum = sum + marks[i]; 
     }

     avg = (sum / ArraySize);
     System.out.println("Average of the class : " + avg);    
   } 
 }