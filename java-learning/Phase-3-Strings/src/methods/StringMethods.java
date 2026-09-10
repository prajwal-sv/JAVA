public class StringMethods {
    public static void main(String[] args) {
        String text = "  Learn Java Strings  ";
        String trimmed = text.trim();

        System.out.println("trim: [" + trimmed + "]");
        System.out.println("contains Java: " + trimmed.contains("Java"));
        System.out.println("startsWith Learn: " + trimmed.startsWith("Learn"));
        System.out.println("endsWith Strings: " + trimmed.endsWith("Strings"));
        System.out.println("indexOf Java: " + trimmed.indexOf("Java"));
        System.out.println("replace: " + trimmed.replace("Java", "powerful Java"));
        System.out.println("split words:");
        for (String word : trimmed.split(" ")) {
            System.out.println(word);
        }
    }
}
