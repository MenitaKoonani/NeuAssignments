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
        travelAgency.populatingAirplaneCatalog();

        // displaying data
        ArrayList<Airliner> airlinerList = travelAgency.getAirlinerList();
        for (Airliner eachAirliner : airlinerList) {
            System.out.println("Airliner Id : " + eachAirliner.getAirlinerId());
            System.out.println("----------------------------------------------");
            ArrayList<AirplaneFleet> fleetList = eachAirliner.getFleetList();
            for (AirplaneFleet eachFleet : fleetList) {
                System.out.println(" Fleet Id :::: " + eachFleet.getFleetId());
                ArrayList<Airplane> airplanesList = eachFleet.getAirplanesList();
                for (Airplane eachAirplane : airplanesList) {
                    System.out.println("Airplane Id ::: " + eachAirplane.getAirplaneId());
                    System.out.println("Airplane revenue : " + eachAirplane.getAirplaneRevenue());
                    System.out.println("Seats Taken : " + eachAirplane.getSeat().getTotalSeats());
                }
                System.out.println("Fleet Revenue : " + eachFleet.calcFleetRevenue());
            }
            System.out.println("Airliner Revenue :" + eachAirliner.calcAirlinerRevenue());
            System.out.println("----------------------------------------------");
        }

        // importing custromer directory
        CustomerDirectory customerDirectory = travelAgency.getCustomerDir();
        customerDirectory.populatingCustomerDirectory(travelAgency);

        // displaying customerData
        ArrayList<Customer> customerList = customerDirectory.getCustomerList();
        for (Customer eachCustomer : customerList) {
            System.out.println("First Name : " + eachCustomer.getFirstName() + "\tPrice : " + eachCustomer.calcCustPrice());
        }

        // importing Master schedule
        MasterSchedule masterSchedule = travelAgency.getMasterSchedule();
        masterSchedule.populatingMasterSchedule();

        // displaying masterSchedule
        ArrayList<Schedule> scheduleList = masterSchedule.getScheduleList();
        for (Schedule eachSchedule : scheduleList) {
            System.out.println("Airplane Num : " + eachSchedule.getAirplaneSerialNumber() + "\tDeparture Time : " + eachSchedule.getDepartureTime());
        }

    }
}
