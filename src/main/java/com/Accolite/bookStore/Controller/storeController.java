package com.Accolite.bookStore.Controller;

import com.Accolite.bookStore.Module.Users;
import com.Accolite.bookStore.Service.storeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class storeController {

    @Autowired
    private com.Accolite.bookStore.Service.storeService storeService;

    @GetMapping("/users")
    private ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok().body(this.storeService.getAllUsers());

    }
    @GetMapping("/users/{userId}")
    private ResponseEntity<Users> getUser(@PathVariable long userId){

        return ResponseEntity.ok().body(this.storeService.getUserById(userId));
    }

    @PostMapping("/users")
    private ResponseEntity<Users> saveUser(@RequestBody Users user){
        return ResponseEntity.ok().body(this.storeService.createUser(user));

    }
    @PutMapping("/users/{userId}")
    private ResponseEntity<Users> updateUser(@PathVariable long userId,@RequestBody Users user){
        user.setUserId(userId);
        return ResponseEntity.ok().body(this.storeService.updateUser(user));
    }


    @DeleteMapping("/users/{userId}")
    private HttpStatus suspendUser(@PathVariable long userId){
        this.storeService.suspendUser(userId);
        return HttpStatus.OK;
    }
}
