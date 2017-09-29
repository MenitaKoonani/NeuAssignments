/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Menita Koonani
 */
public class Airplane {

    private Long serialNumber;
    private String modelNumber;
    private String airplaneName;
    private String airlinerName;
    private boolean isAvailable;
    private String manufacturerName;
    private int yearOfManufacture;
    private int seatsAvailable;
    private int maxRows;
    private Date nextAvailableDate;
    private String airportName;
    private boolean isCertificateValid;
//    private SeatArrangement seatArrangement;
//
//    private Schedule schedule;
//    private float review;

    public Airplane() {
        this.maxRows = 25;
//        this.review = getSumSeatPrices();
    }
    
//    public float getSumSeatPrices()
//    {
//        float seatPrices = 0;
//        for (Seat eachSeat : seatArrangement.getSeatList()) {
//            seatPrices += eachSeat.getPrice();
//        }
//        return seatPrices;
//    }
//
//    public SeatArrangement getSeatArrangement() {
//        return seatArrangement;
//    }
//
//    public void setSeatArrangement(SeatArrangement seatArrangement) {
//        this.seatArrangement = seatArrangement;
//    }
//    
//    public float getReview() {
//        return review;
//    }
//
//    public void setReview(float review) {
//        this.review = review;
//    }


    public Date getNextAvailableDate() {
        return nextAvailableDate;
    }

    public void setNextAvailableDate(Date nextAvailableDate) {
        this.nextAvailableDate = nextAvailableDate;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

//    public Schedule getSchedule() {
//        return schedule;
//    }
//
//    public void setSchedule(Schedule schedule) {
//        this.schedule = schedule;
//    }

    public boolean isCertitficateValid() {
        return isCertificateValid;
    }

    public void setIsCertificateValid(boolean isCertificateValid) {
        this.isCertificateValid = isCertificateValid;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Override
    public String toString() {
        return String.valueOf(this.serialNumber);
    }

    public boolean isNotEmpty(String stringField) {
        return stringField != null && !stringField.isEmpty();
    }

}
