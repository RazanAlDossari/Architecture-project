package com.archi.main.algorithms;

import com.archi.main.algorithms.data_model.Pair;
import com.archi.main.algorithms.data_model.QualityAttributePair;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.archi.main.algorithms.QualityAttributesUtilities.getMainQualityAttributes;

public class AhpAlgorithm {

    public static List<Pair<String, Double>> runAhp(List<QualityAttributePair> qaPair) {
        String[] mainQA = getMainQualityAttributes(qaPair);
        int distinctQASize = mainQA.length;
        Double[][] qaMatrix = new Double[distinctQASize][distinctQASize];

        Pair<String[], double[][]> matrix = getAHPQAMatrix(qaPair);
//        //Initialize Square Matrix

        //Pair<String[], Double[][]> squareMatrix = getProductOfTwoMatrices(matrix, matrix);

        double[][] cellMap = matrix.getSecond();
        System.out.println("------------------------getProductOfTwoMatrices-------------------------");
        double[][] squareMatrix = getProductOfTwoMatrices(cellMap, cellMap, cellMap.length);
//        //Calculates size of SquareMatrix
//        int squareMatrixSize = squareMatrix.length;
//
        double[][] sumOfSquareMatrix = getSumOfEachRowInSquareMatrix(squareMatrix, squareMatrix.length);
//
        System.out.println("The Division of SquareMatrix is:");
        for (double[] doubles : squareMatrix) {
            for (int j = 0; j < squareMatrix.length; j++) {
                System.out.print(doubles[j] + "  ");
            }
            System.out.println();
        }

        double[] sumColArray =  getSumOfEachColumnInSquareMatrix(sumOfSquareMatrix, sumOfSquareMatrix.length);

        double[] priorityVector = calculatesThePriorityVector(sumColArray, qaPair.size());
//
        for (double v : priorityVector) {
            System.out.print(v + "  ");
        }
        System.out.println();
//        /*****************************************************************/
//
//        // Calculates W total by multiply WSM (-2,-1,0,1,2) and perform an addition with priority vector (𝑝⃗) result
//
//        /*****************************************************************/

      return  getWeightNormalization(matrix.getFirst(),priorityVector);
    }

    private static double[][] getProductOfTwoMatrices(double[][] matrix1, double[][] matrix2, int length) {
        double[][] SquareMatrix = new double[length][length];

        //The product of two matrices
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    SquareMatrix[i][j] = SquareMatrix[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("The product of two matrices is:");
        for (double[] squareMatrix : SquareMatrix) {
            for (int j = 0; j < SquareMatrix.length; j++) {
                System.out.print(squareMatrix[j] + "  ");
            }
            System.out.println();
        }
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

    private static double[] getSumOfEachColumnInSquareMatrix(double[][] sumOfSquareMatrix, int squareMatrixSize) {
        double[] sumColArray = new double[squareMatrixSize];
        //Calculates sum of each column of SquareMatrix
        for (int i = 0; i < squareMatrixSize; i++) {
            for (int j = 0; j < squareMatrixSize; j++) {
                sumColArray[i] = sumColArray[i] + sumOfSquareMatrix[j][i];
            }
             System.out.println("Sum of " + (i+1) +" column: " + sumColArray[i] );
        }
        return sumColArray;
    }

    private static double[] calculatesThePriorityVector(double[] sumColArray, int squareMatrixSize) {
        double[] priorityVector = new double[squareMatrixSize];
        //Calculates The priority vector by divide sumColArray elements by the matrix mean value
        for (int i = 0; i < sumColArray.length; i++)
            priorityVector[i] = sumColArray[i] / sumColArray.length;

        System.out.println("The priority vector (𝑝⃗) is:");
        for (int i = 0; i < sumColArray.length; i++)
            System.out.print(priorityVector[i] + "  ");
        System.out.println("qqqq"+priorityVector.length);
        return Arrays.copyOfRange(priorityVector, 0, sumColArray.length);
              //  priorityVector.;
    }


    public static Pair<String[], double[][]> getAHPQAMatrix(List<QualityAttributePair> qaPair) {
        String[] mainQA = getMainQualityAttributes(qaPair);
        int distinctQASize = mainQA.length;
        double[][] qaMatrix = new double[distinctQASize][distinctQASize];
        int index = 0;
        for (int rowIndex = 0; rowIndex < distinctQASize; rowIndex++) {
            for (int colIndex = 0; colIndex < distinctQASize; colIndex++) {
                if (colIndex < rowIndex) {
                    qaMatrix[rowIndex][colIndex] = getInverseBasedOnScale(qaMatrix[colIndex][rowIndex]);
                } else {
                    qaMatrix[rowIndex][colIndex] = getMatrixBasedOnScale(qaPair.get(index).getScale());
                    index++;
                }
                System.out.print("[" + qaMatrix[rowIndex][colIndex] + "]\t");
            }
            System.out.println();
        }
        return new Pair<>(mainQA, qaMatrix);
    }

    private static double getInverseBasedOnScale(double scale) {
        if (scale == 1.0) return 1.0;
        else if (scale == 9.0)
            return Double.parseDouble(new DecimalFormat("###.###").format(1 / 9.0));
        return Double.parseDouble(new DecimalFormat("###.###").format(1 / scale));
    }

    private static double getMatrixBasedOnScale(double scale) {
        if (scale == 1.0) return 1.0;
        else if (scale == 9.0)
            return 9.0;
        if (scale > 1.0)
            return Double.parseDouble(new DecimalFormat("###.###").format(scale));
        else {
            double orgNumber = 1.0 / scale;

            return Double.parseDouble(new DecimalFormat("###.###").format(1 / orgNumber));
        }
    }


    private static List<Pair<String, Double>> getWeightNormalization(String[] qaAttribute, double[] minimumWeights) {
        //todo: pair(attribute, score)
        List<Pair<String, Double>> result = new ArrayList<>();
        double totalWeight = 0.0;
        for (double minimumWeight : minimumWeights) {
            totalWeight += minimumWeight;
        }
        for (int i = 0; i < qaAttribute.length; i++)
        System.out.println(minimumWeights.length+"razan1111::"+qaAttribute[i]);

        if (totalWeight != 0)
            for (int i = 0; i < minimumWeights.length; i++) {
                double total = Double.parseDouble(new DecimalFormat("###.###").format((minimumWeights[i] / totalWeight)));
                result.add(new Pair<>(qaAttribute[i], total));
                System.out.println("[" + result.get(i).getFirst() + "," + result.get(i).getSecond() + "]");
            }

        return result;
    }
}
