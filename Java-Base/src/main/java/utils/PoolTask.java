package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PoolTask {
    public static void main(String[] args) {
        PoolTask.poolTask();
    }

    //按固定频率调度的任务，创建了10个核心线程数，首次执行延迟2秒，后续每3秒执行一次
    public static void poolTask(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("我要发财 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
        }, 2000, 3000, TimeUnit.MILLISECONDS);
    }
}
