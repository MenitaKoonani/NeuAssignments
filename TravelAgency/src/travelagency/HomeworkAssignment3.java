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

        // importing Master schedule
        MasterSchedule masterSchedule = travelAgency.getMasterSchedule();
        masterSchedule.populatingMasterSchedule();

        // importing custromer directory
        CustomerDirectory customerDirectory = travelAgency.getCustomerDir();
        customerDirectory.populatingCustomerDirectory(travelAgency);

        // displaying data
        ArrayList<Airliner> airlinerList = travelAgency.getAirlinerList();
        for (Airliner eachAirliner : airlinerList) {
            System.out.println("----------------------------------------------");
            System.out.println("Airliner Id : " + eachAirliner.getAirlinerId() + "\tAirliner Name : " + eachAirliner.getAirlinerName());
            System.out.println("----------------------------------------------");
            ArrayList<AirplaneFleet> fleetList = eachAirliner.getFleetList();
            for (AirplaneFleet eachFleet : fleetList) {
                System.out.println("\nFleet Id :::: " + eachFleet.getFleetId());
                ArrayList<Flight> airplanesList = eachFleet.getAirplanesList();
                for (Flight eachAirplane : airplanesList) {
                    System.out.println("\tAirplane Id ::: " + eachAirplane.getAirplaneId() + "\tAirplane Name : " + eachAirplane.getAirplaneName() + "\tAirplane revenue : $" + eachAirplane.calcAirplaneRevenue());
                }
                System.out.println("Fleet Revenue : $" + eachFleet.calcFleetRevenue());
            }
            System.out.println("\n" + eachAirliner.getAirlinerName() + " Airliner Revenue : $" + eachAirliner.calcAirlinerRevenue());
            System.out.println("\n----------------------------------------------");
        }
        System.out.println("\nTravel Agency Revenue : $" + travelAgency.calcAgencyRevenue());
        System.out.println("\n----------------------------------------------");
    }
}
