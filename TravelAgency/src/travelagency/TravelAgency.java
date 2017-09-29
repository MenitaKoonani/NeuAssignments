/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

/**
 *
 * @author Menita Koonani
 */
public class TravelAgency {

    private CustomerDirectory customerDir;
    private MasterSchedule masterSchedule;
    private AirplaneCatalog airplaneCatalog;

    public TravelAgency() {
        this.customerDir = new CustomerDirectory();
        this.masterSchedule = new MasterSchedule();
        this.airplaneCatalog = new AirplaneCatalog();
    }

    public CustomerDirectory getCustomerDir() {
        return customerDir;
    }

    public void setCustomerDir(CustomerDirectory customerDir) {
        this.customerDir = customerDir;
    }

    public MasterSchedule getMasterSchedule() {
        return masterSchedule;
    }

    public void setMasterSchedule(MasterSchedule masterSchedule) {
        this.masterSchedule = masterSchedule;
    }

    public AirplaneCatalog getAirplaneCatalog() {
        return airplaneCatalog;
    }

    public void setAirplaneCatalog(AirplaneCatalog airplaneCatalog) {
        this.airplaneCatalog = airplaneCatalog;
    }
}
