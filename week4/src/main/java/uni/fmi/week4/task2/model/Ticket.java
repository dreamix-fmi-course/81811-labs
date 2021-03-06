package uni.fmi.week4.task2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Ticket {
    private Long ticketId;
    private BigDecimal price;
    private int row;
    private int seat;
    private User user;
    private Event event;
}
