package fr.glouglouwine;

import fr.glouglouwine.domain.Bottle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class BottleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BottleMapper bottleMapper = new BottleMapper();

    public void addBlotte(Bottle bottle) {
        jdbcTemplate.update("INSERT INTO bottle (owner, grape_type, domain_name, year, quantity, opening_date) " +
                "VALUES (?, ?, ?, ?, ? , ?);", bottle.getOwner(), bottle.getGrapeType().name(), bottle.getDomain(),
                bottle.getYear(), bottle.getQuantity(), Timestamp.valueOf(bottle.getOpeningDate()));
    }

    public List<Bottle> fetchAll() {
        // TODO le faire en prepared statement
        return jdbcTemplate.query("select * from bottle", bottleMapper);
    }
}

