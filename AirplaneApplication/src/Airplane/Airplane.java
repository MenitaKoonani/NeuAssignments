/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airplane;

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
    private Date nextAvailableDate;
    private String airportName;
    private boolean isCertificateValid;

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

}
