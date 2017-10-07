/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

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
public class TravelAgency {

    private AirlinerDirectory airlinerDirectory;

    // constructor
    public TravelAgency() {
        this.airlinerDirectory = new AirlinerDirectory();
    }

    public AirlinerDirectory getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerDirectory(AirlinerDirectory airlinerDirectory) {
        this.airlinerDirectory = airlinerDirectory;
    }

    public ArrayList<Flight> getAllFlights() {
        ArrayList<Flight> flightList = new ArrayList<>();
        for (Airliner eachAirliner : airlinerDirectory.getAirlinerList()) {
            for (Flight eachFlight : eachAirliner.getFleet().getFlightList()) {
                flightList.add(eachFlight);
            }
        }
        if (!flightList.isEmpty()) {
            return flightList;
        } else {
            JOptionPane.showMessageDialog(null, "Empty flight list!", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public ArrayList<Long> getAirlinerIdList() {
        ArrayList<Long> airlinerIdList = new ArrayList<>();
        for (Airliner eachAirliner : airlinerDirectory.getAirlinerList()) {
            airlinerIdList.add(eachAirliner.getAirlinerId());
        }
        return airlinerIdList;
    }

    public boolean isAirlinerInList(Long airlinerId) {
        return (getAirlinerIdList().contains(airlinerId));
    }

    // import airliner details
    public void importAirlinersDetails() throws IOException, ParseException {

        File chosenFile = new File("AirlinerData.csv");
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
            while (string.hasMoreTokens() && objPosition <= 8) {
                tokenNum++;
                objPosition++;
                eachObject.add(string.nextToken(","));
            }
            if (!eachObject.isEmpty()) {
                Long airlinerId = Long.parseLong(((String) eachObject.get(0)).trim());
                String airlinerName = String.valueOf(eachObject.get(1)).trim();
                Airliner airliner;
                if (isAirlinerInList(airlinerId)) {
                    airliner = airlinerDirectory.getAirlinerById(airlinerId);
//                    System.out.println("Airliner id already exists in the directory! Provide a new unique airliner id");
                } else {
                    airliner = airlinerDirectory.addNewAirliner();
                    airliner.setAirlinerId(airlinerId);
                    airliner.setAirlinerName(airlinerName);
                }

                Long flightId = Long.parseLong(((String) eachObject.get(2)).trim());
                Flight flight;
                if (airliner.isFlightInAirliner(flightId)) {
                    System.out.println("Flight id already exists in the airliner! Provide a new unique flight id");
                } else {
                    flight = airliner.getFleet().addNewFlight();
                    flight.setFlightId(flightId);
                    flight.setFlightName(String.valueOf(eachObject.get(3)).trim());

                    Schedule schedule = new Schedule();
                    schedule.setSourceLocation(String.valueOf(eachObject.get(4)).trim());
                    schedule.setDestLocation(String.valueOf(eachObject.get(5)).trim());
                    
                    String date = (String) eachObject.get(6);
                    DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
                    Date departureDate = dateFormatter.parse(date);
                    schedule.setDepartureDate(departureDate);

                    String time = (String) eachObject.get(7);
                    DateFormat timeFormatter = new SimpleDateFormat("HH:mm");
                    Date arrivalTime = timeFormatter.parse(time);
                    schedule.setDepartureTime(new java.sql.Time(arrivalTime.getTime()));

                    schedule.setPrice(Float.parseFloat(String.valueOf(eachObject.get(8)).trim()));
                    flight.setSchedule(schedule);
                    flight.setAirlinerName(airlinerName);
                    
                }
                airliner.setFlightCount(airliner.getFleet().getFlightList().size());
            }
        }
    }
}
