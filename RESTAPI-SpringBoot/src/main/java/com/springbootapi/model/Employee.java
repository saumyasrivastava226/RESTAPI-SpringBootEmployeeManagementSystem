package com.springbootapi.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity // This class is going to represent a database table
@Table(name="tbl_employee")
public class Employee {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 private Long id;
	// now we need to map these fields to database columns
	 @NotNull
	  @Column(name="name")
      private String name;
      
      // lets say we don't want to return the age od the person in our response for some reason
      
      @Column(name="age")
      private Long age;
      
      @Column(name="location")
      private String location;
      
      
      @Email(message="Please enter the valid email address")
      @Column(name="email")
      private String email;
      
      @NotNull
      @Column(name="department")
      private String department;
      // in order to generate getters and setter we will use lombok annnotation 
      @CreationTimestamp
      @Column(name="created_at", nullable=false, updatable=false)
      private Date createdAt;
      
      @UpdateTimestamp
      @Column(name="updated_at")
      private Date updateAt;
      
      
      
}
