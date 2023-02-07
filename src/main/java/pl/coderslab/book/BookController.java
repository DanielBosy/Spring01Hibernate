package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherDao;

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao ;
    public BookController(BookDao bookDao, PublisherDao publisherDao,AuthorDao authorDao ) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }
    @RequestMapping("/book/add")
    @ResponseBody
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Dan");
        publisherDao.savePublisher(publisher);
        Author author1 = authorDao.findById(1);
        Author author2 = authorDao.findById(2);
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("worth");
        book.setPublisher(publisher);
        book.getAuthors().add(author1);
        book.getAuthors().add(author2);
        bookDao.saveBook(book);
        return "book Id is :"
                + book.getId();
    }
    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }
    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        bookDao.deleteById(id);
        return "deleted";
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
//        Book book = bookDao.updateTitleById(id, title);
        return book.toString();
    }
}

