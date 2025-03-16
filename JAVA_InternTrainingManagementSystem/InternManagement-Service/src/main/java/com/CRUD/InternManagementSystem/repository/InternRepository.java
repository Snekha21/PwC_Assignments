package com.CRUD.InternManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.InternManagementSystem.model.Intern;

public interface InternRepository extends JpaRepository<Intern, Long>{

    List<Intern> findAll();

    Iterable<Intern> findByNameContainingIgnoreCase(String title);

    List<Intern> findByAttended(boolean b);


}
