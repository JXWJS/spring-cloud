package xuanwei.online.cloud_invoker.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;

import xuanwei.online.cloud_invoker.util.MyPing;
import xuanwei.online.cloud_invoker.util.MyRule;

public class MyConfig {
	
	@Bean
	public IRule getRule() {
		return new MyRule();
	}
	
	@Bean 
	public IPing getPing() {
		return new MyPing();
	}
	
	
}
