/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;
    private static int counter;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
        counter = 1000;
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Clinic.getValue())) {
            organization = new ClinicOrganization();
        } else if (type.getValue().equals(Type.Distributor.getValue())) {
            organization = new DistributorOrganization();
        }
        organization.setOrganizationID(counter++);
        organizationList.add(organization);
        return organization;
    }

    public Organization getOrgByName(int orgId) {
        for (Organization eachOrg : organizationList) {
            if (eachOrg.getOrganizationID() == orgId) {
                return eachOrg;
            }
        }
        return null;
    }
}
