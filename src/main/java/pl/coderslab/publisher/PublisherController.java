package pl.coderslab.publisher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public  PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String addPublisher() {
        Publisher publisher = new  Publisher();
        publisher.setName("Daniel");
        publisherDao.savePublisher(publisher);
        return "Id Publisher to :"
                +  publisher.getId();
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        publisherDao.deleteById(id);
        return "deleted";
    }

    @RequestMapping("/publisher/update/{id}/{title}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String title) {
        Publisher publisher =  publisherDao.findById(id);
        publisher.setName(title);
        publisherDao.update(publisher);
        return publisher.toString();
    }
}
