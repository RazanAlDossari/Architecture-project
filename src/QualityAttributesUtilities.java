import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class QualityAttributesUtilities {

    static final String Usability = "Usability";
    static final String Maintainability = "Maintainability";
    static final String Cost = "Cost";
    static final String Scalability = "Scalability";

    //this will be our input
    public static List<QualityAttributePair> getQAPair() {
        List<QualityAttributePair> qaPair = new ArrayList<>();
        qaPair.add(new QualityAttributePair(Usability, Usability, 1.0));
        qaPair.add(new QualityAttributePair(Usability, Maintainability, 2.0));
        qaPair.add(new QualityAttributePair(Usability, Cost, 5.0));
        qaPair.add(new QualityAttributePair(Usability, Scalability, 3.0));

        qaPair.add(new QualityAttributePair(Maintainability, Maintainability, 1.0));
        qaPair.add(new QualityAttributePair(Maintainability, Cost, 3.0));
        qaPair.add(new QualityAttributePair(Maintainability, Scalability, 2.0));

        qaPair.add(new QualityAttributePair(Cost, Cost, 1.0));
        qaPair.add(new QualityAttributePair(Cost, Scalability, 1.0 / 3.0));
        qaPair.add(new QualityAttributePair(Scalability, Scalability, 1.0));
        return qaPair;
    }

    public static Triplet[][] getQAMatrix(List<QualityAttributePair> qaPair) {
        int distinctQASize = getNumberOfQualityAttributes(qaPair) ;
        Triplet[][] qaMatrix = new Triplet[distinctQASize][distinctQASize];
        int index = 0;
        for (int rowIndex = 0; rowIndex < distinctQASize; rowIndex++) {
            for (int colIndex = 0; colIndex < distinctQASize; colIndex++) {
                if (colIndex < rowIndex) {
                    qaMatrix[rowIndex][colIndex] = getTripletIInverseBasedOnScale(qaMatrix[colIndex][rowIndex].getMiddle());
                } else {
                    qaMatrix[rowIndex][colIndex] = getTripletBasedOnScale(qaPair.get(index).getScale());
                    index++;
                }
                System.out.print("[" + qaMatrix[rowIndex][colIndex].getLower() + "," + qaMatrix[rowIndex][colIndex].getMiddle() + "," + qaMatrix[rowIndex][colIndex].getUpper() + "]\t");
            }
            System.out.println();
        }
        return qaMatrix;
    }

    public static int getNumberOfQualityAttributes(final List<QualityAttributePair> qaPairs) {
        Set<String> areas = new HashSet<>();
        for(final QualityAttributePair qaPair: qaPairs) {
            areas.add(qaPair.getQualityAttributeA());
        }
        return areas.size();
    }

    private static Triplet getTripletBasedOnScale(double scale) {
        if (scale == 1.0) return new Triplet(1.0, 1.0, 1.0);
        else if (scale == 9.0)
            return new Triplet(9.0, 9.0, 9.0);
        if (scale > 1.0)
            return new Triplet(scale - 1, scale, scale + 1);
        else {
            double orgNumber = Double.parseDouble(new DecimalFormat("###.0").format(1.0 / scale));
            return new Triplet(1/(orgNumber +1), 1/orgNumber, 1/(orgNumber - 1));
        }
    }

    private static Triplet getTripletIInverseBasedOnScale(double scale) {
        if (scale == 1.0) return new Triplet(1.0, 1.0, 1.0);
        else if (scale == 9.0)
            return new Triplet(1.0 / 9.0, 1.0 / 9.0, 1.0 / 9.0);
        if (scale > 1.0)
            return new Triplet(1.0 / (scale + 1), 1.0 / scale, 1.0 / (scale - 1));
        else {
            double orgNumber = Double.parseDouble(new DecimalFormat("###.0").format(1.0 / scale));
            return new Triplet(orgNumber - 1, orgNumber, orgNumber + 1);
        }
    }
}