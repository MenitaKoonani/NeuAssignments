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
public class Person {

    int personId;
    String firstName;
    String lastName;
//    String username;
//    char[] personPassword;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public char[] getPersonPassword() {
//        return personPassword;
//    }
//
//    public void setPersonPassword(char[] personPassword) {
//        this.personPassword = personPassword;
//    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
