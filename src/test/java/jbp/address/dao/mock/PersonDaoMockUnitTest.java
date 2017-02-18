package jbp.address.dao.mock;

import jbp.address.domain.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Silver on 9.2.2017..
 */
public class PersonDaoMockUnitTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test_idSet() {
        Person person = new Person(1, "Ivan", "Ivić", null, null, null);
        Person person1 = new Person(2, "Marko", null, null, null, null);
        Person person2 = new Person(3, null, "Perić", null, null, null);
        PersonDaoMock daoPerson = new PersonDaoMock();
        daoPerson.savePerson(person);
        daoPerson.savePerson(person1);
        daoPerson.savePerson(person2);
    }

    @Test
    public void test_personSet() {
        Person person = new Person(1, "Ivan", "Ivić", null, null, null);
        PersonDaoMock daoPerson = new PersonDaoMock();
        daoPerson.savePerson(person);
    }


    @Test
    public void test_fechPerson() {
        Person person = new Person(1, "Ivan", "Ivić", null, null, null);
        PersonDaoMock daoPerson = new PersonDaoMock();
        daoPerson.savePerson(person);
        daoPerson.fetchPerson("1");
    }

    @Test
    public void test_deletePerson() {
        Person person = new Person(1, "Ivan", "Ivić", null, null, null);
        PersonDaoMock daoPerson = new PersonDaoMock();
        daoPerson.savePerson(person);
        daoPerson.deletePerson("1");


    }

    /*    @Test
    public void test_idNotSet() throws IOException {
        boolean notSet = false;
        Person person = new Person(-1, "Ivan", "Ivić", null, null,null);
        PersonDaoMock daoPerson = new PersonDaoMock();
        try {
            daoPerson.savePerson(person);
        } catch(IllegalArgumentException e) {
            notSet = true;
        }
        if (!notSet) throw new IllegalStateException("Test has failed");
    }*/

    @After
    public void tearDown() throws Exception {

    }

}