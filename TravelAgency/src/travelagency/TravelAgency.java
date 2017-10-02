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
public class TravelAgency {

    private CustomerDirectory customerDir;
    private MasterSchedule masterSchedule;
    private ArrayList<Airliner> airlinerList;

    // constructor
    public TravelAgency() {
        this.customerDir = new CustomerDirectory();
        this.masterSchedule = new MasterSchedule();
        this.airlinerList = new ArrayList<Airliner>();
    }

    public CustomerDirectory getCustomerDir() {
        return customerDir;
    }

    public void setCustomerDir(CustomerDirectory customerDir) {
        this.customerDir = customerDir;
    }

    public MasterSchedule getMasterSchedule() {
        return masterSchedule;
    }

    public void setMasterSchedule(MasterSchedule masterSchedule) {
        this.masterSchedule = masterSchedule;
    }

    public ArrayList<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(ArrayList<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }

    public Airliner addNewAirliner() {
        Airliner airliner = new Airliner();
        airlinerList.add(airliner);
        return airliner;
    }

    public ArrayList<Long> getAirlinerIdList() {
        ArrayList<Long> airlinerIdList = new ArrayList<>();
        for (Airliner eachAirliner : airlinerList) {
            airlinerIdList.add(eachAirliner.getAirlinerId());
        }
        return airlinerIdList;
    }

    public boolean isAirlinerInList(Long airlinerId) {
        return (getAirlinerIdList().contains(airlinerId));
    }

    public Airliner getAirlinerById(Long airlinerId) {
        for (Airliner eachAirliner : airlinerList) {
            if (Objects.equals(eachAirliner.getAirlinerId(), airlinerId)) {
                return eachAirliner;
            }
        }
        return null;
    }

    public void populatingAirplaneCatalog() throws IOException, ParseException {

        File chosenFile = new File("Airliner.csv");
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
                Long airlinerNum = Long.parseLong(((String) eachObject.get(0)).trim());
                Airliner airliner;
                if (isAirlinerInList(airlinerNum)) {
                    airliner = getAirlinerById(airlinerNum);
                } else {
                    airliner = addNewAirliner();
                    airliner.setAirlinerId(airlinerNum);
                    airliner.setAirlinerName(String.valueOf(eachObject.get(1)).trim());
                }

                Long fleetId = Long.parseLong(((String) eachObject.get(2)).trim());
                AirplaneFleet airplaneFleet;
                if (airliner.isFleetInList(fleetId)) {
                    airplaneFleet = airliner.getFleetById(fleetId);
                } else {
                    airplaneFleet = airliner.addNewAirplaneFleet();
                    airplaneFleet.setFleetId(fleetId);
                }
                Long airplaneId = Long.parseLong(((String) eachObject.get(3)).trim());
                Flight airplane = airplaneFleet.addNewAirplane();
                airplane.setAirplaneId(airplaneId);
                airplane.setAirplaneName(String.valueOf(eachObject.get(4)).trim());
                airplane.setMaxSeats(Integer.parseInt(String.valueOf(eachObject.get(5)).trim()));
                Seat seat = airplane.getSeat();
                seat.setAislePrice(Float.parseFloat(String.valueOf(eachObject.get(6)).trim()));
                seat.setMiddlePrice(Float.parseFloat(String.valueOf(eachObject.get(7)).trim()));
                seat.setWindowPrice(Float.parseFloat(String.valueOf(eachObject.get(8)).trim()));
            }
        }
    }

    public float calcAgencyRevenue() {
        float travelAgencyRev = 0;
        for (Airliner eachAirliner : getAirlinerList()) {
            travelAgencyRev += eachAirliner.calcAirlinerRevenue();
        }
        return travelAgencyRev;
    }

}
