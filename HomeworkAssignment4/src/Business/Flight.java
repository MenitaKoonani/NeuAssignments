/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Menita Koonani
 */
public class Flight {

    private Long flightId;
    private String flightName;
    private Schedule schedule;
    private String airlinerName;
    private float pricePerTicket;
    private int maxSeatCount;
    private int seatAvailable;

    // cosntructor
    public Flight() {
        this.schedule = new Schedule();
        this.pricePerTicket = 100.0F;
        this.seatAvailable = this.maxSeatCount;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public float getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(float pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }

    public int getMaxSeatCount() {
        return maxSeatCount;
    }

    public void setMaxSeatCount(int maxSeatCount) {
        this.maxSeatCount = maxSeatCount;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    @Override
    public String toString() {
        return this.flightId.toString();
    }

    // add flights in new airliner panel
    // departure time
}
