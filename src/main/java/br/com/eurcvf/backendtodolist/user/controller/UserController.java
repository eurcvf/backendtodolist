package br.com.eurcvf.backendtodolist.user.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.eurcvf.backendtodolist.user.model.UserModel;
import br.com.eurcvf.backendtodolist.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var userAlreadyExists = this.userRepository.findByUsername(userModel.getUsername());

        if (userAlreadyExists != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O usuário informado já está cadastrado em nosso sistema!");
        }

        var PasswordHash = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(PasswordHash);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

}
