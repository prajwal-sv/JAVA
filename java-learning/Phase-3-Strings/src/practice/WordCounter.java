import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine().trim();

        int wordCount = sentence.isEmpty() ? 0 : sentence.split("\\s+").length;
        System.out.println("Word count: " + wordCount);
        scanner.close();
    }
}
