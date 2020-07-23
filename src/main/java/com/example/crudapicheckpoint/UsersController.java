package com.example.crudapicheckpoint;

import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    private final UserRepository repository;

    public UsersController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return this.repository.findAll();
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User user) {
        return this.repository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return this.repository.findByUserId(Long.parseLong(id));
    }

    @PatchMapping("/users/{id}")
    public User patchUserById(@PathVariable("id") String id,
                              @RequestBody User user) {
        User newUser = this.repository.findByUserId(Long.parseLong(id));
        String email = user.getEmail();
        String password = user.getPassword();

          if (email != null) {
            newUser.setEmail(email);
          }
          if (password != null) {
            newUser.setPassword(password);
          }
          this.repository.deleteUser(Long.parseLong(id));
          this.repository.save(newUser);
          return this.repository.findByUserId(Long.parseLong(id));
    }
}
