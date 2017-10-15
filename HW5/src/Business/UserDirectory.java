/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Menita Koonani
 */
public class UserDirectory {

    private ArrayList<User> userList;
    private static int userIdGen;
    String userRole[] = {"HR Admin", "System Admin"};

    // constuctor
    public UserDirectory() {
        userList = new ArrayList<User>();
        userIdGen = 201;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public String[] getUserRole() {
        return userRole;
    }

    public void setUserRole(String[] userRole) {
        this.userRole = userRole;
    }

    // add new user to User Directory
    public User addNewUser() {
        User newUser = new User();
        newUser.setUserId(userIdGen++);
        userList.add(newUser);
        return newUser;
    }

    // delete User from User Directory
    public void deleteUser(User user) {
        userList.remove(user);
    }

    // check if user is valid
    public User isValidUser(String userName, char[] password) {
        for (User eachUser : userList) {
            if (userName.equals(eachUser.getUsername()) && Arrays.equals(password, eachUser.getUserPassword())) {
                return eachUser;
            }
        }
        return null;
    }

    // search user in user directory
    public User getUserById(int userId) {
        for (User eachUser : userList) {
            if (eachUser.getUserId() == userId) {
                return eachUser;
            }
        }
        return null;
    }

    // get user by username and password
    public User getUserList(String userName, char[] password) {
        for (User eachUser : userList) {
            if (userName.equals(eachUser.getUsername()) && Arrays.equals(password, eachUser.getUserPassword())) {
                return eachUser;
            }
        }
        return null;
    }
}
