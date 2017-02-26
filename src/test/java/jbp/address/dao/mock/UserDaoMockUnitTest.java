package jbp.address.dao.mock;

import jbp.address.domain.Role;
import jbp.address.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Silver on 9.2.2017..
 */
public class UserDaoMockUnitTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test_findUser() {
        User user = new User("marko", "123", Role.ADMIN);
        UserDaoMock userDaoMock = new UserDaoMock();
        userDaoMock.findUsers().add(user);
        if(1 != userDaoMock.findUsers().size()) {
            throw new IllegalStateException("Number of user in list is not expected size.");
        }
    }

/*    @Test
    public void test_UserIdSet() {
        UserDaoMock userDaoMock = new UserDaoMock();
        userDaoMock.findUsers().add(new User("marko", "123", null));
        userDaoMock.findUsers().get(0).setId(1);
        userDaoMock.fetchUser("1");
    }*/

    @Test
    public void test_UserSet() {
        UserDaoMock userDaoMock = new UserDaoMock();
        userDaoMock.findUsers().add(new User("marko", "123", Role.ADMIN));
        userDaoMock.findUsers().get(0).setId(1);
        userDaoMock.fetchUser("1");
    }

    @Test
    public void test_AuthenticateUser() {
        UserDaoMock userDaoMock = new UserDaoMock();
        userDaoMock.findUsers().add(new User("marko", "123", Role.ADMIN));
        userDaoMock.findUsers().get(0).setId(1);
        userDaoMock.authenticateUser("marko", "123");
    }

    @After
    public void tearDown() throws Exception {

    }

}