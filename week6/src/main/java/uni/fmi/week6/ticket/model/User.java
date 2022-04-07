package uni.fmi.week6.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String email;
}
