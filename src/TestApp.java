import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        List<QualityAttributePair> qaPair = QualityAttributesUtilities.getQAPair();
        //todo: need to multiply Weight Normalization with all archi matrix
        double[] weightedQAForFAHP = FahpAlgorithm.runFahp(qaPair);

        double[][] matrix1 = {{1, 2, 3, 1.0 / 2.0}, {1.0 / 2.0, 1, 2, 1.0 / 3.0}, {1.0 / 3.0, 1.0 / 2.0, 1, 1.0 / 4.0}, {2, 3, 4, 1}};
        double[][] matrix2 = {{1, 2, 3, 1.0 / 2.0}, {1.0 / 2.0, 1, 2, 1.0 / 3.0}, {1.0 / 3.0, 1.0 / 2.0, 1, 1.0 / 4.0}, {2, 3, 4, 1}};

        double[] weightedQAForAHP = AhpAlgorithm.runAhp(matrix1, matrix2);
    }
}