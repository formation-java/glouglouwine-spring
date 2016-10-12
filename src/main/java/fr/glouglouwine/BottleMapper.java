package fr.glouglouwine;

import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.domain.GrapeTypes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BottleMapper implements RowMapper<Bottle> {
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
