package com.archi.main.algorithms;

import com.archi.main.algorithms.data_model.*;

import java.util.ArrayList;
import java.util.List;

import static com.archi.main.algorithms.QualityAttributesUtilities.getCalculation;

public class StubData {
    public static List<QualityAttributePair> getInputNFRs(List<Pair<String, Integer>> numOfCountsOfQAs) {
        //todo: we need to assign the scale of each QA and SUB-QA
//        List<Pair<String, Integer>> numOfCountsOfQAs = new ArrayList<>();
//       // P8= (5,2,17,4,15,10,0)
//        numOfCountsOfQAs.add(new Pair<>("Usability", 5));
//        numOfCountsOfQAs.add(new Pair<>("Maintainability", 2));
//        numOfCountsOfQAs.add(new Pair<>("Reliability", 17));
//        numOfCountsOfQAs.add(new Pair<>("Portability", 4));
//        numOfCountsOfQAs.add(new Pair<>("Supportability", 15));
//        numOfCountsOfQAs.add(new Pair<>("Availability", 10));
//        numOfCountsOfQAs.add(new Pair<>("Security", 0));

        // Total core for project 8, TCQA=6
        int coreQAs = (int) numOfCountsOfQAs.stream().filter(item -> item.getSecond() != 0).count();

        List<Pair<String, Integer>> scaleQAs = new ArrayList<>();
        for (Pair<String, Integer> qa : numOfCountsOfQAs) {
            if(qa.getSecond()!=0)
            scaleQAs.add(new Pair<>(qa.getFirst(), getCalculation(qa.getSecond(), coreQAs)));
        }

        List<QualityAttributePair> qaPair = new ArrayList<>();
        for (int i = 0; i < scaleQAs.size(); i++) {
            for (int j = i; j < scaleQAs.size(); j++) {
                System.out.println("A: "+
                        scaleQAs.get(i).getSecond()+"   B:"+ scaleQAs.get(j).getSecond());
                double diff = (scaleQAs.get(i).getSecond() - scaleQAs.get(j).getSecond()) + 1;
                if (diff < 1) {
                    diff = 1.0 / (double)(scaleQAs.get(j).getSecond() - scaleQAs.get(i).getSecond() + 1);
                    System.out.println(1.0+"/"+(double)(scaleQAs.get(j).getSecond() - scaleQAs.get(i).getSecond() + 1));
                }
                QualityAttributePair test = new QualityAttributePair(scaleQAs.get(i).getFirst(), scaleQAs.get(j).getFirst(), diff);
                qaPair.add(test);
                System.out.println("pair comparison: " + test.getQualityAttributeA() + "||" + test.getQualityAttributeB() + "||" + test.getScale());
                System.out.println();
            }
        }


        //for testing  systematic paper
//        List<QualityAttributePair> qaPair = new ArrayList<>();
//        qaPair.add(new QualityAttributePair(Usability_QA, Usability_QA, 1));
//        qaPair.add(new QualityAttributePair(Usability_QA, Maintainability_QA, 2));
//        qaPair.add(new QualityAttributePair(Usability_QA, Cost_QA, 5));
//        qaPair.add(new QualityAttributePair(Usability_QA, Scalability_QA, 3));
//
//
//        qaPair.add(new QualityAttributePair(Maintainability_QA, Maintainability_QA, 1));
//        qaPair.add(new QualityAttributePair(Maintainability_QA, Cost_QA, 3));
//        qaPair.add(new QualityAttributePair(Maintainability_QA, Scalability_QA, 2));
//
//
//        qaPair.add(new QualityAttributePair(Cost_QA, Cost_QA, 1));
//        qaPair.add(new QualityAttributePair(Cost_QA, Scalability_QA, (double) 1.0 / 3.0));
//
//
//        qaPair.add(new QualityAttributePair(Scalability_QA, Scalability_QA, 1))
        return qaPair;
    }
}