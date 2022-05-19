package com.archi.main.algorithms;

import com.archi.main.algorithms.data_model.*;

import java.util.ArrayList;
import java.util.List;

import static com.archi.main.algorithms.QualityAttributesUtilities.getCalculation;

public class StubData {

    static final String Usability = "Usability";
    static final String Maintainability = "Maintainability";
    static final String Scalability = "Scalability";
    static final String Performance = "Performance";
    static final String Availability = "Availability";
    static final String Security = "Security";
    static final String Reliability = "Reliability";

    static final String PF = "Pipe and filter";
    static final String MVC = "MVC";


    public static List<QualityAttributePair> getInputNFRs() {
        //todo: we need to assign the scale of each QA and SUB-QA
        List<Pair<String, Integer>> numOfCountsOfQAs = new ArrayList<>();
        //P8= (5,2,17,4,15,10,0)
        numOfCountsOfQAs.add(new Pair<>(Usability, 5));
        numOfCountsOfQAs.add(new Pair<>(Maintainability, 2));
        numOfCountsOfQAs.add(new Pair<>(Reliability, 17));
        numOfCountsOfQAs.add(new Pair<>(Scalability, 4));
        numOfCountsOfQAs.add(new Pair<>(Performance, 15));
        numOfCountsOfQAs.add(new Pair<>(Availability, 10));
        numOfCountsOfQAs.add(new Pair<>(Security, 0));
        // Total core for project 8, TCQA=6
        int coreQAs = (int) numOfCountsOfQAs.stream().filter(item -> item.getSecond() != 0).count();

        List<Pair<String, Double>> scaleQAs = new ArrayList<>();
        for (int i = 0; i < numOfCountsOfQAs.size(); i++) {
            Pair<String, Integer> qa = numOfCountsOfQAs.get(i);
            scaleQAs.add(new Pair<>(qa.getFirst(), getCalculation(qa.getSecond(), coreQAs)));
        }

        List<QualityAttributePair> qaPair = new ArrayList<>();
        for (int i = 0; i < scaleQAs.size(); i++) {
            for (int j = i; j < scaleQAs.size(); j++) {
                double diff = (scaleQAs.get(i).getSecond() - scaleQAs.get(j).getSecond()) + 1;
                if (diff < 1) {
                    diff = 1 / (scaleQAs.get(j).getSecond() - scaleQAs.get(i).getSecond() + 1);
                }
                QualityAttributePair test = new QualityAttributePair(scaleQAs.get(i).getFirst(), scaleQAs.get(j).getFirst(), diff);
                qaPair.add(test);
                System.out.println("pair comparison: " + test.getQualityAttributeA() + "||" + test.getQualityAttributeB() + "||" + test.getScale());
            }
        }
        return qaPair;
    }
}