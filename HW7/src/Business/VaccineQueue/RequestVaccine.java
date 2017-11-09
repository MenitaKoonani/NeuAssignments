/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VaccineQueue;

import Business.Disease.Disease;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import java.util.Date;

/**
 *
 * @author Menita Koonani
 */
public abstract class RequestVaccine {

    private Disease disease;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Vaccine vaccine;
    private Date requestDate;
    private Date resolveDate;

    public RequestVaccine() {
        requestDate = new Date();
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
}
