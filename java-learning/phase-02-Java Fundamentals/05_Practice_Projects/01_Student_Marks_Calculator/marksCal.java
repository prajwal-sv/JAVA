import java.util.Scanner;
public class marksCal {
    public static void main(String[] args) {
        // Create a Scanner object to capture user input from the console
    Scanner sc =  new Scanner(System.in);

    System.out.println("Enter your subject : ");
        int n = sc.nextInt();
        int[] marks =  new int[n];

    int total = 0 ;
    int highest;
    int lowest;

    for (int i = 0; i < marks.length; i++) {
        System.out.println("enter marks for subject" +(i+1)+": ");
        marks[i] = sc.nextInt();
    }
    highest = marks[0];
    lowest = marks[0];

    for (int  mark : marks) {
        total+=mark;
        if(mark > highest){
            highest = mark;
        }
        if(mark<lowest){
            lowest = mark;
        }
        
    }

    double avg = (double) total /n;

        System.out.println("\nTotal = " + total);
        System.out.println("Average = " + avg);
        System.out.println("Highest = " + highest);
        System.out.println("Lowest = " + lowest);

        
// Close the Scanner resource to prevent memory leaks
        sc.close();



    }
}
