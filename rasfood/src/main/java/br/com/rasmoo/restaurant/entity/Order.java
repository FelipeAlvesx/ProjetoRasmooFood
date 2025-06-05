package br.com.rasmoo.restaurant.entity;


import br.com.rasmoo.restaurant.dao.OrderDao;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Client client;

    private BigDecimal price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersDish> ordersDishList = new ArrayList<>();

    @Column(name = "create_order")
    private LocalDateTime createOrder = LocalDateTime.now();

    public Order(Client client) {
        this.client = client;
    }

    public Order(){

    }

    public void addOrderDish(OrdersDish ordersDish){
        ordersDish.setOrder(this);
        this.ordersDishList.add(ordersDish);
        this.price = ordersDish.getTotal().multiply(BigDecimal.valueOf(ordersDish.getQuantity()));
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder(LocalDateTime createOrder) {
        this.createOrder = createOrder;
    }

    public List<OrdersDish> getOrdersDishList() {
        return ordersDishList;
    }

    public void setOrdersDishList(List<OrdersDish> ordersDishList) {
        this.ordersDishList = ordersDishList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", price=" + price +
                ", ordersDishList=" + ordersDishList +
                ", createOrder=" + createOrder +
                '}';
    }
}
