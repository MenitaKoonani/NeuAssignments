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

    private ArrayList<Airplane> airplanesList;
    private Long fleetId;

    public Long getFleetId() {
        return fleetId;
    }

    public void setFleetId(Long fleetId) {
        this.fleetId = fleetId;
    }

    public AirplaneFleet() {
        airplanesList = new ArrayList<>();
    }

    public float calcFleetRevenue() {
        float fleetPrice = 0;
        for (Airplane eachAirplane : airplanesList) {
            fleetPrice += eachAirplane.calcAirplaneRevenue();
        }
        return fleetPrice;
    }

    public Airplane addNewAirplane() {
        Airplane newAirplane = new Airplane();
        airplanesList.add(newAirplane);
        return newAirplane;
    }

    public ArrayList<Airplane> getAirplanesList() {
        return airplanesList;
    }

    public void setAirplanesList(ArrayList<Airplane> airplanesList) {
        this.airplanesList = airplanesList;
    }

    public ArrayList<Long> getAirplaneIds() {
        ArrayList<Long> airplaneIds = new ArrayList<>();
        for (Airplane eachAirplane : airplanesList) {
            airplaneIds.add(eachAirplane.getAirplaneId());
        }
        return airplaneIds;
    }

    public Airplane getAirplaneById(Long airplaneId) {
        for (Airplane eachAirplane : airplanesList) {
            if (Objects.equals(eachAirplane.getAirplaneId(), airplaneId)) {
                return eachAirplane;
            }
        }
        return null;
    }
}
