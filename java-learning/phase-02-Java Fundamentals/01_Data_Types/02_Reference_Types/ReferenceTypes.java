public class ReferenceTypes {

    public static void main(String[] args) {
        // Refrence Type : store the refernce of the Object 
        String firstName = "Alex";
        String lastName = "Smith";
        // String → reference type
        // name → variable
        // "Alex" → a String object/value


        // Join the String : 
        String fullName = firstName + " " + lastName;

        System.out.println(fullName);



        // Array  in Refrence Type 

        int[] marks  ={80,90,75,88};

        // int[]: int itself is primitive  but int[] is refrence type becouse its an array obejct 

        System.out.println(marks[0]);


        // Class and Object 
        // using class you can create own refernce type 
        class Student {
            String name = "prajwal";
            int age = 90;
        }
        Student student = new Student();
        // Student → reference type
        // student → variable
        // new Student() → creates an object


        // Null : reference variables can contain a special value

        // String name =  null ; 

        System.out.println(student.name);
        System.out.println(student.age);

    






    }
}