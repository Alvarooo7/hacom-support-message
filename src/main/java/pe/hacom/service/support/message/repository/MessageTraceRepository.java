package pe.hacom.service.support.message.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.hacom.service.support.message.model.MessageTrace;
import reactor.core.publisher.Flux;
import java.time.Instant;


@Repository
public interface MessageTraceRepository extends ReactiveMongoRepository<MessageTrace, String> {
    Flux<MessageTrace> findByTsBetween(Instant from, Instant to);
}

