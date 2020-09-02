package info.vziks.api.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Class ScheduledTasks
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/45 * * * * *", zone = "Europe/Moscow")
    public void cronReportCurrentTime() {
        log.info("The cron time is now {}", dateFormat.format(new Date()));
    }


    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        log.info(
                "Fixed rate task with one second initial delay - " + now);
    }
}
