package com.archi.main.algorithms;


import com.archi.main.algorithms.data_model.ArchitectureStyle;
import com.archi.main.algorithms.data_model.ArchitectureStyles;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Utils_Data {
}
//
//    private static List<Triplet> getQAList() {
//        //sheet3
//        List<Triplet> list = new ArrayList<>();
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        list.add(new Triplet(1.0, 2.0, 3.0));
//        list.add(new Triplet(2.0, 3.0, 4.0));
//        list.add(new Triplet(0.33, 0.50, 1.00));
//        ////
//        list.add(new Triplet(0.33, 0.50, 1.00));
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        list.add(new Triplet(1.00, 2.00, 3.00));
//        list.add(new Triplet(0.25, 0.33, 0.50));
//        ////
//        list.add(new Triplet(0.25, 0.33, 0.50));
//        list.add(new Triplet(0.33, 0.50, 1.00));
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        list.add(new Triplet(0.20, 0.25, 0.33));
//        ////
//        list.add(new Triplet(1.00, 2.00, 3.00));
//        list.add(new Triplet(2.00, 3.00, 4.00));
//        list.add(new Triplet(3.00, 4.00, 5.00));
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        return list;
//    }
//
//    private static Triplet[][] getInputData() {
//        List<Triplet> list = getQAList1();
//
//        int rootList = (int) Math.sqrt(list.size());
//        Triplet[][] qaMatrix = new Triplet[rootList][rootList];
//
//        for (int rowIndex = 0; rowIndex < qaMatrix.length; rowIndex++) {
//            for (int colIndex = 0; colIndex < qaMatrix[rowIndex].length; colIndex++) {
//                qaMatrix[rowIndex][colIndex] = list.get((rowIndex * qaMatrix.length) + colIndex);///new Triplet(1.0, 2.0, 3.0); //do constructor-y stuff here
//                System.out.print("[" + qaMatrix[rowIndex][colIndex].getLower() + "," + qaMatrix[rowIndex][colIndex].getMiddle() + "," + qaMatrix[rowIndex][colIndex].getUpper() + "]\t");
//            }
//            System.out.println();
//        }
//        return qaMatrix;
//    }
//
//    private static List<Triplet> getQAList1() {
//        //sheet2
//        List<Triplet> list = new ArrayList<>();
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        list.add(new Triplet(1.0, 2.0, 3.0));
//        list.add(new Triplet(4.00, 5.00, 6.00));
//        list.add(new Triplet(2.00, 3.00, 4.00));
//        ////
//        list.add(new Triplet(0.33, 0.50, 1.00));
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        list.add(new Triplet(2.00, 3.00, 4.00));
//        list.add(new Triplet(1.00, 2.00, 3.00));
//        ////
//        list.add(new Triplet(0.17, 0.20, 0.25));
//        list.add(new Triplet(0.25, 0.33, 0.50));
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        list.add(new Triplet(0.25, 0.33, 0.50));
//        ////
//        list.add(new Triplet(0.25, 0.33, 0.50));
//        list.add(new Triplet(0.33, 0.50, 1.00));
//        list.add(new Triplet(2.00, 3.00, 4.00));
//        list.add(new Triplet(1.0, 1.0, 1.0));
//        return list;
//    }
//}

    //    public static List<Pair<String, Double>> calculateScoreOfSubQAs(List<MainQAWithSubWeights> finalWeightForEachSubQA) {
