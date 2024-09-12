package orderget.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceorderCommand {

    private Long id;
    private String productId;
    private String productName;
}
