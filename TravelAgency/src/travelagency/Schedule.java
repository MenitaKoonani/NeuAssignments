/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Menita Koonani
 */
public class Schedule {

    private Time arrivalTime;
    private Time departureTime;
    private Date arrivalDate;
    private Date departureDate;
    private boolean isDelayed;
    private String arrivalCity;
    private String departureCity;
    private Long airplaneSerialNumber;

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public Long getAirplaneSerialNumber() {
        return airplaneSerialNumber;
    }

    public void setAirplaneSerialNumber(Long airplaneSerialNumber) {
        this.airplaneSerialNumber = airplaneSerialNumber;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public boolean isIsDelayed() {
        return isDelayed;
    }

    public void setIsDelayed(boolean isDelayed) {
        this.isDelayed = isDelayed;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }
}
