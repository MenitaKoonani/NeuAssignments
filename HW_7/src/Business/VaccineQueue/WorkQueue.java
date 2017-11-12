/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VaccineQueue;

import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class WorkQueue {
    
    private ArrayList<RequestVaccine> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<RequestVaccine> getWorkRequestList() {
        return workRequestList;
    }
}