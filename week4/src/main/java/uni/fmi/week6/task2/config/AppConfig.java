package uni.fmi.week6.task2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties(prefix = "config")
@Configuration
@Data
public class AppConfig {
    private final LoggerConfig logger = new LoggerConfig();

    private final EventConfig eventConfig = new EventConfig();

    public LoggerConfig getLogger() {
        return logger;
    }

    public EventConfig getEvent() {
        return eventConfig;
    }

    @Data
    @ConfigurationProperties(prefix = "logger")
    public static class LoggerConfig {
        private String level;
    }

    @Data
    @ConfigurationProperties(prefix = "event")
    public static class EventConfig {
        private int maximumRows;
        private int minimumRows;

        //@Value("#{'${config.event.names}'.split(',')}");
        private List<String> names;
        private List<String> descriptions;
    }
}
