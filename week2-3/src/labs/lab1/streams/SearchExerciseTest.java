package labs.lab1.streams;

import labs.lab1.entity.Order;
import labs.lab1.entity.OrderLine;
import labs.lab1.entity.User;
import labs.lab1.vo.OrderStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchExerciseTest {
    private final SearchExercise service = new SearchExercise();

    @Test
    public void getActiveOrdersTest() {
        String assertMessage = "getActiveOrders does not find the correct orders";

        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order2 = new Order(OrderStatus.ACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2, order3);
        //assertEquals(Arrays.asList(order1, order2), service.getActiveOrders(user), assertMessage);
        assertIterableEquals(Arrays.asList(order1, order2), service.getActiveOrders(user), assertMessage);
    }

    @Test
    public void getOrderByIdTest() {
        String assertMessage = "getOrderById does not return the correct order";

        Order expected = new Order(3);
        List<Order> orders = List.of(new Order(1), new Order(2), new Order(3), new Order(4));
        Order actual = service.getOrderById(orders, 3);
        assertEquals(expected, actual, assertMessage);

    }

    @Test
    public void getOrderByIdTest_When_id_not_found_Then_return_null() {
        String assertMessage =
            "getOrderById is expected to return null when an order with the given id is not present";

        List<Order> orders = List.of(new Order(1), new Order(2), new Order(3), new Order(4));
        assertNull(service.getOrderById(orders, 5), assertMessage);
    }

    @Test
    public void hasActiveOrdersTest_true() {
        String assertMessage =
            "hasActiveOrders does not work correctly when there is an active order in the list";

        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order2 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2);
        assertTrue(service.hasActiveOrders(user), assertMessage);
    }

    @Test
    public void hasActiveOrdersTest_When_inactive_Then_return_false() {
        String assertMessage =
            "hasActiveOrders is expected to return false when there is no active order in the list";

        Order order1 = new Order(OrderStatus.INACTIVE);
        Order order2 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2);
        assertFalse(service.hasActiveOrders(user), assertMessage);
    }

    @Test
    public void canBeReturnedTest_When_no_items_Then_return_true() {
        String assertMessage =
            "canBeReturned does not work properly when there is no order line with a special offer";

        OrderLine orderLine1 = new OrderLine(false);
        OrderLine orderLine2 = new OrderLine(false);
        OrderLine orderLine3 = new OrderLine(false);
        Order order = new Order(orderLine1, orderLine2, orderLine3);

        assertTrue(service.canBeReturned(order), assertMessage);
    }

    @Test
    public void canBeReturnedTest_When_item_have_SO_Then_return_false() {
        String assertMessage =
            "canBeReturned is expected to return false when there is an order line with a special offer";

        OrderLine orderLine1 = new OrderLine(true);
        OrderLine orderLine2 = new OrderLine(true);
        OrderLine orderLine3 = new OrderLine(false);
        Order order = new Order(orderLine1, orderLine2, orderLine3);

        assertFalse(service.canBeReturned(order), assertMessage);
    }

    @Test
    public void getMaxPriceOrderTest() {
        String assertMessage = "getMaxPrice does not calculate the max price properly";

        Order order1 = new Order(BigDecimal.valueOf(3.5));
        Order order2 = new Order(BigDecimal.valueOf(0.5));
        Order order3 = new Order(BigDecimal.valueOf(100));
        User user = new User(order1, order2, order3);

        Optional<Order> expected = Optional.of(order3);
        Optional<Order> actual = service.getMaxPriceOrder(user);
        assertEquals(expected, actual, assertMessage);
    }

    @Test
    public void getMaxPriceOrderTest_When_no_orders_Then_return_nothing() {
        User user = new User();
        assertTrue(service.getMaxPriceOrder(user).isEmpty());
    }
}
