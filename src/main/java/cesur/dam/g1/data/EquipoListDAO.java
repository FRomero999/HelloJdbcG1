package cesur.dam.g1.data;

import cesur.dam.g1.models.Equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Enunciado del ejercicio: implementar el DAO en memoria usando una lista.
 * <p>
 * Implementación de {@link DAO} para {@link Equipo} que almacena los datos
 * en memoria dentro de un {@link ArrayList}, sin persistencia en base de datos.
 * Los métodos {@code findByNombre} y {@code findByCategoria} son adicionales
 * al contrato de la interfaz.
 * </p>
 */
public class EquipoListDAO implements  DAO<Equipo> {

    /** Lista en memoria que almacena los equipos. */
    private List<Equipo> equipoList = new ArrayList<>();

    /**
     * Busca un equipo por su identificador.
     *
     * @param id identificador del equipo
     * @return un {@link Optional} con el equipo encontrado, o vacío si no existe
     */
    @Override
    public Optional<Equipo> findById(Long id) {
        return Optional.empty();
    }

    /**
     * Obtiene todos los equipos almacenados.
     *
     * @return lista con todos los equipos
     */
    @Override
    public List<Equipo> findAll() {
        return List.of();
    }

    /**
     * Guarda un nuevo equipo en la lista.
     *
     * @param obj equipo a guardar
     * @return el equipo guardado, posiblemente con el identificador asignado
     */
    @Override
    public Equipo save(Equipo obj) {
        return null;
    }

    /**
     * Actualiza un equipo existente de la lista.
     *
     * @param entity equipo con los datos actualizados
     */
    @Override
    public void update(Equipo entity) {

    }

    /**
     * Elimina un equipo por su identificador.
     *
     * @param id identificador del equipo a eliminar
     */
    @Override
    public void deleteById(Long id) {

    }

    /**
     * Busca equipos cuyo nombre coincida con el indicado.
     *
     * @param nombre nombre a buscar
     * @return lista de equipos que coinciden con el nombre
     */
    public List<Equipo> findByNombre(String nombre){
        return List.of();
    }

    /**
     * Busca equipos cuya categoría coincida con la indicada.
     *
     * @param categoria categoría a buscar
     * @return lista de equipos que coinciden con la categoría
     */
    public List<Equipo> findByCategoria(String categoria){
        return List.of();
    }

}
