package jbp.address.dao;

import jbp.address.domain.Person;

import java.io.IOException;
import java.util.List;

/**
 * Created by Silver on 3.2.2017..
 */
public interface PersonDao {

    public Person fetchPerson(final String id);

    public List<Person> findPersons();

    public String savePerson(final Person person) throws IOException;

    public void deletePerson (final String id);
}
