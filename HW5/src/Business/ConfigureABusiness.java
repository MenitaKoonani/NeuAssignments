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
public class ConfigureABusiness {

    // import business data
    public static Business Initialize() {

        Business business = new Business();
        PersonDirectory personDirectory = business.getPersonDirectory();
        UserDirectory userDirectory = business.getUserDirectory();

        Person p1 = personDirectory.addNewPerson();
        p1.setFirstName("Menita");
        p1.setLastName("Koonani");

        User u1 = userDirectory.addNewUser();
        u1.setUsername("Menita");
        u1.setUserPassword(("menita").toCharArray());
        u1.setIsActive(true);
        u1.setPerson(p1);
        u1.setUserRole("System Admin");

        User u2 = userDirectory.addNewUser();
        u2.setUsername("koonani");
        u2.setUserPassword(("koonani").toCharArray());
        u2.setIsActive(true);
        u2.setPerson(p1);
        u2.setUserRole("User");

        Person p2 = personDirectory.addNewPerson();
        p2.setFirstName("Mohan");
        p2.setLastName("Koonani");

        User u3 = userDirectory.addNewUser();
        u3.setUsername("mohan");
        u3.setUserPassword(("mohan").toCharArray());
        u3.setIsActive(true);
        u3.setPerson(p2);
        u3.setUserRole("HR Admin");

        return business;
    }
}
