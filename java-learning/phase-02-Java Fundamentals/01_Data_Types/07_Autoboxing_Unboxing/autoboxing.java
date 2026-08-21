public class autoboxing {
    public static void main(String[] args) {
        // Autoboxing
        // Primitive → Wrapper object

        int num = 10 ;
        Integer obj = num ; // Autoboxing

        // Equivalent  to :

        Integer obj1 = Integer.valueOf(num);

        System.out.println(obj1);
        // Unboxing
        // Wrapper object → Primitive

        Integer obj3 = 20;
        int num1 = obj3;       // Unboxing

         System.out.println(num1);
        // Equivalent to:


        int num2 = obj.intValue();

        System.out.println(num2);

    

    }
}
