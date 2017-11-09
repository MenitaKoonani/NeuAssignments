/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.VaccineQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory staffDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;

    public enum Type {
        
        Admin("Admin Organization"),
        Doctor("Doctor Organization"),
        Distributor("Distributor Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        staffDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public PersonDirectory getStaffDirectory() {
        return staffDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }

}
