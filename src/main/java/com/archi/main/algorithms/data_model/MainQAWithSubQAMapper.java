package com.archi.main.algorithms.data_model;

import java.util.List;
//EX: Usability [Learnability,Operability,Accessibility]
public class MainQAWithSubQAMapper {

    private final String mainQA;
    private final List<QualityAttributePair> subQAList;

    public MainQAWithSubQAMapper(String mainQA, List<QualityAttributePair> subQAList) {
        this.mainQA = mainQA;
        this.subQAList = subQAList;
    }

    public String getMainQA() {
        return mainQA;
    }

    public List<QualityAttributePair> getSubQAList() {
        return subQAList;
    }

}