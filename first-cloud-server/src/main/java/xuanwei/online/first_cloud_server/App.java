package xuanwei.online.first_cloud_server;

import java.util.Scanner;

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
        // 读取控制台输入，决定使用哪个profiles
    	Scanner scan = new Scanner(System.in);
    	String profiles = scan.nextLine();
    	new  SpringApplicationBuilder(App.class).profiles(profiles).run(args);
    }
}
