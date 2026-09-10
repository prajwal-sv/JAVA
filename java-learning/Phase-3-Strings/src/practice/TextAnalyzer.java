import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        int letters = 0;
        int digits = 0;
        int spaces = 0;
        int other = 0;

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                letters++;
            } else if (Character.isDigit(character)) {
                digits++;
            } else if (Character.isWhitespace(character)) {
                spaces++;
            } else {
                other++;
            }
        }

        System.out.println("Characters: " + text.length());
        System.out.println("Letters: " + letters);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        System.out.println("Other: " + other);
        scanner.close();
    }
}
