package labs.lab1.entity;

import labs.lab1.vo.OrderStatus;
import labs.lab1.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Create class Order that implements
 * id, status:OrderStatus, List<OrderLine> orderLines, creationDate, totalPrice, paymentMethod,
 * deliveryDueDate, user
 * <p>
 * Implements constructors: default, by status, by id, by array of lines (use ...)
 * getters, setters, toString, isActive
 */
public class Order {
    private long id;
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

    public Order(long id, OrderStatus orderStatus, OrderLine... orderLines) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.orderLines = Arrays.stream(orderLines).collect(Collectors.toList());
    }

    public Order(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(long id) {
        this.id = id;
    }

    public Order(OrderLine... orderLines) {
        this.orderLines = Arrays.stream(orderLines).collect(Collectors.toList());
    }

    public Order(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDeliveryDueDate() {
        return deliveryDueDate;
    }

    public void setDeliveryDueDate(LocalDate deliveryDueDate) {
        this.deliveryDueDate = deliveryDueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return orderStatus.equals(OrderStatus.ACTIVE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
               "ig='" + id + '\'' +
               ", orderStatus=" + orderStatus +
               ", orderLines=" + orderLines +
               ", creationDate=" + creationDate +
               ", totalPrice=" + totalPrice +
               ", paymentMethod=" + paymentMethod +
               ", deliveryDueDate=" + deliveryDueDate +
               ", user=" + user +
               ", isActive=" + isActive +
               '}';
    }
}
