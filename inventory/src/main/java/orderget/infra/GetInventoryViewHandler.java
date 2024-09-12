package orderget.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import orderget.config.kafka.KafkaProcessor;
import orderget.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class GetInventoryViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private GetInventoryRepository getInventoryRepository;
    //>>> DDD / CQRS
}
