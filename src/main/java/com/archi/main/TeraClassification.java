package com.archi.main;

import com.archi.main.algorithms.data_model.Pair;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;

public class TeraClassification {

    static final String Availability_QA = "Availability";
    static final String Usability_QA = "Usability";
    static final String Performance_QA = "Performance";
    static final String Security_QA = "Security";
    static final String Maintainability_QA = "Maintainability";
    static final String Portability_QA = "Portability";
    static final String Scalability_QA = "Scalability";

    public void ReadTearData() {
        try {
            File tearData = new File("nfr.tar");
            Scanner myReader = new Scanner(tearData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//ReadTearData

    public List<String> ExtractProjectsUserStory() throws IOException {
        List<String> UserStoryList = new ArrayList<String>();
        String line;
        File tearData = new File("nfr.tar");
        BufferedReader myReader = new BufferedReader(new FileReader(tearData));
        while ((line = myReader.readLine()) != null) {
            if (line.contains("@DATA")) {
                break; // breaks the while loop
            }
        }
        // we reach the user story section
        while ((line = myReader.readLine()) != null) {
            if (line.contains("% Manual trace timing"))
                break; // breaks the while loop
            else
                // Tear data extracted from project1 - project15
                UserStoryList.add(line + "\n");
        }//while
        myReader.close();
        return UserStoryList;
    }//ExtractProjectsUserStory

    public List<Pair<String, Integer>> Project_QualityAttributes(int projectNumber) throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith(projectNumber + ",'")) {
                // *Print project1 user story*
                // System.out.println("Project1 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 1
        }//for loop
        System.out.println();
        System.out.println("** Frequency of Quality Attributes in project " + projectNumber + " **");
       // System.out.println("Functional Requirements = " + FunctionalReq);
        System.out.println("Availability = " + Availability);
        System.out.println("Maintainability = " + Maintainability);
        System.out.println("Performance = " + Performance);
        System.out.println("Scalability = " + Scalability);
        System.out.println("Security = " + Security);
        System.out.println("Usability = " + Usability);
        System.out.println("Portability = " + Portability);
        System.out.println();
        List<Pair<String, Integer>> numOfCountsOfQAs = new ArrayList<>();
        // P8= (5,2,17,4,15,10,0)
        if (Availability != 0)
            numOfCountsOfQAs.add(new Pair<>(Availability_QA, Availability));
        if (Maintainability != 0)
            numOfCountsOfQAs.add(new Pair<>(Maintainability_QA, Maintainability));
        if (Performance != 0)
            numOfCountsOfQAs.add(new Pair<>(Performance_QA, Performance));
        if (Scalability != 0)
            numOfCountsOfQAs.add(new Pair<>(Scalability_QA, Scalability));
        if (Security != 0)
            numOfCountsOfQAs.add(new Pair<>(Security_QA, Security));
        if (Usability != 0)
            numOfCountsOfQAs.add(new Pair<>(Usability_QA, Usability));
        if (Portability != 0)
            numOfCountsOfQAs.add(new Pair<>(Portability_QA, Portability));

        return numOfCountsOfQAs;
    }//Project1_QualityAttributes


    public List<Object> Project1_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("1,'")) {
                // *Print project1 user story*
                // System.out.println("Project1 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 1
        }//for loop
/*
        System.out.println("**Project 1 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project1_QualityAttributes

    public List<Object> Project2_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("2,'")) {
                // *Print project1 user story*
                // System.out.println("Project2 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 2
        }//for loop

      /*  System.out.println("**Project 2 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project2_QualityAttributes

    public List<Object> Project3_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("3,'")) {
                // *Print project1 user story*
                //  System.out.println("Project3 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 2
        }//for loop

        /*System.out.println("**Project 3 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project3_QualityAttributes

    public List<Object> Project4_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("4,'")) {
                // *Print project1 user story*
                //  System.out.println("Project4 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 4
        }//for loop

        /*System.out.println("**Project 4 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project4_QualityAttributes

    public List<Object> Project5_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("5,'")) {
                // *Print project1 user story*
                //  System.out.println("Project5 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 5
        }//for loop

        /*System.out.println("**Project 5 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project5_QualityAttributes

    public List<Object> Project6_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("6,'")) {
                // *Print project1 user story*
                //  System.out.println("Project6 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 6
        }//for loop

        /*System.out.println("**Project 6 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project6_QualityAttributes

    public List<Object> Project7_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("7,'")) {
                // *Print project7 user story*
                //  System.out.println("Project7 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 7
        }//for loop

        /*System.out.println("**Project 7 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project7_QualityAttributes

    public List<Object> Project8_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("8,'")) {
                // *Print project1 user story*
                //  System.out.println("Project8 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 8
        }//for loop

        /*System.out.println("**Project 8 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project8_QualityAttributes

    public List<Object> Project9_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("9,'")) {
                // *Print project1 user story*
                //  System.out.println("Project9 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 9
        }//for loop

        /*System.out.println("**Project 9 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project9_QualityAttributes

    public List<Object> Project10_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("10,'")) {
                // *Print project1 user story*
                //  System.out.println("Project10 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 10
        }//for loop

        /*System.out.println("**Project 10 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project10_QualityAttributes

    public List<Object> Project11_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("11,'")) {
                // *Print project1 user story*
                //  System.out.println("Project11 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 11
        }//for loop

        /*System.out.println("**Project 11 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project11_QualityAttributes

    public List<Object> Project12_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("12,'")) {
                // *Print project1 user story*
                //  System.out.println("Project12 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 12
        }//for loop

        /*System.out.println("**Project 12 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project12_QualityAttributes

    public List<Object> Project13_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("13,'")) {
                // *Print project1 user story*
                //  System.out.println("Project13 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 13
        }//for loop

        /*System.out.println("**Project 13 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project13_QualityAttributes

    public List<Object> Project14_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("14,'")) {
                // *Print project1 user story*
                //  System.out.println("Project14 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 14
        }//for loop

        /*System.out.println("**Project 14 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project14_QualityAttributes

    public List<Object> Project15_QualityAttributes() throws IOException {
        int FunctionalReq = 0, Availability = 0, Performance = 0, Maintainability = 0, Scalability = 0, Security = 0, Usability = 0, Portability = 0;
        Object[] UserStoryArray = ExtractProjectsUserStory().toArray();
        for (int i = 0; i < UserStoryArray.length; i++) {
            // System.out.println( UserStoryArray[i]);
            while (UserStoryArray[i].toString().startsWith("15,'")) {
                // *Print project1 user story*
                //  System.out.println("Project15 - " + UserStoryArray[i]);

                // check the 7 QA
                if (UserStoryArray[i].toString().endsWith("F\n") && !UserStoryArray[i].toString().endsWith("LF\n")) {
                    // System.out.println("Functional Req - "+UserStoryArray[i]);
                    FunctionalReq++;
                }

                if (UserStoryArray[i].toString().endsWith("A\n")) {
                    //  System.out.println("Availability NonFunctional Req - "+UserStoryArray[i]);
                    Availability++;
                }
                if (UserStoryArray[i].toString().endsWith("MN\n")) {
                    // System.out.println("Maintainability NonFunctional Req - "+UserStoryArray[i]);
                    Maintainability++;
                }
                if (UserStoryArray[i].toString().endsWith("PE\n")) {
                    // System.out.println("Performance NonFunctional Req - "+UserStoryArray[i]);
                    Performance++;
                }
                if (UserStoryArray[i].toString().endsWith("SC\n")) {
                    // System.out.println("Scalability NonFunctional Req - "+UserStoryArray[i]);
                    Scalability++;
                }
                if (UserStoryArray[i].toString().endsWith("SE\n")) {
                    // System.out.println("Security NonFunctional Req - "+UserStoryArray[i]);
                    Security++;
                }
                if (UserStoryArray[i].toString().endsWith("US\n")) {
                    // System.out.println("Usability NonFunctional Req - "+UserStoryArray[i]);
                    Usability++;
                }
                if (UserStoryArray[i].toString().endsWith("PO\n")) {
                    //  System.out.println("Portability NonFunctional Req - "+UserStoryArray[i]);
                    Portability++;
                }
                break; // breaks the while loop

            }//end read project 15
        }//for loop

        /*System.out.println("**Project 15 User Story**");
        System.out.println("Functional Req = "+ FunctionalReq);
        System.out.println("Availability = "+ Availability);
        System.out.println("Maintainability = "+ Maintainability);
        System.out.println("Performance = "+ Performance);
        System.out.println("Scalability = "+ Scalability);
        System.out.println("Security = "+ Security);
        System.out.println("Usability = "+ Usability);
        System.out.println("Portability ="+ Portability);
*/
        List<Object> QAList = new ArrayList<Object>();

        QAList.add("Availability:" + Availability);
        QAList.add("Maintainability:" + Maintainability);
        QAList.add("Performance:" + Performance);
        QAList.add("Scalability:" + Scalability);
        QAList.add("Security:" + Security);
        QAList.add("Usability:" + Usability);
        QAList.add("Portability:" + Portability);

        return QAList;
    }//Project15_QualityAttributes

}//TeraClassification
