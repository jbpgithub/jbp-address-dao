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
    public User fetchUser(final String id) {
        int testId = Integer.parseInt(id);
        User testUser = null;
        for(User user: findUsers()) {
            if(testId == user.getId()) {
                testUser = user;
            }
        }
        return testUser;
    }

    public List<User> findUsers() {
        return users;
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
        User testUser = new User();
        for(User user: findUsers()) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                test = true;
            }
        }
        return test;
    }
}
