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
        //User blank = new User();
        //System.out.println(blank.toString());
        User user0 = new User("marko", "123", Role.ADMIN);
        user0.setId(1);
        System.out.println(user0.getId());
        User user1 = new User("ivan", "234", Role.NORMAL);
        user1.setId(2);
        User user2 = new User("pero", "789", Role.ADMIN);
        user2.setId(3);
        UserDaoMock userDaoMock = new UserDaoMock();

 /*       if (!user.getPassword().equals("123")) {
            throw new IllegalStateException("kriva lozinka");
        }*/
        /*if(0 == blank.getId() && null == blank.getUsername() && null == blank.getPassword()) {
            throw new IllegalStateException("Korisnik nema sve potrebne podatke");
        }*/
        if (0 == user0.getId() || null == user0.getUsername() || null == user0.getPassword()) {
            throw new IllegalStateException("Korisnik nema sve potrebne podatke");
        }
        userDaoMock.findUsers().add(user0);
        userDaoMock.findUsers().add(user1);
        userDaoMock.findUsers().add(user2);

        //test user0
        String testId = "2";
        if (null == userDaoMock.fetchUser(testId)) {
            throw new IllegalStateException("Korisnika sa tim ID-om nema na popisu");
        }
        //test username and password
        String testUsername = "marko";
        String testPassword = "1243";
        if (!userDaoMock.authenticateUser(testUsername, testPassword)) {
            throw new IllegalStateException("Korisničko ime ili lozinka su pogrešni");
        }
    }


    @After
    public void tearDown() throws Exception {

    }

}