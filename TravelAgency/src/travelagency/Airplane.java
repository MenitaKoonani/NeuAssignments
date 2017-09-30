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
public class Airplane {

    private Long airplaneId;
    private String airplaneName;
    private int maxSeats;
    private Seat seat;
    private float airplaneRevenue;

    public float getAirplaneRevenue() {
        return airplaneRevenue;
    }

    public void setAirplaneRevenue(float airplaneRevenue) {
        this.airplaneRevenue = airplaneRevenue;
    }

    public float calcAirplaneRevenue() {
        return (seat.getNumAisle() * 400) + (seat.getNumMiddle() * 300) + (seat.getNumWindow() * 500);
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Airplane() {
        this.maxSeats = 150;
        seat = new Seat();
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }
}
