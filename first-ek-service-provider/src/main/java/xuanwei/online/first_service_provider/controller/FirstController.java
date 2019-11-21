package xuanwei.online.first_service_provider.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xuanwei.online.first_service_provider.entity.Person;

@RestController
public class FirstController {
	
	@RequestMapping(value = "person/{personId}", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findPerson(@PathVariable("personId") Integer personId) {
		Person person = new Person(personId, "luxuanwei", 21);
		return person;
	}
}
