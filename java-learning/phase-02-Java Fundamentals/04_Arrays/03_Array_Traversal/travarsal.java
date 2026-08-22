
public class travarsal {
    public static void main(String[] args) {
        
    
    int[] numbers = {10, 20, 30, 40, 50};
    for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
    }
// Java also provides a simpler loop:

    for (int number : numbers) {
    System.out.println(number);
}

int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }

    
}



}

}
