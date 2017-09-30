/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Menita Koonani
 */
public class CustomerDirectory {

    private ArrayList<Customer> customerList;
    private Long updatedTime;

    public CustomerDirectory() {
        this.customerList = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    // new customerList
    public Customer addNewCustomer() {
        Customer newCustomer = new Customer();
        customerList.add(newCustomer);
        return newCustomer;
    }

    // import customer directory
    public void populatingCustomerDirectory(TravelAgency travelAgency) throws IOException, ParseException {

        File chosenFile = new File("Customer_Seat.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(chosenFile.getAbsolutePath()));
        String stringLine = "";
        StringTokenizer string = null;
        int lineNum = 0;
        int tokenNum = 0;
        while ((stringLine = bufferedReader.readLine()) != null) {
            lineNum++;
            string = new StringTokenizer(stringLine, ",");
            int objPosition = 0;
            ArrayList eachObject = new ArrayList();
            while (string.hasMoreTokens() && objPosition <= 7) {
                tokenNum++;
                objPosition++;
                eachObject.add(string.nextToken(","));
            }
            if (eachObject != null && !eachObject.isEmpty()) {
                Customer customer = addNewCustomer();
                customer.setFirstName(String.valueOf(eachObject.get(0)).trim());
                customer.setLastName(String.valueOf(eachObject.get(1)).trim());

                Long airlinerNum = Long.parseLong(String.valueOf(eachObject.get(2)));
                Long fleetNum = Long.parseLong(String.valueOf(eachObject.get(3)));
                Long airplaneNum = Long.parseLong(String.valueOf(eachObject.get(4)));
                customer.setAirplaneNum(airplaneNum);

                Seat customerSeat = customer.getSeat();
                int numAisle = (Integer.parseInt((String) eachObject.get(5)));
                int numMiddle = (Integer.parseInt((String) eachObject.get(6)));
                int numWindow = (Integer.parseInt((String) eachObject.get(7)));
                customerSeat.setNumAisle(numAisle);
                customerSeat.setNumMiddle(numMiddle);
                customerSeat.setNumWindow(numWindow);

                int totalSeatsBooked = numAisle + numMiddle + numWindow;
                customer.setSeatsBooked(totalSeatsBooked);

                Airliner airliner = travelAgency.getAirlinerById(airlinerNum);
                AirplaneFleet fleet = airliner.getFleetById(fleetNum);
                Airplane airplane = fleet.getAirplaneById(airplaneNum);
                Seat airplaneSeat = airplane.getSeat();
                airplaneSeat.setNumAisle(numAisle);
                airplaneSeat.setNumMiddle(numMiddle);
                airplaneSeat.setNumWindow(numWindow);
                airplaneSeat.setTotalSeats(totalSeatsBooked);
            }
        }
    }

    public float calcCustDirPrice() {
        float custDirPrice = 0;
        for (Customer eachCustomer : customerList) {
            custDirPrice += eachCustomer.calcCustPrice();
        }

        return custDirPrice;
    }
}
