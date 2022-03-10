package labs.lab1.entity;

import labs.lab1.vo.OrderStatus;
import labs.lab1.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Create class Order that implements
 * id, status:OrderStatus, List<OrderLine> orderLines, creationDate, totalPrice, paymentMethod,
 * deliveryDueDate, user
 *
 * Implements constructors: default, by status, by id, by array of lines (use ...)
 * getters, setters, toString, isActive
 */
public class Order {
    private String ig;
    private OrderStatus orderStatus;
    private List<OrderLine> orderLines;
    private LocalDate creationDate;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private LocalDate deliveryDueDate;
    private User user;
    private boolean isActive;

    public Order() {
    }

    public Order(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(String ig) {
        this.ig = ig;
    }
}
