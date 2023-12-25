package test.avinash.jobscheduling.caffinesample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.stats.CacheStats;

@RestController
public class CaffineLoaderController {
	
	@Autowired
	public CacheConfig cc;
	
	  @Autowired
	    private CacheManager cacheManager;
	
	
	@RequestMapping("/checkCacheController")
	 @Cacheable("StudentCache")
	public String checkCache() {
		return "from Cache controller";
	}
	
	@RequestMapping("/cahceData")
	public String loaddataToCache() {
		//Cache<String, DataObject> cache = cc.caffeineCacheBuilderStringkey();
		DataObject dtaObject = new DataObject("Avinash1");
		
		
		cacheManager.getCache("A").put("A", dtaObject);
		
		
		dtaObject = new DataObject("Avinash2");
		cacheManager.getCache("B").put("B", dtaObject);
		 
		dtaObject = new DataObject("Avinash3");
		cacheManager.getCache("C").put("C", dtaObject);
		
		
		
		return "data Added";
	}

	@RequestMapping("/getcahceData")
	public Map<Object, Object>  getcahceData() {
		 org.springframework.cache.Cache cache = cacheManager.getCache("A");
		 org.springframework.cache.Cache cacheB = cacheManager.getCache("B");
	     org.springframework.cache.Cache cacheC = cacheManager.getCache("C");;

		// Map<String, DataObject> dataObjectMap = cache.getAll(Arrays.asList("A", "B", "C"), null);
	     
	     
	     List<String> KeyData = new ArrayList<String>();
	       
	     KeyData.add("A");
	     KeyData.add("B");
	     KeyData.add("C");
	      
	     Map<Object, Object> myMap = new HashMap<Object, Object>(); 
	     for (int i = 0; i < KeyData.size(); i++) {
	            System.out.println(KeyData.get(i));
	        
	     CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache(KeyData.get(i));
	 	Cache<Object, Object> nativeCache = caffeineCache.getNativeCache();
	 	

	 	for (Map.Entry<Object, Object> entry : nativeCache.asMap().entrySet()) {

	 		//System.out.println("Key = " + entry.getKey());
	 		//System.out.println("Value = " + entry.getValue());
	 		myMap.put(entry.getKey(), entry.getValue());
	 	}
	     }
		 
		 return myMap;
	}
	
	@RequestMapping("/getCacheStats")
	public List<cacheInfo> getCacheInfo() {
        return cacheManager.getCacheNames()
            .stream()
            .map(this::getCacheInfo)
            .toList();
    }
	
	 private cacheInfo getCacheInfo(String cacheName) {
	        Cache<Object, Object> nativeCache = (Cache)cacheManager.getCache(cacheName).getNativeCache();
	        Set<Object> keys = nativeCache.asMap().keySet();
	        CacheStats stats = nativeCache.stats();
	        return new cacheInfo(cacheName, keys.size(), keys, stats.toString());
	    }
	  
}
