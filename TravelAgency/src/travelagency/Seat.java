/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

/**
 *
 * @author Menita Koonani
 */
public class Seat {

    private int seatNumber;
    private char seatPref; // A, M, W
    private boolean isColumn1;
    private float price;
    private Long userId;
    private Long airplaneSerialNumber;
    private boolean isAssgined;

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public char getSeatPref() {
        return seatPref;
    }

    public void setSeatPref(char seatPref) {
        this.seatPref = seatPref;
    }

    public boolean isIsColumn1() {
        return isColumn1;
    }

    public void setIsColumn1(boolean isColumn1) {
        this.isColumn1 = isColumn1;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAirplaneSerialNumber() {
        return airplaneSerialNumber;
    }

    public void setAirplaneSerialNumber(Long airplaneSerialNumber) {
        this.airplaneSerialNumber = airplaneSerialNumber;
    }

    public boolean isIsAssgined() {
        return isAssgined;
    }

    public void setIsAssgined(boolean isAssgined) {
        this.isAssgined = isAssgined;
    }
}
