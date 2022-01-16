package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogTest {

    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
        System.out.println("测试log4j");
        log.trace("--------trace---------");
        log.info("---------Info---------");
        log.warn("---------warn---------");
        log.debug("--------debug---------");
        log.error("--------error---------");
    }
}
