public class CommandLineArgs {

    public static void main(String[] args) {
        // String[] args : contain values supplied when launching  the program 
        System.out.println(
            "Number of arg : "+ args.length
        );

        for(String arg : args){
            System.out.println("argument : "+ arg);
        }
    }
}

// Java 21 Beginner
// Number of arg : 3
// argument : Java
// argument : 21
// argument : Beginner