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
                if(eachAirplane.isAvailable())
                {
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
                if(eachAirplane.getManufacturerName().equals(manuName))
                {
                    airplaneList.add(eachAirplane);
                }
            }
            return airplaneList;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No airplanes manufactured by " + manuName);
        }
        return null;
    }
    
    public void populatingAirplaneCatalog(File chosenFile) throws IOException {

        AirplaneCatalog airplaneCatalog = new AirplaneCatalog();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(chosenFile.getAbsolutePath()));
        String stringLine = "";
        StringTokenizer string = null;
        int lineNum = 0;
        int tokenNum = 0;
        while ((stringLine = bufferedReader.readLine()) != null) {
            lineNum++;
            string = new StringTokenizer(stringLine, ",");
            int objPosition = 0;
            ArrayList eachObject = new ArrayList();
            while (string.hasMoreTokens() && objPosition <= 7) {
                tokenNum++;
                eachObject.set(objPosition++, string.nextToken(";"));
            }
            Airplane airplane = airplaneCatalog.addNewAirplane();
            airplane.setSerialNumber(Long.parseLong((String) eachObject.get(0)));
            airplane.setModelNumber((String) eachObject.get(1));
            airplane.setAirplaneName((String) eachObject.get(2));
            airplane.setIsAvailable(eachObject.get(3).equals("Yes"));
            airplane.setAirportName((String) eachObject.get(4));
            airplane.setManufacturerName((String) eachObject.get(5));
            airplane.setYearOfManufacture((int) eachObject.get(6));
            airplane.setSeatsAvailable((int) eachObject.get(7));
            JOptionPane.showMessageDialog(null, "Airplane:::" + airplane);
        }
    }

}
