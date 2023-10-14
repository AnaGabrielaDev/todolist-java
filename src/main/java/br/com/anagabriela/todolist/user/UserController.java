package br.com.anagabriela.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired // manage the life cycle of repository
    private IUserRepository userRepository;

    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {
        UserModel user = this.userRepository.findByUsername(userModel.getUsername());
        if (user != null) {
            System.out.println("cadastrado");
            return null;
        }

        UserModel userCreated = this.userRepository.save(userModel);

        return userCreated;
    }
}
