package orderget.external;

import java.util.Date;
import lombok.Data;

@Data
public class Order {

    private Long id;
    private String productId;
    private String productName;
}
