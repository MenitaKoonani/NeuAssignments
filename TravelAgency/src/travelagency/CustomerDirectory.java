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
import javax.swing.JOptionPane;

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
     public void populatingCustomerDirectory() throws IOException, ParseException {

        File chosenFile = new File("CustomerDir.csv");
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
            while (string.hasMoreTokens() && objPosition <= 6) {
                tokenNum ++;
                objPosition ++;
                eachObject.add(string.nextToken(","));
            }
            if(eachObject != null && !eachObject.isEmpty())
            {
                Customer customer = addNewCustomer();
                setUpdatedTime(System.currentTimeMillis());
                customer.setUserId(Long.parseLong(((String) eachObject.get(0)).trim()));
                customer.setFirstName(String.valueOf(eachObject.get(1)).trim());
                customer.setLastName(String.valueOf(eachObject.get(2)).trim());
                customer.setPassportNumber(String.valueOf(eachObject.get(3)).trim());
                customer.setPhoneNumber(Long.parseLong(((String) eachObject.get(4)).trim()));
                customer.setEmailId(String.valueOf(eachObject.get(5)).trim());
            }
        }
    }
}
