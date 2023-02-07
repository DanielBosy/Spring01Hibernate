package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.PersonDetails.PersonDetails;
import pl.coderslab.PersonDetails.PersonDetailsDao;

@Controller
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public  PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @RequestMapping("/Person/add")
    @ResponseBody
    public String addPerson() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setCity("Rybnik");
        personDetails.setFirstName("Dan");
        personDetails.setLastName("Bosy");
        personDetails.setStreet("Chwałowicka");
        personDetails.setStreetNumber(29);
        personDetailsDao.savePersonDetails(personDetails);

        Person person = new Person();
        person.setPersonDetails(personDetails);

        person.setEmail("Dan@wp.pl");
        person.setLogin("ryb");
        person.setPassword("Lerroy Jenkins");
        personDao.savePerson(person);
        return "preson id :"
                +  person.getId() + person.toString();
    }

//    @RequestMapping("/Person/get/{id}")
//    @ResponseBody
//    public String getPerson(@PathVariable long id) {
//        Person person = PersonDao.findById(id);
//        return person.toString();
//    }
//
//    @RequestMapping("/publisher/delete/{id}")
//    @ResponseBody
//    public String deletePublisher(@PathVariable long id) {
//        publisherDao.deleteById(id);
//        return "deleted";
//    }
//
//    @RequestMapping("/publisher/update/{id}/{title}")
//    @ResponseBody
//    public String updatePublisher(@PathVariable long id, @PathVariable String title) {
//        Publisher publisher =  publisherDao.findById(id);
//        publisher.setName(title);
//        publisherDao.update(publisher);
//        return publisher.toString();
//    }
}
