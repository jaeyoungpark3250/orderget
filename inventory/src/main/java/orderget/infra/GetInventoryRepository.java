package orderget.infra;

import java.util.List;
import orderget.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "getInventories",
    path = "getInventories"
)
public interface GetInventoryRepository
    extends PagingAndSortingRepository<GetInventory, Long> {}
