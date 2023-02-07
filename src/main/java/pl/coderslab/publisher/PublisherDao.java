package pl.coderslab.publisher;

import org.springframework.stereotype.Repository;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void deleteById(long id) {
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.remove(publisher);
    }
    public void update(Publisher publisher){
        entityManager.merge(publisher);
    }
    public Publisher updateTitleById(long id, String title) {
        Publisher publisher = entityManager.find(Publisher.class, id);
        publisher.setName(title);
        return publisher;
    }
}