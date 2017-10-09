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
public class CustomerDirectory {

    private ArrayList<Customer> customerList;
    private Long updatedTime;

    // constructor
    public CustomerDirectory() {
        this.customerList = new ArrayList<>();
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

    // get Customer by First and Last names
    public Customer getCustomerByNames(String firstName, String lastName) {
        for (Customer eachCustomer : customerList) {
            if (eachCustomer.getFirstName().equalsIgnoreCase(firstName) && eachCustomer.getLastName().equals(lastName)) {
                return eachCustomer;
            }
        }
        return null;
    }

    // remove Customer from Directory
    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
    }
}
