package com.archi.main.algorithms;

import com.archi.main.algorithms.data_model.*;

import java.util.ArrayList;
import java.util.List;

public class StubData {

    static final String Usability = "Usability";
    static final String Maintainability = "Maintainability";
    static final String Cost = "Cost";
    static final String Scalability = "Scalability";
    //Usability
    static final String Learnability = "Learnability";
    static final String Accessibility = "Accessibility";
    static final String Operability = "Operability";

    static final String PF = "Pipe and filter";
    static final String MVC = "MVC";

    //Maintainability
    static final String a123 = "a123";
    static final String b124 = "b124";
    static final String c123 = "c123";

    static final String xxxx = "xxxx";
    static final String yyyy = "yyyy";

    static final String x123 = "x123";
    static final String y123 = "y123";

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

    public static List<QualityAttributeSubPair> getQASubPair() {
        List<QualityAttributeSubPair> qaPair = new ArrayList<>();

        qaPair.add(new QualityAttributeSubPair(Usability, Learnability, Learnability, 1.0));
        qaPair.add(new QualityAttributeSubPair(Usability, Learnability, Accessibility, 3.0));
        qaPair.add(new QualityAttributeSubPair(Usability, Learnability, Operability, 2.0));

        qaPair.add(new QualityAttributeSubPair(Usability, Accessibility, Accessibility, 1.0));
        qaPair.add(new QualityAttributeSubPair(Usability, Accessibility, Operability, 1.0 / 3.0));

        qaPair.add(new QualityAttributeSubPair(Usability, Operability, Operability, 1.0));


        qaPair.add(new QualityAttributeSubPair(Maintainability, a123, a123, 1.0));
        qaPair.add(new QualityAttributeSubPair(Maintainability, a123, b124, 3.0));
        qaPair.add(new QualityAttributeSubPair(Maintainability, a123, c123, 2.0));

        qaPair.add(new QualityAttributeSubPair(Maintainability, b124, b124, 1.0));
        qaPair.add(new QualityAttributeSubPair(Maintainability, b124, c123, 1.0 / 3.0));

        qaPair.add(new QualityAttributeSubPair(Maintainability, c123, c123, 1.0));


        qaPair.add(new QualityAttributeSubPair(Scalability, xxxx, xxxx, 1.0));
        qaPair.add(new QualityAttributeSubPair(Scalability, xxxx, yyyy, 1.0 / 3.0));

        qaPair.add(new QualityAttributeSubPair(Scalability, yyyy, yyyy, 1.0));


        qaPair.add(new QualityAttributeSubPair(Cost, x123, x123, 1.0));
        qaPair.add(new QualityAttributeSubPair(Cost, x123, y123, 1.0 / 3.0));

        qaPair.add(new QualityAttributeSubPair(Cost, y123, y123, 1.0));


        return qaPair;

    }

