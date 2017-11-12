/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private VaccineCatalog vaccineCatalog;

    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        vaccineCatalog = new VaccineCatalog();
        organizationDirectory = new OrganizationDirectory();
    }

    public enum EnterpriseType {
        Hospital("Hospital"),
        Distributor("Distributor");

        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
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
