package labs.lab1.streams;

import labs.lab1.entity.Order;
import labs.lab1.entity.OrderLine;
import labs.lab1.entity.User;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchExercise {
    /**
     * extract all active orders
     *
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        return user.getOrders().stream()
            .filter(Order::isActive)
            .collect(Collectors.toList());
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        List<Order> result = new LinkedList<>();
        List<Order> userOrders = user.getOrders();
        for (Order order : userOrders) {
            if (order.isActive()) {
                result.add(order);
            }
        }

        return result;
    }

    /**
     * Return order by a specific id
     *
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderById(List<Order> orders, long orderId) {
        if (orders == null) {
            throw new IllegalArgumentException("orders cannot be null");
        }

        return orders.stream()
            .filter(o -> o.getId() == orderId)
            .findAny()
            .orElse(null);
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        if (orders == null) {
            throw new IllegalArgumentException("orders cannot be null");
        }

        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }

        return null;
    }

    /**
     * Return orders that have specific description for item
     *
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        if (user == null || description == null) {
            throw new IllegalArgumentException("orders or description cannot be null");
        }

        if (description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be an empty string");
        }

        return user.getOrders().stream()
            .filter(o -> hasItemWithDescription(o.getOrderLines(), description))
            .collect(Collectors.toList());
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        return user.getOrders().stream().anyMatch(Order::isActive);
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order cannot be null");
        }

        return order.getOrderLines().stream().noneMatch(OrderLine::isSpecialOffer);
    }

    /**
     * Return the order with maximum total price
     *
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        return user.getOrders().stream()
            .max(Comparator.comparing(Order::getTotalPrice));
    }

    private boolean hasItemWithDescription(List<OrderLine> orderLines, String description) {
        if (orderLines == null || description == null) {
            throw new IllegalArgumentException("orders or description cannot be null");
        }

        if (description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be an empty string");
        }

        return orderLines.stream()
            .anyMatch(orderLine -> orderLine.getItem().getDescription().equals(description));
    }
}
