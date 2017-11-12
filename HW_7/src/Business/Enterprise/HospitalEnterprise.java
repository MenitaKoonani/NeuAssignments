/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HospitalEnterprise extends Enterprise {

//    private VaccineCatalog hospitalVaccineCatalog;

    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
//        hospitalVaccineCatalog = new VaccineCatalog();
    }

//    public VaccineCatalog getHospitalVaccineCatalog() {
//        return hospitalVaccineCatalog;
//    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public ArrayList<Vaccine> getVaccineListForDisease(String disease) {
//        ArrayList<Vaccine> vaccineList = new ArrayList<>();
//        for (Vaccine eachVaccine : hospitalVaccineCatalog.getVaccineList()) {
//            if (eachVaccine.getDisease().getDiseaseName().equalsIgnoreCase(disease)) {
//                vaccineList.add(eachVaccine);
//            }
//        }
//        return vaccineList;
//    }
}
