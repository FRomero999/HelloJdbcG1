package cesur.dam.g1;

import cesur.dam.g1.data.EquipoJdbcDAO;
import cesur.dam.g1.models.Equipo;

import java.util.Optional;

public class Main2 {
    public static void main(String[] args)
    {
        var dao = new EquipoJdbcDAO();
        Optional<Equipo> p = dao.findById(1L);

        if( p.isPresent() ){
            System.out.println( p.get() );
        }else{
            System.out.println("No encontrado");
        }

    }
}
