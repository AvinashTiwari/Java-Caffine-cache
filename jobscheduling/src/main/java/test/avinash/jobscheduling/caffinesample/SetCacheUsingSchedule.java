package test.avinash.jobscheduling.caffinesample;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
//@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class SetCacheUsingSchedule {
	
	 @Autowired
	    private CacheManager cacheManager;
	
	 static int count =0;
	 
	@Scheduled(fixedDelay = 10000)
	public void  computePrice() {
		LocalTime myObj = LocalTime.now();
		
DataObject dtaObject = new DataObject("Avinash1" + myObj);
		
		
		cacheManager.getCache("A").put("A", dtaObject);
		
		
		dtaObject = new DataObject("Avinash2 " + myObj);
		cacheManager.getCache("B").put("B", dtaObject);
		 
		dtaObject = new DataObject("Avinash3 " + myObj);
		cacheManager.getCache("C").put("C", dtaObject);
		
		int valueData = count = count +1;
		System.out.println("Count happed at " + valueData);
		 
	}


}
