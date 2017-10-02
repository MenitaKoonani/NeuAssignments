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
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Menita Koonani
 */
public class CustomerDirectory {

    private ArrayList<Customer> customerList;
    private Long updatedTime;

    // constructor
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
            while (string.hasMoreTokens() && objPosition <= 8) {
                tokenNum++;
                objPosition++;
                eachObject.add(string.nextToken(","));
            }
            if (!eachObject.isEmpty()) {

                String firstName = String.valueOf(eachObject.get(0)).trim();
                String lastName = String.valueOf(eachObject.get(1)).trim();
                Long airlinerNum = Long.parseLong(String.valueOf(eachObject.get(2)));
                Long fleetNum = Long.parseLong(String.valueOf(eachObject.get(3)));
                Long airplaneNum = Long.parseLong(String.valueOf(eachObject.get(4)));

                if (travelAgency.isAirlinerInList(airlinerNum)) {
                    Airliner airliner = travelAgency.getAirlinerById(airlinerNum);
                    if (airliner.isFleetInList(fleetNum)) {
                        AirplaneFleet fleet = airliner.getFleetById(fleetNum);
                        if (fleet.isAirplaneInList(airplaneNum)) {
                            Flight airplane = fleet.getAirplaneById(airplaneNum);

                            int colNum = (Integer.parseInt((String) eachObject.get(5)));
                            if (colNum == 1 || colNum == 2) {
                                int numAisle = (Integer.parseInt((String) eachObject.get(6)));
                                int numMiddle = (Integer.parseInt((String) eachObject.get(7)));
                                int numWindow = (Integer.parseInt((String) eachObject.get(8)));
                                int totalSeatsBookedByCust = numAisle + numMiddle + numWindow;

                                Seat airplaneSeat = airplane.getSeat();
                                if ((totalSeatsBookedByCust + airplane.getSeatsBooked()) <= airplane.getMaxSeats()) {
                                    airplaneSeat.setNumAisle(numAisle);
                                    airplaneSeat.setNumMiddle(numMiddle);
                                    airplaneSeat.setNumWindow(numWindow);
                                    airplaneSeat.setTotalSeats(totalSeatsBookedByCust);

                                    airplane.setSeatsBooked(totalSeatsBookedByCust); //should be summed up

                                    Customer customer = addNewCustomer();
                                    customer.setFirstName(firstName);
                                    customer.setLastName(lastName);
                                    customer.setAirplaneNum(airplaneNum);

                                    Seat customerSeat = customer.getSeat();
                                    customerSeat.setNumAisle(numAisle);
                                    customerSeat.setNumMiddle(numMiddle);
                                    customerSeat.setNumWindow(numWindow);
                                    customerSeat.setColNum(colNum);
                                    customer.setSeatsBooked(totalSeatsBookedByCust);

                                } else {
                                    System.out.println("Exceeded maximum seats in flight " + airplaneNum);
                                    System.out.println("Customer " + firstName + " was not added to the directory!");
                                }
                            } else {
                                System.out.println("Customer " + firstName + " hasn't chosen a valid column! Choose either Column 1 or Column 2");
                                System.out.println("Customer " + firstName + " was not added to the directory!");
                            }

                        } else {
                            System.out.println("Invalid flight ( " + airplaneNum + " ) !! ");
                            System.out.println("Customer " + firstName + " was not added to the directory!");
                        }
                    } else {
                        System.out.println("Invalid fleet ( " + fleetNum + " ) !! ");
                        System.out.println("Customer " + firstName + " was not added to the directory!");
                    }
                } else {
                    System.out.println("Invalid airliner ( " + airlinerNum + " ) !! ");
                    System.out.println("Customer " + firstName + " was not added to the directory!");
                }
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
