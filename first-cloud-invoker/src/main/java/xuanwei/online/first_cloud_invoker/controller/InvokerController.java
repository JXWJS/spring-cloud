package xuanwei.online.first_cloud_invoker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.infix.lang.infix.antlr.EventFilterParser.regex_predicate_return;

@RestController
@Configuration
public class InvokerController {

	/*
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "router" , method = RequestMethod.GET , 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public String router() {
		RestTemplate restIpl = getRestTemplate();
		String json = restIpl.getForObject("http://first-cloud-provider/person/1", String.class);
		return json;
	}
	*/
	
	@Autowired
	private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;
/*	
	@RequestMapping(value = "router", method = RequestMethod.GET)
	public String router() {
		List<ServiceInstance> ins = getServiceInstances();
		for (ServiceInstance service : ins) {
			EurekaServiceInstance esi = (EurekaServiceInstance) service;
			InstanceInfo info = esi.getInstanceInfo();
			System.out.println(info.getAppName () + "---"+ info.getInstanceId()
			+ " --- " + info.getStatus());
		}
		return "";
	}
	*/
	
	private List<ServiceInstance> getServiceInstances(){
		List<String> ids = discoveryClient.getServices();
		List<ServiceInstance> result = new ArrayList<ServiceInstance>();
		for(String id : ids) {
			List<ServiceInstance> ins = discoveryClient.getInstances(id);
			result.addAll(ins);
			}
		return result;
		
	}
	
	@RequestMapping(value = "/router" , method = RequestMethod.GET)
	public String router() {
		System.out.println("*******************************");
		List<ServiceInstance> ins = discoveryClient.getInstances("heart-beat-client");
		for (ServiceInstance service : ins) {
			System.out.println("////////////////////////");
			System.out.println(service.getMetadata().get("company-name"));
		}
		return "";
	}
	
	
	
	
	
}
