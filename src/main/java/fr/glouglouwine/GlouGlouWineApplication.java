package fr.glouglouwine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication
public class GlouGlouWineApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlouGlouWineApplication.class, args);
    }

    // initialize or not
    @Value("${db.init}")
    public Boolean dbInit;

    @PostConstruct
    public void init() {
        System.out.println("hello");
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

}
