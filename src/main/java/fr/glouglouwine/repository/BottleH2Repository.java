package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class BottleH2Repository implements BottleRepository {

    class BottleMapper implements RowMapper<Bottle> {
        @Override
        public Bottle mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Bottle(resultSet.getLong("id"), resultSet.getString("owner"),
                    resultSet.getString("domain"),
                    resultSet.getTimestamp("opening_date").toLocalDateTime());
        }
    }

    private final BottleMapper bottleMapper = new BottleMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Bottle bottle) {
        jdbcTemplate.update("INSERT INTO bottle (owner, domain, opening_date) VALUES (?, ?, ?);",
                bottle.getOwner(), bottle.getDomain(), Timestamp.valueOf(bottle.getOpeningDate()));
    }

    @Override
    public Bottle get(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM bottle WHERE id = ?", new Object[]{id}, bottleMapper);
    }

    @Override
    public List<Long> getAll() {
        return jdbcTemplate.queryForList("SELECT id FROM bottle", Long.class);
    }
}
