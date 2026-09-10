public class StringImmutability {
    public static void main(String[] args) {
        String original = "Java";
        String changed = original.concat(" Strings");

        System.out.println("Original: " + original);
        System.out.println("New value: " + changed);
        System.out.println("Original is unchanged: " + original.equals("Java"));

        original = original.toUpperCase();
        System.out.println("After reassignment: " + original);
    }
}
