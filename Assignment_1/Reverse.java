package Assignment_1;

public class Reverse {

    public static void main(String[] args) {
        int input = 1234;
        int num = input; 
        int reversedNum = 0;
        
        while (num != 0) {
            int digit = num % 10;                     
            reversedNum = (reversedNum * 10) + digit; 
            num /= 10;                               
        }

        System.out.println("Input: " + input);
        System.out.println("Output: " + reversedNum);

    }
    
}
