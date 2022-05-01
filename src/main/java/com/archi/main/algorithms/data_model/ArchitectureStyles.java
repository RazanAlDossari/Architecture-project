package com.archi.main.algorithms.data_model;

//public class ArchitectureStyles {
//}
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


import java.util.ArrayList;

public class ArchitectureStyles{
    public ArrayList<ArchitectureStyle> architectureStyle;

    public ArchitectureStyles(ArrayList<ArchitectureStyle> architectureStyle) {
        this.architectureStyle = architectureStyle;
    }
}

