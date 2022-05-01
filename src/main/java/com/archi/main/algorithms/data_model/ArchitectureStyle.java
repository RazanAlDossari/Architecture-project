package com.archi.main.algorithms.data_model;

import java.util.ArrayList;

public class ArchitectureStyle {
    public ArchitectureStyle(String name, ArrayList<MainCriteria> mainCriteria) {
        this.name = name;
        this.mainCriteria = mainCriteria;
    }

    public String name;
    public ArrayList<MainCriteria> mainCriteria;
}
