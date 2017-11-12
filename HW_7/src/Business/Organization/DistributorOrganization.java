/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Distributor;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class DistributorOrganization extends Organization{

    public DistributorOrganization() {
        super(Organization.Type.Distributor.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Distributor());
        return roles;
    }
}
