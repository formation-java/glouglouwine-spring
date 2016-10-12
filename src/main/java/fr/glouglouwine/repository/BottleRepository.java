package fr.glouglouwine.repository;

import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.domain.GrapeTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
            return new Bottle(resultSet.getLong("id"), resultSet.getString("owner"),
                    GrapeTypes.valueOf(resultSet.getString("grape_type")), resultSet.getString("domain_name"),
                    resultSet.getString("year"), resultSet.getInt("quantity"),
                    resultSet.getTimestamp("opening_date").toLocalDateTime(),
                    // TODO talk
                    finishingDate != null ? finishingDate.toLocalDateTime() : null);
        }
    }

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
        return jdbcTemplate.query("SELECT * FROM bottle", bottleMapper);
    }
}

