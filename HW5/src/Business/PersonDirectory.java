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
    private int personIdGen = 101;

    // cosntructor
    public PersonDirectory() {
        this.personList = new ArrayList<Person>();
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
}
