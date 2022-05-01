package com.archi.main.algorithms;

import com.archi.main.algorithms.data_model.*;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import static com.archi.main.algorithms.StubData.setStylesRanks;

public final class QualityAttributesUtilities {


    public static Pair<String[], Triplet[][]> getQAMatrix(List<QualityAttributePair> qaPair) {
        String[] mainQA = getMainQualityAttributes(qaPair);
        int distinctQASize = mainQA.length;
        Triplet[][] qaMatrix = new Triplet[distinctQASize][distinctQASize];
        int index = 0;
        for (int rowIndex = 0; rowIndex < distinctQASize; rowIndex++) {
            for (int colIndex = 0; colIndex < distinctQASize; colIndex++) {
                if (colIndex < rowIndex) {
                    qaMatrix[rowIndex][colIndex] = getTripletIInverseBasedOnScale(qaMatrix[colIndex][rowIndex].getMiddle());
                } else {
                    qaMatrix[rowIndex][colIndex] = getTripletBasedOnScale(qaPair.get(index).getScale());
                    index++;
                }
                System.out.print("[" + qaMatrix[rowIndex][colIndex].getLower() + "," + qaMatrix[rowIndex][colIndex].getMiddle() + "," + qaMatrix[rowIndex][colIndex].getUpper() + "]\t");
            }
            System.out.println();
        }
        return new Pair<>(mainQA, qaMatrix);
    }

    public static String[] getMainQualityAttributes(final List<QualityAttributePair> qaPairs) {
        Set<String> areas = new LinkedHashSet<>();
        for (final QualityAttributePair qaPair : qaPairs) {
            areas.add(qaPair.getQualityAttributeA());
        }
        String[] myArray = new String[areas.size()];
        areas.toArray(myArray);
        return myArray;
    }

    private static Triplet getTripletBasedOnScale(double scale) {
        if (scale == 1.0) return new Triplet(1.0, 1.0, 1.0);
        else if (scale == 9.0)
            return new Triplet(9.0, 9.0, 9.0);
        if (scale > 1.0)
            return new Triplet(scale - 1, scale, scale + 1);
        else {
            double orgNumber = Double.parseDouble(new DecimalFormat("###.0").format(1.0 / scale));
            return new Triplet(1 / (orgNumber + 1), 1 / orgNumber, 1 / (orgNumber - 1));
        }
    }

    private static Triplet getTripletIInverseBasedOnScale(double scale) {
        if (scale == 1.0) return new Triplet(1.0, 1.0, 1.0);
        else if (scale == 9.0)
            return new Triplet(1.0 / 9.0, 1.0 / 9.0, 1.0 / 9.0);
        if (scale > 1.0)
            return new Triplet(1.0 / (scale + 1), 1.0 / scale, 1.0 / (scale - 1));
        else {
            double orgNumber = Double.parseDouble(new DecimalFormat("###.0").format(1.0 / scale));
            return new Triplet(orgNumber - 1, orgNumber, orgNumber + 1);
        }
    }

    public static LinkedHashMap<String, List<QualityAttributePair>> covertToMapper(List<QualityAttributeSubPair> qaPairs) {
        LinkedHashMap<String, List<QualityAttributePair>> qaPairsByMainQa = new LinkedHashMap<>();
        for (QualityAttributeSubPair qaPair : qaPairs) {
            List<QualityAttributePair> users = qaPairsByMainQa.computeIfAbsent(qaPair.getMainQualityAttribute(), k -> new ArrayList<>());
            users.add(new QualityAttributePair(qaPair.getQualityAttributeA(), qaPair.getQualityAttributeB(), qaPair.getScale()));
        }
        return qaPairsByMainQa;
    }

    public static List<Pair<String, Double>> calculateScore(List<MainQAWithSubWeights> finalWeightForEachSubQA) {
        ArrayList<ArchitectureStyle> styles = setStylesRanks();
        List<Pair<String, Double>> archiResult = new ArrayList<>();
        for (ArchitectureStyle style : styles) {
            ArrayList<MainCriteria> selectedStyleMainAttributes = style.mainCriteria;
            double total = 0;

            for (MainCriteria selectedStyleMainAttribute : selectedStyleMainAttributes) {
                //todo: get main Attribute and subList to multiply it with the score
                String selectedMainName = selectedStyleMainAttribute.name;

                ArrayList<SubCriteria> selectedSubList = selectedStyleMainAttribute.subCriteria;

                List<MainQAWithSubWeights> result = finalWeightForEachSubQA.stream()
                        .filter(item -> item.getMainQA().equals(selectedMainName)).toList();

                List<Pair<String, Double>> subAttribute = result.get(0).getSubQAList();
                //todo: loop to each subCriteria of the style
                for (SubCriteria currentSub : selectedSubList) {
                    List<Pair<String, Double>> resultSub = subAttribute.stream()
                            .filter(item ->
                                    item.getFirst().equals(currentSub.name)
                            ).toList();
                    if (resultSub.size() != 0)
                        total += currentSub.score * resultSub.get(0).getSecond();
                }
            }
            archiResult.add(new Pair<>(style.name, total));
        }
        Comparator<Pair<String, Double>> comparator = Comparator.comparing(Pair::getSecond);

        return archiResult.stream().sorted(comparator.reversed()).
                collect(Collectors.toList());
    }
}