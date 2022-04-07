package labs.lab1.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create a class User with list of orders
 */
public class User {
    private final List<Order> orders;

    public User(Order... orders) {
        this.orders = Arrays.stream(orders).collect(Collectors.toList());
    }

    public List<Order> getOrders() {
        return orders;
    }
}
