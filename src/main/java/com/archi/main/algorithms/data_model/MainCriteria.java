package com.archi.main.algorithms.data_model;

import java.util.ArrayList;

public class MainCriteria {
    public String name;
    public int score;
    public ArrayList<SubCriteria> subCriteria;

    public MainCriteria(String name, int score, ArrayList<SubCriteria> subCriteria) {
        this.name = name;
        this.score = score;
        this.subCriteria = subCriteria;
    }
}