//        ArrayList<ArchitectureStyle> styles = setStylesRanks();
//        List<Pair<String, Double>> archiResult = new ArrayList<>();
//        for (ArchitectureStyle style : styles) {
//            ArrayList<MainCriteria> selectedStyleMainAttributes = style.mainCriteria;
//            double total = 0;
//
//            for (MainCriteria selectedStyleMainAttribute : selectedStyleMainAttributes) {
//                //todo: get main Attribute and subList to multiply it with the score
//                String selectedMainName = selectedStyleMainAttribute.name;
//
//                ArrayList<SubCriteria> selectedSubList = selectedStyleMainAttribute.subCriteria;
//
//                List<MainQAWithSubWeights> result = finalWeightForEachSubQA.stream()
//                        .filter(item -> item.getMainQA().equals(selectedMainName)).toList();
//
//                List<Pair<String, Double>> subAttribute = result.get(0).getSubQAList();
//                //todo: loop to each subCriteria of the style
//                for (SubCriteria currentSub : selectedSubList) {
//                    List<Pair<String, Double>> resultSub = subAttribute.stream()
//                            .filter(item ->
//                                    item.getFirst().equals(currentSub.name)
//                            ).toList();
//                    if (resultSub.size() != 0)
//                        total += currentSub.score * resultSub.get(0).getSecond();
//                }
//            }
//            archiResult.add(new Pair<>(style.name, total));
//        }
//        Comparator<Pair<String, Double>> comparator = Comparator.comparing(Pair::getSecond);
//
//        return archiResult.stream().sorted(comparator.reversed()).
//                collect(Collectors.toList());
//    }
//    private static ArrayList<MainCriteria> getMVCArchi() {
//        ArrayList<SubCriteria> usabilitySubCriteria = new ArrayList<>();
//        usabilitySubCriteria.add(new SubCriteria(Learnability, 1));
//        usabilitySubCriteria.add(new SubCriteria(Accessibility, 0));
//        usabilitySubCriteria.add(new SubCriteria(Operability, 2));
//
//        ArrayList<SubCriteria> maintainabilitySubCriteria = new ArrayList<>();
//        maintainabilitySubCriteria.add(new SubCriteria(a123, 2));
//        maintainabilitySubCriteria.add(new SubCriteria(b124, 2));
//        maintainabilitySubCriteria.add(new SubCriteria(c123, 0));
//
//        ArrayList<SubCriteria> costSubCriteria = new ArrayList<>();
//        costSubCriteria.add(new SubCriteria(xxxx, 2));
//        costSubCriteria.add(new SubCriteria(yyyy, -1));
//
//        ArrayList<SubCriteria> scalabilitySubCriteria = new ArrayList<>();
//        scalabilitySubCriteria.add(new SubCriteria(x123, -2));
//        scalabilitySubCriteria.add(new SubCriteria(y123, -1));
//
//        ArrayList<MainCriteria> mainCriteria = new ArrayList<>();
//
//        mainCriteria.add(new MainCriteria(Usability, 1, usabilitySubCriteria));
//        mainCriteria.add(new MainCriteria(Maintainability, 1, maintainabilitySubCriteria));
//        mainCriteria.add(new MainCriteria(Cost, 0, costSubCriteria));
//        mainCriteria.add(new MainCriteria(Scalability, -2, scalabilitySubCriteria));
//        return mainCriteria;
//    }
//
//    private static ArrayList<MainCriteria> getPFArchi() {
//        ArrayList<SubCriteria> usabilitySubCriteria = new ArrayList<>();
//        usabilitySubCriteria.add(new SubCriteria(Learnability, 1));
//        usabilitySubCriteria.add(new SubCriteria(Accessibility, 1));
//        usabilitySubCriteria.add(new SubCriteria(Operability, 2));
//
//        ArrayList<SubCriteria> maintainabilitySubCriteria = new ArrayList<>();
//        maintainabilitySubCriteria.add(new SubCriteria(a123, 1));
//        maintainabilitySubCriteria.add(new SubCriteria(b124, 1));
//        maintainabilitySubCriteria.add(new SubCriteria(c123, 1));
//
//        ArrayList<SubCriteria> scalabilitySubCriteria = new ArrayList<>();
//        scalabilitySubCriteria.add(new SubCriteria(xxxx, 2));
//        scalabilitySubCriteria.add(new SubCriteria(yyyy, 1));
//
//        ArrayList<SubCriteria> costSubCriteria = new ArrayList<>();
//        costSubCriteria.add(new SubCriteria(x123, 2));
//        costSubCriteria.add(new SubCriteria(y123, 1));
//
//
//        ArrayList<MainCriteria> mainCriteria = new ArrayList<>();
//
//        mainCriteria.add(new MainCriteria(Usability, -2, usabilitySubCriteria));
//        mainCriteria.add(new MainCriteria(Maintainability, 1, maintainabilitySubCriteria));
//        mainCriteria.add(new MainCriteria(Cost, 0, costSubCriteria));
//        mainCriteria.add(new MainCriteria(Scalability, 1, scalabilitySubCriteria));
//        return mainCriteria;
//    }
//    public static ArrayList<ArchitectureStyle> setStylesRanks() {
//        ArrayList<ArchitectureStyle> ArchitectureStylesList = new ArrayList<>();
//
//        ArchitectureStylesList.add(new ArchitectureStyle(MVC, getMVCArchi()));
//        ArchitectureStylesList.add(new ArchitectureStyle(PF, getPFArchi()));
//
//        return ArchitectureStylesList;
//    }