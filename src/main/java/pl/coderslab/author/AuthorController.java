package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("Daniel");
        author.setLastName("worth");
        authorDao.saveAuthor(author);
        return "Id Author to :"
                + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        authorDao.deleteById(id);
        return "deleted";
    }

    @RequestMapping("/author/update/{id}/{title}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String title) {
        Author author =  authorDao.findById(id);
        author.setFirstName(title);
        authorDao.update(author);
        return author.toString();
    }
}
