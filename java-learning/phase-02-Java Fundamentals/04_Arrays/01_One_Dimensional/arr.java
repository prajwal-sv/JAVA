public class arr {
    public static void main(String[] args) {
        // Declaration
        // int[] mark ;
        // create an array 
        int[] numbers = new int[5];
        // or 
        // int[] numbers = new int[5]
        // Assigning values

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;


        for (int i = 0; i < numbers.length; i++) {
            // Accessing Elements 
            System.out.println(numbers[i]);
        }
        // Changing an element:
        numbers[2] = 100;



    }
}
