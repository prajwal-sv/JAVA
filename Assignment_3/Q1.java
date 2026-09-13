package Assignment_3;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Q1 {
    public static void main(String[] args) {
        LocalDateTime  dt =  LocalDateTime.of(2022, 12, 31, 23, 59,59 );

        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd//MM/yyyy")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("hh:mm")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd//MM/yyyy HH:mm:ss")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd//MM/yyyy hh:mm:ss a")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd//MM/yyyy HH:mm")));




    }
    
}
