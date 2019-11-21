package xuanwei.online.first_euraka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class App 
{
    public static void main( String[] args )
    {
      new SpringApplicationBuilder(App.class).run(args);
    }
}
