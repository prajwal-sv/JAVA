import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine().toLowerCase();
        Map<Character, Integer> frequencies = new LinkedHashMap<>();

        for (char character : text.toCharArray()) {
            if (!Character.isWhitespace(character)) {
                frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        scanner.close();
    }
}
