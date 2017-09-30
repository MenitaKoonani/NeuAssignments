/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Menita Koonani
 */
public class Airliner {

    private ArrayList<AirplaneFleet> fleetList;
    private Long airlinerId;
    private String airlinerName;

    public float calcAirlinerRevenue() {
        float airlinerPrice = 0;
        for (AirplaneFleet eachFleet : fleetList) {
            airlinerPrice += eachFleet.calcFleetRevenue();
        }
        return airlinerPrice;
    }

    public ArrayList<Long> getFleetIdList() {
        ArrayList<Long> fleetIdList = new ArrayList<>();
        for (AirplaneFleet eachFleet : fleetList) {
            fleetIdList.add(eachFleet.getFleetId());
        }
        return fleetIdList;
    }

    public boolean isFleetInList(Long fleetId) {
        return (getFleetIdList().contains(fleetId));
    }

    public AirplaneFleet getFleetById(Long fleetId) {
        for (AirplaneFleet eachFleet : fleetList) {
            if (Objects.equals(eachFleet.getFleetId(), fleetId)) {
                return eachFleet;
            }
        }
        return null;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public Long getAirlinerId() {
        return airlinerId;
    }

    public void setAirlinerId(Long airlinerId) {
        this.airlinerId = airlinerId;
    }

    // constructor
    public Airliner() {
        fleetList = new ArrayList<>();
        importAirliner();
    }

    public ArrayList<AirplaneFleet> getFleetList() {
        return fleetList;
    }

    public void setFleetList(ArrayList<AirplaneFleet> fleetList) {
        this.fleetList = fleetList;
    }

    public AirplaneFleet addNewAirplaneFleet() {
        AirplaneFleet newFleet = new AirplaneFleet();
        fleetList.add(newFleet);
        return newFleet;
    }

    public void importAirliner() {
        setAirlinerId(Long.parseLong("1001"));
        setAirlinerName("Jet airways");
    }
}
