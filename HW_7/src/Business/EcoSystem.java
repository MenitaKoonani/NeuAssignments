package Business;

import Business.Disease.DiseaseCatalog;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private DiseaseCatalog diseaseCatalog;
    private VaccineCatalog vaccineCatalog;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        diseaseCatalog = new DiseaseCatalog();
        vaccineCatalog = new VaccineCatalog();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        return true;
    }

    public DiseaseCatalog getDiseaseCatalog() {
        return diseaseCatalog;
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
