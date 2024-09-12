package orderget.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import orderget.OrderApplication;
import orderget.domain.OrderCanceled;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private String productName;

    @PostPersist
    public void onPostPersist() {}

    @PreRemove
    public void onPreRemove() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void placeorder(PlaceorderCommand placeorderCommand) {
        //implement business logic here:

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        orderget.external.GetInventoryQuery getInventoryQuery = new orderget.external.GetInventoryQuery();
        OrderApplication.applicationContext
            .getBean(orderget.external.InventoryService.class)
            .getInventory(getInventoryQuery);
    }

    //>>> Clean Arch / Port Method
    public void cancelorder() {
        //implement business logic here:

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

        orderget.external.GetDeliveryQuery getDeliveryQuery = new orderget.external.GetDeliveryQuery();
        OrderApplication.applicationContext
            .getBean(orderget.external.DeliveryService.class)
            .getDelivery(getDeliveryQuery.getId, getDeliveryQuery);
    }
}
//>>> DDD / Aggregate Root
