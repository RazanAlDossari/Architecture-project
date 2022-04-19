
public class QualityAttributePair {

    private final String QualityAttributeA;
    private final String QualityAttributeB;
    private final double scale;

    public QualityAttributePair(String qualityAttributeA, String qualityAttributeB, double scale) {
        QualityAttributeA = qualityAttributeA;
        QualityAttributeB = qualityAttributeB;
        this.scale = (double) Math.round(scale * 1000) / 1000;
    }

    public String getQualityAttributeA() {
        return QualityAttributeA;
    }

    public String getQualityAttributeB() {
        return QualityAttributeB;
    }

    public double getScale() {
        return scale;
    }
}