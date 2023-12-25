package test.avinash.jobscheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSpringController {
	@Autowired
	public loopEngline le;
	@RequestMapping("/hello")
	public String hello() {
		return "helo world";
	}
	
	@RequestMapping("/getCount")
	public String getCount() {
		return "Count is " +String.valueOf(le.returnCountData());
	}

}
