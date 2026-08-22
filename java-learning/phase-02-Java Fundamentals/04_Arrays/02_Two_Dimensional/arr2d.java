
public class arr2d {
    public static void main(String[] args) {
        // A 2D array is an array containing rows and columns.
    //                    Col 0   Col 1   Col 2
    //         Row    0    10      20      30
    //         Row    1    40      50      60
    //         Row    2    70      80      90
    //Creating to 2d array 

    int[][] matrix = new int[3][3];
    // 3 rows × 3 columns

    // assigning value 

    matrix[0][0] = 10;
    matrix[0][1] = 20;
    matrix[0][2] = 30;

    matrix[1][0] = 40;
    matrix[1][1] = 50;
    matrix[1][2] = 60;
// Direct initialization
//    int[][] matrix = {
//     {10, 20, 30},
//     {40, 50, 60},
//     {70, 80, 90}
// };
// accessing
System.out.println(matrix[1][2]);

    }
    
}
