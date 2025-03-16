package pe.hacom.service.support.message.controller;


import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.hacom.service.support.message.model.MessageTrace;
import pe.hacom.service.support.message.model.MessageTraceRequest;
import pe.hacom.service.support.message.service.MessageTraceService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
class MessageController {
    private static final Logger logger = LogManager.getLogger(MessageController.class);
    private final MessageTraceService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public Mono<MessageTrace> createTraceMessage(@RequestBody MessageTrace traceMsg) {
        logger.info("[SAVE MESSAGE] Received request to create TraceMsg");
        return service.saveTraceMsg(traceMsg);
    }

    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public Flux<MessageTrace> getMessagesByDateRange(@Valid @RequestBody MessageTraceRequest request) {
        logger.info("[GET MESSAGES] Received request to get messages by date range from {} to {}",
                request.getFrom().toString(), request.getTo().toString());
        return service.getTraceMsgByDateRange(request.getFrom(), request.getTo());
    }
}
