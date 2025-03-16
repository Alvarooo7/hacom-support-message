package pe.hacom.service.support.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trace_messages")
public class MessageTrace {
    @Id
    private String id;
    private String sessionId;
    private String payload;
    private Instant ts;
}

