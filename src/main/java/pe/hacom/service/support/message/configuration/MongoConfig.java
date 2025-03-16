package pe.hacom.service.support.message.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import lombok.RequiredArgsConstructor;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.jsr310.Jsr310CodecProvider;
import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@RequiredArgsConstructor
@Configuration
public class MongoConfig {

    private final MongoProperties mongoProperties;

    @Bean
    public MongoClient mongoClient() {
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        CodecRegistry jsr310CodecRegistry = CodecRegistries.fromProviders(new Jsr310CodecProvider());
        CodecRegistry combinedCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, jsr310CodecRegistry);
        String mongoUri = String.format(mongoProperties.getMongodbUri(), mongoProperties.getUsername(), mongoProperties.getPassword());

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUri))
                .codecRegistry(combinedCodecRegistry)
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
        return new ReactiveMongoTemplate(mongoClient, mongoProperties.getMongodbDatabase());
    }
}