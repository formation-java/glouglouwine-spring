package fr.glouglouwine;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class GlouGlouWineApplication implements ServletContextInitializer {

    private static final Logger logger = LoggerFactory.getLogger(GlouGlouWineApplication.class);

    // initialize or not
    @Value("${db.init}")
    public Boolean dbInit;

    public static void main(String[] args) {
        SpringApplication.run(GlouGlouWineApplication.class, args);
    }

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
        b.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
        b.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
        return b;
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:sql/schema.sql");
        if (dbInit) {
            edb.addScript("classpath:sql/start-data.sql");
        }
        return edb.build();
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // FIXME si je remove la conf ?
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/h2-console/*");
        h2ConsoleServlet.setInitParameter("-properties", "src/main/resources/");
        h2ConsoleServlet.setLoadOnStartup(1);
    }
}
