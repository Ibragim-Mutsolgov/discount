package vip.redcode.discount.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.discount.core.model.User;
import vip.redcode.discount.core.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(name = "id") Long id) {
        User user = service.findById(id);
        if (user != null) return ResponseEntity.ok().body(user);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> save(User user) {
        return ResponseEntity.ok().body(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> savePut(@PathVariable(name = "id") Long id, User user) {
        User userSave = service.savePut(id, user);
        if (userSave != null) return ResponseEntity.ok().body(userSave);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> savePatch(@PathVariable(name = "id") Long id, User user) {
        User userSave = service.savePatch(id, user);
        if (userSave != null) return ResponseEntity.ok().body(userSave);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<User> deleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
