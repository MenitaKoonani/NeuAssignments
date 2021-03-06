/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import Business.Disease.Disease;
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

    public Vaccine newVaccine(String vaccineName, Disease disease, int maxAvail) {
        Vaccine newVaccine = new Vaccine();
        newVaccine.setVaccineId(counter++);
        newVaccine.setVaccineName(vaccineName);
        newVaccine.setDisease(disease);
        newVaccine.setMaxAvailable(maxAvail);
        vaccineList.add(newVaccine);
        return newVaccine;
    }

    public Vaccine newVaccine(Vaccine vaccine) {
        vaccineList.add(vaccine);
        return vaccine;
    }

    public void removeVaccine(Vaccine vaccine) {
        vaccineList.remove(vaccine);
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }
}
