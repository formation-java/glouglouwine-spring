package fr.glouglouwine;

import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.domain.GrapeTypes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class BottleRepository {

    class BottleMapper implements RowMapper<Bottle> {

        @Override
        public Bottle mapRow(ResultSet resultSet, int i) throws SQLException {
            Timestamp finishingDate = resultSet.getTimestamp("finishing_date");
            return new Bottle(resultSet.getInt("id"), resultSet.getString("owner"),
                    GrapeTypes.valueOf(resultSet.getString("grape_type")), resultSet.getString("domain_name"),
                    resultSet.getString("year"), resultSet.getInt("quantity"),
                    resultSet.getTimestamp("opening_date").toLocalDateTime(),
                    finishingDate != null ? finishingDate.toLocalDateTime() : null);
        }
    }

    private final BottleMapper bottleMapper = new BottleMapper();

    @Inject
    private JdbcTemplate jdbcTemplate;

    public void addBottle(Bottle bottle) {
        if(bottle.getOwner().equals("Eric")) {
            throw new RuntimeException("Eric shouldn't drink");
        }
        jdbcTemplate.update("insert into bottle (owner, grape_type, domain_name, opening_date) values (?, ?, ?, ?);",
                bottle.getOwner(), bottle.getGrapeType().name(), bottle.getDomain(),
                Timestamp.valueOf(bottle.getOpeningDate()));
    }

    public List<Bottle> fetchAll() {
        return jdbcTemplate.query("SELECT * FROM bottle", bottleMapper);
    }
}
