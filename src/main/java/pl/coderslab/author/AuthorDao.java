package pl.coderslab.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void deleteById(long id) {
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
    }
    public void update(Author author){
        entityManager.merge(author);
    }
    public Author updateTitleById(long id, String title) {
        Author author = entityManager.find(Author.class, id);
        author.setFirstName(title);
        return author;
    }
}