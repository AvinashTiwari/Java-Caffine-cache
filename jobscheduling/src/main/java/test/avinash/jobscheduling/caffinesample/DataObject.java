package test.avinash.jobscheduling.caffinesample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DataObject {
    private final String data;

    private static int objectCounter = 0;
    private static final Logger log = LoggerFactory.getLogger(DataObject.class);

    public DataObject(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DataObject{" + "data='" + data + '\'' + '}';
    }

    public static DataObject get(String data) {
        objectCounter++;
        log.info("Init DataObject#{} with '{}'", objectCounter, data);
        return new DataObject(data);
    }
}