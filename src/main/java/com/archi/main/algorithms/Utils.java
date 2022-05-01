package com.archi.main.algorithms;


import com.archi.main.algorithms.data_model.ArchitectureStyles;
import com.google.gson.Gson;

public class Utils {


    public static  void getDataForJson(){
        final  String jsonString = "{\"architectureStyle\":[{\"name\":\"Pipe and filter\",\"mainCriteria\":[{\"name\":\"Usability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Learnability\",\"score\":\"1\"},{\"name\":\"Operability\",\"score\":\"3\"}]},{\"name\":\"Reliability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Maturity\",\"score\":\"1\"},{\"name\":\"Fault-tolerance\",\"score\":\"3\"},{\"name\":\"Recoverability\",\"score\":\"3\"}]},{\"name\":\"Maintainability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Analyzability\",\"score\":\"1\"},{\"name\":\"Modifiability\",\"score\":\"3\"},{\"name\":\"Testability\",\"score\":\"3\"}]},{\"name\":\"Portability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Adaptability\",\"score\":\"1\"},{\"name\":\"Installability\",\"score\":\"3\"},{\"name\":\"Replaceability\",\"score\":\"3\"}]}]},{\"name\":\"mvc\",\"mainCriteria\":[{\"name\":\"Usability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Learnability\",\"score\":\"1\"},{\"name\":\"Operability\",\"score\":\"3\"}]},{\"name\":\"Reliability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Maturity\",\"score\":\"1\"},{\"name\":\"Fault-tolerance\",\"score\":\"3\"},{\"name\":\"Recoverability\",\"score\":\"3\"}]},{\"name\":\"Maintainability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Analyzability\",\"score\":\"1\"},{\"name\":\"Modifiability\",\"score\":\"3\"},{\"name\":\"Testability\",\"score\":\"3\"}]},{\"name\":\"Portability\",\"score\":\"1\",\"subCriteria\":[{\"name\":\"Adaptability\",\"score\":\"1\"},{\"name\":\"Installability\",\"score\":\"3\"},{\"name\":\"Replaceability\",\"score\":\"3\"}]}]}]}";
        Gson g = new Gson();
        ArchitectureStyles styles = g.fromJson(jsonString, ArchitectureStyles.class);
        System.out.println("test "+styles.architectureStyle.size());
    }
}

/*
*
 {
  "architectureStyle": [
    {
      "name": "Pipe and filter",
      "mainCriteria": [
        {
          "name": "Usability",
          "score": "1",
          "subCriteria": [
            {
              "name": "Learnability",
              "score": "1"
            },
            {
              "name": "Operability",
              "score": "3"
            }
          ]
        }, {
          "name": "Reliability",
          "score": "1",
          "subCriteria": [
            {
              "name": "Maturity",
              "score": "1"
            },
            {
              "name": "Fault-tolerance",
              "score": "3"
            },
            {
              "name": "Recoverability",
              "score": "3"
            }
          ]
        },
        {
          "name": "Maintainability",
          "score": "1",
          "subCriteria": [
            {
              "name": "Analyzability",
              "score": "1"
            },
            {
              "name": "Modifiability",
              "score": "3"
            },
            {
              "name": "Testability",
              "score": "3"
            }
          ]
        },
        {
          "name": "Portability",
          "score": "1",
          "subCriteria": [
            {
              "name": "Adaptability",
              "score": "1"
            },
            {
              "name": "Installability",
              "score": "3"
            },
            {
              "name": "Replaceability",
              "score": "3"
            }
          ]
        }
      ]
    }
  ]
}
* */
