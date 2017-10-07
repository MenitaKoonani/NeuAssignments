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
public class Airliner {

    private Long airlinerId;
    private String airlinerName;
    private int flightCount;
    private String airlinerAddress;
    private Fleet fleet;

    public Airliner() {
        this.fleet = new Fleet();
    }

    public Long getAirlinerId() {
        return airlinerId;
    }

    public void setAirlinerId(Long airlinerId) {
        this.airlinerId = airlinerId;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public int getFlightCount() {
        return flightCount;
    }

    public void setFlightCount(int flightCount) {
        this.flightCount = flightCount;
    }

    public String getAirlinerAddress() {
        return airlinerAddress;
    }

    public void setAirlinerAddress(String airlinerAddress) {
        this.airlinerAddress = airlinerAddress;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    @Override
    public String toString() {
        return this.airlinerId.toString();
    }

    // check if flight in airliner
    public boolean isFlightInAirliner(Long flightId) {
        if (!fleet.getFlightList().isEmpty()) {
            for (Flight eachFlight : fleet.getFlightList()) {
                if (eachFlight.getFlightId().equals(flightId)) {
                    return true;
                }
            }
        }
        return false;
    }
}
