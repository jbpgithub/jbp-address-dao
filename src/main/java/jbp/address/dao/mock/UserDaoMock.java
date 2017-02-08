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

    public UserDaoMock(List<User> users) {
        this.users = users;
    }


    //interface
    public User fetchUser(final String id) {


        return null;
    }

    public List<User> findUsers() {
        return users;
    }

    public boolean authenticateUser(final String username, final String password) {
        return false;
    }
}
