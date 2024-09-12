package orderget.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@FeignClient(name = "delivery", url = "${api.url.delivery}")
public interface DeliveryService {
    @RequestMapping(method= RequestMethod., path="/deliveries/{id}")
    public void getDelivery(@PathVariable("id") Long id , @RequestBody GetDeliveryCommand getDeliveryCommand );
    @GetMapping(path="/deliveries/search/findByGetDelivery/{id}")
    public Delivery getDelivery(@PathVariable("id") Long id, GetDeliveryQuery getDeliveryQuery);
}