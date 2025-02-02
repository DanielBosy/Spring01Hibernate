package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void deleteById(long id) {
       Book book = entityManager.find(Book.class, id);
       entityManager.remove(book);
    }
    public void update(Book book){
        entityManager.merge(book);
    }
    public Book updateTitleById(long id, String title) {
        Book book = entityManager.find(Book.class, id);
        book.setTitle(title);
        return book;
    }
}