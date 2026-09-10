public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Java");

        builder.append(" Strings");
        builder.insert(0, "Learning ");
        builder.replace(0, 8, "Mastering");
        builder.reverse();

        System.out.println("Result after builder operations: " + builder);
        System.out.println("Length: " + builder.length());
        System.out.println("Capacity: " + builder.capacity());
    }
}
