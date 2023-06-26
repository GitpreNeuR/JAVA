
package Matrix;

import java.util.*;

public class MatrixOne {

    static void printMatrix(int arr[][]) {
        int N=arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if ((i == j) || (i + j == mat.length - 1)) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    

    

    static void rotate90Clockwise(int a[][]) {

        int N = a.length;
        // Traverse each cycle
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    public static void main(String args[])

    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows in matrix");
        int rows = sc.nextInt();

        System.out.println("Enter number of columns in matrix");
        int cols = sc.nextInt();

        int first[][] = new int[rows][cols];
        int i, j;

        // Read the matrix values
        System.out.println("Enter the elements of the matrix");
        for (i = 0; i < rows; i++)
            for (j = 0; j < cols; j++)
                first[i][j] = sc.nextInt();

        // Display the elements of the matrix
        System.out.println("\nThe matrix is");
        printMatrix(first);



        rotate90Clockwise(first);
        System.out.println("\nThe rotated matrix is");
        printMatrix(first);

    }
}
