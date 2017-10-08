/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Menita Koonani
 */
public class AirlinerDirectory {

    private ArrayList<Airliner> airlinerList;

    // constructor
    public AirlinerDirectory() {
        this.airlinerList = new ArrayList<>();
    }

    public ArrayList<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(ArrayList<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }

    // add new airliner
    public Airliner addNewAirliner() {
        Airliner airliner = new Airliner();
        airlinerList.add(airliner);
        return airliner;
    }

    // search airliner by id
    public Airliner getAirlinerById(Long airlinerId) {
        for (Airliner eachAirliner : airlinerList) {
            if (eachAirliner.getAirlinerId().equals(airlinerId)) {
                return eachAirliner;
            }
        }
        return null;
    }

    // search airliner by name
    public Airliner getAirlinerByName(String airlinerName) {
        for (Airliner eachAirliner : airlinerList) {
            if (eachAirliner.getAirlinerName().equalsIgnoreCase(airlinerName)) {
                return eachAirliner;
            }
        }
        return null;
    }

    // delete airliner
    public void deleteAirliner(Long airlinerId) {
        for (Airliner eachAirliner : airlinerList) {
            if (eachAirliner.getAirlinerId().equals(airlinerId)) {
                airlinerList.remove(eachAirliner);
                JOptionPane.showMessageDialog(null, eachAirliner.getAirlinerName() + " airliner deleted!");
            }
        }
    }

    // get all flight list from all airliners
    public ArrayList<Flight> getAllFlightsList() {
        ArrayList<Flight> flightList = new ArrayList<>();
        for (Airliner eachAirliner : getAirlinerList()) {
            for (Flight eachFlight : eachAirliner.getFleet().getFlightList()) {
                flightList.add(eachFlight);
            }
        }
        if (!flightList.isEmpty()) {
            return flightList;
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! No flights available!");
            return null;
        }
    }

    // get flight list based on source location
    public ArrayList<Flight> getFlightsBySource(String sourceLoc, ArrayList<Flight> searchFlightList) {
        ArrayList<Flight> flightList = new ArrayList<>();
        for (Flight eachFlight : searchFlightList) {
            if (eachFlight.getSchedule().getSourceLocation().equalsIgnoreCase(sourceLoc)) {
                flightList.add(eachFlight);
            }
        }
        if (!flightList.isEmpty()) {
            return flightList;
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! No flights available from " + sourceLoc + "...");
            return null;
        }
    }

    // get flight list based on destination
    public ArrayList<Flight> getFlightsByDestination(String destLoc, ArrayList<Flight> searchFlightList) {
        ArrayList<Flight> flightList = new ArrayList<>();
        for (Flight eachFlight : searchFlightList) {
            if (eachFlight.getSchedule().getDestLocation().equalsIgnoreCase(destLoc)) {
                flightList.add(eachFlight);
            }
        }
        if (!flightList.isEmpty()) {
            return flightList;
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! No flights available to " + destLoc + "...");
            return null;
        }
    }

    // get fligth list based on max price
    public ArrayList<Flight> getFlightsByMaxPrice(float maxPrice, ArrayList<Flight> searchFlightList) {
        ArrayList<Flight> flightList = new ArrayList<>();
        for (Flight eachFlight : searchFlightList) {
            if (eachFlight.getPricePerTicket() <= maxPrice) {
                flightList.add(eachFlight);
            }
        }
        if (!flightList.isEmpty()) {
            return flightList;
        } else {
            return null;
        }
    }
}
