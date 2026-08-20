public class Calculator {

    public static void main(String[] args) {
        // int a = 15 ;
        // int is a data type which tell which type of data store in "A"
        // a is avriable who store a value 15 in it 

        // int b =10 ;4

        int a = Integer.parseInt(args[0]);
        int  b = Integer.parseInt(args[1]);
        //    it accpet the number using the args 

        


        System.out.println("Addition "+ (a+b));
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));

    }
}