package labs.lab1.entity;

import labs.lab1.vo.OrderLineStatus;

/**
 * Create OrderLine which holds information for:
 * Item, enum for status, boolean specialOffer and count
 * Implement setters/getters/constructor
 */
public class OrderLine {
    private Item item;
    private OrderLineStatus orderLineStatus;
    private boolean specialOffer;
    private int count;

    public OrderLine(Item item, OrderLineStatus orderLineStatus, boolean specialOffer, int count) {
        this.item = item;
        this.orderLineStatus = orderLineStatus;
        this.specialOffer = specialOffer;
        this.count = count;
    }

    public OrderLine(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderLineStatus getOrderLineStatus() {
        return orderLineStatus;
    }

    public void setOrderLineStatus(OrderLineStatus orderLineStatus) {
        this.orderLineStatus = orderLineStatus;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
