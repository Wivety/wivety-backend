package com.wivety.controller;
import com.wivety.models.AuthenticationModel;
import com.wivety.models.Profile;
import com.wivety.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    private ResponseEntity<Profile> save(@RequestBody Profile user){
        Profile createdUser = userService.create(user);
        try {
            return ResponseEntity.created(new URI("/api/user"+createdUser.getId())).body(createdUser);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/authenticate")
    private ResponseEntity<Profile> authenticate(@RequestBody AuthenticationModel user){
        try {
            Profile createdUser = userService.authenticate(user);
            return ResponseEntity.ok(createdUser);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Profile>> getAll (){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping
    private ResponseEntity<Void> delete (@RequestBody Profile persona){
        userService.delete(persona);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Profile> listarPersonasPorID (@PathVariable ("id") String id){
        return ResponseEntity.ok(userService.findById(id));
    }
}
