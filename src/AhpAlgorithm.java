
public class AhpAlgorithm {

    public static double[] runAhp(double[][] matrix1, double[][] matrix2) {
        //Initialize Square Matrix
        double[][] squareMatrix = getProductOfTwoMatrices(matrix1, matrix2, matrix1.length);

        //Calculates size of SquareMatrix
        int squareMatrixSize = squareMatrix.length;

        double[][] sumOfSquareMatrix = getSumOfEachRowInSquareMatrix(squareMatrix, squareMatrixSize);

         /*System.out.println("The Division of SquareMatrix is:");
      for (int i = 0; i < squareMatrix.length; i++) {
         for (int j = 0; j < squareMatrix.length; j++) {
            System.out.print(squareMatrix[i][j] + "  ");
         }
         System.out.println();
      }*/

        double[] sumColArray =  getSumOfEachColumnInSquareMatrix(squareMatrixSize, sumOfSquareMatrix);

        double[] priorityVector = calculatesThePriorityVector(sumColArray, matrix1.length);

        /*****************************************************************/

        // Calculates W total by multiply WSM (-2,-1,0,1,2) and perform an addition with priority vector (𝑝⃗) result

        /*****************************************************************/
        return  priorityVector;
    }
    private static double[][] getProductOfTwoMatrices(double[][] Matrix1, double[][] Matrix2, int counter) {
        double[][] SquareMatrix = new double[counter][counter];

        //The product of two matrices
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < counter; j++) {
                for (int k = 0; k < counter; k++) {
                    SquareMatrix[i][j] = SquareMatrix[i][j] + Matrix1[i][k] * Matrix2[k][j];
                }
            }
        }

     /* System.out.println("The product of two matrices is:");
      for (int i = 0; i < SquareMatrix.length; i++) {
         for (int j = 0; j < SquareMatrix.length; j++) {
            System.out.print(SquareMatrix[i][j] + "  ");
         }
         System.out.println();
      }*/
        return SquareMatrix;
    }

    private static double[][] getSumOfEachRowInSquareMatrix(double[][] squareMatrix, int squareMatrixSize) {
        double sumRow = 0;
        //Calculates sum of each row of squareMatrix
        for (int i = 0; i < squareMatrixSize; i++) {
            sumRow = 0;
            for (int j = 0; j < squareMatrixSize; j++) {
                sumRow = sumRow + squareMatrix[i][j];
            }
            // System.out.println("Sum of " + (i+1) +" row: " + sumRow);

            //Divide each element in the row by its sum of squareMatrix
            for (int j = 0; j < squareMatrixSize; j++) {
                squareMatrix[i][j] = squareMatrix[i][j] / sumRow;
            }
        }
        return squareMatrix;
    }

    private static double[] getSumOfEachColumnInSquareMatrix(int squareMatrixSize, double[][] sumOfSquareMatrix) {
        double[] sumColArray = new double[squareMatrixSize];
        //Calculates sum of each column of SquareMatrix
        for (int i = 0; i < squareMatrixSize; i++) {
            for (int j = 0; j < squareMatrixSize; j++) {
                sumColArray[i] = sumColArray[i] + sumOfSquareMatrix[j][i];
            }
            // System.out.println("Sum of " + (i+1) +" column: " + sumColArray[i] );
        }


        return  sumColArray;
    }

    private static double[] calculatesThePriorityVector(double[] sumColArray, int squareMatrixSize) {
        double[] priorityVector = new double[squareMatrixSize];
        //Calculates The priority vector by divide sumColArray elements by the matrix mean value
        for (int i = 0; i < sumColArray.length; i++)
            priorityVector[i] = sumColArray[i] / sumColArray.length;

        System.out.println("The priority vector (𝑝⃗) is:");
        for (int i = 0; i < sumColArray.length; i++)
            System.out.print(priorityVector[i] + "  ");
        return priorityVector;
    }
}
