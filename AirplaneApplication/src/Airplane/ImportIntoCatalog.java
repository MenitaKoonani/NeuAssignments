/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airplane;

import Interface.MainJFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Menita Koonani
 */
public class ImportIntoCatalog {
    
    public static AirplaneCatalog populatingAirplaneCatalog(File chosenFile) throws IOException, ParseException {

        AirplaneCatalog airplaneCatalog = MainJFrame.airplaneCatalog;
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
            while (string.hasMoreTokens() && objPosition <= 11) {
                tokenNum ++;
                objPosition ++;
                eachObject.add(string.nextToken(","));
            }
            if(eachObject != null && !eachObject.isEmpty())
            {
                Airplane airplane = airplaneCatalog.addNewAirplane();
                airplaneCatalog.setUpdatedTime(System.currentTimeMillis());
                airplane.setSerialNumber(Long.parseLong(((String) eachObject.get(0)).trim()));
                airplane.setModelNumber(String.valueOf(eachObject.get(1)).trim());
                airplane.setAirlinerName(String.valueOf(eachObject.get(2)).trim());
                airplane.setAirplaneName(String.valueOf(eachObject.get(3)).trim());
                airplane.setIsAvailable(String.valueOf(eachObject.get(4)).trim().equalsIgnoreCase("Yes"));
                airplane.setAirportName(String.valueOf(eachObject.get(5)).trim());
                airplane.setManufacturerName(String.valueOf(eachObject.get(6)).trim());
                airplane.setYearOfManufacture(Integer.parseInt(String.valueOf(eachObject.get(7)).trim()));
                airplane.setSeatsAvailable(Integer.parseInt(String.valueOf(eachObject.get(8)).trim()));
                airplane.setIsCertificateValid(String.valueOf(eachObject.get(9)).trim().equalsIgnoreCase("Yes"));

                String availDate = (String) eachObject.get(10);
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
                Date date = formatter.parse(availDate);
                airplane.setNextAvailableDate(date);
            }
        }
        JOptionPane.showMessageDialog(null, "Airplane Catalog Added!");
        return airplaneCatalog;
    }
}
