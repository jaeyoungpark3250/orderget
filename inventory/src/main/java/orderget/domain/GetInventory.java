package orderget.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "GetInventory_table")
@Data
public class GetInventory {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
