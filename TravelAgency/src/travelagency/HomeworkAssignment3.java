/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import travelagency.*;

/**
 *
 * @author Menita Koonani
 */
public class HomeworkAssignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        // TODO code application logic here
        TravelAgency travelAgency = new TravelAgency();

        // importing airplaneData
        AirplaneCatalog airplaneCatalog = travelAgency.getAirplaneCatalog();
        airplaneCatalog.populatingAirplaneCatalog();

        // displaying airplane catalog
        ArrayList<Airplane> airplanesList = airplaneCatalog.getAirplanesList();
        for (Airplane eachAirplane : airplanesList) {
            System.out.println("Airplane Serial Number :" + eachAirplane.getSerialNumber());
        }

        // importing custromer directory
        CustomerDirectory customerDirectory = travelAgency.getCustomerDir();
        customerDirectory.populatingCustomerDirectory();

        // displaying customerData
        ArrayList<Customer> customerList = customerDirectory.getCustomerList();
        for (Customer eachCustomer : customerList) {
            System.out.println("User ID : " + eachCustomer.getUserId());
        }

        // importing Master schedule
        MasterSchedule masterSchedule = travelAgency.getMasterSchedule();
        masterSchedule.populatingMasterSchedule();

        // displaying masterSchedule
        ArrayList<Schedule> scheduleList = masterSchedule.getScheduleList();
        for (Schedule eachSchedule : scheduleList) {
            System.out.println("Airplane Num : " + eachSchedule.getAirplaneSerialNumber() + "\tDeparture Time : " + eachSchedule.getDepartureTime());
        }
        
        // importing seat arrangement
        SeatArrangement seatArrangement = airplaneCatalog.getSeatArrangement();
        seatArrangement.populatingSeatArrangement();
        
        // displaying seatArrangement
        ArrayList<Seat> seatArrangementList = seatArrangement.getSeatList();
        for(Seat eachSeat : seatArrangementList){
            System.out.println("User ID : " + eachSeat.getUserId()+ "\tSeatPref : " + eachSeat.getSeatPref());
        }
        
    }
}
