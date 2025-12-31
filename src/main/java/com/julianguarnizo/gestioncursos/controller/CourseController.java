package com.julianguarnizo.gestioncursos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianguarnizo.gestioncursos.model.Course;
import com.julianguarnizo.gestioncursos.services.course.CourseService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @GetMapping("/buscar")
    public List<Course> getCoursesByname(@RequestParam(name = "nombre") String name) {
        return courseService.getCoursesContainsName(name);
    }

    @PostMapping()
    public Course createCourse(@RequestBody Course course) {
        return courseService.create(course);
    }
    
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.update(id, course);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.delete(id);
    }
}
