package uni.fmi.week6.task2.logger;

public interface Logger {
    void info(Object toLog);

    void debug(Object toLog);

    void trace(Object toLog);

    void error(Object toLog);
}
