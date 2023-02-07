package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void deleteById(long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
    public void update(Person person){
        entityManager.merge(person);
    }
//    public Person updateTitleById(long id, String title) {
//        Person person = entityManager.find(Person.class, id);
//        person.setFirstName(title);
//        return person;
//    }
}