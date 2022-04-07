package uni.fmi.week4.task2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {
    private Long eventId;
    private String name;
    private LocalDateTime date;
    private String description;
}
