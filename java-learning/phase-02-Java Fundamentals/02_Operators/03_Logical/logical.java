
public class logical {
   public static void main(String[] args) {
//     && — Logical AND: both conditions must be true.
    // || — Logical OR: at least one condition must be true.
    // ! — Logical NOT: reverses the result.

        int age = 20;

        System.out.println(age >= 18 && age <= 60); // true
        System.out.println(age < 18 || age > 60);   // false
        System.out.println(!(age >= 18));           // false

   } 
}
