package com.julianguarnizo.gestioncursos.services.course;

import java.util.List;

import com.julianguarnizo.gestioncursos.exceptions.CourseNotFoundException;
import com.julianguarnizo.gestioncursos.model.Course;

/**
 * Clase de logica de negocio para gestionar cursos.
 */
public interface CourseService {
    /**
     * Listar los cursos existentes en el sistema.
     * 
     * @return Todos los cursos existentes. En caso que no haya ningun curso, devuelve una lista vacia.
     */
    List<Course> getAll();

    /**
     * Consulta el curso que tenga asignado el id dado
     * 
     * @param id El identificador del curso a buscar.
     * @return La informacion del curso que tiene el id dado.
     * @throws IllegalArgumentException Si el id es nulo o menor que 0
     * @throws CourseNotFoundException Si no se encuentra el id en los cursos del sistema
     */
    Course getById(Long id);

    /**
     * Consulta cursos que su nombre tenga coincidencia con el texto ingresado 
     * 
     * @param name El texto ingresado para buscar los cursos por su nombre
     * @return Una lista de los cursos en los cuales su nombre contiene ese texto ingresado
     */
    List<Course> getCoursesContainsName(String name);

    /**
     * Crea un curso
     * 
     * @param course Curso a agregar a la lista en memoria
     * @return El curso creado
     * @throws IllegalArgumentException Si los parametros del curso no son validos segun reglas de negocio
     */
    Course create(Course course);

    /**
     * Actualiza la informacion de un curso en especifico
     * 
     * @param id El identificador del curso a actualizar.
     * @param course Toda la informacion del curso a actualizar
     * @return El objeto curso que fue actualizado
     * @throws IllegalArgumentException Si el parametro id es nulo o menor a cero 
     */
    Course update(Long id, Course course);

    /**
     * Eliminar un curso de la lista de cursos en memoria
     * 
     * @param id El identificador del curso a eliminar
     * @throws IllegalArgumentException Si el id es nulo o menor que 0
     * @throws CourseNotFoundException Si no se encuentra el id en los cursos del sistema 
     */
    void delete(Long id);
}
