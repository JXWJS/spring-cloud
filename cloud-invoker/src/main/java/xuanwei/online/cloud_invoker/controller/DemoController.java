package xuanwei.online.cloud_invoker.controller;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

@RestController
@Configuration
public class DemoController {
	
	@Autowired
	private SpringClientFactory factory;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/router", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String router() {
		RestTemplate restTpl = getRestTemplate();
		String json = restTpl.getForObject("http://cloud-provider/person/1", String.class);
		/*Map<String ,String> maps = new HashedMap();
		maps.put("name", "lxw");
		maps.put("age", "21"); */
		return json;
	}
	
	@RequestMapping(value="/defaultValue", method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String defaultValue() {
		System.out.println("输出默认配置");
		
		ZoneAwareLoadBalancer alb = (ZoneAwareLoadBalancer) factory.getLoadBalancer("cloud-provider");
		System.out.println(factory.getLoadBalancer("default").getClass().getName());
		System.out.println(alb.getRule().getClass().getName());
		System.out.println(alb.getPing().getClass());
		System.out.println(alb.getServerListImpl().getClass().getName());
		return " ";
	}
	
}
