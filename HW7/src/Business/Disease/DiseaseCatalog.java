/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Disease;

import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class DiseaseCatalog {

    private ArrayList<Disease> diseaseList;
    public static int counter;

    public DiseaseCatalog() {
        diseaseList = new ArrayList<>();
        counter = 800;
    }

    public ArrayList<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(ArrayList<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public Disease newDisease(String diseaseName) {
        Disease newDisease = new Disease();
        newDisease.setDiseaseName(diseaseName);
        newDisease.setDiseaseId(counter++);
        diseaseList.add(newDisease);
        return newDisease;
    }
}
