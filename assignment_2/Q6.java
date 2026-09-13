package assignment_2;

public class Q6 {
   public static void main(String[] args) {
    boolean b = true;
    String s = Boolean.toString(b);
    System.err.println("boolean value to string "+s);

    boolean obj = Boolean.valueOf(s);
    System.out.println("boolean to instance boolean "+obj);

    String str2 = "true";

    boolean b1 = Boolean.parseBoolean(str2);
    System.out.println("string value "+str2+" to boolean value "+b1);


   } 

    

}
