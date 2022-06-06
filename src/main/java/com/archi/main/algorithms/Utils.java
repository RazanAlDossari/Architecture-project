package com.archi.main.algorithms;

import com.archi.main.algorithms.data_model.ArchitectureStyle;
import com.archi.main.algorithms.data_model.ArchitectureStyles;
import com.google.gson.Gson;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<ArchitectureStyle> getArchitectureStyles() {
        final String jsonString = "{\n" +
                "  \"architectureStyle\": [\n" +
                "    {\n" +
                "      \"name\": \"Pipe and filter\",\n" +
                "      \"mainCriteria\": [\n" +
                "        {\n" +
                "          \"name\": \"Usability\",\n" +
                "          \"score\": \"-2\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Portability\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Maintainability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Scalability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Performance\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Availability\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Security\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Cost\",\n" +
                "          \"score\": \"0\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"mvc\",\n" +
                "      \"mainCriteria\": [\n" +
                "        {\n" +
                "          \"name\": \"Usability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Portability\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Maintainability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Scalability\",\n" +
                "          \"score\": \"-2\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Performance\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Availability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Security\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Cost\",\n" +
                "          \"score\": \"0\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"soa\",\n" +
                "      \"mainCriteria\": [\n" +
                "        {\n" +
                "          \"name\": \"Usability\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Portability\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Maintainability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Scalability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Performance\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Availability\",\n" +
                "          \"score\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Security\",\n" +
                "          \"score\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Cost\",\n" +
                "          \"score\": \"1\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Gson g = new Gson();
        ArchitectureStyles styles = g.fromJson(jsonString, ArchitectureStyles.class);
        System.out.println("test " + styles.architectureStyle.size());
        return styles.architectureStyle;

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
          "score": "-2"
        },
        {
          "name": "Portability",
          "score": "0"
        },
        {
          "name": "Maintainability",
          "score": "1"
        },
        {
          "name": "Scalability",
          "score": "1"
        },
        {
          "name": "Performance",
          "score": "0"
        },
        {
          "name": "Availability",
          "score": "0"
        },
        {
          "name": "Security",
          "score": "0"
        },
        {
          "name": "Cost",
          "score": "0"
        }
      ]
    },
    {
      "name": "mvc",
      "mainCriteria": [
        {
          "name": "Usability",
          "score": "1"
        },
        {
          "name": "Portability",
          "score": "0"
        },
        {
          "name": "Maintainability",
          "score": "1"
        },
        {
          "name": "Scalability",
          "score": "-2"
        },
        {
          "name": "Performance",
          "score": "0"
        },
        {
          "name": "Availability",
          "score": "1"
        },
        {
          "name": "Security",
          "score": "0"
        },
        {
          "name": "Cost",
          "score": "0"
        }
      ]
    },
    {
      "name": "soa",
      "mainCriteria": [
        {
          "name": "Usability",
          "score": "0"
        },
        {
          "name": "Portability",
          "score": "0"
        },
        {
          "name": "Maintainability",
          "score": "1"
        },
        {
          "name": "Scalability",
          "score": "1"
        },
        {
          "name": "Performance",
          "score": "0"
        },
        {
          "name": "Availability",
          "score": "1"
        },
        {
          "name": "Security",
          "score": "0"
        },
        {
          "name": "Cost",
          "score": "1"
        }
      ]
    }
  ]
}
* */
