package cesur.dam.g1;

import cesur.dam.g1.data.EquipoJdbcDAO;
import cesur.dam.g1.models.Equipo;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Optional;

public class Main2 {

    private static String url = "jdbc:mysql://localhost:3307/ad";
    private static String username = "user" ;
    private static String password = "pwd" ;

    public static void main(String[] args)
    {

        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(url);
        ds.setUser(username);
        ds.setPassword(password);

        var dao = new EquipoJdbcDAO(ds);
        Optional<Equipo> p = dao.findById(10L);

        p.ifPresent( (equipo) -> {
            dao.deleteById(equipo.getId());
        });

    }
}
