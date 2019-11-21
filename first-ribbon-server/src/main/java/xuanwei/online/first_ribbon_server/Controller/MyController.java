package xuanwei.online.first_ribbon_server.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xuanwei.online.first_ribbon_server.entity.Person;

@RestController
public class MyController {
	
	@RequestMapping(value = "/person/{personId}" , method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findPerson(@PathVariable("personId") Integer personId,HttpServletRequest request) {
		Person p =new Person();
		p.setId(personId);
		p.setName("Crazyit");
		p.setAge(30);
		p.setMessage(request.getRequestURI().toString() + ":port"+ request.getServerPort());
		return p;
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
}
