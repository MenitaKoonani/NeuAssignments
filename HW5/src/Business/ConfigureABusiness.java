/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Menita Koonani
 */
public class ConfigureABusiness {

    // import business data
    public static Business Initialize() {

        Business business = new Business();
        try {
            PersonDirectory personDirectory = business.getPersonDirectory();
            UserDirectory userDirectory = business.getUserDirectory();

            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            Person p1 = personDirectory.addNewPerson();
            p1.setFirstName("Mohan");
            p1.setLastName("Koonani");
            p1.setDateOfBirth(dateFormat.parse("06/14/1967"));

            User u1 = userDirectory.addNewUser();
            u1.setUsername("mohan");
            u1.setUserPassword(("mohan").toCharArray());
            u1.setPerson(p1);
            u1.setUserRole("System Admin");

            p1.getUserList().add(u1);

            User u2 = userDirectory.addNewUser();
            u2.setUsername("hema");
            u2.setUserPassword(("hema").toCharArray());
            u2.setIsActive(false);
            u2.setPerson(p1);
            u2.setUserRole("HR Admin");

            p1.getUserList().add(u2);

            Person p2 = personDirectory.addNewPerson();
            p2.setFirstName("Menita");
            p2.setLastName("Koonani");
            p2.setDateOfBirth(dateFormat.parse("12/22/1994"));

            User u3 = userDirectory.addNewUser();
            u3.setUsername("menita");
            u3.setUserPassword(("menita").toCharArray());
            u3.setPerson(p2);
            u3.setUserRole("System Admin");

            p2.getUserList().add(u3);

            User u4 = userDirectory.addNewUser();
            u4.setUsername("akshay");
            u4.setUserPassword(("akshay").toCharArray());
            u4.setPerson(p2);
            u4.setUserRole("HR Admin");

            p2.getUserList().add(u4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return business;
    }
}
