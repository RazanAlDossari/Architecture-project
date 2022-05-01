package com.archi.main.algorithms.data_model;


//EX: Usability 0.5
public class MainQAWithSingleWeight {

    private final String mainQA;
    private final Pair<String, Double> qMainAWeight;

    public String getMainQA() {
        return mainQA;
    }

    public Pair<String, Double> getMainQAWeight() {
        return qMainAWeight;
    }

    public MainQAWithSingleWeight(String mainQA, Pair<String, Double> qMainAWeight) {
        this.mainQA = mainQA;
        this.qMainAWeight = qMainAWeight;
    }
}