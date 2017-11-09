/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VaccineQueue;

/**
 *
 * @author Menita Koonani
 */
public class VaccineRequest extends RequestVaccine {

    private String testResult;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
