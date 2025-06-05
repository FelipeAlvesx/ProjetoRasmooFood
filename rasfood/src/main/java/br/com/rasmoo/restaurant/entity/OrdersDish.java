package br.com.rasmoo.restaurant.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders_dish")
public class OrdersDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Dish dish;

    private BigDecimal total;

    private Integer quantity;

    public OrdersDish(Dish dish, Integer quantity) {
        this.dish = dish;
        this.quantity = quantity;
        this.total = dish.getPrice();
    }

    public OrdersDish(){

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrdersDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", total=" + total +
                ", quantity=" + quantity +
                '}';
    }
}
