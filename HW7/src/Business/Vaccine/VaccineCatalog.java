/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class VaccineCatalog {

    private ArrayList<Vaccine> vaccineList;
    private static int counter;

    public VaccineCatalog() {
        vaccineList = new ArrayList<>();
        counter = 300;
    }

    public Vaccine newVaccine(String vaccineName) {
        Vaccine newVaccine = new Vaccine();
        newVaccine.setVaccineId(counter++);
        newVaccine.setVaccineName(vaccineName);
        return newVaccine;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }
}
