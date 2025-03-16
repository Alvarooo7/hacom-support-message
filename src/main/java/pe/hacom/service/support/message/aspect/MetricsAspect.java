package pe.hacom.service.support.message.aspect;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricsAspect {

    private final Counter insertCounter;

    public MetricsAspect(MeterRegistry meterRegistry) {
        this.insertCounter = Counter.builder("hacom.test.developer.insert.rx")
                .description("Number insertions messages")
                .register(meterRegistry);
    }

    @AfterReturning("execution(* pe.hacom.service.support.message.service.MessageTraceService.saveTraceMsg(..))")
    public void incrementCounter() {
        insertCounter.increment();
    }
}

