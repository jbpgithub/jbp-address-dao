package jbp.address.dao;

import jbp.address.domain.Person;

import java.util.List;

/**
 * Created by Silver on 3.2.2017..
 */
public interface PersonDao {

    public Person fetchPerson(final String id);

    public List<Person> findUsers();

    //public boolean authenticateUser(final String username, final String password);
}
