package cesur.dam.g1.data;

import cesur.dam.g1.models.Equipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EquipoJdbcDAO implements DAO<Equipo> {

    private String url = "jdbc:mysql://localhost:3307/ad";
    private String username = "user" ;
    private String password = "pwd" ;

    @Override
    public Optional<Equipo> findById(Long id) {
        String sql = "select * from Equipo where id=?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setLong(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setId(rs.getLong("id"));
                    equipo.setNombre(rs.getString("nombre"));
                    equipo.setCategoria(rs.getString("categoria"));
                    equipo.setDisponible(rs.getBoolean("disponible"));
                    return Optional.ofNullable(equipo);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Equipo> findAll() {
        return List.of();
    }

    @Override
    public Equipo save(Equipo obj) {
        return null;
    }

    @Override
    public void update(Equipo entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
