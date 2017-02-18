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
    public void userDaoMock() {

        User user0 = new User("marko", "123", Role.ADMIN);
        user0.setId(1);
        System.out.println(user0.getId());
        User user1 = new User("ivan", "234", Role.NORMAL);
        user1.setId(2);
        User user2 = new User("pero", "789", Role.ADMIN);
        user2.setId(3);
        UserDaoMock userDaoMock = new UserDaoMock();

        if (0 == user0.getId() || null == user0.getUsername() || null == user0.getPassword()) {
            throw new IllegalArgumentException("Korisnik nema sve potrebne podatke");
        }
        userDaoMock.findUsers().add(user0);
        userDaoMock.findUsers().add(user1);
        userDaoMock.findUsers().add(user2);

        //test user0
        String testId = "3";
        if (null == userDaoMock.fetchUser(testId)) {
            throw new IllegalStateException("Korisnika sa tim ID-om nema na popisu");
        }
        //test username and password
        String testUsername = "marko";
        String testPassword = "123";
        if (!userDaoMock.authenticateUser(testUsername, testPassword)) {
            throw new IllegalArgumentException("Korisničko ime ili lozinka su pogrešni");
        }
    }


    @After
    public void tearDown() throws Exception {

    }

}