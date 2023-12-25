package test.avinash.jobscheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.Console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class loopEngline {
static int count =0;
 
public int returnCountData () {
	return count;
}

//@Scheduled(fixedDelay = 2000)
public void  computePrice() {
	int valueData = count = count +1;
	System.out.println("Count happed at " + valueData);
	 
}



}
