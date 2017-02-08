package jbp.address.dao;

import jbp.address.domain.User;

import java.util.List;

/**
 * Created by Silver on 3.2.2017..
 */
public interface UserDao {

    public User fetchUser(final String id);

    public List<User> findUsers();

    public boolean authenticateUser(final String username, final String password);
}
