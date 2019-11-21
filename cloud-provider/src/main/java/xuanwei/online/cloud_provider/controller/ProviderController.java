package xuanwei.online.cloud_provider.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xuanwei.online.cloud_provider.entity.Person;

@RestController
public class ProviderController {
	@RequestMapping(value = "person/{personId}" , method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findPerson(@PathVariable("personId") Integer personId,HttpServletRequest request) {
		Person person = new Person(personId, "本大爷是陆哥", 21);
		person.setMessage(request.getRequestURL().toString());
		return person;
	}
}
