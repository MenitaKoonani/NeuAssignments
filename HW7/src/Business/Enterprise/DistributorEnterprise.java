/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Disease.DiseaseCatalog;
import Business.Role.Role;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HospitalEnterprise extends Enterprise {

    private DiseaseCatalog diseaseCatalog;
    private VaccineCatalog vaccineCatalog;

    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
        diseaseCatalog = new DiseaseCatalog();
        vaccineCatalog = new VaccineCatalog();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public DiseaseCatalog getDiseaseCatalog() {
        return diseaseCatalog;
    }

    public void setDiseaseCatalog(DiseaseCatalog diseaseCatalog) {
        this.diseaseCatalog = diseaseCatalog;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }

    public ArrayList<Vaccine> getVaccineListForDisease(String disease) {
        ArrayList<Vaccine> vaccineList = new ArrayList<>();
        for (Vaccine eachVaccine : vaccineCatalog.getVaccineList()) {
            if (eachVaccine.getDisease().getDiseaseName().equalsIgnoreCase(disease)) {
                vaccineList.add(eachVaccine);
            }
        }
        return vaccineList;
    }
}
