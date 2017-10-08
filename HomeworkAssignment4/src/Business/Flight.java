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

    // cosntructor
    public Flight() {
        this.schedule = new Schedule();
        this.pricePerTicket = 100.0F;
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

    @Override
    public String toString() {
        return this.flightId.toString();
    }
}
