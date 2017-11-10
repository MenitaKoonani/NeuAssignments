/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DistributorRole.DistributorWorkAreaJPanel;

/**
 *
 * @author Menita Koonani
 */
public class Distributor extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DistributorWorkAreaJPanel(userProcessContainer, account, (DistributorOrganization) organization, (HospitalEnterprise) enterprise);
    }

}
