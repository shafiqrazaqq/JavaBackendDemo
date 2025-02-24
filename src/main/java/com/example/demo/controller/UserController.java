package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserId;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id) {
        UserId userId = new UserId();
        userId.setId(id);
        return ResponseEntity.ok(userService.findUser(userId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<User>> findAllUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.findAllUser(pageable));
    }

    @GetMapping("/genderize/{id}")
    public ResponseEntity<String> callExternalApi(@PathVariable Long id) throws IOException {
        UserId userId = new UserId();
        userId.setId(id);
        return ResponseEntity.ok(userService.callExternalApi(userId));
    }
}
