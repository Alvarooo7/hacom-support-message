package pe.hacom.service.support.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Validated
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageTraceRequest {
    @NotNull
    private Instant from;

    @NotNull
    private Instant to;
}