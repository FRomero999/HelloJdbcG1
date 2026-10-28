package cesur.dam.g1;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        /*
            C - Create
            R - Read
            U - Update
            D - Delete

         */



        String url = "jdbc:mysql://localhost:3307/ad";
        String username = "user" ;
        String password = "pwd" ;
        String sqlQuery = "select * from Equipo";
        String sqlFind = "select * from Equipo where id=?";
        String sqlInsert = "insert into Equipo (nombre, categoria, disponible) " +
                           "VALUES (?,?,?)";
        String sqlUpdate = "update Equipo set nombre=?, categoria=?, disponible=? " +
                           "where id=?";
        String sqlDelete = "delete from Equipo where id=?";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = conn.prepareStatement(sqlInsert) )
        {
            pst.setString(1,"Nuevo equipo");
            pst.setString(2,"Nueva categoria");
            pst.setBoolean(3,true);
            int result = pst.executeUpdate();
            System.out.println("Filas afectadas : "+result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /* try con update */
        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = conn.prepareStatement(sqlUpdate) )
        {
            pst.setString(1,"Equipo actualizado");
            pst.setString(2,"Categoria actualizada");
            pst.setBoolean(3,false);
            pst.setInt(4,1);
            int result = pst.executeUpdate();
            System.out.println("Filas afectadas : "+result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /* try con borrar */
        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = conn.prepareStatement(sqlDelete) )
        {
            pst.setInt(1,1);
            int result = pst.executeUpdate();
            System.out.println("Filas afectadas : "+result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery())
        {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nombre") + " | " +
                        rs.getString("categoria") + " | " +
                        (rs.getBoolean("disponible")? "disponible" : "no disponible")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = conn.prepareStatement(sqlFind))
        {
            pst.setInt(1,24);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("nombre") + " | " +
                                rs.getString("categoria") + " | " +
                                (rs.getBoolean("disponible")? "disponible" : "no disponible")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
