
public class Switch {
    public static void main(String[] args) {
        // Important: break prevents execution from continuing into the next case.

        // Modern Java also supports the arrow-style switch:

      // switch
    int day = 1 ;
    switch (day) {
    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    case 3:
        System.out.println("Wednesday");
        break;

    default:
        System.out.println("Invalid day");
}

        int day2 = 2;

switch (day2) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    case 3 -> System.out.println("Wednesday");
    default -> System.out.println("Invalid day");
}
    }
    
}
