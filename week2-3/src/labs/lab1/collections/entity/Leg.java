package labs.lab1.collections.entity;

import java.time.LocalDate;

public class Leg {
    private final String fromAirport;
    private final String toAirport;
    private final LocalDate date;

    public Leg(String fromAirport, String toAirport, LocalDate date) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.date = date;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Leg{" +
               "fromAirport='" + fromAirport + '\'' +
               ", toAirport='" + toAirport + '\'' +
               ", date=" + date +
               '}';
    }
}
