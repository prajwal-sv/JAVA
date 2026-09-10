public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Shared");

        buffer.append(" text");
        buffer.insert(0, "Thread-safe ");
        buffer.delete(0, 11);

        System.out.println("Result: " + buffer);
        System.out.println("Length: " + buffer.length());
        System.out.println("Capacity: " + buffer.capacity());
    }
}
