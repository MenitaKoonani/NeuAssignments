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
public class Flight {

    private Long airplaneId;
    private String airplaneName;
    private int maxSeats;
    private Seat seat;
    private int seatsBooked;

    // constructor
    public Flight() {
        seat = new Seat();
        this.seatsBooked = 0;
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

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked += seatsBooked;
    }

    public float calcAirplaneRevenue() {
        return (seat.getNumAisle() * seat.getAislePrice()) + (seat.getNumMiddle() * seat.getMiddlePrice()) + (seat.getNumWindow() * seat.getWindowPrice());
    }
}
