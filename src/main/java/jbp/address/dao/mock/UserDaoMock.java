package jbp.address.dao.mock;

import jbp.address.dao.UserDao;
import jbp.address.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silver on 3.2.2017..
 */
public class UserDaoMock implements UserDao {

    private List<User> users;

    public UserDaoMock() {
        this.users = new ArrayList<User>();
    }

    //interface
    public List<User> findUsers() {
        return users;
    }

    public User fetchUser(final String id) {
        int testId = Integer.parseInt(id);
        User testUser = null;
        for (User user : findUsers()) {
            if (0 >= user.getId() || null == user.getUsername() || null == user.getPassword()) {
                throw new IllegalArgumentException("The user does not have all required data.");

            } else {
                if (testId == user.getId()) {
                    testUser = user;
                    break;
                } else {
                    throw new IllegalStateException("User with this ID is not on the list.");
                }
            }
        }
        return testUser;
    }

/*    public boolean authenticateUser(final String username, final String password) {
        String testUsername = "marko";
        String testPassword = "123";
        boolean test = false;
        if(testUsername.equals(username)&& testPassword.equals(password)) {
            test = true;
        }
        return test;
    }*/

    public boolean authenticateUser(final String username, final String password) {
        boolean test = false;
        for (User user : findUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                test = true;
                break;
            } else {
                throw new IllegalArgumentException("The username or password are incorrect");
            }
        }
        return test;
    }
}
