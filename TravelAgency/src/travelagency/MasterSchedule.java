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
import java.sql.Time;
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
public class MasterSchedule {

    private ArrayList<Schedule> scheduleList;
    private Long updatedTime;

    public MasterSchedule() {
        this.scheduleList = new ArrayList<>();
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public ArrayList<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(ArrayList<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    // add new Schedule
    public Schedule addNewSchedule() {
        Schedule schedule = new Schedule();
        scheduleList.add(schedule);
        return schedule;
    }

    // imoorting schedule data
    public void populatingMasterSchedule() throws IOException, ParseException {

        File chosenFile = new File("ScheduleData.csv");
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
                Schedule schedule = addNewSchedule();
                setUpdatedTime(System.currentTimeMillis());
                schedule.setAirplaneSerialNumber(Long.parseLong(((String) eachObject.get(0)).trim()));
                schedule.setArrivalCity(String.valueOf(eachObject.get(1)).trim());
                schedule.setDepartureCity(String.valueOf(eachObject.get(2)).trim());

                String time = (String) eachObject.get(3);
                DateFormat timeFormatter = new SimpleDateFormat("HH:mm");
                Date arrivalTime = timeFormatter.parse(time);
                schedule.setArrivalTime(new java.sql.Time(arrivalTime.getTime()));

                time = (String) eachObject.get(4);
                Date departureTime = timeFormatter.parse(time);
                schedule.setDepartureTime(new java.sql.Time(departureTime.getTime()));

                String date = (String) eachObject.get(5);
                DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
                Date arrivalDate = dateFormatter.parse(date);
                schedule.setArrivalDate(arrivalDate);

                date = (String) eachObject.get(6);
                Date departureDate = dateFormatter.parse(date);
                schedule.setDepartureDate(departureDate);

                boolean isDelayed = String.valueOf(eachObject.get(7)).trim().equalsIgnoreCase("Yes");
                schedule.setIsDelayed(isDelayed);

//                if (isDelayed) {
//                    time = (String) eachObject.get(8);
//                    System.out.println("delay time: " + time);
//                    Date delayTime = timeFormatter.parse(time);
//                    schedule.setDelayTime(new java.sql.Time(delayTime.getTime()));
//                }
            }
        }
    }
}
