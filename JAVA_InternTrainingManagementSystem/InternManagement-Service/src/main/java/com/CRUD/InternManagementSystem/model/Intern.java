package com.CRUD.InternManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "intern")
public class Intern {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "practice")
  private String practice;

  @Column(name = "training_attended")
  private Boolean attended;

  

// Empty Constructor
  public Intern() {

  }

  public Intern(String name, String practice, Boolean attended) {
    this.name = name;
    this.practice = practice;
    this.attended = attended;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPractice() {
    return practice;
  }

  public void setPractice(String practice) {
    this.practice = practice;
  }

  public boolean getAttended() {
    return attended;
  }

  public void setAttended(boolean attended) {
    this.attended = attended;
  }

  @Override
  public String toString() {
    return "Intern [id=" + id + ", name=" + name + ", practice=" + practice + ", attended=" + attended + "]";
  }

}
