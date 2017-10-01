/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 *
 * @author Menita Koonani
 */
public class AirplaneFleet {

    private ArrayList<Flight> airplanesList;
    private Long fleetId;

    // construtor
    public AirplaneFleet() {
        airplanesList = new ArrayList<>();
    }

    public ArrayList<Flight> getAirplanesList() {
        return airplanesList;
    }

    public void setAirplanesList(ArrayList<Flight> airplanesList) {
        this.airplanesList = airplanesList;
    }

    public Long getFleetId() {
        return fleetId;
    }

    public void setFleetId(Long fleetId) {
        this.fleetId = fleetId;
    }

    public Flight addNewAirplane() {
        Flight newAirplane = new Flight();
        airplanesList.add(newAirplane);
        return newAirplane;
    }

    public boolean isAirplaneInList(Long airplaneId) {
        for (Flight eachAirplane : airplanesList) {
            if (Objects.equals(eachAirplane.getAirplaneId(), airplaneId)) {
                return true;
            }
        }
        return false;
    }

    public Flight getAirplaneById(Long airplaneId) {
        for (Flight eachAirplane : airplanesList) {
            if (Objects.equals(eachAirplane.getAirplaneId(), airplaneId)) {
                return eachAirplane;
            }
        }
        return null;
    }

    public ArrayList<Long> getAirplaneIds() {
        ArrayList<Long> airplaneIds = new ArrayList<>();
        for (Flight eachAirplane : airplanesList) {
            airplaneIds.add(eachAirplane.getAirplaneId());
        }
        return airplaneIds;
    }

    public float calcFleetRevenue() {
        float fleetPrice = 0;
        for (Flight eachAirplane : airplanesList) {
            fleetPrice += eachAirplane.calcAirplaneRevenue();
        }
        return fleetPrice;
    }
}
