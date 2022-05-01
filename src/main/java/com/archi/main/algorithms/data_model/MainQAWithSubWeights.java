package com.archi.main.algorithms.data_model;

import java.util.List;

//input: Usability [Learnability,Operability,Accessibility]
//EX: Usability [0.5,0.3,0.2]
public class MainQAWithSubWeights {

    private final String mainQA;


    // private final double[] subQAList;
    private final List<Pair<String, Double>> subQAList;

    public String getMainQA() {
        return mainQA;
    }

    public List<Pair<String, Double>> getSubQAList() {
        return subQAList;
    }

    public MainQAWithSubWeights(String mainQA, List<Pair<String, Double>> subQAList) {
        this.mainQA = mainQA;
        this.subQAList = subQAList;
    }
}