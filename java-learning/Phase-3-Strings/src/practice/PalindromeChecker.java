import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String original = scanner.nextLine();
        String normalized = original.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();

        System.out.println(normalized.equals(reversed) ? "Palindrome" : "Not a palindrome");
        scanner.close();
    }
}
