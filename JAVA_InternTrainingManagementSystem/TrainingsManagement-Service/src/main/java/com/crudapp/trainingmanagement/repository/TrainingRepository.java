package com.crudapp.trainingmanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.trainingmanagement.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
  List<Training> findByCompleted(boolean completed);
  List<Training> findByTitleContainingIgnoreCase(String title);
}