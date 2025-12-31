package com.julianguarnizo.gestioncursos.services.course;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.julianguarnizo.gestioncursos.exceptions.CourseNotFoundException;
import com.julianguarnizo.gestioncursos.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

    private AtomicLong consecitive;
    private List<Course> courses;

    public CourseServiceImpl() {
        this.courses = new ArrayList<>();
        this.consecitive = new AtomicLong(1);
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<Course>(courses);
    }

    @Override
    public Course getById(Long id) {
        validId(id);

        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException(
                        String.format("El curso con id '%d' no ha sido encontrado!", id)));
    }

    @Override
    public List<Course> getCoursesContainsName(String name) {
        if (name == null || name.isBlank())
            return getAll();

        return courses.stream()
                .filter(c -> c.getName().contains(name))
                .toList();
    }

    @Override
    public Course create(Course course) {
        validateCourse(course);

        course.setId(consecitive.getAndIncrement());

        courses.add(course);
        return course;
    }

    @Override
    public Course update(Long id, Course course) {
        validId(id);

        var updateCourse = getById(id);
        updateCourse.setName(course.getName());
        updateCourse.setCode(course.getCode());
        updateCourse.setCredits(course.getCredits());
        updateCourse.setDescription(course.getDescription());
        updateCourse.setInitialDate(course.getInitialDate());
        updateCourse.setFinalDate(course.getFinalDate());

        return updateCourse;
    }

    @Override
    public void delete(Long id) {
        validId(id);

        var searchCourse = getById(id);
        courses.remove(searchCourse);
    }

    /**
     * Metodo para validar que el id ingresado no sea nulo ni sea menor que cero
     * 
     * @param id Identificador unico de un curso
     * @throws IllegalArgumentException Si el id es nulo o es menor que cero
     */
    private void validId(Long id) {
        if (id == null)
            throw new IllegalArgumentException("El id esta vacio");
        if (id < 0)
            throw new IllegalArgumentException("El id no puede ser un numero negativo");
    }

    /**
     * Metodo para validar los parametros del objeto curso
     * 
     * @param course Curso a validar
     * @throws IllegalArgumentException Si una de las propiedades ingresadas no
     *                                  cumple con las reglas propuestas
     */
    private void validateCourse(Course course) {
        if (course == null)
            throw new IllegalArgumentException("No fue enviado ningun curso para crear");

        if (course.getName() == null || course.getName().isBlank())
            throw new IllegalArgumentException("El nombre del curso es obligatorio");

        if (course.getCredits() <= 0)
            throw new IllegalArgumentException("Los creditos del curso deben ser mayores a cero");

        if (course.getInitialDate().isAfter(course.getFinalDate()))
            throw new IllegalArgumentException("La fecha inicial debe ser anterior a la fecha final");
    }

}
