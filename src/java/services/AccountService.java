package services;

import models.User;

/**
 *
 * @author Jireh
 */
public class AccountService {
    public AccountService() {
    }

    public User login(String username, String password) {
        final String USER_1 = "abe";
        final String USER_2 = "barb";
        final String PASSWORD = "password";
        
        if ((username.equals(USER_1) || username.equals(USER_2)) && password.equals(PASSWORD)) {
            User user = new User(username, null);
            return user;    
        } else {
            return null;   
        }
    }
    
}
