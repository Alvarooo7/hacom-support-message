package pe.hacom.service.support.message.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pe.hacom.service.support.message.model.MessageTrace;
import pe.hacom.service.support.message.repository.MessageTraceRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class MessageTraceService {

    private final MessageTraceRepository repository;
    private static final Logger logger = LogManager.getLogger(MessageTraceService.class);

    public Mono<MessageTrace> saveTraceMsg(MessageTrace traceMsg) {
        logger.info("[SAVE MESSAGE] Saving TraceMsg with sessionId: {}", traceMsg.getSessionId());
        return repository.save(traceMsg)
                .doOnSuccess(saved -> logger.info("[SAVE MESSAGE] Success Saving TraceMsg with id: {}", saved.getId()));
    }

    public Flux<MessageTrace> getTraceMsgByDateRange(Instant from, Instant to) {
        logger.info("[GET MESSAGES] Getting Messages by date range from {} to {}", from, to);
        return repository.findByTsBetween(from, to)
                .doOnComplete(() -> logger.info("[GET MESSAGES] Success Getting Messages"));    }
}
