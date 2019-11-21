package xuanwei.online.cloud_invoker.util;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyPing implements IPing {

	@Override
	public boolean isAlive(Server server) {
		// TODO Auto-generated method stub
		System.out.println("自定义ping类,服务器信息：" + server.getHostPort());
		return true;
	}

}
