package mix.scheduler;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * cron：通过cron表达式来配置执行规则
 * zone：cron表达式解析时使用的时区
 * fixedDelay：上一次执行结束到下一次执行开始的间隔时间（单位：ms）
 * fixedDelayString：上一次任务执行结束到下一次执行开始的间隔时间，使用java.time.Duration#parse解析
 * fixedRate：以固定间隔执行任务，即上一次任务执行开始到下一次执行开始的间隔时间（单位：ms），若在调度任务执行时，上一次任务还未执行完毕，会加入worker队列，等待上一次执行完成后立即执行下一次任务
 * fixedRateString：与fixedRate逻辑一致，只是使用java.time.Duration#parse解析
 * initialDelay：首次任务执行的延迟时间
 * initialDelayString：首次任务执行的延迟时间，使用java.time.Duration#parse解析
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000) //每隔5秒执行一次
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
