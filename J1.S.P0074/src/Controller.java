import java.io.IOException;
import java.util.Scanner;
public class Controller implements IMatrix{
    private static final Scanner in = new Scanner(System.in);

    int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    int checkInputInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(in.nextLine());
                if(result > 0)
                    return result;
            } catch (NumberFormatException ex) {
            }
            ;
        }
    }
    
    int checkData(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                
            }
        }
    }
    
      public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        if(matrix1.length != matrix2.length ||matrix1[0].length != matrix2[0].length){
            return null;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j] ;
            }
        }
        return matrixResult;
    }
     
      public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        
        if(matrix1.length != matrix2.length ||matrix1[0].length != matrix2[0].length){
            return null;
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j] ;
            }
        }
        return matrixResult;
    }
    
      public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] matrixResult = new int[row1][col2];
        if (col1 != row2) {
            return null;
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }
}
