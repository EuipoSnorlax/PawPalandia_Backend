package com.example.pawpalandiaDB.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.pawpalandiaDB.exceptions.UserNotFoundException;
import com.example.pawpalandiaDB.model.UserEntity;
import com.example.pawpalandiaDB.service.UserService;

@RestController
@RequestMapping("/api/v3")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserEntity> getUsers() { 
        return this.userService.getAll(); 
    }

    //Método para mapear getById() usando un PathVariable
    @GetMapping("/users/{id}")
    public UserEntity findById(@PathVariable(name = "id") Long id) {
        return this.userService.getById(id);
    }

    //Método para recuperar un nuevo usuario mediante email utilizando query personalizada
    @GetMapping("/users/email/{email}")
    public ResponseEntity<UserEntity> getByEmail(@PathVariable(name = "email") String email) {
        UserEntity userByEmail = this.userService.getByEmail(email);
        
        if(userByEmail == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<UserEntity>(userByEmail, HttpStatus.OK);
    }

    //Método para crear un nuevo usuario
    @PostMapping("/post-user")
    public UserEntity newUser(@RequestBody UserEntity user){
        return this.userService.createUser(user);
    }

    //Método para eliminar un usuario
    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        this.userService.deleteUser(id);
    }

    //Método para actualizar un usuario usando mapeo en PUT
    @PutMapping("update-user/{id}")
	public ResponseEntity <UserEntity> updateUser(@RequestBody UserEntity user, @PathVariable(name = "id") Long id){
		try{
			return ResponseEntity.ok(this.userService.updateUser(user, id));
		} catch(UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

    
}
