package com.example.shoppingAPP.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingAPP.exception.ResourceNotFoundException;
import com.example.shoppingAPP.model.Users;
import com.example.shoppingAPP.repository.UsersRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ShoppingController {
	
	  @Autowired private UsersRepository usersRepository;
	  
	  @GetMapping("/users")
	  public List<Users> getAllUsers() { 
		  return usersRepository.findAll(); 
		  }
	   
	  
	  @GetMapping("users/{id}")
	  public ResponseEntity<Users> getUsersById(@PathVariable(value = "id")Long usersId)
			  throws ResourceNotFoundException{ 
		  Users users = usersRepository.findById(usersId) 
				  .orElseThrow(() -> new ResourceNotFoundException ("User not found for this Id::" + usersId));
		  return ResponseEntity.ok().body(users);
	  }
	  
	  @PostMapping("/users")
	  public Users signUp(@Valid @RequestBody Users users ) {
		  return usersRepository.save(users);
	  }
	  
	  
	  @PutMapping("/users/{id}")
	  public ResponseEntity<Users> updateUsers(@PathVariable(value = "id")Long usersId,
			  @Valid @RequestBody Users usersDetails)
	    throws ResourceNotFoundException{ 
		  Users users = usersRepository.findById(usersId)
				  .orElseThrow(() -> new ResourceNotFoundException ("User not found for this Id::" + usersId));
	  
	  users.setId(usersDetails.getId());
	  users.setActive(usersDetails.isActive());
	  users.setAddress(usersDetails.getAddress());
	  users.setName(usersDetails.getName());
	  users.setPassword(usersDetails.getPassword());
	  users.setPhone(usersDetails.getPhone());
	  users.setRole(usersDetails.getRole());
	  final Users updatedUsers = usersRepository.save(users);
	  
	    return ResponseEntity.ok(updatedUsers);
        }
	  
	  
	  
}
