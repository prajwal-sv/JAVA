public class StringComparison {
    public static void main(String[] args) {
        String first = "Java";
        String second = "java";

        System.out.println("equals: " + first.equals(second));
        System.out.println("equalsIgnoreCase: " + first.equalsIgnoreCase(second));
        System.out.println("compareTo: " + first.compareTo(second));
        System.out.println("compareToIgnoreCase: " + first.compareToIgnoreCase(second));
    }
}
