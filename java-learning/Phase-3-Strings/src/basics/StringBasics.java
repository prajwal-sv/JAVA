public class StringBasics {
    public static void main(String[] args) {
        String greeting = "Hello, Java!";
        String language = new String("Java");

        System.out.println("Greeting: " + greeting);
        System.out.println("Language: " + language);
        System.out.println("Length: " + greeting.length());
        System.out.println("First character: " + greeting.charAt(0));
        System.out.println("Uppercase: " + greeting.toUpperCase());
        System.out.println("Substring: " + greeting.substring(7, 11));
    }
}
