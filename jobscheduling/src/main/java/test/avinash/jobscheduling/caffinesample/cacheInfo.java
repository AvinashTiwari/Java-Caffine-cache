package test.avinash.jobscheduling.caffinesample;

import java.util.Set;

public class cacheInfo {
	public  String name;
	public int size; 
	public Set<Object> keys; 
	public String stats;
	cacheInfo(String name, int size, Set<Object> keys, String stats){
		this.name = name;
		this.size = size;
		this.keys = keys; 
		this.stats = stats;
	}
	
}
