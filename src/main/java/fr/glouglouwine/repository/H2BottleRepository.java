package fr.glouglouwine.repository;

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
public class H2BottleRepository implements BottleRepository {

    class BottleMapper implements RowMapper<Bottle> {
        @Override
        public Bottle mapRow(ResultSet resultSet, int i) throws SQLException {
            Timestamp finishingDate = resultSet.getTimestamp("finishing_date");
            return new Bottle(resultSet.getLong("id"), resultSet.getString("owner"),
                    GrapeTypes.valueOf(resultSet.getString("grape_type")), resultSet.getString("domain_name"),
                    resultSet.getInt("year"), resultSet.getInt("quantity"),
                    resultSet.getTimestamp("opening_date").toLocalDateTime(),
                    finishingDate != null ? finishingDate.toLocalDateTime() : null);
        }
    }

    @Inject
    private JdbcTemplate jdbcTemplate;

    private BottleMapper bottleMapper = new BottleMapper();

    @Override
    public void addBlotte(Bottle bottle) {
        //        if(bottle.getOwner().equals("Eric")) {
        //            throw new RuntimeException("Eric can't drink");
        //        }
        jdbcTemplate.update("INSERT INTO bottle (owner, grape_type, domain_name, year, quantity, opening_date) " +
                        "VALUES (?, ?, ?, ?, ? , ?);", bottle.getOwner(), bottle.getGrapeType().name(), bottle.getDomain(),
                bottle.getYear(), bottle.getQuantity(), Timestamp.valueOf(bottle.getOpeningDate()));
    }

    @Override
    public List<Bottle> fetchAll() {
        return jdbcTemplate.query("SELECT * FROM bottle", bottleMapper);
    }
}

