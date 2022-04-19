import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        List<QualityAttributePair> qaPair = QualityAttributesUtilities.getQAPair();
        //todo: need to multiply Weight Normalization with all archi matrix
        double[] weightedQA = FahpAlgorithm.runFahp(qaPair);
    }
}