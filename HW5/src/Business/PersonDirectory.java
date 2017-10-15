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
public class PersonDirectory {

    private ArrayList<Person> personList;
    private static int personIdGen;

    // cosntructor
    public PersonDirectory() {
        this.personList = new ArrayList<Person>();
        personIdGen = 101;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    // add new person to Person Directory
    public Person addNewPerson() {
        Person newPerson = new Person();
        newPerson.setPersonId(personIdGen++);
        personList.add(newPerson);
        return newPerson;
    }

    // delete Person from Person Directory
    public void deletePerson(Person person) {
        personList.remove(person);
        // remove from userList
    }

    // get person from person name
    public Person getPersonByName(String name) {
        for (Person eachPerson : personList) {
            String compareName = eachPerson.getFirstName() + " " + eachPerson.getLastName();
            if (compareName.equalsIgnoreCase(name)) {
                return eachPerson;
            }
        }
        return null;
    }

    // get Person for username and password
    public Person getPersonByUser(String userName, char[] password) {
        for (Person eachPerson : personList) {
            for (User eachUser : eachPerson.userList) {
                if (eachUser.getUsername().equalsIgnoreCase(userName) && eachUser.getUserPassword().equals(password)) {
                    return eachPerson;
                }
            }
        }
        return null;
    }

    // get Person by lastname
    public Person getPersonByLastName(String lastname) {
        for (Person eachPerson : personList) {
            if (eachPerson.getLastName().equalsIgnoreCase(lastname)) {
                return eachPerson;
            }
        }
        return null;
    }

    // get Person by person id
    public Person getPersonByPersonId(int personId) {
        for (Person eachPerson : personList) {
            if (eachPerson.getPersonId() == personId) {
                return eachPerson;
            }
        }
        return null;
    }
}
