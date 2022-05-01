package com.archi.main.algorithms.data_model;

//comparison sub QA
//Ex: Usability, Learnability, Accessibility, 3.0
public class QualityAttributeSubPair {

    private final String mainQualityAttribute;
    private final String qualityAttributeA;
    private final String qualityAttributeB;
    private final double scale;

    public QualityAttributeSubPair(String mainQualityAttribute, String qualityAttributeA, String qualityAttributeB, double scale) {
        this.mainQualityAttribute = mainQualityAttribute;
        this.qualityAttributeA = qualityAttributeA;
        this.qualityAttributeB = qualityAttributeB;
        this.scale = (double) Math.round(scale * 1000) / 1000;
    }

    public String getMainQualityAttribute() {
        return mainQualityAttribute;
    }

    public String getQualityAttributeA() {
        return qualityAttributeA;
    }

    public String getQualityAttributeB() {
        return qualityAttributeB;
    }

    public double getScale() {
        return scale;
    }
}