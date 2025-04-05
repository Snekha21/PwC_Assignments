package com.CRUD.InternManagementSystem.controller;

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

import com.CRUD.InternManagementSystem.model.Intern;
import com.CRUD.InternManagementSystem.repository.InternRepository;


@RequestMapping("/api/intern")
@RestController
public class InternController {

    @Autowired
    InternRepository internRepository;
  
  
   @PostMapping("/add_interns")
    public ResponseEntity<Intern> createIntern(@RequestBody Intern intern) {
      try {
        Intern _intern = internRepository.save(new Intern(intern.getName(), intern.getPractice(), intern.getAttended()));
        return new ResponseEntity<>(_intern, HttpStatus.CREATED);}
        catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
  
    
    @GetMapping("/list")
    public ResponseEntity<List<Intern>> getallinterns() {
      try{
       List<Intern> list = internRepository.findAll();
       return new ResponseEntity<>(list, HttpStatus.OK);

      }
      catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
        
      
    
}


  
 @GetMapping("/interns_search/{id}")
 public ResponseEntity<List<Intern>> getid(@RequestParam(required = false) String name) {
   try {
     List<Intern> tutorials = new ArrayList<Intern>();

     if (name == null)
       internRepository.findAll().forEach(tutorials::add);
     else
       internRepository.findByNameContainingIgnoreCase(name).forEach(tutorials::add);

     if (tutorials.isEmpty()) {
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     return new ResponseEntity<>(tutorials, HttpStatus.OK);
   } catch (Exception e) {
     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
   }
 }

//  @GetMapping("/search/{id}")
//  public ResponseEntity<List<Intern>> getbyid(@RequestParam String name){
//   try{
//     List<Intern>  lists = (List<Intern>) internRepository.findByNameContainingIgnoreCase(name);
//     return new ResponseEntity<>(lists, HttpStatus.OK);
//    }
//  catch(Exception e){
//   return new ResponseEntity<>(null, HttpStatus.OK);

//  }
// }
 // delete from tutorials where id=?
    @DeleteMapping("/delete_interns/{id}")
    public ResponseEntity<HttpStatus> deleteIntern(@PathVariable("id") long id) {
      try {
        internRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


 @DeleteMapping("/deleteinterns")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      internRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
  
@GetMapping("/trainings")
public String getTrainings(){
    RestTemplate rest = new RestTemplate();
    return rest.getForObject("http://localhost:8082/api/trainings/training_list", String.class);
}
  @GetMapping("/interns/attended")
  public ResponseEntity<List<Intern>> findByAttended() {
    try {
      List<Intern> tutorials = internRepository.findByAttended(true);

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @PutMapping("/edit_interns/{id}")
  public ResponseEntity<Intern> updateTutorial(@PathVariable("id") long id, @RequestBody Intern intern) {
    Optional<Intern> tutorialData = internRepository.findById(id);

    if (tutorialData.isPresent()) {
       Intern _intern = tutorialData.get();
      _intern.setName(intern.getName());
      _intern.setPractice(intern.getPractice());
      _intern.setAttended(intern.getAttended());
      return new ResponseEntity<>(internRepository.save(_intern), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }}
// @GetMapping("/user")
// public String findUser() {
// throw new UserNotFoundException("User ID not found");
// }


// @GetMapping("/error")
// public String throwError() {
// throw new NullPointerException("Intentional Null Pointer");
// }}