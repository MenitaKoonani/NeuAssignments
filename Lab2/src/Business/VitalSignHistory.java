/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Menita Koonani
 */
public class VitalSignHistory {
    private ArrayList<VitalSigns> vitalSignArrayList;

    public VitalSignHistory(){
        vitalSignArrayList = new ArrayList<>();
    }
    public ArrayList<VitalSigns> getVitalSignArrayList() {
        return vitalSignArrayList;
    }

    public void setVitalSignArrayList(ArrayList<VitalSigns> vitalSignArrayList) {
        this.vitalSignArrayList = vitalSignArrayList;
    }
    
    public VitalSigns addVitals()
    {
        VitalSigns newVitalSign = new VitalSigns();
        vitalSignArrayList.add(newVitalSign);
        return newVitalSign;
    }
    
    public void deleteVitals(VitalSigns vitalSignToDelete)
    {
        vitalSignArrayList.remove(vitalSignToDelete);
    }
}
