import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FahpAlgorithm {

    public static double[] runFahp(List<QualityAttributePair> qaPair) {
        System.out.println("------------------------getQAMatrix-------------------------");
        Triplet[][] cellMap = QualityAttributesUtilities.getQAMatrix(qaPair);
        System.out.println("------------------------getAverageFromEachRow-------------------------");
        List<Double> mColumn = getAverageFromEachRow(cellMap);
        System.out.println("------------------------getLowerDiffEachRow-------------------------");
        List<Double> lColumn = getLowerDiffEachRow(cellMap);
        System.out.println("------------------------getUpperDiffEachRow-------------------------");
        List<Double> uColumn = getUpperDiffEachRow(cellMap);
        System.out.println("------------------------getFuzzyNumbersBasedOnFuzzyFaction-------------------------");
        System.out.println("(m-§ , m , m+§)");
        List<Triplet> fNBasedOnFuzzy = getFuzzyNumbersBasedOnFuzzyFaction(lColumn, mColumn, uColumn);
        System.out.println("------------------------getFuzzyNumbersInverse-------------------------");
        List<Triplet> fNInverse = getFuzzyNumbersInverse(fNBasedOnFuzzy);
        System.out.println("-------------Calculation of the Fuzzy Composite Extension Si -------------");
        List<Triplet> fCompositeExtension = getFuzzyCompositeExtension(fNBasedOnFuzzy, fNInverse);
        System.out.println("-------------Calculation of degree of importance of M1 over M2 -------------");
        Double[][] fDegreeOfImportance = getDegreeOfImportance(fCompositeExtension);
        System.out.println("------------------------get Minimum Weight-------------------------");
        double[] minimumWeights = getMinimumWeight(fDegreeOfImportance);
        System.out.println("------------------------get Weight Normalization -------------------------");
       return getWeightNormalization(minimumWeights);

    }

    //we calculate the sum for each row then dived it by 3
    private static List<Double> getAverageFromEachRow(Triplet[][] cellMap) {
        List<Double> avgList = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < cellMap.length; rowIndex++) {
            double sum = 0.0;
            for (int colIndex = 0; colIndex < cellMap[rowIndex].length; colIndex++) {
                sum += cellMap[rowIndex][colIndex].getSum();
                System.out.print("[" + sum + "]\t");
            }
            avgList.add(Double.parseDouble(new DecimalFormat("###.###").format(sum / 3)));
            System.out.print("Sum=" + sum + "\t");
            System.out.println("AVG=" + avgList.get(rowIndex));
        }

        return avgList;
    }

    //we get list of fuzzyFraction of (m-l) for each row
    private static List<Double> getLowerDiffEachRow(Triplet[][] cellMap) {
        List<Double> lowerDiff = new ArrayList<>();
        for (Triplet[] triplets : cellMap) {
            double sum = 0.0;
            for (Triplet triplet : triplets) {
                sum += (triplet.getLowerDiff());
                System.out.print("LowerDiff : [" + triplet.getLowerDiff() + "]\t");
                System.out.print("SUM: " + sum + "\t||\t");
            }
            lowerDiff.add(sum);
            System.out.println("");
        }

        return lowerDiff;
    }

    //we will get list of fuzzyFraction of (u-m) for each row
    private static List<Double> getUpperDiffEachRow(Triplet[][] cellMap) {
        List<Double> upperDiff = new ArrayList<>();
        for (Triplet[] triplets : cellMap) {
            double sum = 0.0;
            for (Triplet triplet : triplets) {
                sum += (triplet.getUpperDiff());
                System.out.print("UpperDiff : [" + triplet.getUpperDiff() + "]\t");
                System.out.print("SUM: " + sum + "\t||\t");
            }
            upperDiff.add(sum);
            System.out.println("");
        }
        return upperDiff;
    }

    //we will get FuzzyNumbersBasedOnFuzzyFaction
    //@lColumn get it from getLowerDiffEachRow function
    //@mColumn get it from getAverageFromEachRow function
    //@uColumn get it from getUpperDiffEachRow function
    private static List<Triplet> getFuzzyNumbersBasedOnFuzzyFaction(List<Double> lColumn, List<Double> mColumn, List<Double> uColumn) {
        List<Triplet> lmu = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < mColumn.size(); rowIndex++) {
            lmu.add(new Triplet(mColumn.get(rowIndex) - lColumn.get(rowIndex),
                    mColumn.get(rowIndex),
                    mColumn.get(rowIndex) + uColumn.get(rowIndex)));
            System.out.println("[" + lmu.get(rowIndex).getLower() + "," + lmu.get(rowIndex).getMiddle() + "," + lmu.get(rowIndex).getUpper() + "]\t");

        }
        return lmu;
    }

    //we will get the sum for l (lower),m(middle), u(upper)
    //then we will return (l, m, u ) as (1/total u , 1/total m , 1/total l)
    private static List<Triplet> getFuzzyNumbersInverse(List<Triplet> fNBasedOnFuzzy) {
        List<Triplet> list = new ArrayList<>();
        double lower = 0.0;
        double middle = 0.0;
        double upper = 0.0;
        for (Triplet triplet : fNBasedOnFuzzy) {
            lower += triplet.getLower();
            middle += triplet.getMiddle();
            upper += triplet.getUpper();
        }
        System.out.println("(1/total u , 1/total m , 1/total l)");
        for (int rowIndex = 0; rowIndex < fNBasedOnFuzzy.size(); rowIndex++) {
            list.add(new Triplet(1 / upper, 1 / middle, 1 / lower));
            System.out.println("[" + list.get(rowIndex).getLower() + "," + list.get(rowIndex).getMiddle() + "," + list.get(rowIndex).getUpper() + "]\t");
        }
        return list;
    }

    private static List<Triplet> getFuzzyCompositeExtension(List<Triplet> fNBasedOnFuzzy, List<Triplet> fNInverse) {
        List<Triplet> list = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < fNBasedOnFuzzy.size(); rowIndex++) {
            list.add(new Triplet((fNBasedOnFuzzy.get(rowIndex).getLower() * fNInverse.get(rowIndex).getLower()),
                    (fNBasedOnFuzzy.get(rowIndex).getMiddle() * fNInverse.get(rowIndex).getMiddle()),
                    (fNBasedOnFuzzy.get(rowIndex).getUpper() * fNInverse.get(rowIndex).getUpper())));
            System.out.println("[" + list.get(rowIndex).getLower() + "," + list.get(rowIndex).getMiddle() + "," + list.get(rowIndex).getUpper() + "]\t");
        }
        return list;
    }

    private static Double[][] getDegreeOfImportance(List<Triplet> fList) {
        int matrixSize = fList.size();
        Double[][] qaMatrix = new Double[matrixSize][matrixSize];
        //the outer loop is M2 & the inner loop is M1
        //rowIndex is for M2
        //innerRowIndex is for M1
        //the condition is:::
        //if m2 >= m1 return 1
        //else if l1 >= u2 return 0
        //else return (l1-u2)/((m2-u2)-(m1-l1))
        for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
            for (int innerRowIndex = 0; innerRowIndex < matrixSize; innerRowIndex++) {
                if (rowIndex == innerRowIndex)
                    continue;
                if (fList.get(rowIndex).getMiddle() >= fList.get(innerRowIndex).getMiddle()) {
                    qaMatrix[rowIndex][innerRowIndex] = 1.0;
                } else if (fList.get(innerRowIndex).getLower() >= fList.get(rowIndex).getUpper()) {
                    qaMatrix[rowIndex][innerRowIndex] = 0.0;
                } else {
                    double m2 = fList.get(rowIndex).getMiddle();
                    double m1 = fList.get(innerRowIndex).getMiddle();
                    double u2 = fList.get(rowIndex).getUpper();
                    double l1 = fList.get(innerRowIndex).getLower();
                    double result = ((l1 - u2) / ((m2 - u2) - (m1 - l1)));
                    qaMatrix[rowIndex][innerRowIndex] = Double.parseDouble(new DecimalFormat("###.###").format(result));
                }
            }
        }

        for (Double[] matrix : qaMatrix) {
            for (Double column : matrix) {
                System.out.print("[" + column + "]\t");
            }
            System.out.println("");
        }
        return qaMatrix;
    }

    private static double[] getMinimumWeight(Double[][] fList) {
        double[] result = new double[fList.length];
        for (int i = 0; i < fList.length; i++) {
            int initColumn = getStartingIndex(fList, i, 0);
            double min = fList[i][initColumn];
            for (int j = 1; j < fList[i].length; j++) {
                if (fList[i][j] != null) {
                    if (min >= fList[i][j]) {
                        min = fList[i][j];
                        result[i] = min;
                    }
                }
            }
            result[i] = Double.parseDouble(new DecimalFormat("###.###").format(min));
            System.out.println("[" + result[i] + "]");
        }
        return result;
    }

    private static double[] getWeightNormalization(double[] minimumWeights) {
        double[] result = new double[minimumWeights.length];
        double totalWeight = 0.0;
        for (double minimumWeight : minimumWeights) {
            totalWeight += minimumWeight;
        }

        if (totalWeight != 0)
            for (int i = 0; i < result.length; i++) {
                result[i] = Double.parseDouble(new DecimalFormat("###.###").format((minimumWeights[i] / totalWeight)));
                System.out.println("[" + result[i] + "]");
            }
        return result;
    }

    private static int getStartingIndex(Double[][] fList, int rowIndex, int initIndex) {
        if (rowIndex == 0)
            while (fList[rowIndex][initIndex] == null) {
                initIndex++;
            }
        return initIndex;
    }
}
