package Assignment_1;

public class FibonacciSeries {
    
    public static void main(String[] args) {
        
        int first =  0 ;
        int sec = 1 ;
        for (int i = 0; i < 10; i++) {
            
            System.out.println(first);
            
            int third = first + sec;
            first = sec;
            sec = third;


            
        }
    }
}
