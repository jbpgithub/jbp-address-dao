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

    @Test
    public void test_personDaoListSize() {
        PersonDaoMock daoPerson = new PersonDaoMock();
        daoPerson.savePerson(new Person(1, "Ivan", "Ivić", null, null, null));
        daoPerson.savePerson(new Person(2, "Marko", null, null, null, null));
        daoPerson.savePerson(new Person(3, null, "Perić", null, null, null));
        daoPerson.deletePerson("1");
        if(2 != daoPerson.findPersons().size()) {
            throw new IllegalStateException("Number of person in list is not expected size.");
        }
    }

    @Test
    public void test_fechPersonData() {
        Person person = new Person(1, "Ivan", "Ivić", null, null, null);
        PersonDaoMock daoPerson = new PersonDaoMock();
        daoPerson.savePerson(person);
        if(!("Ivan").equals(daoPerson.fetchPerson("1").getFirstName())) {
            throw new IllegalStateException("Error fetched person is not expected.");
        }
    }

    @After
    public void tearDown() throws Exception {

    }

}