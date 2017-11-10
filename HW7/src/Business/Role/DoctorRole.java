/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DoctorRole.ManageVaccineRequestsJPanel;
import javax.swing.JPanel;
import userinterface.DoctorRole.DoctorsWorkAreaJPanel;

/**
 *
 * @author Menita Koonani
 */
public class DoctorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DoctorsWorkAreaJPanel(userProcessContainer, account, (DoctorOrganization) organization, (HospitalEnterprise) enterprise);
    }

}
