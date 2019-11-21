package xuanwei.online.first_cloud_provider.healthController;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		if(HealthController.canVisitDb) {
			return new Health.Builder(Status.UP).build();
		}else {
		
			return new Health.Builder(Status.DOWN).build();
		}
	}

}
