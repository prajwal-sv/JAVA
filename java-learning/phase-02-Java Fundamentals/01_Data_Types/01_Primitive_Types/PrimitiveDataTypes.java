public class PrimitiveDataTypes {

    public static void main(String[] args) {

//         The 8 primitive types are:

// byte → short → int → long → float → double → char → boolean

        // int age  = 15 ;
        // int : data type
        // age :  variable name 
        // 15  : value 


        // Integer Type : Store the Whole Number 

        // byte : store values from -128 to 127.

        byte rollNo = 15 ;

        System.out.println(rollNo);

        // short:  range  -32,768 to 32,767 
        short marks = 250 ;
        System.out.println(marks);

        // int :  range -2,147,483,648 to 2,147,483,647

        int salary = 50000;
        System.out.println(salary);

        // long : large whole number 
        // The L tells Java that the number is a long literal.

        long population = 1400000000L;

        System.out.println(population);


        //Decimal Type : Java has two primitive types for decimal numbers.
        float price = 99.99f ;
        // Without f, Java normally treats a decimal literal as a double.
        System.out.println(price);

        double pi = 3.1415926535;
        // double provides more precision than float.
        System.out.println(pi);


        // character char

        char grade = 'A';
        // use ' ' single Quotes "" "J" is a String, which we'll learn later.

        System.out.println(grade);


        // Boolean :  store only one of two values : 
        // Ture / flase

        boolean isJavaFun = true;
        boolean isRaining = false;

        System.out.println(isJavaFun);
        System.out.println(isRaining);


        











    }
}