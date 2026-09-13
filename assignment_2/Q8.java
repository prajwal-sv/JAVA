package assignment_2;

public class Q8 {
    public static void main(String[] args) {
        
        byte pre = 42 ;
        String stringValue = "100";


        String bytetToString =  Byte.toString(pre);
        Byte bytetoinstance  = Byte.valueOf(pre);
        Byte StringToByteInstance = Byte.valueOf(stringValue);

        System.out.println("a. Byte value converted to String: \"" + bytetToString + "\"");
        System.out.println("b. Byte value converted to Byte instance: " + bytetoinstance);
        System.out.println("c. String instance converted to Byte instance: " + StringToByteInstance);

        

        
        
    }
}
