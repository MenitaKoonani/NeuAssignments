/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class DistributorEnterprise extends Enterprise {

    private VaccineCatalog distributorVaccineCatalog;

    public DistributorEnterprise(String name) {
        super(name, EnterpriseType.Distributor);
        distributorVaccineCatalog = new VaccineCatalog();
    }

    public VaccineCatalog getDistributorVaccineCatalog() {
        return distributorVaccineCatalog;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Vaccine> getVaccineListForDisease(String disease) {
        ArrayList<Vaccine> vaccineList = new ArrayList<>();
        for (Vaccine eachVaccine : distributorVaccineCatalog.getVaccineList()) {
            if (eachVaccine.getDisease().getDiseaseName().equalsIgnoreCase(disease)) {
                vaccineList.add(eachVaccine);
            }
        }
        return vaccineList;
    }
}
