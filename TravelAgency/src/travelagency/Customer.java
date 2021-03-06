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
public class Customer {

    private String firstName;
    private String lastName;
    private Long airplaneNum;
    private Seat seat;
    private int seatsBooked;

    // constructor
    public Customer() {
        this.seat = new Seat();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAirplaneNum() {
        return airplaneNum;
    }

    public void setAirplaneNum(Long airplaneNum) {
        this.airplaneNum = airplaneNum;
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
        this.seatsBooked = seatsBooked;
    }

    public float calcCustPrice() {
        return (seat.getNumAisle() * seat.getAislePrice()) + (seat.getNumMiddle() * seat.getMiddlePrice()) + (seat.getNumWindow() * seat.getWindowPrice());
    }
}
