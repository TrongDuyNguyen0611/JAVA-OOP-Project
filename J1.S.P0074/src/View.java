public class View {
    Controller ctrl = new Controller();
    void Menu() {
            System.out.println("--------Matrix Caculator-------");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
    }
    int[][] inputMatrix(int n) {
        int row = ctrl.checkInputInt("Enter Row Matrix"+n+": ");
        int col = ctrl.checkInputInt("Enter Colum Matrix"+n+": ");
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = ctrl.checkData("Enter Matrix" + n + "[" + i + "]" + "[" + j + "]:");
            }
        }
        return matrix;
    }
    void displayMatrix(int[][] matrix) {
        if(matrix == null) return;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    void Add(){
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        System.out.println("--------------RESULT--------------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int matrix[][] = new int[matrix2.length][matrix2[0].length];
        if(ctrl.additionMatrix(matrix1,matrix2)!= null){
            matrix = ctrl.additionMatrix(matrix1,matrix2);
            displayMatrix(matrix);
        }
        else
              System.out.println("can not addition");
     }
      void Sub(){
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        System.out.println("--------------RESULT--------------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int matrix[][] = new int[matrix2.length][matrix2[0].length];
        if(ctrl.subtractionMatrix(matrix1,matrix2)!= null){
            matrix = ctrl.subtractionMatrix(matrix1,matrix2);
            displayMatrix(matrix);
        }
        else
              System.out.println("can not subtraction");
     }
      void Mul(){
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        System.out.println("--------------RESULT--------------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int matrix[][] = new int[matrix2.length][matrix2[0].length];
        if(ctrl.multiplicationMatrix(matrix1,matrix2)!= null){
            matrix = ctrl.multiplicationMatrix(matrix1,matrix2);
            displayMatrix(matrix);
        }
        else
              System.out.println("can not multiplication");
     }
}
