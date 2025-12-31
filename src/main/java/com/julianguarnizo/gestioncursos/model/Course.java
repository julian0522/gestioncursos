package com.julianguarnizo.gestioncursos.model;

import java.time.LocalDate;

// POJO -> Plain Old Java Option
// JavaBean o POJO
public class Course {
    private Long id;
    private String name;
    private String code;
    private String description;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Integer credits;

    public Course() {
    }
    
    public Course(Long id, String name, String code, String description, LocalDate initialDate, LocalDate finalDate,
            Integer credits) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
