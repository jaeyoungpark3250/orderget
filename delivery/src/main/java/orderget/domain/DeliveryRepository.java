package orderget.domain;

import java.util.Date;
import java.util.List;
import orderget.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deliveries",
    path = "deliveries"
)
public interface DeliveryRepository
    extends PagingAndSortingRepository<Delivery, Long> {
    @Query(
        value = "select delivery " +
        "from Delivery delivery " +
        "where(:id is null or delivery.id = :id) and (:orderId is null or delivery.orderId like %:orderId%) and (:productId is null or delivery.productId like %:productId%) and (:productName is null or delivery.productName like %:productName%)"
    )
    Delivery findByGetDelivery(
        Long id,
        String orderId,
        String productId,
        String productName
    );
}
