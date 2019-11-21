package xuanwei.online.first_ribbon_server;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	public static void main(String args[]) {
	 Scanner scan = new Scanner(System.in);
     String port = scan.nextLine();
     new SpringApplicationBuilder(App.class).properties("server.port=" + port).run(args);
 }
}
