package com.crudapp.trainingmanagement.controller;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.crudapp.trainingmanagement.exceptions.UserNotFoundException;
import com.crudapp.trainingmanagement.model.Training;
import com.crudapp.trainingmanagement.repository.TrainingRepository;

@RequestMapping("/api/trainings")
@RestController
public class TrainingController {

    @Autowired
    TrainingRepository trainingRepository;
  
  
   @PostMapping("/add_trainings")
    public ResponseEntity<Training> createTraining(@RequestBody Training training) {
      try {
        Training _training = trainingRepository.save(new Training(training.getTitle(), training.getDescription(), false));
        return new ResponseEntity<>(_training, HttpStatus.CREATED);}
        catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
  
    /**
     */
    @GetMapping("/training_list")
    public ResponseEntity<List<Training>> getalltrainings() {
      try{
       List<Training> list = trainingRepository.findAll();
       return new ResponseEntity<>(list, HttpStatus.OK);

      }
      catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
        
      
    
}


  
 @GetMapping("/trainings_search/{id}")
 public ResponseEntity<List<Training>> getid(@RequestParam(required = false) String title) {
   try {
     List<Training> trainings = new ArrayList<Training>();

     if (title == null)
       trainingRepository.findAll().forEach(trainings::add);
     else
       trainingRepository.findByTitleContainingIgnoreCase(title).forEach(trainings::add);

     if (trainings.isEmpty()) {
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     return new ResponseEntity<>(trainings, HttpStatus.OK);
   } catch (Exception e) {
     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
   }
 }

 @GetMapping("/search/{id}")
 public ResponseEntity<List<Training>> getbyid(@RequestParam String title){
  try{
    List<Training>  lists = trainingRepository.findByTitleContainingIgnoreCase(title);
    return new ResponseEntity<>(lists, HttpStatus.OK);
   }
 catch(Exception e){
  return new ResponseEntity<>(null, HttpStatus.OK);

 }
}

@DeleteMapping("/delete_trainings/{id}")
    public ResponseEntity<HttpStatus> deleteTraining(@PathVariable("id") long id) {
      try {
        trainingRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


 @DeleteMapping("/deleteall_trainings")
  public ResponseEntity<HttpStatus> deleteAllTrainings() {
    try {
      trainingRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @GetMapping("/completed_trainings")
  public ResponseEntity<List<Training>> findByCompleted() {
    try {
      List<Training> trainings = trainingRepository.findByCompleted(true);

      if (trainings.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(trainings, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @PutMapping("/edit_trainings/{id}")
  public ResponseEntity<Training> updateTraining(@PathVariable("id") long id, @RequestBody Training training) {
    Optional<Training> trainingData = trainingRepository.findById(id);

    if (trainingData.isPresent()) {
      Training _training = trainingData.get();
      _training.setTitle(training.getTitle());
      _training.setDescription(training.getDescription());
      _training.setCompleted(training.isCompleted());
      return new ResponseEntity<>(trainingRepository.save(_training), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
@GetMapping("/user")
public String findUser() {
throw new UserNotFoundException("User ID not found");
}


@GetMapping("/error")
public String throwError() {
throw new NullPointerException("Intentional Null Pointer");
}

@GetMapping("/interns")
public String getInterns(){
    RestTemplate rest = new RestTemplate();
    return rest.getForObject("http://localhost:9000/api/intern/interns/attended", String.class);
}}