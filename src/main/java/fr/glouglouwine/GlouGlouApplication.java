package fr.glouglouwine;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class GlouGlouApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlouGlouApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:sql/schema.sql")
                .addScript("classpath:sql/start-data.sql")
                .build();
    }

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
        b.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
        b.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
        return b;
    }
}
