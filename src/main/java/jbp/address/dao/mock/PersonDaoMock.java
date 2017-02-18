package jbp.address.dao.mock;

import jbp.address.dao.PersonDao;
import jbp.address.domain.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silver on 3.2.2017..
 */
public class PersonDaoMock implements PersonDao {

    private List<Person> personList;

    public PersonDaoMock() {
        this.personList = new ArrayList<Person>();
    }

    //interface
    public List<Person> findPersons() {
        return this.personList;
    }

    public String savePerson(final Person person) {
        if (person == null) throw new IllegalArgumentException("person must not be null");
        if (person.getId() <= 0) throw new IllegalArgumentException("id must not bee zero or less then zero");
        if ((person.getFirstName() == null || person.getFirstName().length() == 0) && (person.getLastName() == null || person.getLastName().length() == 0)) throw new IllegalArgumentException("firstName or last name must not bee null or empty");

        boolean personExist = false;
        for (Person personItem : this.personList) {
            if (person.getId() == personItem.getId()) {
                personExist = true;
                throw  new IllegalStateException("person with that id already exist");
                //break;
            }
        }
        if (!personExist) this.personList.add(person);
        return person.getId() + "";
    }

    public Person fetchPerson(final String id) {
        try {
            Integer.parseInt( id );
        }
        catch( Exception e ) {
            throw new IllegalArgumentException("id can not contain a letter");
        }
        if(1 > Integer.parseInt(id)) throw new IllegalArgumentException("id must bee number greater than zero");
        int testId = Integer.parseInt(id);
        Person testPerson = null;
        for (Person person : findPersons()) {
            if (testId == person.getId()) {
                testPerson = person;
                break;
            }
        }
        if(testPerson == null) throw new IllegalArgumentException("person with that id does not exist");
        return testPerson;
    }

    public void deletePerson(final String id) {
        Person testPerson = fetchPerson(id);
        if(null == testPerson) throw new IllegalStateException("person with that id does not exist");
        personList.remove(testPerson);
    }

}