    private static List<Triplet> getQAList() {
        //sheet3
        List<Triplet> list = new ArrayList<>();
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(1.0, 2.0, 3.0));
        list.add(new Triplet(2.0, 3.0, 4.0));
        list.add(new Triplet(0.33, 0.50, 1.00));
        ////
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(1.00, 2.00, 3.00));
        list.add(new Triplet(0.25, 0.33, 0.50));
        ////
        list.add(new Triplet(0.25, 0.33, 0.50));
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(0.20, 0.25, 0.33));
        ////
        list.add(new Triplet(1.00, 2.00, 3.00));
        list.add(new Triplet(2.00, 3.00, 4.00));
        list.add(new Triplet(3.00, 4.00, 5.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        return list;
    }

    private static Triplet[][] getInputData() {
        List<Triplet> list = getQAList1();

        int rootList = (int) Math.sqrt(list.size());
        Triplet[][] qaMatrix = new Triplet[rootList][rootList];

        for (int rowIndex = 0; rowIndex < qaMatrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < qaMatrix[rowIndex].length; colIndex++) {
                qaMatrix[rowIndex][colIndex] = list.get((rowIndex * qaMatrix.length) + colIndex);///new Triplet(1.0, 2.0, 3.0); //do constructor-y stuff here
                System.out.print("[" + qaMatrix[rowIndex][colIndex].getLower() + "," + qaMatrix[rowIndex][colIndex].getMiddle() + "," + qaMatrix[rowIndex][colIndex].getUpper() + "]\t");
            }
            System.out.println();
        }
        return qaMatrix;
    }

    private static List<Triplet> getQAList1() {
        //sheet2
        List<Triplet> list = new ArrayList<>();
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(1.0, 2.0, 3.0));
        list.add(new Triplet(4.00, 5.00, 6.00));
        list.add(new Triplet(2.00, 3.00, 4.00));
        ////
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(2.00, 3.00, 4.00));
        list.add(new Triplet(1.00, 2.00, 3.00));
        ////
        list.add(new Triplet(0.17, 0.20, 0.25));
        list.add(new Triplet(0.25, 0.33, 0.50));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(0.25, 0.33, 0.50));
        ////
        list.add(new Triplet(0.25, 0.33, 0.50));
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(2.00, 3.00, 4.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        return list;
    }

    public static ArrayList<ArchitectureStyle> setStylesRanks() {
        ArrayList<ArchitectureStyle> ArchitectureStylesList = new ArrayList<>();

        ArchitectureStylesList.add(new ArchitectureStyle(MVC, getMVCArchi()));
        ArchitectureStylesList.add(new ArchitectureStyle(PF, getPFArchi()));

        return ArchitectureStylesList;
    }

    private static ArrayList<MainCriteria> getMVCArchi() {
        ArrayList<SubCriteria> usabilitySubCriteria = new ArrayList<>();
        usabilitySubCriteria.add(new SubCriteria(Learnability, 1));
        usabilitySubCriteria.add(new SubCriteria(Accessibility, 0));
        usabilitySubCriteria.add(new SubCriteria(Operability, 2));

        ArrayList<SubCriteria> maintainabilitySubCriteria = new ArrayList<>();
        maintainabilitySubCriteria.add(new SubCriteria(a123, 2));
        maintainabilitySubCriteria.add(new SubCriteria(b124, 2));
        maintainabilitySubCriteria.add(new SubCriteria(c123, 0));

        ArrayList<SubCriteria> costSubCriteria = new ArrayList<>();
        costSubCriteria.add(new SubCriteria(xxxx, 2));
        costSubCriteria.add(new SubCriteria(yyyy, -1));

        ArrayList<SubCriteria> scalabilitySubCriteria = new ArrayList<>();
        scalabilitySubCriteria.add(new SubCriteria(x123, -2));
        scalabilitySubCriteria.add(new SubCriteria(y123, -1));

        ArrayList<MainCriteria> mainCriteria = new ArrayList<>();

        mainCriteria.add(new MainCriteria(Usability, 1, usabilitySubCriteria));
        mainCriteria.add(new MainCriteria(Maintainability, 1, maintainabilitySubCriteria));
        mainCriteria.add(new MainCriteria(Cost, 0, costSubCriteria));
        mainCriteria.add(new MainCriteria(Scalability, -2, scalabilitySubCriteria));
        return mainCriteria;
    }

    private static ArrayList<MainCriteria> getPFArchi() {
        ArrayList<SubCriteria> usabilitySubCriteria = new ArrayList<>();
        usabilitySubCriteria.add(new SubCriteria(Learnability, 1));
        usabilitySubCriteria.add(new SubCriteria(Accessibility, 1));
        usabilitySubCriteria.add(new SubCriteria(Operability, 2));

        ArrayList<SubCriteria> maintainabilitySubCriteria = new ArrayList<>();
        maintainabilitySubCriteria.add(new SubCriteria(a123, 1));
        maintainabilitySubCriteria.add(new SubCriteria(b124, 1));
        maintainabilitySubCriteria.add(new SubCriteria(c123, 1));

        ArrayList<SubCriteria> scalabilitySubCriteria = new ArrayList<>();
        scalabilitySubCriteria.add(new SubCriteria(xxxx, 2));
        scalabilitySubCriteria.add(new SubCriteria(yyyy, 1));

        ArrayList<SubCriteria> costSubCriteria = new ArrayList<>();
        costSubCriteria.add(new SubCriteria(x123, 2));
        costSubCriteria.add(new SubCriteria(y123, 1));


        ArrayList<MainCriteria> mainCriteria = new ArrayList<>();

        mainCriteria.add(new MainCriteria(Usability, -2, usabilitySubCriteria));
        mainCriteria.add(new MainCriteria(Maintainability, 1, maintainabilitySubCriteria));
        mainCriteria.add(new MainCriteria(Cost, 0, costSubCriteria));
        mainCriteria.add(new MainCriteria(Scalability, 1, scalabilitySubCriteria));
        return mainCriteria;
    }
}