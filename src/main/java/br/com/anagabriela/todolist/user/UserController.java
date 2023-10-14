package br.com.anagabriela.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired // manage the life cycle of repository
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        UserModel user = this.userRepository.findByUsername(userModel.getUsername());
        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists!");
        }

        var password = BCrypt.withDefaults()
                .hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(password);

        UserModel userCreated = this.userRepository.save(userModel);

        return ResponseEntity.status(201).body(userCreated);
    }
}
