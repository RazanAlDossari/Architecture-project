public class Main {

    public static void main(String[] args) {
        //Initialize matrix
        double[][] Matrix1 = { {1, 2, 3, 1.0/2.0}, {1.0/2.0, 1, 2, 1.0/3.0 }, {1.0/3.0, 1.0/2.0, 1, 1.0/4.0 }, {2, 3, 4, 1 }};
        double[][] Matrix2 = { {1, 2, 3, 1.0/2.0}, {1.0/2.0, 1, 2, 1.0/3.0 }, {1.0/3.0, 1.0/2.0, 1, 1.0/4.0 }, {2, 3, 4, 1 } };

        //Count matrix elemnet
        int counter = 0;
        for (int i = 0; i < Matrix1.length; i ++)
            if (Matrix1[i] != null)
                counter ++;
        //System.out.println(counter);

        //Initialize Square Matrix
        double[][] SquareMatrix = new double[counter][counter];

    /*  System.out.println("Matrix A:");
      for (int i = 0; i < counter; i++) {
         for (int j = 0; j < counter; j++) {
            System.out.print(Matrix1[i][j] + "  ");
         }
         System.out.println();
      }
      System.out.println("Matrix B:");
      for (int i = 0; i < counter; i++) {
         for (int j = 0; j < counter; j++) {
            System.out.print(Matrix2[i][j] + "  ");
         }
         System.out.println();
      }*/

        //The product of two matrices
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < counter; j++){
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

        //Calculates number of rows and columns present in SquareMatrix
        int rows, cols;
        double sumRow,sumCol;
        double[] sumColArray=new double[counter];
        double[] priorityVector=new double[counter];


        rows = SquareMatrix.length;
        cols = SquareMatrix[0].length;

        //Calculates sum of each row of SquareMatrix
        for(int i = 0; i < rows; i++){
            sumRow = 0;
            for(int j = 0; j < cols; j++){
                sumRow = sumRow + SquareMatrix[i][j];
            }
            // System.out.println("Sum of " + (i+1) +" row: " + sumRow);

            //Divide each element in the row by its sum of SquareMatrix
            for(int j = 0; j < cols; j++){
                SquareMatrix[i][j] =  SquareMatrix[i][j]/sumRow;
            }
        }

     /*System.out.println("The Division of SquareMatrix is:");
      for (int i = 0; i < SquareMatrix.length; i++) {
         for (int j = 0; j < SquareMatrix.length; j++) {
            System.out.print(SquareMatrix[i][j] + "  ");
         }
         System.out.println();
      }*/

        //Calculates sum of each column of SquareMatrix
        for(int i = 0; i < cols; i++){
            sumCol = 0;
            for(int j = 0; j < rows; j++){
                sumColArray[i] = sumColArray[i] + SquareMatrix[j][i];
            }
            // System.out.println("Sum of " + (i+1) +" column: " + sumColArray[i] );
        }

        //Calculates The priority vector by divide sumColArray elements by the matrix mean value
        for (int i = 0; i < sumColArray.length; i++)
            priorityVector[i] = sumColArray[i]/sumColArray.length;

        System.out.println("The priority vector (𝑝⃗) is:");
        for (int i = 0; i < sumColArray.length; i++)
            System.out.print(priorityVector[i] + "  ");

        /*****************************************************************/

        // Calculates W total by multiply WSM (-2,-1,0,1,2) and perform an addition with priority vector (𝑝⃗) result

        /*****************************************************************/


    }//Main
}//Class
