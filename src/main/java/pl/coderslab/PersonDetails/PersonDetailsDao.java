package pl.coderslab.PersonDetails;

import org.springframework.stereotype.Repository;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void savePersonDetails(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public PersonDetails findById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void deleteById(long id) {
        PersonDetails person = entityManager.find(PersonDetails.class, id);
        entityManager.remove(person);
    }
    public void update(PersonDetails personDetails){
        entityManager.merge(personDetails);
    }
//    public Person updateTitleById(long id, String title) {
//        Person person = entityManager.find(Person.class, id);
//        person.setFirstName(title);
//        return person;
//    }
}