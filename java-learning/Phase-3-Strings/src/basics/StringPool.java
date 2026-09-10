public class StringPool {
    public static void main(String[] args) {
        String first = "Java";
        String second = "Java";
        String third = new String("Java");
        String pooledThird = third.intern();

        System.out.println("first == second: " + (first == second));
        System.out.println("first == third: " + (first == third));
        System.out.println("first.equals(third): " + first.equals(third));
        System.out.println("first == pooledThird: " + (first == pooledThird));
    }
}
