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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author Menita Koonani
 */
public class SeatArrangement {

    private ArrayList<Seat> seatList;
    private Long updatedTime;

    public SeatArrangement(){
        seatList = new ArrayList<>();
    }
    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    // add new seat
    public Seat addNewSeat() {
        Seat seat = new Seat();
        seatList.add(seat);
        return seat;
    }

    // imoorting schedule data
    public void populatingSeatArrangement() throws IOException, ParseException {

        File chosenFile = new File("SeatData.csv");
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
            while (string.hasMoreTokens() && objPosition <= 6) {
                tokenNum++;
                objPosition++;
                eachObject.add(string.nextToken(","));
            }
            if (!eachObject.isEmpty()) {
                Seat seat = addNewSeat();
                setUpdatedTime(System.currentTimeMillis());
                seat.setAirplaneSerialNumber(Long.parseLong(((String) eachObject.get(0)).trim()));
                seat.setSeatPref(String.valueOf(eachObject.get(1)).trim().charAt(0));
                seat.setIsColumn1(String.valueOf(eachObject.get(2)).trim().equalsIgnoreCase("Yes"));
                seat.setSeatNumber(Integer.parseInt(((String)eachObject.get(3)).trim()));
                seat.setUserId(Long.parseLong(((String) eachObject.get(4)).trim()));
                seat.setPrice(Float.valueOf(((String) eachObject.get(5)).trim()));
                seat.setIsAssgined(String.valueOf(eachObject.get(6)).trim().equalsIgnoreCase("Yes"));
            }
        }
    }
}
