package uni.fmi.week6.ticket.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uni.fmi.week6.ticket.model.User;
import uni.fmi.week6.ticket.service.TicketService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyController {
    //private TicketService ticketService;
    private final List<User> users = new ArrayList<>();

    @GetMapping("/hello-world")
    public String dummyGet() {
        return "dummyGet";
    }

    @GetMapping("/all-users")
    public List<User> getUsers() {
        return users;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        this.users.add(user);
        return user;
    }
}
