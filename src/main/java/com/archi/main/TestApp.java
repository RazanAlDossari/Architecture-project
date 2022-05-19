package com.archi.main;

import com.archi.main.algorithms.*;
import com.archi.main.algorithms.data_model.*;
import java.util.*;
import static com.archi.main.algorithms.QualityAttributesUtilities.calculateScore;
import static com.archi.main.algorithms.StubData.getInputNFRs;
import static com.archi.main.algorithms.StubData.getQAPair;
import static com.archi.main.algorithms.Utils.getDataForJson;

public class TestApp {
    public static void main(String[] args) {
        //main QAPair
        getDataForJson();

        List<QualityAttributePair> qaPair = getInputNFRs();///getQAPair();
        //list of main QA with their weight
        List<MainQAWithSingleWeight> mainQAWithSingleWeight = FahpAlgorithm.runMainFahp(qaPair);

        for (int i = 0; i < mainQAWithSingleWeight.size(); i++) {
            System.out.println(i + 1 + ") " + mainQAWithSingleWeight.get(i).getMainQA() + "= " + mainQAWithSingleWeight.get(i).getMainQAWeight().getSecond());
        }

        List<Pair<String, Double>> finalSortedResult = calculateScore(mainQAWithSingleWeight);
        //subQA-FAHP
        //main QA with list of sub QA
        System.out.println("############################ getWeightOfSubQA ############################");
       /// List<MainQAWithSubQAMapper> qaMapper = getWeightOfSubQA(StubData.getQASubPair());

        //WE GROUPED IT With the main.. so it will be mainQA with list of (weightOFEachSub*weightOfMain)
        //todo: now we have the weight of all subQA grouped by the main one
        //List<MainQAWithSubWeights> finalWeightForEachSubQA = FahpAlgorithm.runAllSubQAForAllMainQA(mainQAWithSingleWeight, qaMapper);
        System.out.println();
        System.out.println("±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±");
      // List<Pair<String, Double>> finalSortedResult = calculateScore(finalWeightForEachSubQA);

        for (int i = 0; i < finalSortedResult.size(); i++) {
            System.out.println(i + 1 + ") " + finalSortedResult.get(i).getFirst() + "= " + finalSortedResult.get(i).getSecond());
        }

//        double[][] matrix1 = {{1, 2, 3, 1.0 / 2.0}, {1.0 / 2.0, 1, 2, 1.0 / 3.0}, {1.0 / 3.0, 1.0 / 2.0, 1, 1.0 / 4.0}, {2, 3, 4, 1}};
//        double[][] matrix2 = {{1, 2, 3, 1.0 / 2.0}, {1.0 / 2.0, 1, 2, 1.0 / 3.0}, {1.0 / 3.0, 1.0 / 2.0, 1, 1.0 / 4.0}, {2, 3, 4, 1}};
//
//        double[] weightedQAForAHP = AhpAlgorithm.runAhp(matrix1, matrix2);

        //todo: need to multiply Weight Normalization with all archi matrix
    }

//    private static List<MainQAWithSubQAMapper> getWeightOfSubQA(List<QualityAttributeSubPair> qaSubPair) {
//        List<MainQAWithSubQAMapper> qaMapper = new ArrayList<>();
//        LinkedHashMap<String, List<QualityAttributePair>> qaSubPairMapper = QualityAttributesUtilities.covertToMapper(qaSubPair);
//        for (String key : qaSubPairMapper.keySet()) {
//            List<QualityAttributePair> objValue = new ArrayList<>();
//            String mainQA = key;
//            for (QualityAttributePair entry : qaSubPairMapper.get(key)) {
//                objValue.add(entry);
//            }
//            qaMapper.add(new MainQAWithSubQAMapper(mainQA, objValue));
//        }
//        return qaMapper;
//    }
}