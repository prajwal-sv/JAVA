import java.util.Random;
import java.util.Scanner;
public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int secret = random.nextInt(100)+1;
        int guess;
        int attempts =0 ;

        System.err.println("Guess a number between 1 and 100.");

        do{
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if(guess > secret){
                System.out.println("Too high");
            }else if(guess < secret){
                System.out.println("Too low ");

            }else{
                System.out.println("Correct");
                System.out.println("Attempts : " + attempts);
            }
        }while(guess != secret);

        sc.close();

    }
}
