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
public class Business {

    private PersonDirectory personDirectory;
    private UserDirectory userDirectory;

    // constructor
    public Business() {
        this.personDirectory = new PersonDirectory();
        this.userDirectory = new UserDirectory();
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public UserDirectory getUserDirectory() {
        return userDirectory;
    }
}
