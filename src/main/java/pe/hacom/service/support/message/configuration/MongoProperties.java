package pe.hacom.service.support.message.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "mongodb")
public class MongoProperties {

    private String mongodbUri;
    private String mongodbDatabase;
    private String username;
    private String password;
}
