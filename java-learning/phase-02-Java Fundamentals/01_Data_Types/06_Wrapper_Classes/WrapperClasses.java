
public class WrapperClasses {
    public static void main(String[] args) {
        
        // A wrapper class is a Java class that represents a primitive value as an object.

        int age =  16;

        Integer RollNO = 16 ; 

        System.out.println(age );
        System.out.println(RollNO);

//         int is primitive.

// `       Integer is a class/object type.

//         Why Do We Need Wrapper Classes?

// One major reason is that some Java features work with objects, not primitives.

// For example, Java collections such as ArrayList use object types.
            // byte     → Byte
            // short    → Short
            // int      → Integer
            // long     → Long
            // float    → Float
            // double   → Double
            // char     → Character
            // boolean  → Boolean

       
            // creating the wraper Object 

            // Integer number  = Integer.valueOf(100);
            // Double price = Double.valueOf(99.99);
            // Boolean active = Boolean.valueOf(true);
            // Character letter = Character.valueOf('A');

            String text = "123";

            int number = Integer.parseInt(text);

            System.out.println(number);


            






    }
    
}
