import java.util.Scanner;

public class Statistics {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size :");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];

        for (int number : numbers) {

        sum += number;

            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }


            
        }
        double average = (double) sum / n;

        System.out.println("\n===== Statistics =====");
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);

        sc.close();

    }
}
