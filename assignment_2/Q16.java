package assignment_2;

public class Q16 {

    public static void main(String[] args) {
       int n = 25 ;
    String s  = Integer.toString(n);

    Integer i = Integer.valueOf(n);

    Integer i2 = Integer.valueOf(s);



    System.out.println(s); 
    System.out.println(i); 
    System.out.println(i2); 

    System.out.println(Integer.toBinaryString(n));
    System.out.println(Integer.toOctalString(n));
    System.out.println(Integer.toHexString(n));
     
    }
    

}
