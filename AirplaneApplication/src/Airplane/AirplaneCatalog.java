/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airplane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Menita Koonani
 */
public class AirplaneCatalog {

    private ArrayList<Airplane> airplanesList;
    private Long updatedTime;

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }
    
    public AirplaneCatalog() {
        airplanesList = new ArrayList<Airplane>();
    }

    public ArrayList<Airplane> getAirplanesList() {
        return airplanesList;
    }

    public void setAirplanesList(ArrayList<Airplane> airplanesList) {
        this.airplanesList = airplanesList;
    }

    public Airplane addNewAirplane() {
        Airplane newAirplane = new Airplane();
        airplanesList.add(newAirplane);
        return newAirplane;
    }

    public ArrayList<Airplane> getAvailableAirplanes() {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if (eachAirplane.isAvailable()) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Currently no available airplanes!");
        }
        return null;
    }

    public ArrayList<Airplane> getAirplaneManufacturer(String manuName) {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if (eachAirplane.getManufacturerName().toLowerCase().startsWith(manuName.toLowerCase())) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No airplanes manufactured by " + manuName);
        }
        return null;
    }

    public ArrayList<Airplane> getAiplaneByManuYear(int findYear) {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if (eachAirplane.getYearOfManufacture() == findYear) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No airplanes were manufactured in " + findYear);
        }
        return null;
    }

    public ArrayList<Airplane> getAirplaneBySerialNum(Long findSerialNum) {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if (Objects.equals(eachAirplane.getSerialNumber(), findSerialNum)) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No airplanes with serial Number : " + findSerialNum);
        }
        return null;
    }

    public ArrayList<Airplane> getAirplaneByModelNum(String findModelNum) {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if (eachAirplane.getModelNumber().equalsIgnoreCase(findModelNum)) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No airplanes with serial Number : " + findModelNum);
        }
        return null;
    }

    public ArrayList<Airplane> getAirplaneByAirport(String findAirport) {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if ((eachAirplane.getAirportName()).equalsIgnoreCase(findAirport)) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No airplanes in this airport : " + findAirport);
        }
        return null;
    }

    public ArrayList<Airplane> getAirplaneByName(String findAirplaneName) {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if ((eachAirplane.getAirplaneName().toLowerCase()).startsWith(findAirplaneName.toLowerCase())) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No " + findAirplaneName + " found!");
        }
        return null;
    }

    public ArrayList<Airplane> getValidCertiAirplanes() {
        ArrayList<Airplane> airplaneList = new ArrayList();
        try {
            for (Airplane eachAirplane : this.getAirplanesList()) {
                if (!eachAirplane.isCertitficateValid()) {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No Airplanes have valid certificates!");
        }
        return null;
    }
}
