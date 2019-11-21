package xuanwei.online.first_cloud_provider;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        String port = scan.nextLine();
        new SpringApplicationBuilder(App.class).properties("server.port=" + port).run(args);
    }
}
