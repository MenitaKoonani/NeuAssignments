/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class Fleet {

    private ArrayList<Flight> flightList;

    public Fleet() {
        this.flightList = new ArrayList<>();
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }

    // add new flight in airliner
    public Flight addNewFlight() {
        Flight newFlight = new Flight();
        getFlightList().add(newFlight);
        return newFlight;
    }

    //get flight by id in airliner fleet
    public Flight getFlightById(Long flightId) {
        for (Flight eachFlight : flightList) {
            if (eachFlight.getFlightId().equals(flightId)) {
                return eachFlight;
            }
        }
        return null;
    }
    
}
