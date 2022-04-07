package uni.fmi.week6.task2.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import uni.fmi.week6.task2.config.AppConfig;

@Component
@Profile("local")
public class LoggerStdoutImpl implements Logger {

    /*@Value("${config.logger.level}")
    private String logLevel;*/

    @Autowired
    private AppConfig appConfig;

    @Value("${config.event.maximum_rows}")
    private int maxRows;

    @Override
    public void info(Object toLog) {
        System.out.println(toLog);
        System.out.println(appConfig.getLogger().getLevel());

        System.out.println(maxRows);
        System.out.println(appConfig.getEvent().getMaximumRows());
    }

    @Override
    public void debug(Object toLog) {

    }

    @Override
    public void trace(Object toLog) {

    }

    @Override
    public void error(Object toLog) {

    }
}
