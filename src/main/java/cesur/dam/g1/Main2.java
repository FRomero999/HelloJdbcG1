package cesur.dam.g1;

import cesur.dam.g1.data.DataSourceFactory;
import cesur.dam.g1.data.EquipoJdbcDAO;
import cesur.dam.g1.data.EquipoListDAO;
import cesur.dam.g1.models.Equipo;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Optional;

public class Main2 {


    public static void main(String[] args)
    {

   /*     var dao = new EquipoJdbcDAO(DataSourceFactory.getDataSource());
        Optional<Equipo> p = dao.findById(11L);

        p.ifPresent( (equipo) -> {
            System.out.println("Equipo: " + equipo);
        });*/

        var dao = new EquipoListDAO();
        Equipo e = new Equipo();
        e.setNombre("dsadsadsa");
        e.setCategoria("dsadsadsa");
        e.setDisponible(true);
        dao.save(e);
        e = new Equipo();
        e.setNombre("dsadstytrytrytradsa");
        e.setCategoria("dsaytrytrytrytrytrdsadsa");
        e.setDisponible(true);
        dao.save(e);

        dao.findAll().forEach(System.out::println);

    }
}
